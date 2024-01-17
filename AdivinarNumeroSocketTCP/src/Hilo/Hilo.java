package Hilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class Hilo extends Thread {
	private Socket cliente;
	private int numero;
	private DataInputStream entrada;
	private DataOutputStream salida;

	public Hilo(Socket client) {
		Random r = new Random();
		cliente = client;
		numero = r.nextInt(0, 101);
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			InputStream is = cliente.getInputStream();
			OutputStream os = cliente.getOutputStream();
			entrada = new DataInputStream(is);
			salida = new DataOutputStream(os);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		try {
			int intento;
			for (int i=0; i<10; i++) {
			while ((intento = entrada.readInt()) != numero) {
				System.out.println("El numero es " + numero);
				System.out.println("El intento es " + intento);
				if (intento < numero) {
					salida.writeInt(-1);
				} else {
					salida.writeInt(1);
				}
				salida.flush();
			}
			System.out.println("El numero es " + numero);
			System.out.println("El intento es " + intento);
			salida.writeInt(0);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
