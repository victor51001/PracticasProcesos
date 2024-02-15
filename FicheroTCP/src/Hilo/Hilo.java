package Hilo;

import java.io.*;
import java.net.Socket;

public class Hilo implements Runnable {
    private Socket clientSocket;

    public Hilo(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());

            String fileName = dis.readUTF();
            System.out.println("Cliente solicita el archivo: " + fileName);

            boolean fileExists = new File(fileName).exists();
            dos.writeBoolean(fileExists);
            dos.flush();

            if (fileExists) {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = br.readLine()) != null) {
                    dos.writeUTF(line);
                    dos.flush();
                }
                br.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
                if (dos != null) dos.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
