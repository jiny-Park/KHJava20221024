package day26Practice;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMainPT {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5003));
			
			System.out.println("★연결 대기 중★");
			Socket socket = serverSocket.accept();
			ClientPT c = new ClientPT(socket);
			c.read();
			c.send();
			
		} catch (Exception e) {	// Exception으로 그냥 단순하게 모든 상황을 하나의 안내로 처리할 수도 있지만,
								// 상황에 맞춰서 예외 발생 코드를 안내하고 싶다면 그 상황에 맞는 예외 처리를 해줘야 한다.
			e.printStackTrace();
		}

	}

}
