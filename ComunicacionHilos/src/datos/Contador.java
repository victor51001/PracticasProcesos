package datos;

public class Contador {
	private int c=0;
	public Contador(int c){
		this.c=c;	
	}
	public synchronized void incrementar() {
	//public void incrementar() {
		c=c+1;
	}
	public synchronized void decrementar() {
	//public void decrementar() {
		c=c-1;
	}
	public int valor() {
		return c;
	}
}
