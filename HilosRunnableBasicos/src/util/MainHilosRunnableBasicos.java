package util;

import hilos.HiloRunnable1;

public class MainHilosRunnableBasicos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloRunnable1 h1 =new HiloRunnable1();
		HiloRunnable1 h2 =new HiloRunnable1();
		HiloRunnable1 h3 =new HiloRunnable1();
		
		new Thread(h1).start();
		new Thread(h1).start();
		new Thread(h1).start();
	}

}
