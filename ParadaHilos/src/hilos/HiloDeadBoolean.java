package hilos;

public class HiloDeadBoolean extends Thread{
	private boolean stopHilo=false;
	
	public void pararHilo() {
		stopHilo=true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stopHilo) {		
			System.out.println("en el hilo");
		}
	}
	
}
