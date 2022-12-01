package day26;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class ClientMainEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Socket socket = null;
		final String encode = "UTF-8";
		// 오늘 예제는 서버와 클라이언트  
		try {

			while(true) {		
				socket = new Socket();
				socket.connect(new InetSocketAddress(5001));
				System.out.println("[연결 완료]");
				// OutputStream 연결
				OutputStream os = socket.getOutputStream();
				// 보내려는 문자열을 바이트 배열로 변환해줌
				System.out.print("입력 : ");
				String str = scan.nextLine();
				byte [] bytes = str.getBytes(encode); // 바이트로 만들어서 전해줘야 함
				// 전송
				os.write(bytes);
				os.flush();
				// OutputStream 객체 닫음.
					
				// 서버에서 보낸 문자열을 입력받아 콘솔에 출력
				InputStream is = socket.getInputStream();
				bytes = new byte[1024];
				int readCount = is.read(bytes);
				str = new String(bytes, 0, readCount, encode);
				System.out.println(str);
				is.close();
				os.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
