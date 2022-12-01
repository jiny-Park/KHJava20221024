package day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMainEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 1. 서버 소켓 생성
		ServerSocket serverSocket = null;
		final String encode = "UTF-8";
		
		try {
			serverSocket = new ServerSocket();	// 소켓 객체를 만들고
			// 2. 바인드를 통해 연결을 해줘야 함
			serverSocket.bind(new InetSocketAddress(5001)); // 포트 번호가 클라이언트와 서로 같아야함.
			while(true) {
				System.out.println("[연결 대기 중]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("[연결 수락 함]" + isa.getAddress());
				InputStream is = socket.getInputStream();
				byte [] bytes = new byte[1024];
				int readCount = is.read(bytes);
				String str = new String(bytes, 0, readCount, encode);
				System.out.println(str);
				
				// 콘솔에서 문자열을 입력받아 클라이언트로 전송
				OutputStream os = socket.getOutputStream();
				System.out.print("입력 : ");
				str = scan.nextLine();
				bytes = str.getBytes(encode);
				os.write(bytes);
				os.flush();
				System.out.println("[전송 완료]");
				os.close();
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
