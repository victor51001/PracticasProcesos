package main;

import java.io.File;
import java.util.Scanner;

import util.HiloPalabra;

public class PrincipalPalabras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f = new File("texto.txt");
		String palabra;
		System.out.println("Introduce el numero de palabras que quieres buscar: ");
		int numP = sc.nextInt();sc.nextLine();
		HiloPalabra[] hps = new HiloPalabra[numP];
		String[] palabras = new String[numP];
		for (int i=0; i<numP; i++) {
			System.out.println("Introduce la palabra " + (i+1) + ":");
			palabras[i] = palabra = sc.nextLine();
			hps[i] = new HiloPalabra(palabra,f);
			hps[i].start();
		}
		for (int i=0; i<hps.length; i++) {
			try {
				hps[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i=0; i<hps.length; i++) {
			System.out.println("El hilo " + (i+1) + " ha encontrado " + hps[i].ocurrencias + " ocurrencias de la palabra " + palabras[i]);
		}
	}

}
