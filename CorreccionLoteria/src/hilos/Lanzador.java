package hilos;

import java.util.ArrayList;

import datos.Bombo;

public class Lanzador extends Thread{
	private Bombo b;
	private ArrayList<Jugador> jugadores;
	private int sorteos;

	public Lanzador(Bombo bombo, ArrayList<Jugador> apostadores, int rondas) {
		this.b = bombo;
		this.jugadores = apostadores;
		this.sorteos = rondas;
	}

	@Override
	public void run() {
		for(int i=0; i<sorteos; i++) {
			boolean ok = true;
			boolean ko = false;
			while (ok) {
				for (Jugador jugador : jugadores) {
					if (!jugador.getState().equals(Thread.State.WAITING)) {
						ko = false;
					}
				}
				if (ko) {
					ok = false;
				} else {
					ok = true;
				}
				ko = true;
			}
			synchronized (b) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				b.lanzar();
				System.out.println("\nRonda " + (i+1));
				System.out.println("Combinacion ganadora: " + b.getCombinacion() + "\n");
				b.notifyAll();
			}
		}
	}
}
