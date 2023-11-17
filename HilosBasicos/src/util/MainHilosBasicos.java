package util;

import hilos.HiloEjemplo1;
import hilos.HiloEjemplo2;

public class MainHilosBasicos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HiloEjemplo1 h1= new HiloEjemplo1("uno");
//		HiloEjemplo1 h2= new HiloEjemplo1("dos");
//		HiloEjemplo1 h3= new HiloEjemplo1("tres");
//		
//		h1.start();
//		h2.start();
//		h3.start();
//
//		Thread.currentThread().setName("Principal");
//		System.out.println(Thread.currentThread().getName());
//		System.out.println(Thread.currentThread().toString());
//		
//		HiloEjemplo1 h=null;
//		for(int i=0;i<3;i++)
//		{
//			h=new HiloEjemplo1("hilo"+i);
//			h.setPriority(i+1);
//			h.start();
//			System.out.println("informacion del hilo:" + h.getName()+": "+h.toString());
//			
//		}
		
		Thread.currentThread().setName("Principal");
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().toString());
		
		ThreadGroup grupo=new ThreadGroup("grupo de hilos");
		HiloEjemplo2 h=new HiloEjemplo2();
		
		Thread h1= new Thread(grupo,h,"hilo1");
		Thread h2= new Thread(grupo,h,"hilo2");
		Thread h3= new Thread(grupo,h,"hilo3");
		
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("Hilos lanzados");
		System.out.println("Hilos activos:"+Thread.currentThread().activeCount());
	}

}
