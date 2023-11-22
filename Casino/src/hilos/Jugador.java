package hilos;

import datos.Cuenta;
import datos.Ruleta;

public class Jugador extends Thread{
	private Ruleta bola;
	private Cuenta banca;
	public Jugador(Ruleta bola, Cuenta banca) {
		super();
		this.bola = bola;
		this.banca = banca;
	}
	@Override
	public void run() {
		int numero;
		for (int i=0; i<10; i++) {
			banca.ingresar(10);
			numero = (int)((Math.random()*36)+1);
			synchronized(bola) {
				try {
					bola.wait();
					System.out.println("apuesto " + numero + " y gana " + bola.getNumero());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}	

}
