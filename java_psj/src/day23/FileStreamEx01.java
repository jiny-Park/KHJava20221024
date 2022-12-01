package day23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
// io 같은 경우엔 반드시 예외처리를 해줘야 하는 부분들이 많음.
import java.io.IOException;

public class FileStreamEx01 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		try {
			fos = new FileOutputStream("test.txt");
			
//			char ch = '나';	// -> \로 나오는 이유는? write는 1byte 변환하기 때문에, 데이터손실이 되어 우리가 원하지 않는 글자가 나오기도 함.
//			fos.write(ch);
			char ch = '\u0000';
			for(int i = 0; i < 200; i ++) {
//				System.out.print(ch);
				fos.write(ch);
				++ch;
			}

			fis = new FileInputStream("test.txt");
			int num;
			for(int i = 0; i < 200; i ++) {
				num = fis.read();
				System.out.print((char)num);
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다!");
		}catch(IOException e) {
			e.printStackTrace();
		}finally { // 메소드가 끝나도 반드시 실행되는 finally
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}

