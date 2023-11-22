package util;

public class Cola {
	private int numero;
	private boolean disponible=false;
	
	//probar con y sin synchronized
	public synchronized int get() {
		if (disponible)
		{
			disponible=false;
			return numero;
		}
		else
			return -1;
	}
	public synchronized void put(int valor) {
		numero=valor;
		disponible=true;
	}
}
