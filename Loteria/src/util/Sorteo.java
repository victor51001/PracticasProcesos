package util;

public class Sorteo {
	private int numero=0;
	
	public Sorteo() {
		
	}
	public int getNumero() {
		return numero;
	}
	public void lanzar() {
		numero = (int) ((Math.random() * 48) + 1);
	}
}
