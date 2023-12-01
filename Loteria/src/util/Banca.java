package util;

public class Banca {
	private int saldo=0;

	public Banca(int num) {
		this.saldo = 1000 + num*10;
	}

	public int getSaldo() {
		return saldo;
	}
	
	public synchronized void ingresar(int cantidad) {
		saldo+=cantidad;
	}
	public synchronized void retirar(int cantidad) {
			saldo-=cantidad;
	}		
}
