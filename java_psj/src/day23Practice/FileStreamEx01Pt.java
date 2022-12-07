package day23Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx01Pt {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		try {
			fos = new FileOutputStream("fileTest.txt");
			
			char ch = '\u0000';
			for(int i = 0; i < 200; i++) {
				fos.write(ch);
				++ch;
			}
			
			fis = new FileInputStream("fileTest.txt");
			int num;
			for(int i = 0; i < 200; i++) {
				num = fis.read();
				System.out.print((char)num);
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
}
