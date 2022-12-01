package day23;

import java.io.File;
import java.io.IOException;

public class FileEx01 {

	public static void main(String[] args) {
						// 상대경로로 지정했기에 프로젝트 안에 생성이 됨.
//		File f = new File("text.txt");
//		try {
//			if(f.createNewFile()) {
//				// RuntimeException외에는 다 예외처리를 해줘야함.
//				
//				System.out.println("File 생성되었습니다!");
//			}else {
//				System.out.println("File 생성이 실패하였습니다!");
//			}
//		}catch(IOException e) {
//			System.out.println("IOException이 발생");
//		}
		
		// 절대경로
//		File f = new File("C:\\Users\\user2\\Downloads/test.txt");
//		try {
//			if(f.createNewFile()) {
//				System.out.println("File 생성되었습니다!");
//			}else {
//				System.out.println("File 생성이 실패하였습니다!");
//			}
//		}catch(IOException e) {
//			System.out.println("IOException이 발생");
//		}
		
		File f = new File("D:/test2/test");
		// mkdir()가 false인 경우 :
		// 	1. 이미 있는 폴더인 경우
		//	2. 상위 폴더가 없는 경우	
		if(f.mkdir()) {
			System.out.println("폴더 생성되었습니다!");
		}else {
			System.out.println("이미 폴더가 있거나 상위 폴더가 없습니다!!");
		}
		
		if(f.mkdirs()) {
			System.out.println("폴더들이 생성되었습니다!");
		}else {
			System.out.println("이미 폴더들이 있습니다!");
		}
		
		if(f.isDirectory()) 
			System.out.println("폴더명 : " + f.getName());
		if(f.isFile())
			System.out.println("파일명 : " + f.getName());
		
		// 삭제
		if(f.delete()) {
			System.out.println("폴더가 삭제 됐습니다!");
		}else {
			System.out.println("없는 폴더입니다!");
		}
		
		
	}
}
