package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HiloVocal extends Thread{
	//atributos
	public char vocal;
	public int ocurrencias;
	public File f;
	
	//constructor
	public HiloVocal(char vowel,File fichero) {
		vocal = vowel;
		f = fichero;																	
		ocurrencias = 0;
	}
	//metodo run
	public void run() {
		FileReader fr = null;
		BufferedReader br  = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			char[] caracteres;
			while ((linea=br.readLine())!=null) {
				caracteres = linea.toLowerCase().toCharArray();
				for (char c : caracteres) {
					if (c==vocal) {
						ocurrencias++;
					}
				}
			}
			System.out.println("He encontrado la letra " + vocal + ocurrencias + " veces");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
