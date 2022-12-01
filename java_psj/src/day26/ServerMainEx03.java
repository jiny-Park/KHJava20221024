package day26;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMainEx03 {

	/* 클라이언트가 연결을 요청하면 연결을 하고,
	 * 연결이 종료되기전까지 클라이언트가 전송한 문자열을 계속 출력함
	 * 
	 */
	static Scanner scna = new Scanner(System.in);
	static final String encode = "UTF-8";
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5002));
			
			while(true) {
				System.out.println("[연결 대기 중]");
				Socket socket = serverSocket.accept();
				read(socket);				
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void read(Socket socket) {
		Thread t = new Thread( () -> {
			try {
				System.out.println("[연결 수락 함] : " + socket.getRemoteSocketAddress());			
				InputStream is = socket.getInputStream();
			
			while(true) {
				byte [] bytes = new byte[1024];
				int readCount = is.read(bytes);
				if(readCount == -1) {
					break;
				}
				String str = new String(bytes, 0, readCount, encode);
				System.out.println(str);
			}
				is.close();	
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
	
	
	
}
