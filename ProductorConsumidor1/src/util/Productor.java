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
			while(cola.put(i)) { }
			System.out.println(" productor "+n+" produce "+i);
		}			
	}	
}
