package hilos;

import datos.Ruleta;

public class Lanzador extends Thread {
	private Ruleta bola;
	private Jugador[] jugador;

	public Lanzador(Ruleta bola,Jugador[] jugadores) {		
		this.bola = bola;
		jugador = jugadores;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0;i<10;i++)
		{
			synchronized(bola){
				bola.lanzar();
				System.out.println("numero:"+bola.getNumero());
					synchronized(jugador) {
						try {
							jugador.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				bola.notifyAll();
			}			
		}
	}