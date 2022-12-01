package day30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardMain {
	
	private static Scanner scan = new Scanner(System.in);
	private static List<Board> boardlist = new ArrayList<Board>(); 
	
	public static void main(String[] args) {
		/* 기능 : 
		 * 	- 게시글 등록
		 * 	- 게시글 수정
		 * 	- 게시글 삭제
		 * 	- 게시글 목록
		 * 	- 게시글 확인
		 * 		-댓글 등록
		 * 		-댓글 확인
		 * 		-이전
		 *  - 프로그램 종료
		 */
		
		// 메뉴를 출력하고, 입력한 메뉴가 프로그램 종료가 아니면 반복하는 코드를 작성	

		
		int menu = -1;
		
		while(menu != 6) {
			printMenu();
			menu = scan.nextInt();
			printBar();		
			runMenu(menu, boardlist);
		}
		
//		for(;menu != 6;) {
//			printMenu();
//			menu = scan.nextInt();
//			printBar();	
//		}
		
//		do {				최소 1번은 반복하는 do while문
//			printMenu();
//			menu = scan.nextInt();
//			printBar();	
//		}while(menu != 6);

	}

	private static void printBar() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	/** 메뉴를 출력하는 메소드
	 * 1. 게시글 등록
	 * 2. 게시글 수정
	 * 3. 게시글 삭제
	 * 4. 게시글 목록
	 * 5. 게시글 확인
	 * 6. 프로그램 종료
	 * 메 뉴 선 택 : 
	 */
	private static void printMenu() {
		System.out.println("# 게시글 프로그램 #");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 목록");
		System.out.println("5. 게시글 확인");
		System.out.println("6. 프로그램 종료");
		System.out.print("메 뉴 선 택 : ");
	}
	
	/** runMenu
	 * 메뉴가 주어지면 주어진 메뉴에 맞는 기능을 출력하는 메소드
	 * @param mneu 선택된 메뉴
	 */
	private static void runMenu(int menu, List<Board> boardlist) {
		switch(menu) {
		case 1: 
			insertBoard(boardlist);
			printBar();
			break;
		case 2: 
			System.out.println("게시글 수정 예정");
			printBar();
			break;
		case 3: 
			System.out.println("게시글 삭제 예정");
			printBar();
			break;
		case 4: 
			System.out.println("게시글 목록 예정");
			printBar();
			break;
		case 5: 
			System.out.println("게시글 확인 예정(댓글 등록, 댓글 확인, 이전 예정)");
			printBar();
			break;
		case 6: 
			printStr("[ 프로그램을 종료합니다! ]");
			break;
		default:
			printStr("[ 잘못된 메뉴를 선택했습니다! ]");
		}	
	}
	
	/** insertBoard
	 * 게시글 정보를 입력받아 게시글을 출력하는 메소드
	 * 메소드 구현에 필요한 필드를 추가해도 됨
	 */
	private static void insertBoard(List<Board> boardlist) {
		// 번호, 제목, 내용, 작성자
		System.out.print("번 호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.print("제 목 : ");
		String title = scan.nextLine();
		System.out.print("내 용 : ");
		String contents = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		
		Board board = new Board(num, title, contents, writer);
		
		// 같은 번호가 있다면 존재하는 게시글이라고 알려준다.
		if(boardlist.contains(board)) {
			printStr("등록 불가! "
					+ "같은 번호의 게시글이 존재합니다!");
			return;
		}
		
		// 같은 번호가 없다면 번호, 제목, 내용, 작성자를 리스트에 저장.
		boardlist.add(board);
		System.out.println(boardlist);	
	}
	
	
}
