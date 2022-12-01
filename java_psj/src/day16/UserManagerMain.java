package day16;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManagerMain {
	// 프로그램 개발전에 어떤 것이 필요할지 고민을 먼저 해야 한다.
	// 회원정보가 필요!
	// 회원정보부는 내역들로 구성되어 있다.
	// 회원정보 클래스
	// 내역(항목) 클래스
	// 회원정보부는 내역들을 가지고 있다.(포함관계 => 회원정보부 클래스에 내역 객체가 필드로)
	// 내역 추가, 확인, 수정, 삭제 기능을 인터페이스로 묶을 수 있다.
	public static void main(String[] args) {
		/* 회원 정보를 관리하는 프로그램을 작성하세요
		 * - 회원 정보는 아이디, 비번, 이름, 나이, 주민번호로 구성
		 * - 기능1 : 회원 추가
		 * - 기능2 : 회원 검색
		 * - 기능3 : 회원 정보 수정
		 * - 기능4 : 회원 삭제
		 * - 기능5 : 프로그램 종료
		 */
		
		Scanner scan = new Scanner(System.in);
		int menu = -1;
		ArrayList<Member1> list =  new ArrayList<Member1>();	// 회원 리스트
		
		
		// 종료전까지 반복
		do {
		// 메뉴 출력
			printMenu();
		// 메뉴 선택(입력)
			menu = scan.nextInt();
		
		// 선택된 메뉴에 따른 기능 실행
			
			switch(menu) {
			case 1:
				if(addMember(list)){
					printStr("입력한 정보를 추가했습니다.");
				}else {
					printStr("입력한 아이디가 이미 존재합니다.");
				}
				break;
			case 2:
				Member1 searchTmp = searchMember(list);
				if(searchTmp == null) {
					printStr("아이디 또는 비밀번호가 일치하지 않습니다.");
				}else {
					System.out.println(searchTmp);
				}
				break;
			case 3:	
				// 수정할 회원 아이디와 비번을 입력하여 일치하는 회원 정보를 가져옴
				Member1 updateTmp = searchMember(list);
				
				if(!updateMember(list, updateTmp)) {
					printStr("아이디 또는 비밀번호가 일치하지 않습니다.");
				}else {
					printStr("수정이 완료 됐습니다.");
				}
				
				break;
			case 4:
//				if(!deletMember(list)) {
//					printStr("아이디 또는 비밀번호가 일치하지 않습니다.");
//				}
				
				// 강사님 풀이
				// 삭제할 회원 아이디와 비번을 입력하여 일치하는 회원 정보를 가져옴
				Member1 deleteTmp = searchMember(list);
				// 일치하는 회원 정보가 있으면 삭제
				if(list.remove(deleteTmp)) {
					printStr("삭제가 완료 됐습니다.");
				} else {
					printStr("아이디 또는 비밀번호가 일치하지 않습니다.");
				}
				
				break;
			case 5:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못된 메뉴입니다!");
			}
			
		} while(menu != 5);
		
	}
	


	public static void printMenu(){
		System.out.println("---회원 관리 메뉴---");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");
	}
	
	public static boolean addMember(ArrayList<Member1> list) {
		Scanner scan = new Scanner(System.in);
		// 회원 정보 입력 
		// 아이디, 비번, 이름, 주민번호, 나이
		System.out.println("*회원 정보 입력*");
		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비번 : ");
		String pw = scan.next();
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("주민번호 : ");
		String residentNumber = scan.next();
		System.out.print("나이 : ");
		int age = scan.nextInt();
		
		// 입력한 정보를 이용한 객체를 생성(회원 리스트에 비교 및 추가하기 위해)
		Member1 member = new Member1(id, pw, name, residentNumber, age);			
		
		// 회원 리스트에 이미 가입된 아이디이면 안내문구 출력 후 종료
		// 회원 아이디가 같은 회원이 있으면
		if(list.contains(member)) {
			return false;
		}
		// , 아니면 회원 리스트에 member 객체를 추가!
		list.add(member);
		return true;
	}
	
	public static void printStr(String str) {
		System.out.println("-----------------------");
		System.out.println(str);
		System.out.println("-----------------------");
	}

	public static Member1 searchMember(ArrayList<Member1> list) {
		Scanner scan = new Scanner(System.in);
		// 아이디 입력
		System.out.println("*검색할 회원 아이디와 비번을 입력하세요*");
		System.out.print("아이디 : ");
		String id = scan.next();
		// 비번 입력
		System.out.print("비번 : ");
		String pw = scan.next();
		
		// 아이디, 비번을 이용하여 객체를 만듬
		Member1 member = new Member1(id, pw);

		// 회원 리스트에서 아이디가 같은 회원 정보를 가져옴
		int index = list.indexOf(member);
		if(index == -1) {
			return null;
		}
		Member1 tmp = list.get(index);

		// 가져온 회원 정보의 비번과 입력한 비번을 비교하여 다르면 종료
		if(!tmp.getPw().equals(member.getPw())) {
			return null;
		}
		return tmp;
	}
	
//	public static boolean deletMember(ArrayList<Member1> list) {
//		Scanner scan = new Scanner(System.in);
//		// 삭제할 아이디 입력
//		System.out.println("삭제할 아이디와 비밀번호를 입력하세요.");
//		System.out.print("아이디 : ");
//		String id = scan.next();
//		// 삭제할 비밀번호 입력
//		System.out.print("비밀번호 : ");
//		String pw = scan.next();
//		
//		// 아이디와 비밀번호를 이용하여 객체 생성
//		Member1 member = new Member1(id, pw);
//		
//		// 아이디와 비밀번호가 일치하면 회원 정보를 보여줌
//		int index = list.indexOf(member);	// 아이디 중복 확인 코드
//		if(index == -1) {
//			return false;
//		}
//		Member1 tmp = list.get(index);
//		if(!tmp.getPw().equals(member.getPw())) {	// 비밀번호 중복 확인 코드
//			return false;
//		}
//		System.out.println(tmp);
//				
//		// 보여준 회원정보를 삭제하겠다면, '삭제'라는 키워드를 입력하여 삭제
//		System.out.println(id + "의 회원정보를 삭제하시겠습니까? " );
//		System.out.print("'삭제' 입력 : ");
//		String delete = scan.next();
//		list.remove(member);
//		
//		return true;
//	}

	public static boolean updateMember(ArrayList<Member1> list, Member1 updateTmp) {
		Scanner scan = new Scanner(System.in);
		// 일치하지 않으면 건너뜀
		if(updateTmp == null) {
			printStr("아이디 또는 비밀번호가 일치하지 않습니다.");
			return false;
		}
		
		// 일치하는 회원 정보가 있으면 비번, 이름, 주민번호, 나이를 입력받음
		System.out.println("수정할 회원 정보를 입력하세요!");
		System.out.print("비번 : ");
		String pw = scan.next();
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("주민번호 : ");
		String residentNumber = scan.next();
		System.out.print("나이 : ");
		int age = scan.nextInt();
		
		// 입력받은 회원정보를 이용하여 updateTmp를 수정
		updateTmp.update(pw, name, residentNumber, age);
		return true;
		

	}

}	


