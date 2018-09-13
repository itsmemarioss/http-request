package br.com.itsmemario.httprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Performing a http request with sockets.
 * Just for fun.
 * 
 * @author mario
 *
 */
public class Main {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		StringBuilder get = new StringBuilder();
		get.append("GET / HTTP/1.1\r\n");
		get.append("Host: www.itsmemario.com.br\r\n\r\n");
		
		System.out.println("REQUEST\n"+get);
		
		Socket httpSocket = new Socket(InetAddress.getByName("www.itsmemario.com.br"), 80);
		OutputStream out = httpSocket.getOutputStream();
		out.write(get.toString().getBytes());
		out.flush();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(httpSocket.getInputStream()));
		
		String line;
		System.out.println("RESPONSE");
		while((line = reader.readLine()) != null) {
			System.out.println(line);			
		}	
		
		reader.close();
	}
}
