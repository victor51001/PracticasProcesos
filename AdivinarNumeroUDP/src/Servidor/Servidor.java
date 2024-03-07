package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Random;

public class Servidor {

	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			Random r = new Random();
			socket = new DatagramSocket(6001);
			HashMap<Integer,Integer> partidas = new HashMap<Integer,Integer>();
			int numero = 0;
				byte[] bufferE = new byte[1024];
				do {
					DatagramPacket paqueteE = new DatagramPacket(bufferE, bufferE.length);
					socket.receive(paqueteE);
					if (!partidas.containsKey(paqueteE.getPort())) {
						numero = r.nextInt(0, 101);
						partidas.put(paqueteE.getPort(), numero);
					}
					int intento = Integer.parseInt(new String(paqueteE.getData()).trim());
					DatagramPacket paqueteS;
					byte[] bufferS;
					if (intento < partidas.get(paqueteE.getPort())) {
						bufferS = "-1".getBytes();
						paqueteS = new DatagramPacket(bufferS, bufferS.length, paqueteE.getAddress(),
								paqueteE.getPort());
						socket.send(paqueteS);
					} else if (intento > partidas.get(paqueteE.getPort())) {
						bufferS = "1".getBytes();
						paqueteS = new DatagramPacket(bufferS, bufferS.length, paqueteE.getAddress(),
								paqueteE.getPort());
						socket.send(paqueteS);
					} else {
						bufferS = "0".getBytes();
						paqueteS = new DatagramPacket(bufferS, bufferS.length, paqueteE.getAddress(),
								paqueteE.getPort());
						socket.send(paqueteS);
						partidas.remove(paqueteE.getPort());
					}
				} while (true);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
