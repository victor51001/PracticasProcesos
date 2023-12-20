package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class Servidor extends ServerSocket{

	public Servidor(int port) throws UnknownHostException, IOException {
		super(port);
	}
	
}
