package util;

import java.io.File;
import java.io.IOException;

public class MainRedireccionar {

	public static void main(String[] args) {
				//si vota o no
				/*ProcessBuilder pb_java_jar = new ProcessBuilder("java","-jar",
						"/home/alumnotd/Escritorio/AlumnoSSD/Procesos/Jar/Miercoles25-10/votar.jar");
				
				File fout = new File("/home/alumnotd/Escritorio/AlumnoSSD/Procesos/Salidas/Miercoles25-10/salida.txt");
				File fin = new File("/home/alumnotd/Escritorio/AlumnoSSD/Procesos/Entradas/Miercoles25-10/entrada.txt");
				File ferr = new File("/home/alumnotd/Escritorio/AlumnoSSD/Procesos/Errores/Miercoles25-10/error.txt");
				
				pb_java_jar.redirectOutput(fout);
				pb_java_jar.redirectInput(fin);
				pb_java_jar.redirectError(ferr);
				
				try {
					Process p_java_jar = pb_java_jar.start();				
				}
				catch (IOException e) 
				{
		 			System.out.println(e);		 			
		 		}
				*/
		
				//calcular nota media de notas
				/*pb_java_jar = new ProcessBuilder("java","-cp",
						"/home/alumnotd/eclipse-workspace/clacularnota/bin","util.PrincipalNotas");
				
				fout = new File("/home/alumnotd/Escritorio/AlumnoSSD/Procesos/Salidas/Miercoles25-10/salida.txt");
				fin = new File("/home/alumnotd/Escritorio/AlumnoSSD/Procesos/Entradas/Miercoles25-10/entrada.txt");
				ferr = new File("/home/alumnotd/Escritorio/AlumnoSSD/Procesos/Errores/Miercoles25-10/error.txt");
				
				pb_java_jar.redirectOutput(fout);
				pb_java_jar.redirectInput(fin);
				pb_java_jar.redirectError(ferr);
				
				try {
					Process p_java_jar = pb_java_jar.start();				
				}
				catch (IOException e) 
				{
		 			System.out.println(e);		 			
		 		}*/
				
				//calcular nota media en c
				ProcessBuilder pb_c = new ProcessBuilder("/home/hdssd/alumnotd/Victor Mandar/Procesos/Ejercicios/Miercoles25-10/media");
				
				File fout = new File("/home/alumnotd/Escritorio/AlumnoSSD/Procesos/Salidas/Miercoles25-10/salida.txt");
				File fin = new File("/home/alumnotd/Escritorio/AlumnoSSD/Procesos/Entradas/Miercoles25-10/entrada.txt");
				File ferr = new File("/home/alumnotd/Escritorio/AlumnoSSD/Procesos/Errores/Miercoles25-10/error.txt");
				
				pb_c.redirectOutput(fout);
				pb_c.redirectInput(fin);
				pb_c.redirectError(ferr);
				
				try {
					Process p_c = pb_c.start();				
				}
				catch (IOException e) 
				{
		 			System.out.println(e);		 			
		 		}
	}

}
