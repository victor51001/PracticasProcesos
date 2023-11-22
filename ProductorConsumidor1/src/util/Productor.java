package util;

public class Productor extends Thread{
	private Cola cola;
	private int n;
	public Productor(Cola cola, int n) {
		this.cola = cola;
		this.n = n;
	}
	public void run() {
		for (int i=0;i<5;i++) {
			cola.put(i);
			System.out.println(i+" productor "+n+" produce "+i);
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}

	
}
