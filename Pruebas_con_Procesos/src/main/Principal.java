package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		// Creamos el processBuilder con el comando para ejecutar nuestro codigo en c compilado.
		ProcessBuilder pb_c = new ProcessBuilder("./ciclismo");
		
		Process procesos[] = new Process[3];//array de procesos
		
		//arrays de ficheros y un array multidimensional con todos
		File[] entradas = {new File("entrada1.txt"),new File("entrada2.txt"),new File("entrada3.txt")};
		File[] salidas = {new File("salida1.txt"), new File("salida2.txt"), new File("salida3.txt")};
        File[] errores = {new File("error1.txt"), new File("error2.txt"), new File("error3.txt")};
        File[][] ficheros = {entradas,salidas,errores};
        
        //declaro FileWriter y BufferedWriter para escribir en los archivos de entrada
        FileWriter fw1 = new FileWriter(entradas[0]);
        BufferedWriter bw1 = new BufferedWriter(fw1);
        FileWriter fw2 = new FileWriter(entradas[1]);
        BufferedWriter bw2 = new BufferedWriter(fw2);
        FileWriter fw3 = new FileWriter(entradas[2]);
        BufferedWriter bw3 = new BufferedWriter(fw3);
        FileWriter[] fws = {fw1,fw2,fw3};
        BufferedWriter[] bws = {bw1,bw2,bw3};
        
        //array de Strings con los textos de entradas
        String[] textos = {
        		"1 15.45\n2 12.78\n3 14.23\n4 13.10\n5 16.55",
        		"1 14.98\n2 12.45\n3 13.78\n4 12.90\n5 15.32",
        		"1 16.20\n2 13.80\n3 15.10\n4 14.45\n5 17.05"
        		};
        
        //compruebo si los archivos existen
        for (int i=0; i<ficheros.length; i++) {
        	for (int j=0; j<ficheros[i].length; j++) {
        		if (!ficheros[i][j].exists()) {
        			try {
						ficheros[i][j].createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
        		}
        	}
        }
        
        //escribo los textos en los archivos de entrada
        for (int i = 0; i < entradas.length; i++) {
            String texto = textos[i];

            try {
                bws[i].write(texto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        
        //cierro los flujos de datos
        for (BufferedWriter bw : bws) {
    		bw.close();
    	}
    	for (FileWriter fw : fws) {
    		fw.close();
    	}
    	
    	/*en cada vuelta del bucle redirecciono la entrada, error y salida para cada proceso
    	 * creo los procesos y los meto en un ayyar de procesos
    	 * guardo en la variable retorno el resultado de la prueba en base a los ficheros de entrada, salida y error
    	 * muestro el resultado de la prueba
    	 */
    	int retorno = -1;    	
		for (int i=0; i<3; i++) {
			pb_c.redirectInput(entradas[i]);
			pb_c.redirectOutput(salidas[i]);
			pb_c.redirectError(errores[i]);
			try {
				procesos[i] = pb_c.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			retorno = Prueba(entradas[i],salidas[i],errores[i]);			
			System.out.println("La prueba " + (i+1) + " ha devuelto " + retorno);
		}
	}
	
	public static int Prueba(File entrada, File salida, File error) throws IOException {
		//abro los flujos de datos que voy a necesitar
		FileReader fr1 = new FileReader(entrada);
		BufferedReader br1 = new BufferedReader(fr1);
		FileReader fr2 = new FileReader(salida);
		BufferedReader br2 = new BufferedReader(fr2);
		// dos arrays en los que voy a guardar los tiempos del fichero de entrada y del fichero de salida en formato String
		String[] stiemposE;
		String[] stiemposS;
		
		//recorro los ficheros de entrada y salida y con split guardo los tiempos despreciando el dorsal
		int n = 0;
		String linea;
		String texto = "";
		while ((linea=br1.readLine())!=null) {
			texto += linea.split(" ")[1] + ";";
		}
		stiemposE = texto.split(";");
		texto = "";
		while ((linea=br2.readLine())!=null) {
			texto += linea.split(" ")[1] + ";";
		}
		stiemposS = texto.split(";");
		
		//creo dos array de float para guardar los tiempos en tipo float y compararlos
		float[] tiemposE = new float[stiemposE.length];
		float[] tiemposS = new float[stiemposS.length];
		
		//recorro los arrays de Strings, convierto los datos de String a float y los guardo en los arrays de float
		for (int i=0; i<stiemposE.length; i++) {
			tiemposE[i] = Float.valueOf(stiemposE[i]);
		}
		for (int i=0; i<stiemposS.length; i++) {
			tiemposS[i] = Float.valueOf(stiemposS[i]);
		}
		
		//ordeno el array de los tiempos de entrada de tipo float
		boolean ok = true;
		float aux;
		while (ok) {
			ok = false;
			for (int i=0; i<tiemposE.length-1; i++) {
				if (tiemposE[i]>tiemposE[i+1]) {
					aux = tiemposE[i];
					tiemposE[i] = tiemposE[i+1];
					tiemposE[i+1] = aux;
					ok = true;
				}
			}
		}	
		
		//comparo los 3 primeros tiempo y devuelvo 1 en caso de que no se correspondan algunos
		for (int i=0; i<tiemposS.length; i++) {
			if (tiemposS[i]!=tiemposE[i]) {
				n=1;
			}
		}
		
		//compruebo que el fichero de error esta vacio, sino no lo esta devuelvo -1
		if (error.length()!=0) {
			n=-1;
		}
		
		//cierro los flujos de datos y retorno un entero
		br1.close();
		br2.close();
		fr1.close();
		fr2.close();
		return n;		
	}
}
