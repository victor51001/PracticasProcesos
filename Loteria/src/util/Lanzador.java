package util;


public class Lanzador extends Thread {
	private Sorteo bola;
	private Thread[] jugadores;
	private int rondas;

	public Lanzador(Sorteo bola, Thread[] apostadores, int rondas) {
		this.bola = bola;
		jugadores = apostadores;
		this.rondas = rondas;
	}

	@Override
	public void run() {
		for(int i=0; i<rondas; i++) {
			boolean ok = true;
			boolean ko = false;
			while (ok) {
				for (Thread jugador : jugadores) {
					if (jugador.getState().equals(Thread.State.RUNNABLE) || 
							jugador.getState().equals(Thread.State.BLOCKED)) {
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
			synchronized (bola) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				bola.lanzar();
				System.out.println("\nRonda " + (i+1));
				System.out.println("numero:" + bola.getNumero());
				bola.notifyAll();
			}
		}
	}
}
