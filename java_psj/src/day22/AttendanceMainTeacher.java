package day22;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceMainTeacher {
	
	private static Scanner scan = new Scanner(System.in);
	
	
	/* 출석부 관리 프로그램
			// 1. 학생 등록
			//	- 이름과 생년월일
			// 2. 학생 수정
			//	- 이름과 생년월일을 검색해서 이름과 생년월일 수정
			// 3. 학생 삭제
			//	- 이름과 생년월일을 검색해서 삭제
			// 4. 학생 출결 확인
			//	- 이름과 생년월일을 검색해서 해당 학생의 모든 출결을 확인
			// ex) 2022-11-22 : O(출석 확인)
			// 5. 출석 확인 
			//	- 날짜 입력 : ex) 2022-11-22
			//	- 출석 : O, 지각 : /, 조회 : \, 결석 : X
			//  
			// 예) 홍길동 출석 현황 : X
			// 	  고길동 출석 현황 : O
			//		...
			//	
			// 6. 출석 수정
			//	- 날짜 입력
			//	- 수정할 학생의 이름과 생년월일 입력
			// 7. 출석 삭제
			//	- 날짜 입력하여 해당 날짜 출석 삭제
			// 8. 날짜별 출석 확인
			//	- 날짜 입력하여 해당 날짜의 모든 학생의 출석 여부를 확인
			// 9. 프로그램 종료
			* 학생(Student) 클래스 : 이름, 생년월일
			* 학생 일지 클래스(StudentLog) : 이름, 생년월일, 출결
			* 일지 클래스(Log) : 날짜, 학생일지(이름, 생년월일, 출결)
			* 출석부 클래스(Attendance) : 학생들, 일지들
			*/ 
	public static void main(String[] args) {
		
		int menu = -1;
		Attendance attendance = new Attendance();
			
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			System.out.println("================");
			runMenu(menu, attendance);
			
		}while(menu != 3);
		

	}

//▼▼▼▼▼▼▼▼▼▼ M e t h o d ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	private static void printBar() {
		System.out.println("=====================");
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	private static void printMenu() {
		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
		System.out.println("▤ 출 석 부 메 뉴 ▤");
		System.out.println("  1. 학생 관리");
		System.out.println("  2. 출 석 관 리");
		System.out.println("  3. 종 료 ");
		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
		System.out.print("▤ 메 뉴 선 택 : ");	
	}
	
	private static void printSubMenu(int menu) {
		switch(menu) {
		case 1:
			System.out.println("▤ 학 생 관 리 메 뉴 ▤");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 수정");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 취 소");
			System.out.print("메 뉴 선 택 : ");
			break;
			
		case 2:
			System.out.println("▤ 출 석 관 리 메 뉴 ▤");
			System.out.println("1. 출석 확인 - 전체");
			System.out.println("2. 출석 확인 - 개별");
			System.out.println("3. 출석 확인 - 날짜별");
			System.out.println("4. 출석 수정");
			System.out.println("5. 출석 삭제");
			System.out.println("6. 취 소");
			System.out.print("메 뉴 선 택 : ");
			break;
			
		default:
			printStr("▤ 잘 못 된 메 뉴 입 니 다!");
		}
	}
	
	private static void runMenu(int menu, Attendance attendance) {
		ArrayList<Student> stds = attendance.getStds();
		ArrayList<Log> logs = attendance.getLogs();
		
		switch(menu) {
		case 1:
			managementStudents(stds);
			
			break;
			
		case 2:
//			managementLogs(logs, stds);
			
			break;
			
		case 3:
			System.out.println("▤ 프 로 그 램 종 료 ▤" );
			break;
			
		default:
			printStr("▤ 잘 못 된 메 뉴 입 니 다!");
		}
		
	}

	private static void managementStudents(ArrayList<Student> stds) {
		printSubMenu(1);
		int subMenu = scan.nextInt();
		scan.nextLine();
		printBar();
		switch(subMenu) {
		case 1:		addStudent(stds);					break;
		case 2:		updateStudent(stds);				break;
		case 3:		deleteStudent(stds);				break;
		case 4:		System.out.println("▤ 취소 했습니다!");	break;
		default:	printStr("▤ 잘 못 된 메 뉴 입 니 다!");
		}
	}

	private static void addStudent(ArrayList<Student> stds) {
		if(stds == null) {
			throw new RuntimeException("※예외 발생 : 학생 정보를 관리하는 리스트가 없습니다!");
		}
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("생일 입력(0000-00-00) : ");
		String birth = scan.nextLine();
		
		Student std = new Student(name, birth);
		if(stds.indexOf(std) != -1) {		// @Data 이노텐션을 이용하기 때문에, 또한 특별히 하나만 비교하는 것이 아니라 
											// 전체를 비교해야하기 때문에 equals를 생성하지 않음.
			printStr("학생 정보를 추가하지 못했습니다!");
			return;
		}
		
		stds.add(std);
		printStr("학생 정보를 추가했습니다!");
	}
	
	private static void updateStudent(ArrayList<Student> stds) {
		if(stds == null) {
			throw new RuntimeException("※예외 발생 : 학생 정보를 관리하는 리스트가 없습니다!");
		}
		System.out.println("수정할 학생 정보 검색");
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("생일 입력(0000-00-00) : ");
		String birth = scan.nextLine();
		
		Student std = new Student(name, birth);
		int index = stds.indexOf(std);
		if(index == -1) {		
			printStr("입력 정보와 일치하는 학생이 없습니다!");
			return;
		}
		
		System.out.print("수정할 이름 입력 : ");
		name = scan.nextLine();
		System.out.print("수정할 생일 입력(0000-00-00) : ");
		birth = scan.nextLine();
		std = new Student(name, birth);	//덮어쓰기, 전 예제는 일부만이였기 때문에 set을 사용하지 않았었음.
		stds.set(index, std);
		printStr("학생 정보를 수정했습니다!");
	}
	
	private static void deleteStudent(ArrayList<Student> stds) {
		if(stds == null) {
			throw new RuntimeException("※예외 발생 : 학생 정보를 관리하는 리스트가 없습니다!");
		}
		System.out.println("삭제할 학생 정보 검색");
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("생일 입력(0000-00-00) : ");
		String birth = scan.nextLine();
		
		Student std = new Student(name, birth);
		int index = stds.indexOf(std);
		if(index == -1) {		
			printStr("입력 정보와 일치하는 학생이 없습니다!");
			return;
		}
		
		stds.remove(index);
		printStr("학생 정보를 삭제했습니다!");
	}
}
