package Hilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class Hilo extends Thread{
	private Socket cliente;
	private int numero;
	
	public Hilo(Socket client) {
		Random r = new Random();
		cliente = client;
		numero = r.nextInt(0,101);
	}

	@Override
	public void run() {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			dis = new DataInputStream(cliente.getInputStream());
			dos = new DataOutputStream(cliente.getOutputStream());
			int intento;
			intento = dis.readInt();
			System.out.println("El numero es " + numero);
			System.out.println("El intento es " + intento);
			dos.flush();
			while(intento!=numero) {
				if (intento<numero) {
					dos.writeInt(-1);
				} else {
					dos.writeInt(1);
				}
			}
			dos.writeInt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
