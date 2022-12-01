package day23;

import java.io.*;

public class FileStreamEx03 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			
			fis = new FileInputStream("test.txt");
			fos = new FileOutputStream("test.txt");
			dis = new DataInputStream(fis);
			dos = new DataOutputStream(fos);
			
			dos.writeUTF("박서진");
			dos.writeUTF("2000-00-00");

			dos.writeUTF("송혜교");
			dos.writeUTF("2000-03-02");
			
			dos.writeUTF("유재석");
			dos.writeUTF("2000-04-04");
			
			// 순서가 아주 중요! 패턴을 맞춰줘야 된다!!!
			while(true) {
				String name = dis.readUTF();
				String birth = dis.readUTF();
				System.out.println(name + ", " + birth);
			}
	
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료됐습니다!");
		}catch(Exception e) {	// 최상위 클래스 Exception을 통해 다른 예외 클래스를 미리 차단
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				fos.close();
				dis.close();
				dos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
