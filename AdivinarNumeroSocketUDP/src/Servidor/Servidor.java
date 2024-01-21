package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;

public class Servidor {

	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			Random r = new Random();
			socket = new DatagramSocket(6001);
			int numero;
			boolean acertado = false;
			while (true) {
				acertado = false;
				numero = r.nextInt(0, 101);
				while (!acertado) {
					byte[] bufferE = new byte[1024];

					DatagramPacket paqueteE = new DatagramPacket(bufferE, bufferE.length);
					socket.receive(paqueteE);
					int intento = Integer.parseInt(new String(paqueteE.getData()).trim());

					DatagramPacket paqueteS;
					byte[] bufferS;
					if (intento < numero) {
						bufferS = "-1".getBytes();
						paqueteS = new DatagramPacket(bufferS, bufferS.length, paqueteE.getAddress(),
								paqueteE.getPort());
						socket.send(paqueteS);
					} else if (intento > numero) {
						bufferS = "1".getBytes();
						paqueteS = new DatagramPacket(bufferS, bufferS.length, paqueteE.getAddress(),
								paqueteE.getPort());
						socket.send(paqueteS);
					} else {
						bufferS = "0".getBytes();
						paqueteS = new DatagramPacket(bufferS, bufferS.length, paqueteE.getAddress(),
								paqueteE.getPort());
						socket.send(paqueteS);
						acertado = true;
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
