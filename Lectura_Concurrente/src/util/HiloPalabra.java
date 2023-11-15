package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HiloPalabra extends Thread{
	//atributos
	public String palabra;
	public int ocurrencias;
	private char[] puntuaciones = {'.', ',', ';', ':', '!', '?'};
	public File f;
	
	//constructor
	public HiloPalabra(String pal, File fichero) {
		palabra = pal;
		ocurrencias = 0;
		f = fichero;
	}
	
	//metodo run
	public void run() {
		FileReader fr = null;
		BufferedReader br  = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			String[] palabras;
			while ((linea=br.readLine())!=null) {
				palabras = linea.split(" ");
				for (String pal : palabras) {
					for (int i=0; i<puntuaciones.length; i++) {
						if (pal.charAt(pal.length()-1)==puntuaciones[i]) {
							pal = pal.substring(0, (pal.length()-1));
						}
					}
					if (pal.equals(palabra)) {
						ocurrencias++;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}