package hilos;

import datos.Cuenta;
import datos.Ruleta;

public class JugadorMartingala extends Thread {
	private Ruleta bola;
	private Cuenta banca;
	private int apuesta;
	private int monedero;
	
	public JugadorMartingala(Ruleta bola, Cuenta banca) {
		super();
		this.bola = bola;
		this.banca = banca;
		this.monedero = 1000;
		this.apuesta = 10;
		this.setName("Hilo Martingala " + this.getName().split("-")[1]);
	}
	
	@Override
	public void run() {
		int numero;
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			apuesta *= 2;
		}
		System.out.println("Hilo " + this.getName() + " se retira");
	}

}
