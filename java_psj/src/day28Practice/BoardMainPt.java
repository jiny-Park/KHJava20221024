package day28Practice;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BoardMainPt {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static List<MemberPt> memberList = new ArrayList<MemberPt>();
	private static List<BoardPt> boardList	 = new ArrayList<BoardPt>();
	private static List<String> categoryList = new ArrayList<String>();
	private static MemberPt user = null;

	public static void main(String[] args) {
		int menu = -1;
		
		loadMember("memberPt.txt");
		loadBoard("BoardPt.txt");
		loadCategory("categoryPt.txt");
		 
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			printBar();
			runMenu(menu);				
		}while(menu != 4);
		
		saveMember("memberPt.txt");
		saveBoard("BoardPt.txt");
		saveCategory("CategoryPt.txt");
	}


	private static void loadMember(String filename) {
		try (ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(filename))){
			while(true) {
				MemberPt member = (MemberPt)ois.readObject();
				memberList.add(member);
			}
		} catch (ClassNotFoundException e) {
			printStr("불러오기 실패");
		} catch (EOFException e) {
			printStr("불러오기 성공");
		} catch (IOException e) {
			printStr("불러오기 실패");
		}	
	}
	
	private static void saveMember(String filename) {
		if(memberList.size() == 0) 
			return;
		try (ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(filename))){
			for(MemberPt member : memberList) {
				oos.writeObject(member);
			}
			System.out.println("파일 저장 완료");
		} catch (IOException e) {
			printStr("불러오기 실패");
		}	
	}
	
	private static void loadBoard(String filename) {
		try (ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(filename))){
			while(true) {
				BoardPt board = (BoardPt)ois.readObject();
				boardList.add(board);
			}
		} catch (ClassNotFoundException e) {
			printStr("불러오기 실패");
		} catch (EOFException e) {
			printStr("불러오기 성공");
		} catch (IOException e) {
			printStr("불러오기 실패");
		}		
	}

	private static void saveBoard(String filename) {
		try (ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(filename))){
			for(BoardPt board : boardList) {
				oos.writeObject(board);
			}
			System.out.println("파일 저장 완료");
		} catch (IOException e) {
			printStr("불러오기 실패");
			e.printStackTrace();
		}		
	}
	
	private static void loadCategory(String filename) {
		try (ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(filename))){
			while(true) {
				String category = (String)ois.readObject();
				categoryList.add(category);
			}
		} catch (ClassNotFoundException e) {
			printStr("불러오기 실패");
		} catch (EOFException e) {
			if(categoryList.size() == 0)
				categoryList = new ArrayList<String>(Arrays.asList("공지", "자유"));
			printStr("불러오기 성공");
		} catch (IOException e) {
			printStr("불러오기 실패");
		}			
	}
	
	private static void saveCategory(String filename) {
		try (ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(filename))){
			for(MemberPt member : memberList) {
				oos.writeObject(member);
			}
			System.out.println("파일 저장 완료");
		} catch (IOException e) {
			printStr("불러오기 실패");
		}			
	}

	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}

	private static void printBar() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");	
	}

	private static void printMenu() {
		System.out.println(" *메 뉴* ");
		System.out.println("1. 회원 관리");
		System.out.println("2. 게시글 관리");
		System.out.println("3. 카테고리 관리");
		System.out.println("4. 프로그램 종료");
		printBar();
		System.out.print("메뉴선택 : ");
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1: memberMenu(); break;
		case 2: boardMenu();	break;
		case 3: categoryMenu(); break;
		case 4: printStr("프로그램 종료"); break;
		default: 
			throw new RuntimeException("잘못된 메뉴 선택");
		}
	}

	private static void printSubmenu(int menu) {
		switch(menu) {
		case 1:
			System.out.println("*회원 관리 메뉴*");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 이전");
			break;
		case 2:
			System.out.println("*게시글 관리 메뉴*");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 수정");
			System.out.println("3. 게시글 삭제");
			System.out.println("4. 게시글 목록");
			System.out.println("5. 이전");
			break;
		case 3:
			System.out.println("*카테고리 관리 메뉴*");
			System.out.println("1. 카테고리 등록");
			System.out.println("2. 카테고리 수정");
			System.out.println("3. 카테고리 삭제");
			System.out.println("4. 카테고리 목록");
			System.out.println("5. 이전");
			break;
		}
		printBar();
		System.out.print("메뉴 선택 : ");	
	}

	private static void memberMenu() {
		if(checkLogin(true))
			return;
		int subMenu = -1;
		do {
			printSubmenu(1);
			subMenu = scan.nextInt();
			scan.nextLine();
			subMenu = runMemberMenu(subMenu);		
		}while(subMenu != 3);	
	}

	private static boolean checkLogin(boolean res) {
		if(user != null && res) {
			printStr("로그인한 사용자는 해당 기능을 이용할 수 없음");
			return res;
		}
		if(user == null && !res) {
			printStr("로그인 하지 않은 사용자는 해당 기능을 이용할 수 없음");
			return !res;
		}
		return false;
	}

	private static int runMemberMenu(int subMenu) {
		switch(subMenu) {
		case 1:
			signup();
			break;
		case 2:
			login();
			if(user != null)
				return 3;
			break;
		case 3:
			printStr("이전 메뉴로 돌아갑니다!");
		default:
			printStr("잘못된 메뉴 선택");
		}
		return subMenu;	
	}

	private static void signup() {
		MemberPt member = null;
		System.out.println("회원 정보 입");
		member = inputMember();
		
		if(isMember(member)) {
			printStr("이미 가입된 ID입니다!");
			return;
		}
		memberList.add(member);
		printStr("회원 가입이 완료 되었습니다!");	
	}

	private static MemberPt inputMember() {
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		Authority authority = memberList.size() == 0 ? Authority.ADMIN : Authority.MEMBER;
		return new MemberPt(id, pw, authority);
	}

	private static boolean isMember(MemberPt member) {
		if(member == null)
			return false;
		if(memberList == null)
			memberList = new ArrayList<MemberPt>();
		if(memberList.size() == 0)
			return false;
		for(MemberPt tmp : memberList) {
			if(tmp.getId().equals(member.getId()))
				return true;
		}
		return false;
	}

	private static void login() {
		MemberPt member = null;
		System.out.println("로그인 정보 입력");
		member = inputMember();
		
		int index = memberList.indexOf(member);
		if(index == -1) {
			printStr("로그인 실패");
			return;
		}
		user = memberList.get(index);
		printStr("로그인 성공");		
	}
	
	private static void boardMenu() {
		int subMenu = -1;
		do {
			printSubmenu(2);
			subMenu = scan.nextInt();
			scan.nextLine();
			printBar();
			runBoardMenu(subMenu);
		}while(subMenu != 5);	
	}

	private static void runBoardMenu(int subMenu) {
		switch(subMenu) {
		case 1:	 insertBoard();					   break;
		case 2:  updateBoard();					   break;
		case 3:  deleteBoard();					   break;
		case 4:  printBoard();					   break;
		case 5:  printStr("이전 메뉴로 돌아갑니다!");	   break;
		default: printStr("잘못된 메뉴를 선택했습니다!"); break;
		}
		System.out.println(boardList);	
	}


	private static void insertBoard() {
		if(checkLogin(false))
			return;
		printCategory();
		printBar();
		String category = null;
		do {
			if(category != null)
				printStr("등록되지 않은 카테고리 입니다!");
			System.out.println("카테고리 : ");
			category = scan.nextLine();
		}while(!categoryList.contains(category));
		System.out.println("제목 : ");
		String title = scan.nextLine();
		System.out.println("내용 : ");
		String contents = scan.nextLine();
		printBar();
		BoardPt board = new BoardPt(title, contents, user.getId(), category);
		boardList.add(board);
		printStr("게시글 등록 완료!");
		
	}


	private static void updateBoard() {
		// TODO Auto-generated method stub
		
	}


	private static void deleteBoard() {
		// TODO Auto-generated method stub
		
	}


	private static void printBoard() {
		// TODO Auto-generated method stub
		
	}
	
	
}
