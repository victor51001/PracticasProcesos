package main;

import java.io.File;

import util.HiloVocal;

public class PrincipalVocales {

	public static void main(String[] args) {
		File f = new File("texto.txt");
		char[] vocales = {'a','e','i','o','u'};
		HiloVocal[] hvs = new HiloVocal[vocales.length];
		
		for (int i=0; i<hvs.length; i++) {
			hvs[i] = new HiloVocal(vocales[i],f);
			hvs[i].start();
		}
		for (int i=0; i<hvs.length; i++) {
			try {
				hvs[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i=0; i<hvs.length; i++) {
			System.out.println("El hilo " + (i+1) + " ha encontrado " + hvs[i].ocurrencias + " ocurrencias de la " + vocales[i]);
		}
	}
}
