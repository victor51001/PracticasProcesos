package hilos;

public class Controlador extends Thread{
	private Jugador[] jugador;
	
	public Controlador(Jugador[] jugadores){
		jugador = jugadores;
	}
		
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			synchronized(jugador) {
				while (getEstadoJugadores(jugador)) {
					
				}
				jugador.notify();
			}
		}
	}


	public static boolean getEstadoJugadores(Jugador[] jugadores) {
		boolean ok = true;
		for (int i=0; i<jugadores.length; i++) {
			if (jugadores[i].getState().equals(Thread.State.WAITING)) {
				ok = false;
			} else {
				return true;
			}
		}
		return ok;
	}

}
