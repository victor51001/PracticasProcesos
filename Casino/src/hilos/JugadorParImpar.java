package hilos;

import java.util.Random;

import datos.Cuenta;
import datos.Ruleta;

public class JugadorParImpar extends Thread {
	private Ruleta bola;
	private Cuenta banca;
	private int monedero;
	
	public JugadorParImpar(Ruleta bola, Cuenta banca) {
		super();
		this.bola = bola;
		this.banca = banca;
		this.monedero = 1000;
		this.setName("Hilo ParImpar " + this.getName().split("-")[1]);
	}

	@Override
	public void run() {
		Random r = new Random();
		boolean parImpar;
		int apuesta = 10;
		int multiplicador = 2;
		while (monedero>=apuesta) {
			banca.ingresar(apuesta);
			monedero -= apuesta;
			parImpar = r.nextBoolean();//true es par, false es impar
			String texto;
			if (parImpar) {
				texto = "par";
			} else {
				texto = "impar";
			}
			synchronized (bola) {
				try {
					bola.wait();
					System.out.println(this.getName() + " apuesta a " + texto + " la cantidad de " + apuesta + " y le queda " + monedero);
					if (parImpar==(bola.getNumero()%2==0)) {
						System.out.println(this.getName() + " gana");
						banca.retirar(apuesta*multiplicador);
						monedero += apuesta*multiplicador;
					} else {
						System.out.println(this.getName() + " pierde");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(this.getName() + " se retira");
	}
}
