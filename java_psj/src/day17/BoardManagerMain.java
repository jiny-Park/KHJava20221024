package day17;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardManagerMain {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		/* 게시글 관리 프로그램을 작성하세요
		 * 1. 게시글 작성
		 * 2. 게시글 조회
		 * 3. 게시글 수정
		 * 4. 게시글 삭제
		 * 5. 프로그램 종료
		 * - 게시글은 번호, 제목, 내용, 작성자, 작성일, 조회수로 구성
		 * - 게시글 전체 조회는 나중에 작성된 게시글이 상단에 조회
		 * - 게시글 상세 조회는 게시글 번호를 입력하여 게시글 내용을 확인
		 * - 게시글 상세 조회를 하면 조회수가 1증가
		 * - 게시글 수정은 게시글 번호를 선택하면 해당 게시글의 제목, 내용을 수정
		 * - 게시글 삭제는 게시글 번호를 선택하면 해당 게시글을 삭제
		 * 
		 * 
		 */
		
		
		// menu 변수, list(class 생성) 필요
		int menu = -1;
		ArrayList<Board> list = new ArrayList<Board>();
		
		
		do {
			// 메뉴 출력
			printMenu();
		
			// 메뉴 선택
			menu = scan.nextInt();

			// 기능 실행
			runMenu(menu, list);
			
		}while(menu != 5);
		
		

	}

	private static void runMenu(int menu, ArrayList<Board> list) {
		/* - 게시글은 번호, 제목, 내용, 작성자, 작성일, 조회수로 구성
		 * - 게시글 전체 조회는 나중에 작성된 게시글이 상단에 조회
		 * 
		 * - 게시글 상세 조회는 게시글 번호를 입력하여 게시글 내용을 확인
		 * - 게시글 상세 조회를 하면 조회수가 1증가
		 * - 게시글 수정은 게시글 번호를 선택하면 해당 게시글의 제목, 내용을 수정
		 * - 게시글 삭제는 게시글 번호를 선택하면 해당 게시글을 삭제
		 */
		
		switch(menu) {
		case 1:
			// 게시글 작성
			write(list);	
			break;
		case 2:
			// 게시글 조회
			boardLook(list);
			break;
		case 3:

			// 게시글 수정
			// 번호, 제목만 출력 
			printBoard(list);
			//> 번호 선택 >
			System.out.print("수정하실 글 번호를 선택 : ");
			int index = scan.nextInt() -1;
			printBoardDetaile(list, index);
			
			// 선택한 번호 상세 조회
			
			// 수정 > 수정 완료
			scan.nextLine();
			System.out.print("수정할 제목 : ");
			String title = scan.nextLine();
			System.out.print("수정할 내용 : ");
			String texts = scan.nextLine();

			
			break;
		case 4:
			// 게시글 삭제
			printBoard(list);
			deleteBoard(list);
			break;
		case 5:
			System.out.println("프로그램 종료 \"I see u. See u again~\"");
			break;
		default:
			System.out.println();
			System.out.println("※경고! 집중해. 다시 입력해봐!");
			System.out.println();
		
		
		}
		
	}
	
	/**
	 * 게시글 조회와 번호 입력시 상세조회, 상세조회시 조회시 +1 증가
	 * @param list
	 */
	private static void boardLook(ArrayList<Board> list) {
		// 게시글 조회
		// 조회기능을 선택시 먼저 글 번호와 제목만 전체 출력이 되게끔 한다.
		printBoard(list);
		int index = scan.nextInt() -1;
		printBoardDetaile(list, index);
		
		// 글 번호를 선택할시 상세 조회로 넘어간다. 상세 조회가 된 글은 view가 +1 증가
		

	}

	/**
	 * 게시글 삭제 기능
	 * @param list
	 */
	private static void deleteBoard(ArrayList<Board> list) {
		// 예외 처리 필요
		System.out.print("삭제할 게시글 번호를 선택 : ");
		int index = scan.nextInt() -1;
		System.out.println(list.get(index));
		System.out.print("내용 확인 부탁 드립니다. 삭제하실거면 '삭제' 입력 하세요 : ");
		String delete = scan.next();
		if(delete.equals("삭제")) {
			System.out.println("삭제 완료!");
			list.remove(index);
		} else {
			System.out.println("삭제하지 못했습니다.");
		}
	}

	/**
	 * 선택한 번호에 대한 게시글 상세조회
	 * @param list
	 * @param index
	 */
	private static void printBoardDetaile(ArrayList<Board> list, int index) {
		if(list == null || list.size() == 0) {
			System.out.println("******************");
			System.out.println("저장된 게시글이 없습니다!");
			System.out.println("******************");
			return;
		}
		System.out.println(list.get(index));
	}
	
	/**
	 * 게시글 번호와 제목만 보여지는 메소드
	 * @param list
	 */
	private static void printBoard(ArrayList<Board> list) {
		if(list == null || list.size() == 0) {
			System.out.println("******************");
			System.out.println("저장된 게시글이 없습니다!");
			System.out.println("******************");
			return;
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 +". " + list.get(i).getTitle());
		}
	}

	/**
	 * 게시글 작성 메소드
	 * @param list
	 */
	private static void write(ArrayList<Board> list) {
		// 게시글 작성 번호> 제목> 내용> 작성자> 작성일> 조회수
			System.out.println();
			scan.nextLine();
			System.out.print("제목 : ");
			String title = scan.nextLine();
			System.out.print("내용 : ");
			String texts = scan.nextLine();
			System.out.print("작성자 : ");
			String id = scan.next();
			scan.nextLine();
			System.out.print("작성일 : ");
			String day = scan.nextLine();

			list.add(new Board(title, texts, id, day));

	}

	/**
	 * 메뉴 출력
	 */
	private static void printMenu() {
		System.out.println(" ★ 메 뉴 ★ ");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 ☞ ");	
	}

}
