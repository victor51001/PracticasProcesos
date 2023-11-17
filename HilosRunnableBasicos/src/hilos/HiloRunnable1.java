package hilos;

public class HiloRunnable1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("información del hilo:"+Thread.currentThread().toString());
	}

}
