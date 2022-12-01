package day09;

import java.util.Scanner;

public class HighStudentManager {

	public static void main(String[] args) {
		/* 메뉴 
		 * 1. 학생 추가
		 * 2. 학생 성적 추가
		 * 3. 학생 정보 출력
		 * 4. 프로그램 종료
		 */
		
		// 반복문을 통해 메뉴를 출력 - 프로그램 종료를 선택할 때까지 
		int menu;
		HighStudent [] List = new HighStudent[30];
		int count = 0;
		
		do {
			// 메뉴를 출력
			printMenu();
			
			// 메뉴 선택(입력)
			menu = selectMenu();
			
			
			// 선택한 메뉴에 맞는 기능 실행
			count = runMenu(menu, List, count);
			
			
		}while(menu != 4);

	}
	
	/**
	 * 메뉴를 출력하는 메소드
	 * 기능 : 
	 * 리턴타입 : 없음 => void
	 */
	public static void printMenu() {	// -> main에 static이 있기 때문에, 
		System.out.println("-------메뉴-------");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 성적 추가");
		System.out.println("3. 학생 정보 출력");
		System.out.println("4. 프로그램 종료");
		System.out.println("-------메뉴-------");
		System.out.print("메뉴를 선택하세요 : ");

	}
	
	/**
	 * 메뉴를 콘솔에서 입력받은 정수(메뉴)를 알려주는 메소드
	 * @return 입력받은 정수(메뉴) 
	 */
	public static int selectMenu() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	/**
	 * 메뉴에 맞는 기능을 실행하는 메소드
	 * @param menu 선택한 메뉴
	 * @param List 학생들 정보가 들어있는 리스트
	 * @return 현재 저장된 학생수
	 */
	public static int runMenu(int menu, HighStudent [] List, int count) {
		int grade, classNum, num;
		String name;
		Scanner scan = new Scanner(System.in);
		switch(menu) {
		case 1:
			// - 학생 추가
			// 1-1. 학생 정보를 입력 
			System.out.print("학생 정보 입력(학년, 반, 번호, 이름순) : ");
			grade = scan.nextInt();
			classNum = scan.nextInt();
			num = scan.nextInt();
			name = scan.next();
			// 1-2. 리스트에 학생 정보를 추가
			List[count] = new HighStudent(grade, classNum, num, name);
			
			// 1-3. 리스트에 들어가 있는 학생수 1증가
			count++;
			break;
		case 2:
			// -학생 성적 추가
			// 2-1. 학생을 선택 => 학생 정보를 출력 후, 학생을 선택
			// 2-1-1. 학생 정보 출력
			for(int i = 0 ; i < count; i++) {
				System.out.println("+++++학생 목록+++++");
				System.out.println(i + 1 + "번 학생");
				List[i].print();
				System.out.println("++++++++++++++++");
			}
			// 2-1-2. 학생을 선택
			System.out.print("학생을 번호로 선택 : ");
			int index = scan.nextInt() - 1;

			// 2-2. 성적을 입력
			System.out.print("성적 입력(국어, 영어, 수학순) : ");
			int kor = scan.nextInt();
			int eng = scan.nextInt();
			int math = scan.nextInt();
			
			// 2-3. 해당 학생의 성적을 입력받은 성적으로 변경
			List[index].updateScore(kor, eng, math);

			break;
		case 3:
			// - 학생 정보 출력
			for(int i = 0 ; i < count; i++) {
				List[i].print();
				System.out.println();
			}
			break;
		case 4:
			System.out.println("프로그램을 종료합니다!");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		return count;
		
	}
}
	
