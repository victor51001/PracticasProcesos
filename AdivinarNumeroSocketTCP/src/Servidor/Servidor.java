package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Hilo.Hilo;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int puerto = 6001;
		Hilo[] hilos = new Hilo[10];
		try {
			ServerSocket ssock = new ServerSocket(puerto);
			for (int i=0; i<10; i++) {
				Socket cliente = ssock.accept();
				Hilo hilo = new Hilo(cliente);
				hilo.start();
				hilos[i] = hilo;
			}
			for (int i=0; i<hilos.length; i++) {
				hilos[i].join();
			}
			ssock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
