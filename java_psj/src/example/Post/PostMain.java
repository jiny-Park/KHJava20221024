package example.Post;

import java.util.Scanner;

public class PostMain {
	/* 게시글 관리 프로그램
	 * 기능 1.회원가입 2.비회원 조회 3.로그인 4.종
	 * 1.회원가입  
	 * 1-1. id, pw, 이름, 나이, 주민등록번호, 주소, 이메
	 * 1-2. id가 동일한지 확인후에 없다면 저
	 * 
	 * 
	 *
	 * 
	 */
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		int menu = -1;
		
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
			
			
		}while(menu != 4);
		

	}
	
	private static void printBar() {
		System.out.println("-------------------");
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	private static void printMenu() {
		System.out.println("+ 게시글 관리 프로그램 +");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 비회원 조회");
		System.out.println("4. 종 료");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}
	
	

}
