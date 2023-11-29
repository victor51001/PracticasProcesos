package datos;

public class Cuenta {
	private int saldo=0;

	public Cuenta(int saldo) {
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}
	
	public synchronized void ingresar(int cantidad) {
		saldo+=cantidad;
	}
	public synchronized void retirar(int cantidad) {
		if (cantidad<=saldo) {
			saldo-=cantidad;
		} else {			
			System.out.println("Bancarrota");
			System.exit(0);
		}
	}

}
