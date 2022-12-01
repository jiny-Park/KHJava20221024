package day27;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Ex01_Server {
	
	private static ArrayList<Client> clientList = new ArrayList<Client>();

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(1004));
			System.out.println("[서버 시작]");
			while(true){
				Socket socket = serverSocket.accept();
				Client client = new Client(socket);
				client.recive();
				clientList.add(client);
				System.out.println("[클라이언트 접속] - 현재 접속 인원 : " + clientList.size());
			}			
		} catch (Exception e) {
			System.out.println("[예외 발생 : 서버 종료]");
		}
		

	}
	// class 안에 class를 내부 클래스라고 함.
	static class Client {
		private Socket socket;
		
		public Client(Socket socket) {
			this.socket = socket;
		}
		
		public void recive() {
			Thread t = new Thread(()-> {	
	// 람다식은 함수적 인터페이스(메소드가 하나만 있는 인터페이스)를 구현할 때 필요함.
	// 쓰레드 클래스			
				InputStream is = null;
				try {
					byte [] bytes = new byte[1024];	// 한 번 읽어올 수 있는 byte의 최대 갯수
					is = socket.getInputStream();
					
					while(true) {
						int readCount = is.read(bytes);	// 읽어온 갯수를 저장함
						/* read() : 1byte를 읽어와서 정수로 알려줌
						 * read(byte[] bytes) : bytes 크기만큼 한 번에 읽어 와서 bytes 배열에 저장하고,
						 * 						읽어온 갯수를 정수로 알려줌.
						 */
						
						if(readCount == -1) {
							break;
						}
						
						String str = new String(bytes, 0, readCount, "UTF-8");
						// byte[]에 있는 byte들을 문자열로 변환, 0번지부터 
						// readCount 개수만큼 변환하는데 인코딩은 UTF-8
						System.out.println(str);
						// 다른 Client들에게 str을 전송
						if(clientList.size() == 0) {
							continue;
						}
						for(Client tmp : clientList) {
							tmp.send(str);
						}
					}
					is.close();
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					// 읽기 위해서 대기하다 예외가 발생하면 socket를 닫아줌.
					// => Client에서 접속을 종료함
						try {
							if(socket != null && !socket.isClosed()) 
								socket.close();
							// 클라이언트 리스트에서 접속 종료한 클라이언트를 제거
							clientList.remove(this);
							System.out.println("[클라이언트 종료] - 현재 접속 인원 : " + clientList.size());
						} catch (Exception e2) {
							System.out.println("[클라이언트 소켓 닫기 실패]");
						}
				}
				
			});
			t.start();
		}
		
		public void send(String data) {
			Thread t = new Thread(()-> {
				OutputStream os = null;
				try {
					os = socket.getOutputStream();
					byte [] bytes = data.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
				}catch(Exception e){
					System.out.println("서버 예외 발생");
				}			
			});
			t.start();	
		}
	}
	
}
