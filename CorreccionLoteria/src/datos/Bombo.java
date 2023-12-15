package datos;

import java.util.HashSet;
import java.util.Set;

public class Bombo {
	private Set<Integer> combinacion = new HashSet<Integer>();

	public Bombo() {
	}

	public Set<Integer> getCombinacion() {
		return combinacion;
	}

	public void lanzar() {
		int numero = 0;
		if (combinacion.size()>0) {
			combinacion.clear();
		}
		while (combinacion.size() < 3) {
			numero = (int) (Math.random() * 48) + 1;
			combinacion.add(numero);
		}
	}
}
