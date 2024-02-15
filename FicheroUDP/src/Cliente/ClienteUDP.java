package Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {

    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            socket = new DatagramSocket();

            System.out.println("Ingrese el nombre del archivo:");
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();

            byte[] fileNameBytes = fileName.getBytes();
            DatagramPacket requestPacket = new DatagramPacket(fileNameBytes, fileNameBytes.length, serverAddress, 6001);
            socket.send(requestPacket);

            while (true) {
                byte[] responseBuffer = new byte[1024];
                DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
                socket.receive(responsePacket);

                String response = new String(responsePacket.getData(), 0, responsePacket.getLength());

                if (response.equals("Fin del flujo de entrada.")) {
                    break;  // Salir del bucle cuando se alcanza el final del flujo
                }

                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
