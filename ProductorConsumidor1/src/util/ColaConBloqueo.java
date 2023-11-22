package util;

public class ColaConBloqueo {
	private int numero;
	private boolean disponible=false;
	public synchronized int get() {
		while(!disponible)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//visualizar valor
		disponible=false;
		return numero;
	}
	public synchronized void put(int valor) {
		while(disponible)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		numero=valor;
		disponible=true;
		//visualizar valor
		notify();
	}

}
