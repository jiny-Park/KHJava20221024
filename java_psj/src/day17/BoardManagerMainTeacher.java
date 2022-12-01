package day17;

import java.util.ArrayList;
import java.util.Scanner;

import day17.BoardT;

public class BoardManagerMainTeacher {
	public static Scanner scan = new Scanner(System.in);
	
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
		 */

		int menu = -1;
		ArrayList<BoardT> list = new ArrayList<BoardT>();	// Set과 map은 순서대로 저장이 되지 않기 때문에, 이번 예제에서는 적합하지 않음.
				
		do {
			printMenu();
			
			
			menu = scan.nextInt();
			

			
			switch(menu) {
			case 1:
				// 메뉴에서 입력한 엔터 처리
				scan.nextLine();
				// 콘솔에서 입력받아 게시글 생성
				BoardT insertTmp = inputBoard();
				// 게시글을 목록에 추가
				insertBoard(list, insertTmp);	
				break;
				
			case 2:
				// 서브메뉴 출력
				printSubMenu(menu);
				
				// 서브 메뉴 선택
				int subMenu = scan.nextInt();
				
				// 서브 메뉴에 따른 기능 실행
				printBoard(list, subMenu);
				break;
				
			case 3:
				// 게시글 번호 입력
				System.out.print("수정할 게시글 번호 : ");
				int num2 = scan.nextInt();
				// 게시글 번호와 일치하는 게시글을 가져옴 
				//	-> num2에 1이란 입력을 받았을시 
				// BoardT객체에 1과 같은 num이 있는지 찾아서 인덱스에 저장하는데, 
				// 찾아서 있다면 0을 리턴하고 없다면 -1을 리턴
				int index = list.indexOf(new BoardT(num2));
				System.out.println(index);
				BoardT tmp = list.get(index);

				System.out.println(tmp);
			
				
				if(index == -1) {
					printStr("일치하는 게시글이 없습니다.");
					continue;
				}
				
				// 일치하는 게시글이 있으면 제목, 내용을 입력
				scan.nextLine();
				System.out.println("게시글을 수정해주세요!");
				System.out.print("제목: ");
				String title = scan.nextLine();
				System.out.print("내용: ");
				String content = scan.nextLine();
				
				// 입력 받은 제목, 내용으로 게시글을 수정
				tmp.update(title, content);
				
				break;
				
			case 4:
				// 삭제할 게시글 번호 입력
				System.out.print("삭제할 게시글 번호 : ");
				int num = scan.nextInt();
				// 게시글 번호에 맞는 게시글 삭제
				// (게시글 번호를 이용하여 게시글 객체를 생성하여 삭제)
				if(list.remove(new BoardT(num))) {
					printStr("게시글이 삭제되었습니다.");
				}else {
					printStr("일치하는 게시글이 없습니다.");
				}
				break;
				
			case 5:
				printStr("종료 Good bye");
				break;
			default:
				printStr("잘 못 입력!");
			}
		}while(menu != 5);
		
	}

	public static void printMenu() {
		System.out.println(" ★ 메 뉴 ★ ");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 ☞ ");	
	}
	
	public static void printSubMenu(int menu) {
		switch(menu) {
		case 2:
			System.out.println("# 조회 메뉴 #");
			System.out.println("1. 전체 조회");
			System.out.println("2. 상세 조회");
			System.out.print("메뉴 선택 : ");
		}
		
	}
	
	public static void printStr(String str) {
		System.out.println("---------------");
		System.out.println(str);
		System.out.println("---------------");
	}

	public static void insertBoard(ArrayList<BoardT> list, BoardT board) {					
		// 목록에 추가
		// 0번지에 추가한 이유는 나중에 등록된 게시글이 위로가기 위해서
		list.add(0, board);
		printStr("게시글이 등록되었습니다.");
	}
	
	public static BoardT inputBoard() {
		// 게시글 정보 입력
		System.out.println();
		System.out.println("게시글 작성 해주세요!");
		System.out.print("제목: ");
		String title = scan.nextLine();
		System.out.print("내용: ");
		String content = scan.nextLine();
		System.out.print("작성자: ");
		String writer = scan.next();
		System.out.println();
		// 목록에 게시글 추가
		// 게시글 객체 생성
		return new BoardT(title, content, writer);
	}
	
	public static void printAll(ArrayList<BoardT> list) {
		if(list == null || list.size() == 0) {
			printStr("등록된 게시글이 없습니다.");
			return;
		}
		// 전체 조회
		for(BoardT tmp : list) {
			System.out.println(tmp);
		}
	}
	
	public static void printDetail(ArrayList<BoardT> list, int num) {
		// 해당 번호와 맞는 게시글 조회
		int index = list.indexOf(new BoardT(num));
		
		if(index == -1) {
			System.out.println("없는 게시글 번호입니다.");
			return;
		}
		// 게시글 조회수 증가
		list.get(index).updateViews();
		
		// 게시글 출력
		System.out.println(list.get(index).print());
	}
	
	public static void printBoard(ArrayList<BoardT> list, int subMenu) {
		switch(subMenu) {
		case 1:
			// 전체 조회
			printAll(list);
			break;
		case 2:
			// 상세 조회
			// 번호 입력
			System.out.print("게시글 번호 : ");
			int num = scan.nextInt();
			printDetail(list, num);				
			break;
		default:
			printStr("잘 못 입력!");
		}
	}
}
