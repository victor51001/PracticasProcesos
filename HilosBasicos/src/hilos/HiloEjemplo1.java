package hilos;

public class HiloEjemplo1 extends Thread {
	private int x=1;

	public HiloEjemplo1(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void run() {
		
		for(int i=0;i<10;i++)
		{
			System.out.println("Hilo "+getName()+" vuelta "+i+ 
					" x vale "+(x++)+"Id:"+getId());
		}
		Thread.currentThread();
		System.out.println(
				"Dentro del hilo :"+Thread.currentThread().getName()+
				"\n\tPriodidad :"+Thread.currentThread().getPriority()+
				"\n\tID :"+Thread.currentThread().getId()+
				"\n\tHilos activos :"+Thread.activeCount());
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	
	
}
