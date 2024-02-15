package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress grupo = InetAddress.getByName("225.0.0.1");
            byte[] mensaje = "Hola soy el profesor Javier".getBytes();
            DatagramPacket dp = new DatagramPacket(mensaje, mensaje.length, grupo, 12345);
            socket.send(dp);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String mensajeServidor;

            while (true) {
                System.out.print("Servidor: ");
                mensajeServidor = reader.readLine();
                byte[] bufferServidor = mensajeServidor.getBytes();
                DatagramPacket dpServidor = new DatagramPacket(bufferServidor, bufferServidor.length, grupo, 12345);
                socket.send(dpServidor);

                if (mensajeServidor.equals("fin")) {
                    break;
                }

                byte[] buffer = new byte[256];
                DatagramPacket entrada = new DatagramPacket(buffer, buffer.length);
                socket.receive(entrada);
                String texto = new String(entrada.getData()).trim();
                System.out.println("Recibido de cliente: " + texto);

                if (texto.equals("fin")) {
                    System.out.println("Servidor cerrado por el cliente.");
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
