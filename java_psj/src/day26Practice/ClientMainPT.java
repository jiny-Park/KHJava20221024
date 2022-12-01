package day26Practice;

import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientMainPT {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(5003));
			System.out.println("★연결 완료★");
			ClientPT c = new ClientPT(socket);
			c.send();
			c.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
