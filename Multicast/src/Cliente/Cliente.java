package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Cliente {

    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket(12345);
            InetAddress grupo = InetAddress.getByName("225.0.0.1");
            socket.joinGroup(grupo);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String mensaje;

            while (true) {
                byte[] buffer = new byte[256];
                DatagramPacket entrada = new DatagramPacket(buffer, buffer.length);
                socket.receive(entrada);
                String texto = new String(entrada.getData()).trim();
                System.out.println("Recibido: " + texto);

                if (texto.equals("fin")) {
                    System.out.println("Cliente cerrado por el servidor.");
                    break;
                }

                System.out.print("Cliente: ");
                mensaje = reader.readLine();
                byte[] bufferCliente = mensaje.getBytes();
                DatagramPacket dpCliente = new DatagramPacket(bufferCliente, bufferCliente.length, grupo, 12345);
                socket.send(dpCliente);

                if (mensaje.equals("fin")) {
                    break;
                }
            }

            socket.leaveGroup(grupo);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
