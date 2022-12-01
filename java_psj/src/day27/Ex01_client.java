package day27;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_client {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[연결 시도 중]");
			socket.connect(new InetSocketAddress(1004));
			// "192.168.10.6", 5001 강사님 자리 IP 주소
			System.out.println("[연결 성공]");
			send(socket, "서진");
			recive(socket);
		}catch (Exception e) {
			System.out.println("[연결 실패]");
		}
	}
	
	public static void recive(Socket socket) {
		Thread t = new Thread(()-> {				
			InputStream is = null;
			try {
				byte [] bytes = new byte[1024];
				is = socket.getInputStream();
				while(true) {
					int readCount = is.read(bytes);	
					if(readCount == -1) {
						break;
					}
					String str = new String(bytes, 0, readCount, "UTF-8");
					int index = str.indexOf(",");
					if(index == -1) {
						continue;
					}
					String name = str.substring(0, index);
					String message = str.substring(index+1);
					System.out.println(name + ">" + message);	// > 은 구분하기 위해서
				}
				is.close();
			}catch(Exception e) {
				
			}finally {
					try {
						if(socket != null && !socket.isClosed()) 
							socket.close();
						System.out.println("[클라이언트 종료]");
					}catch (Exception e2) {
						System.out.println("[클라이언트 소켓 닫기 실패]");
					}
			}	
		});
		t.start();
	}
	
	public static void send(Socket socket, String name) {
		Thread t = new Thread(()->{
			Scanner scan = new Scanner(System.in);
			
			try {
				OutputStream os = socket.getOutputStream();
				while(true) {
					String str = scan.nextLine();
					if(str.equals("exit")) {
						if(socket != null && !socket.isClosed()) {
							socket.close();
						}
						os.close();
						break;
					}
					str = name + "," + str;
					byte [] bytes = str.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
				}
			}catch (Exception e) {
				e.printStackTrace();// 어디서 예외가 발생했는지, 문구를 안 보려면 지워주면 됨.
			}finally {
				System.out.println("종료");
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				}catch (Exception e) {
					System.out.println("클라이언트 소켓 종료 실패");
				}
			}
		
		});
		t.start();
		
	}

}
