package main;

import datos.Cuenta;
import hilos.HiloSacar;
import hilos.HiloIngresar;

public class MainComHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuenta cuenta=new Cuenta(100);
		HiloIngresar[] hi=new HiloIngresar[120];
		HiloSacar[] hs=new HiloSacar[120];
		int cantidad = 50;
		
		for (int i=0; i<hi.length; i++) {
			hi[i] = new HiloIngresar("Hilo " + i,cuenta);
			hs[i] = new HiloSacar("Hilo " + i,cuenta);
			if (i==60) {
				cantidad = 20;
			} else if (i==20) {
				cantidad = 100;
			}
			hi[i].start();
			hs[i].start();
		}
		
		for (int i=0; i<hi.length; i++) { 
			try {
				hi[i].join();
				hs[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 System.out.println("Saldo en cuenta "+cuenta.valor());

	}

}
