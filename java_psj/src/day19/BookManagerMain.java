package day19;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;

public class BookManagerMain {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 도서 관리 프로그램을 작성하세요.
		 * 도서 정보 : 
		 *  - ISBN (ISBN으로 정렬)
		 * 	- 도서명 
		 * 	- 저자(여러명, 엮은이, 옮긴이 다 포함)
		 * 	- 가격
		 * 	- 출판사
		 * 	- 분류
		 * 
		 * 기능 
		 * 	- 1. 도서 추가
		 * 		- ISBN으로 정렬
		 *  - 2. 도서 조회
		 *  	- 2-1. 도서명으로 조회
		 *  	- 2-2. 저자로 조회
		 *  	- 2-3. 출판사로 조회
		 *  	- 2-4. 분류로 조회
		 *  - 3. 프로그램 종료
		 */
		
		// 도서정보 리스트를 담을 BookInfor 클래스 생성 -> ISBN, 도서명, 저자(여러명, 엮은이, 옮긴이 다포함), 가격, 출판사, 분류
		
		// 필요한 메서드 : 메뉴 출력, 메뉴 선택, 메뉴 실행(기능 : 각 기능별 메서드 필요), 
		
		int menu = -1;
		ArrayList<BookInfor> list = new ArrayList<BookInfor>();
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			runMenu(list, menu, scan);
			
		
		}while(menu != 3);

		
	}

	public static void runMenu(ArrayList<BookInfor> list, int menu, Scanner scan) {
		switch(menu) {
		case 1:
			if(insertBook(list)) {
				printStr("입력한 도서를 추가했습니다.");
			}else {
				printStr("입력한 도서가 이미 존재합니다.");
			}
			break;
		case 2:
			printSubMenu();
			int seleteSubMenu = scan.nextInt();
			runSubMenuRun(list, seleteSubMenu);
			break;
		case 3:
			System.out.println("프로그램 종료 Good bye~");
			break;
		default:
			System.out.println("잘못 입력했으~");
		}
		
	}

	public static void printStr(String str) {
		System.out.println("-------------");
		System.out.println(str);
		System.out.println("-------------");
		
	}

	public static boolean insertBook(ArrayList<BookInfor> list) {
		// 도서 정보 ISBN, 도서명, 저자(여러명, 엮은이, 옮긴이 다포함), 가격, 출판사, 분류
		scan.nextLine();
		System.out.print("도서명 : ");
		String bookName = scan.nextLine();
		System.out.print("저자(여러명, 엮은이, 옮긴이 포함) : ");
		String writer = scan.nextLine();
		System.out.print("가격 : ");
		int price = scan.nextInt();
		scan.nextLine();
		System.out.print("출판사 : ");
		String publisherConpany = scan.nextLine();
		System.out.print("분야(소설/자기개발등) : ");
		String type = scan.nextLine();
		
		BookInfor book = new BookInfor(bookName, writer, price, publisherConpany, type);
		
		if(list.contains(book)) {
			return false;
		}
		list.add(book);
		return true;
	}

	public static void runSubMenuRun(ArrayList<BookInfor> list, int seleteSubMenu) {
		//- 2. 도서 조회
		 /*  	- 2-1. 도서명으로 조회
		 *  	- 2-2. 저자로 조회
		 *  	- 2-3. 출판사로 조회
		 *  	- 2-4. 분류로 조회
		 */  	
	}



	public static void printSubMenu() {
		System.out.println("조회 조건 선택해!");
		System.out.println("1. 도서명 조회");
		System.out.println("2. 저자로 조회");
		System.out.println("3. 출판사로 조회");
		System.out.println("4. 분류로 조회");
		System.out.print("당신의 선택 : ");
	}

	public static void printMenu() {
		System.out.println(" # 메 뉴 # ");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 조회");
		System.out.println("3. 종 료");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
