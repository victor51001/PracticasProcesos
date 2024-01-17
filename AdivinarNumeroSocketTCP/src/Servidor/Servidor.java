package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Hilo.Hilo;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int puerto = 6001;
		try {
			ServerSocket ssock = new ServerSocket(puerto);
			while (true) {
				Socket cliente = ssock.accept();
				Hilo hilo = new Hilo(cliente);
				hilo.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
