package datos;

public class Cuenta {
	private int saldo;
	public Cuenta(int c){
		this.saldo=c;	
	}
	public synchronized void incrementar(int n) {
		saldo += n;
		this.notify();
	}
	public synchronized void decrementar(int n) {
		while (this.valor()<n){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}					
		}
		saldo -= n;
	}
	public synchronized int valor() {
		return saldo;
	}
}
