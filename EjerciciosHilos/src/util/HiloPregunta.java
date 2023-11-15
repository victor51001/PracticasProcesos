package util;

import java.util.Scanner;

public class HiloPregunta extends Thread{
	public static boolean ok = false;
	public void run() {
		Scanner sc = new Scanner(System.in);
        int respuesta = 0;
    	while(!isInterrupted()) {
    		System.out.println("¿En qué año se descubrió América? ¡Si no aciertas en 30 segundos, destruiré todos tus datos!");
    		try {
				respuesta = sc.nextInt();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
    		if (respuesta==1492 && !isInterrupted()) {
    			System.out.println("Por esta vez te has salvado, no te fíes de los extraños");
    			ok = true;
    			break;
    		}
    	}
	}
}
