package hilos;

public class HiloEjemplo2 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("información del hilo:"+Thread.currentThread().toString());
		int z=0;
		for (int i=0;i<1000;i++) z++;
		System.out.println("hilo "+Thread.currentThread().getName()+"finaliza ejecución");
	}
	

}
