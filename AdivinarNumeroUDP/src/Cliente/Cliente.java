package Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DatagramSocket socket = null;
		boolean sigue = false;
		try {
			InetAddress servidor = InetAddress.getByName("localhost");
			socket = new DatagramSocket();

			while (!sigue) {
				System.out.println("Introduce un numero: ");
				int intento = sc.nextInt();

				byte[] bufferS = String.valueOf(intento).getBytes();
				DatagramPacket paqueteS = new DatagramPacket(bufferS, bufferS.length, servidor, 6001);

				socket.send(paqueteS);

				byte[] bufferE = new byte[1024];
				DatagramPacket paqueteE = new DatagramPacket(bufferE, bufferE.length);

				socket.receive(paqueteE);
				String respuesta = new String(paqueteE.getData()).trim();

				switch (respuesta) {
				case "-1":
					System.out.println("El numero es mayor");
					break;
				case "1":
					System.out.println("El numero es menor");
					break;
				case "0":
					System.out.println("Has acertado");
					System.out.println("Quieres seguir jugando? (s/n)");
					String seguir = sc.next();
					if (seguir.equals("n")) {
						sigue = true;
					}
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}

}
