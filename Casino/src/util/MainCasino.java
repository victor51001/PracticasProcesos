package util;
import java.util.Iterator;

import datos.Cuenta;

import datos.Ruleta;
import hilos.*;


public class MainCasino {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cuenta banca=new Cuenta(10000);
		Ruleta ruleta=new Ruleta();

		Jugador[] jugadores = new Jugador[10];
		Lanzador coupier = new Lanzador(ruleta,jugadores);
		Controlador control = new Controlador(jugadores);
		
		for (int i=0; i<jugadores.length; i++) {
			jugadores[i]= new Jugador(ruleta, banca);
			jugadores[i].start();
		}
		coupier.start();	
		control.start();
		
		for (int i= 0; i<jugadores.length; i++) {
			try {								
				jugadores[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		try {
			coupier.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("hola");
		
	}	

}
