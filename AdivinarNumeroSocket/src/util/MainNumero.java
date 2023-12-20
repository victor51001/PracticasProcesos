package util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.UnknownHostException;

import sockets.Cliente;
import sockets.Servidor;

public class MainNumero {
	public static void main(String[] args) {
		int puerto=6000;
		try {
			Cliente cliente = new Cliente("localhost",puerto);
			Servidor server = new Servidor(puerto);
			
			OutputStream as = cliente.getOutputStream();
			DataOutputStream dos = new DataOutputStream(as);
		} catch (UnknownHostException e){
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}