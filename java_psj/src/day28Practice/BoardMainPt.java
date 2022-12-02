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

	
	
}
