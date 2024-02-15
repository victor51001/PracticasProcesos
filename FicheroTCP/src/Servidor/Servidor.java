package Servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import Hilo.Hilo;

public class Servidor {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            serverSocket = new ServerSocket(6001);
            System.out.println("Servidor TCP esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread thread = new Thread(new Hilo(clientSocket));
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
