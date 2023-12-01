package util;

public class Consumidor extends Thread {
	private Cola cola;
	private int n;
	public Consumidor(Cola cola, int n) {
		this.cola = cola;
		this.n = n;
	}
	public void run() {
		for (int i=0;i<5;i++) {
			int valor;
			while((valor = cola.get())==-1) { 
				try {
					Thread.sleep((long) (Math.random()*3000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("consumidor "+n+" consume "+valor);
		}
	}
}
