package util;

public class Consumidor extends Thread {
	private Cola cola;
	private int n;
	public Consumidor(Cola cola, int n) {
		this.cola = cola;
		this.n = n;
	}
	public void run() {
		int valor=0;
		for (int i=0;i<5;i++) {
			while((valor = cola.get())==-1) { }
			System.out.println("consumidor "+n+" consume "+valor);
		}
	}
}
