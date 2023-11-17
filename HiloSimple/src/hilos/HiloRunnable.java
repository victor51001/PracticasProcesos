package hilos;

public class HiloRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++) {
			System.out.println("En el hilo 3 ....");
		}
	}
	

}
