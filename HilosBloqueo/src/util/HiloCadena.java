package util;

public class HiloCadena extends Thread{
	private ObjetoCompartido com;
    String cad;
	public HiloCadena(ObjetoCompartido com, String cad) {
		this.com = com;
		this.cad = cad;
	}
	
	public void run() {
		synchronized(com) {
			for (int i=0;i<10;i++)
			{
				com.pintaCadena(cad);
				com.notify();
				try {
					com.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			com.notify();
		}
		System.out.println(cad + "finalizado");
	}
}
