package util;

import java.io.IOException;
import java.io.InputStream;

public class Principal {
	
	public static void main(String[] argc) {
		ProcessBuilder pb_programaGrafico = new ProcessBuilder("pluma","hola.txt");
		try {
			Process p = pb_programaGrafico.start();
			System.out.println("Proceso lanzado.");
			p.waitFor();
			System.out.println("Proceso lanzado.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProcessBuilder pb_comando = new ProcessBuilder("ls","-l","/home/alumnotd");
		
		try {
			Process p_comando = pb_comando.start();
			InputStream is = p_comando.getInputStream();
			int c;
			while ((c=is.read())!=-1)
			{
				System.out.print((char)c);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ProcessBuilder pb_javaClass= new ProcessBuilder("java",
				"-cp",
				"/home/alumnotd/eclipse-workspace/holamundo/bin", 
				"principal.mainSaludo");
		try {
			Process p_javaClass = pb_javaClass.start();
			InputStream is=p_javaClass.getInputStream();
			int c;
			while ((c=is.read())!=-1)
			{
				System.out.print((char)c);
				
			}	
			is.close();
		}
		catch (IOException e) 
		{
 			System.out.println("Problema al lanzar el proceso");
 		}
		ProcessBuilder pb_java_jar = new ProcessBuilder();
		/*
		try {
			Process p_java_jar = pb_java_jar.start();
			InputStream is=pb_java_jar
			int c;
			while ((c=is.read())!=-1)
			{
				System.out.print((char)c);
				
			}	
			is.close();
		}
		catch (IOException e) 
		{
 			System.out.println("Problema al lanzar el proceso");
 		}*/
	}
}
