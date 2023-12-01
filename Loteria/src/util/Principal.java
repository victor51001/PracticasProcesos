package util;

import java.util.Scanner;


public class Principal {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero de apostadores: ");
		int numApostadores = sc.nextInt();sc.nextLine();
		System.out.println("Introduce el numero de sorteos: ");
		int numSorteos = sc.nextInt();sc.nextLine();
	
		Banca banca=new Banca(numApostadores);
		Sorteo bola=new Sorteo();
		
		Apostante[] apostadores = new Apostante[numApostadores];
		for(int i=0; i<apostadores.length; i++) {
			apostadores[i] = new Apostante(bola,banca,numSorteos);
			apostadores[i].start();
		}
		
		Lanzador lanzador = new Lanzador(bola,apostadores,numSorteos);
		lanzador.start();
		
		for(int i=0; i<apostadores.length; i++) { 
			try {
				apostadores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Se acabo el sorteo");
	}
}
