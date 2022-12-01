package day21Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class PhListMaintPT {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int menu = -1;
		ArrayList<PhBookPT> list = new ArrayList<PhBookPT>();
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			printBar();
			
			runMenu(menu, list);
			
		}while(menu != 5);

	}
	




	private static void printBar() {
		System.out.println("--------------");
	}

	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	private static void printMenu() {
		System.out.println("전화번호부 메 뉴 ");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 프로그램 종료");
		System.out.print("메 뉴 선 택 : ");	
	}
	
	private static void runMenu(int menu, ArrayList<PhBookPT> list) {
		switch(menu) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			printStr("프로그램 종료");
			break;
		default:
			printStr("잘 못 선택");
		}
		
	}
}
