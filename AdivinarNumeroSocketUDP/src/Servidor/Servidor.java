package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;

public class Servidor {

	public static void main(String[] args) {
		try {
			Random r = new Random();
			int numero = r.nextInt(0,101);
			while (true) {
				DatagramSocket socket = new DatagramSocket();
				
				byte[] buffer = new byte[256];
				
				DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
				socket.receive(paquete);
				int intento = Integer.parseInt(new String(paquete.getData()).trim());
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
