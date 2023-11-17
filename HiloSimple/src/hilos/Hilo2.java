package hilos;

public class Hilo2 extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("En el hilo 2 ....");
		}

	}
}
