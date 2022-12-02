package day30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardMain {
	
	private static Scanner scan = new Scanner(System.in);
	private static List<Board> 	 boardList 	 = new ArrayList<Board>(); 
	private static List<Comment> commentList = new ArrayList<Comment>(); 
	
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
			runMenu(menu, boardList);
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
	private static void runMenu(int menu, List<Board> boardList) {
		switch(menu) {
		case 1: 
			insertBoard(boardList);
			printBar();
			break;
		case 2: 
			updateBoardList(boardList);
			printBar();
			break;
		case 3: 
			deleteBoardList(boardList);
			printBar();
			break;
		case 4: 
			printBoardList();
			printBar();
			break;
		case 5: 
			printBoard();
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
	private static void insertBoard(List<Board> boardList) {
		// 번호, 제목, 내용, 작성자
		
		int num = inputBoardNum();
	
		Board board = inputBoard(num);
		
		// 같은 번호가 있다면 존재하는 게시글이라고 알려준다.
		if(boardList.contains(board)) {
			printStr("등록 불가! " + "같은 번호의 게시글이 존재합니다!");
			return;
		}
		
		// 같은 번호가 없다면 번호, 제목, 내용, 작성자를 리스트에 저장.
		boardList.add(board);
	}
	
	/** inputBoardNum : Scanner를 통해 번호를 입력받아 알려주는 메소드
	 * @return 입력받은 게시글 번호
	 */
	private static int inputBoardNum() {
		System.out.print("게시글 번호 입력 : ");
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}
	
	/** inputBoard : 게시글 번호가 주어지면 제목, 내용, 작성자 입력하여 게시글 객체를 반환하는 메소드
	 * @param num 게시글 번호
	 * @return 게시글 객체
	 */
	private static Board inputBoard(int num) {	
		System.out.print("제 목 : ");
		String title = scan.nextLine();
		System.out.print("내 용 : ");
		String content = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		return new Board(num, title, content, writer);	
	}
	
	/** updateBoard : 게시글 리스트에 주어진 게시글을 수정하는 메소드로 수정하면 true를 실패하면 false를 반환
	 * @param boardList 게시글 리스트
	 * @param board 수정할 게시글
	 * @return 수정 성공 true, 실패 false
	 */
	private static boolean updateBoard(List<Board> boardList, Board board) {
		if(boardList.size() == 0) 
			return false;
		int index = boardList.indexOf(board);
		if(index == -1) 
			return false;
		boardList.set(index, board);
		return true;	
	}
	
	/** updateBoardList : 게시글 정보를 입력 받아 수정하는 메소드
	 * 
	 */
	public static void updateBoardList(List<Board> boardList) {
		int num = inputBoardNum();
		Board board = inputBoard(num);
		if(updateBoard(boardList, board)) {
			printStr("게시글을 수정 했습니다!");
		}else {
			printStr("게시글을 수정하지 못했습니다!");
		}
	}
	
	/** deleteBoard : 게시글 리스트에 주어진 게시글을 삭제하는 메소드
	 * @param boardList 게시글 리스트
	 * @param board 삭제할 게시글 번호
	 * @return 수정 성공 true, 실패 false
	 */
	private static boolean deleteBoard(List<Board> boardList, int num) {
		Board board = new Board(num);
		return boardList.remove(board);
	}
	
	/** deleteBoardList : 게시글 번호를 입력받아 삭제하는 메소드
	 * 
	 */
	private static void deleteBoardList(List<Board> boardList) {
		int num = inputBoardNum();
		if(deleteBoard(boardList, num)) {
			printStr("게시글을 삭제 했습니다!");
		}else {
			printStr("게시글을 삭제하지 못했습니다!");
		}
	}
	
	/** printBoardList : 게시글 전체를 출력하는 메소드
	 * 
	 */
	private static void printBoardList() {
		boardList.forEach(b->System.out.println(b));
	}		// forEach 메소드 활용
	
	/** printSubmenu : 게시글 확인해서 필요한 서브 메뉴를 출력
	 */
	private static void printSubmenu() {
		 System.out.println("=== 게시글 확인 서브 메뉴 ===");
		 System.out.println("1. 댓글 등록");
		 System.out.println("2. 댓글 확인");
		 System.out.println("3. 이전");
		 System.out.print("메뉴 선택 : ");	 
	}
	
	/* runPrintSubmenu : 선택한 서브 메뉴를 실행하는 메소드,
	 * 					 우선은 서브 메뉴를 선택하면 선택한 서브 메뉴를 
	 * 					 콘솔에 출력하는 기능으로 일단 구현
	 * @param submenu 선택한 서브 메뉴
	 */
	private static void runPrintSubmenu(int submenu) {
		switch(submenu) {
		case 1:
			System.out.println("댓글 등록 예정");
			break;
		case 2:
			System.out.println("댓글 확인 예정");
			break;
		case 3:
			printStr("이전으로 돌아갑니다!");
		default:
			printStr("잘못 입력했습니다!");
		}
	}
	
	/** printBoard : 게시글 번호를 입력받아 입력받은 게시글을 출력하고, 
	 * 				 서브메뉴를 출력하고, 서브메뉴를 선택하면
	 * 				 선택한 서브 메뉴를 실행하는 메소드
	 */
	private static void printBoard() {
		int num = inputBoardNum();
		Board board = new Board(num);
		int index = boardList.indexOf(board);
		if(index == -1) {
			printStr("등록되지 않았거나 삭제된 게시글 입니다!");
			return;
		}
		board = boardList.get(index);
		board.print();
		int submenu = -1;
		do {
			printSubmenu();
			submenu = scan.nextInt();
			scan.nextLine();
			runPrintSubmenu(submenu);
		}while(submenu != 3);		
	}
	
	/** insertComment : 댓글을 댓글 리스트에 추가하는 메소드
	 * @param commentList 댓글 리스트
	 * @param comment 댓글
	 * @return 댓글 추가 여부
	 */
	private static boolean insertComment(List<Comment> commentList, Comment comment) {
		System.out.print("댓글 번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.print("내 용 : ");
		String contents = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		
		return new Comment(num, contents, writer);
	}
	
	/** insertCommentList : 댓글 정보를 입력받아 댓글을 추가하는 메소드
	 * 
	 */
	private static void insertCommentList() {
		commentList.add(insertComment);
	}
	
	
	
	
	
	
	
	
	
	

	
	
}
