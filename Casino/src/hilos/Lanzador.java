package hilos;

import datos.Ruleta;

public class Lanzador extends Thread {
	private Ruleta bola;
	private Thread[] jugadores;

	public Lanzador(Ruleta bola, Thread[] apostadores) {
		this.bola = bola;
		jugadores = apostadores;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int ronda = 1;
		while (true) {
			synchronized (bola) {
				bola.lanzar();
				System.out.println("Ronda: " + ronda);
				ronda++;
				System.out.println("numero:" + bola.getNumero());
				bola.notifyAll();
			}
			boolean ok = true;
			boolean ko = false;
			while (ok) {
				int contador = 0;
				for (Thread jugador : jugadores) {
					if (jugador.getState().equals(Thread.State.RUNNABLE) || 
							jugador.getState().equals(Thread.State.BLOCKED)) {
						ko = false;
					}
					if (jugador.getState().equals(Thread.State.TERMINATED)) {
						contador++;
					}
				}
				if (contador==jugadores.length) {
					System.out.println("Todos los jugadores han perdido");
					System.exit(0);
				}
				if (ko) {
					ok = false;
				} else {
					ok = true;
				}
				ko = true;
			}
		}
	}
}