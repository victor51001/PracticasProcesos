package util;
import java.util.Iterator;

import datos.Cuenta;

import datos.Ruleta;
import hilos.*;


public class MainCasino {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cuenta banca=new Cuenta(50000);
		Ruleta ruleta=new Ruleta();

		JugadorBasico[] jugadoresBasicos = new JugadorBasico[4];
		int numBasicos = jugadoresBasicos.length;
		JugadorParImpar[] jugadoresParImpar = new JugadorParImpar[4];
		int numParImpar = jugadoresParImpar.length;
		JugadorMartingala[] jugadoresMartingala = new JugadorMartingala[4];
		int numMartingala = jugadoresMartingala.length;
		
		Thread[] jugadores = new Thread[numBasicos+numParImpar+numMartingala];
		
		for (int i=0; i<jugadoresBasicos.length; i++) {
			jugadoresBasicos[i] = new JugadorBasico(ruleta, banca);
			jugadoresBasicos[i].start();
		}
		for (int i=0; i<jugadoresParImpar.length; i++) {
			jugadoresParImpar[i] = new JugadorParImpar(ruleta,banca);
			jugadoresParImpar[i].start();
		}
		for (int i=0; i<jugadoresMartingala.length; i++) {
			jugadoresMartingala[i] = new JugadorMartingala(ruleta,banca);
			jugadoresMartingala[i].start();
		}		
		for (int i=0; i<numBasicos; i++) {
			jugadores[i] = jugadoresBasicos[i];
		}
		for (int i=0; i<numParImpar; i++) {
			jugadores[i+numBasicos] = jugadoresParImpar[i];
		}
		for (int i=0; i<numMartingala; i++) {
			jugadores[i+numBasicos+numParImpar] = jugadoresMartingala[i];
		}		
		
		Lanzador coupier = new Lanzador(ruleta,jugadores);
		coupier.start();
		
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
	}	

}
