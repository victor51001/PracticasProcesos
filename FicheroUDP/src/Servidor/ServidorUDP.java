package Servidor;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {

    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(6001);
            System.out.println("Servidor UDP esperando conexiones...");

            while (true) {
                byte[] requestBuffer = new byte[1024];
                DatagramPacket requestPacket = new DatagramPacket(requestBuffer, requestBuffer.length);
                socket.receive(requestPacket);

                String fileName = new String(requestPacket.getData(), 0, requestPacket.getLength());
                System.out.println("Cliente solicita el archivo: " + fileName);

                InetAddress clientAddress = requestPacket.getAddress();
                int clientPort = requestPacket.getPort();

                boolean fileExists = new File(fileName).exists();

                if (fileExists) {
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            byte[] responseBytes = line.getBytes();
                            DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, clientAddress, clientPort);
                            socket.send(responsePacket);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    String response = "El archivo no existe";
                    byte[] responseBytes = response.getBytes();
                    DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, clientAddress, clientPort);
                    socket.send(responsePacket);
                }
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
