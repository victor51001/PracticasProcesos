package Cliente;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            socket = new Socket("localhost", 6001);
            System.out.println("Conexión establecida");

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            System.out.println("Ingrese el nombre del archivo:");
            String fileName = scanner.nextLine();

            dos.writeUTF(fileName);
            dos.flush();

            boolean fileExists = dis.readBoolean();
            if (fileExists) {
                System.out.println("Contenido del archivo:");
                String content = "";
                try {
	                while(true) {
	                	content = content.concat("\n"+dis.readUTF());
	                }
                } catch (EOFException e) {}
                System.out.println(content);
            } else {
                System.out.println("El archivo no existe.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
                if (dos != null) dos.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
