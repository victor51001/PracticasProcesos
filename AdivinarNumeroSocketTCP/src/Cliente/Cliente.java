package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Socket sock = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		boolean acertado = false;
		try {
			sock = new Socket("localhost",6001);
			System.out.println("Conexion establecida");
			dis = new DataInputStream(sock.getInputStream());
			dos = new DataOutputStream(sock.getOutputStream());
			while(!acertado) {
				System.out.println("Introduce un numero: ");
				int intento = sc.nextInt();
				dos.writeInt(intento);
				dos.flush();
				int numero = dis.readInt();
				switch (numero) {
					case -1:
						System.out.println("El numero es mayor");
						break;
					case 1:
						System.out.println("El numero es menor");
						break;
					case 0:
						System.out.println("Has acertado");
						acertado = true;
						break;
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				dos.close();
				sock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
