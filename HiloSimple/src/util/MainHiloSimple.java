package util;

import hilos.Hilo2;
import hilos.HiloNuevo;
import hilos.HiloRunnable;
import hilos.HiloSimple;

public class MainHiloSimple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloSimple hs=new HiloSimple();
		HiloNuevo hn=new HiloNuevo();
		Hilo2 h1=new Hilo2();
		HiloRunnable hr=new HiloRunnable();
		Thread t=new Thread(hr);		
		h1.start();
		hs.start();
		hn.start();
		t.start();
		for(int i=0;i<5;i++) {
			System.out.println("fuera del hilo");
			
		}
	}

}
