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
			while(cola.put(i)) {
				try {
					Thread.sleep((long) (Math.random()*3000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(" productor "+n+" produce "+i);
		}			
	}	
}
