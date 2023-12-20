package sockets;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente extends Socket{

	public Cliente(String host, int port) throws UnknownHostException, IOException {
		super(host, port);
	}

}
