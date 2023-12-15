package hilos;

import java.util.HashSet;
import java.util.Set;

import datos.Cuenta;
import datos.Bombo;

public class Jugador extends Thread {
	private Bombo b;
	private Cuenta c;
	private int monedero;
	private int vueltas;
	private static int contador = 0;

	public Jugador(Bombo b, Cuenta c, int monedero, int vueltas) {
		this.b = b;
		this.c = c;
		this.monedero = monedero;
		this.vueltas = vueltas;
		this.setName("Jugador " + contador++);
	}

	@Override
	public void run() {
		int numero = 0;
		int aciertos = 0;
		Set<Integer> apuesta = new HashSet<Integer>();
		Set<Integer> ganadora;
		for (int i = 0; i < vueltas; i++) {
			if (monedero >= 10) {
				c.ingresar(10);
				monedero -= 10;
				while (apuesta.size() < 3) {
					numero = (int) (Math.random() * 48) + 1;
					apuesta.add(numero);
				}
				synchronized (b) {
					try {
						b.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				ganadora = b.getCombinacion();
				aciertos = 0;
				for (int n : ganadora)
					if (apuesta.contains(n))
						aciertos++;

				switch (aciertos) {
				case 0:
					System.out.println(this.getName() + " acierta " + aciertos + "\nCon la combinacion " + apuesta + "\n");
					break;
				case 1:
					System.out.println(this.getName() + " acierta " + aciertos + "\nCon la combinacion " + apuesta);
					c.retirar(5);
					monedero += 5;
					break;
				case 2:
					System.out.println(this.getName() + " acierta " + aciertos + "\nCon la combinacion " + apuesta);
					c.retirar(25);
					monedero += 25;
					break;
				case 3:
					System.out.println(this.getName() + " acierta " + aciertos + "\nCon la combinacion " + apuesta);
					c.retirar(1000);
					monedero += 1000;
					break;
				}
			}
		}
	}
}
