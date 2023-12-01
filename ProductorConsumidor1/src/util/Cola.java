package util;

public class Cola {
	private final int TAMAÑO = 4;
	private int[] numeros;
	
	public Cola() {
		numeros = new int[TAMAÑO];
		//Este for evita que se haga ningun get sin un put previo.
		for (int i=0; i<numeros.length; i++) {
			numeros[i] = -1;
		}
	}

	public synchronized int get() {
		for (int i=0; i<numeros.length; i++) {
			if (numeros[i]!=-1) {
				int num = numeros[i];
				numeros[i] = -1;
				return num;			
			}
		}
		return -1;
	}

	public synchronized boolean put(int valor) {
		for (int i=0; i<numeros.length; i++) {
			if (numeros[i]==-1) {
				numeros[i]=valor;
				return false;
			}
		}
		return true;
	}
	/* Metodo para devolver la cola, 
	en el main se puede comprobar que 
	todos los valores han sido consumidos.*/
	
	public int[] getNumeros() {
		return numeros;
	}
}
