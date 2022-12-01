package day27;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardMain {

	/* 게시글 관리 프로그램
	 * - 회원가입
	 * 	- 처음 가입한 회원이 관리자로 지정, 그 외에 회원은 일반 회원
	 * - 로그인
	 * - 게시글 등록/수정/삭제 => 회원만 가능
	 * 
	 * - 카테고리 관리(공지, 자유게시판)
	 * - 카테고리 추가/수정/삭제 => 관리자만 가능
	 * // 첫번째 메뉴에서 보여지는 것 : 회원가입, 로그인, 카테고리 관리(관리자만 접근), 종료
		
		// 1. 회원가입 선택시 보여질 것 : 가입 절차 
		// 	1-1. ID, PW, 성명, 생년월일, 성별, 폰 번호
		//  1-2. ID, PW, 생년월일, 폰번호는 일정한 규칙으로 저장해야함
		//  1-3. ID는 동일해선 안 됨. 다른 것 입력 전에 동일한 id가 있는지 없는지 확인 필요.
		//  1-4. 동일한 id가 없다면 등록
		
		// 2. 로그인 선택시 보여질 것 : 게시글 등록, 수정, 삭제
		//  2-1. ID, PW 입력하여 등록된 user라면 로그인으로 넘어가고 아니라면 회원가입먼저 해달라는 안내문 출력
		//  2-2. 로그인이 됐다면 보여질 기능 : 게시글 등록, 수정, 삭제
		//  2-3. 게시글 등록 선택시 : 카테고리 선택
		//  2-4. 게시글 수정 선택시 : 
		//  2-5. 게시글 삭제 선택시 : 
		//  2-6. 취소 누르면 다시 처음 메뉴로 돌아감
		
		// 3. 카테고리 관리(공지, 자유게시판)
		//  3-1. 첫번째 등록한 id, pw와 비교하여 로그인 확인(list 사용시 0번지가 될듯?)
		//  3-2. 로그인 후에 보여질 화면 : 카테고리 추가/수정/삭제 기능
		//  3-3. 카테고리 추가 선택시 : 카테고리명이랑 기존에 있던 카테고리명이랑 같은지 확인
		//  3-4. 카테고리 수정 선택시 : 기존에 등록된 카테고리가 번호순으로 보여지고 번호를 선택하여 수정
		//  3-4-1. 선택한 번호의 카테고리 이름을 수정하고 저장
		//  3-5. 카테고리 삭제 선택시 : 기존에 등록된 카테고리가 번호순으로 보여지고 번호를 선택하여 삭제
	 * 
	 * 
	 */
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		// 
		
		ArrayList<Member> mbList = new ArrayList<Member>();
		
		int menu = -1;
		
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			printBar();
			runMenu(menu, mbList);
			
		}while(menu != 4);

	}
	
	private static void printBar() {
		System.out.println("-------------------------");
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	private static void printMenu() {
		System.out.println("+ 게시글 관리 프로그램 +");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 카테고리 관리");
		System.out.println("4. 종 료");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	private static void runMenu(int menu, ArrayList<Member> mbList) {
		switch(menu) {
		case 1:
			addMember(mbList);
			break;
		
		case 2:
			System.out.println("로그인 기능 예정");
			break;
		
		case 3: 
			System.out.println("카테고리 관리 예정");
			break;
		
		case 4: 
			printStr("[프로그램 종료]");
			break;
		
		default:
			printStr("[잘못 입력했습니다!]");
		}
	}

	private static void addMember(ArrayList<Member> mbList) {
		// 1. 회원가입 선택시 보여질 것 : 가입 절차 
			// 	1-1. ID, PW, 성명, 생년월일, 성별, 폰 번호
			//  1-2. ID, PW, 생년월일, 폰번호는 일정한 규칙으로 저장해야함
			//  1-3. ID는 동일해선 안 됨. 다른 것 입력 전에 동일한 id가 있는지 없는지 확인 필요.
			//  1-4. 동일한 id가 없다면 등록
		System.out.println("[ 소문자, 숫자, _, - 만 사용하여 5~20자 입력 가능합니다. ]");
		System.out.print("ID : ");
		String id = scan.nextLine();
		System.out.println("[ 소문자, 숫자, _, - 만 사용하여 5~20자 입력 가능합니다. ]");
		System.out.print("PW : ");
		String pw = scan.nextLine();
		System.out.print("성명 : ");
		String naem = scan.nextLine();
		System.out.print("생년월일(0000-00-00) : ");
		String birth = scan.nextLine();
		System.out.print("성별(남/여/선택안함) : ");
		String gender = scan.nextLine();
		System.out.print("폰 번호('-' 포함) : ");
		String phoneNum = scan.nextLine();
		
		Member list = new Member(id, pw, naem, birth, gender, phoneNum);
		
		System.out.println(list);
	}
	
}
