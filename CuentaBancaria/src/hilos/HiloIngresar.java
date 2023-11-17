package hilos;

import datos.Cuenta;

public class HiloIngresar extends Thread {
	public int cantidad = 50;
	private Cuenta cuenta;
	public HiloIngresar(String n, Cuenta c){
		setName(n);
		this.cuenta=c;
	}
	@Override
	public void run() {
		try {
			sleep((long) (Math.random()*99+1));
			cuenta.incrementar(cantidad);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
