package day26;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMainEx04 {

	/* 클라이언트가 연결을 요청하면 연결을 하고,
	 * 연결이 종료되기전까지 클라이언트가 전송한 문자열을 계속 출력함
	 * 
	 */
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5002));
			
			while(true) {
				System.out.println("[연결 대기 중]");
				Socket socket = serverSocket.accept();
				Client c = new Client(socket);
				c.read();
				c.send();
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
