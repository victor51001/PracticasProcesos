package util;

import java.util.Arrays;

public class Cola {
	private int[] numeros = new int[5];

	public synchronized int get() {
		if (numeros[0] > -1) {
			int numero = numeros[0];
			numeros[0] = -1;
			Arrays.sort(numeros);
			int n = numeros.length;
			for (int i = 0; i < n / 2; i++) {
				int temp = numeros[i];
				numeros[i] = numeros[n - i - 1];
				numeros[n - i - 1] = temp;
			}
			return numero;
		} else {
			return -1;
		}
	}

	public synchronized boolean put(int valor) {
		for (int n : numeros) {
			if (n==-1) {
				n=valor;
				return false;
			}
		}
		return true;
	}
}
