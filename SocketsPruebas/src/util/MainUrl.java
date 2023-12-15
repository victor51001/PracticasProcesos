package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainUrl {

	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://192.168.146.250/procesos/pruebas.html");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Visualizar(url);
		BufferedReader br = null;			
		String linea;
		try {
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void Visualizar(URL url) {
		System.out.println("\tURL completa:"+url.toString());
		System.out.println("\tgetProtocol():"+url.getProtocol());
		System.out.println("\tgetHost():"+url.getHost());
		System.out.println("\tgetPort():"+url.getPort());
		System.out.println("\tgetFile():"+url.getFile());
		System.out.println("\tgetUserInfo():"+url.getUserInfo());
		System.out.println("\tgetPath():"+url.getPath());
		System.out.println("\tgetAuthority():"+url.getAuthority());
		System.out.println("\tgetQuery():"+url.getQuery());
		System.out.println("\tgetDefaultPort():"+url.getDefaultPort());
	}
}
