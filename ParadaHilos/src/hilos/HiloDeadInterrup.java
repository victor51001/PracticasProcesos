package hilos;

public class HiloDeadInterrup  extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!isInterrupted()) {
				System.out.println("en el hilo");
				Thread.sleep(10);
			}
		}
	
		catch (InterruptedException e) {
			System.out.println("Se ha producido una interrupcción");
		}
	}
	
	public void interrumpir() {
		interrupt();
	}

}
