package util;

import datos.Contador;
import hilos.HiloResta;
import hilos.HiloSuma;

public class MainComHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador cuenta=new Contador(100);
		HiloSuma[] hs=new HiloSuma[120];
		
		for (int i=0; i<hs.length; i++) {
			
		}
		HiloResta[] hr=new HiloResta[120];
		 
		 System.out.println("Contador en main "+cuenta.valor());

	}

}
