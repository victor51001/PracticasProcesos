package util;

import hilos.HiloDeadBoolean;
import hilos.HiloDeadInterrup;

public class MainParadaHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloDeadBoolean hb=new HiloDeadBoolean();
		
		hb.start();
		for (int i=0;i<1000000;i++);
		hb.pararHilo();
		System.out.println("fin del hilo 1");
		System.out.println("estado:"+hb.getState());
		
		HiloDeadInterrup hi=new HiloDeadInterrup();
		hi.start();
		
		for(int i=0;i<1000000;i++);
		hi.interrumpir();
		//hi.interrupt();
		System.out.println("fin del hilo 2");
		System.out.println("estado:"+hi.getState());
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("estado:"+hi.getState());
		
	}

}
