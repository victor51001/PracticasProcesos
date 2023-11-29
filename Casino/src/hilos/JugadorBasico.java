package hilos;

import datos.Cuenta;
import datos.Ruleta;

public class JugadorBasico extends Thread {
	private Ruleta bola;
	private Cuenta banca;
	private int monedero;

	public JugadorBasico(Ruleta bola, Cuenta banca) {
		super();
		this.bola = bola;
		this.banca = banca;
		this.monedero = 1000;
		this.setName("Hilo Basico " + this.getName().split("-")[1]);
	}

	@Override
	public void run() {
		int numero;
		int apuesta = 10;
		int multiplicador = 36;
		while (monedero>=apuesta) {
			banca.ingresar(apuesta);
			monedero -= apuesta;
			numero = (int) ((Math.random() * 36) + 1);
			synchronized (bola) {
				try {
					bola.wait();
					System.out.println(this.getName() + " apuesta al " + numero + " la cantidad de " + apuesta + " y le queda " + monedero);
					if (numero==bola.getNumero()) {
						banca.retirar(apuesta*multiplicador);
						monedero += apuesta*multiplicador;
					} else {
						System.out.println(this.getName() + " pierde");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Hilo " + this.getName() + " se retira");
	}

}
