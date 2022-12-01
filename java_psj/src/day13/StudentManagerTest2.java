package day13;

import java.util.Scanner;

public class StudentManagerTest2 {
// 코드 작성은 쉬운 것 부터!
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student [] stds = new Student[30];
		int count = 0;
		int menu = -1;
		// 반복
		for( ; menu != 4; ) {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			
			count = runMenu(menu, stds, count); // count은 리턴을 통해 바뀐 값을 알려저야 함.

		} // for문 끝
	} // main 끝
//-------------------------------------------------------------
	private static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1.학생 정보 추가");
		System.out.println("2.학생 성적 추가");
		System.out.println("3.학생 정보 출력");
		System.out.println("4.프로그램 종료");
		System.out.print("메뉴 선택 : ");	
	}
	
	private static int runMenu(int menu, Student[] stds, int count) {
		Scanner scan = new Scanner(System.in);
		
		switch(menu) {
		case 1:
			if(addStudent(stds, count)) {
				System.out.println("학생을 추가했습니다.");
				count++;
			}else {
				System.out.println("학생을 추가하지 못했습니다.");
			}
			break;
		case 2:
			if(addScore(stds, count)) {
				System.out.println("성적 등록 완료");
			}else {
				System.out.println("성적 등록에 실패했습니다.");
			}
			break;
		case 3:
			printStudentList(stds, count);
			break;
		case 4:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴!!");	
		}
		return count;
		// 선택한 메뉴에 따른 기능 실행
	}
	
	private static void printStudentList(Student[] stds, int count) {
		for(int i = 0; i < count; i++) {
			System.out.println(stds[i]);
			stds[i].printScore();
		}
	}
	
	private static boolean addScore(Student[] stds, int count) {
		System.out.println("성적을 추가할 학생 정보 입력");
		Student tmp = scanStudentBaseInfo();
		
//		Student tmp = new Student(grade, classNum, num);  ??왜 필요없어짐?	-> 윗줄에서 어차피 받아오니깐
		
		int index = indexOfStudent(stds, count, tmp);
		
		if(index == -1) {
			return false;
		}
		
		System.out.println("성적 정보를 입력");
		return stds[index].addScore(scanScore());
	}
	
	private static boolean addStudent(Student[] stds, int count) {
		Scanner scan = new Scanner(System.in);
		System.out.println("추가할 학생 정보 입력");
		Student tmp = scanStudentBaseInfo();

		System.out.print("이름 : ");
		tmp.setName(scan.next());
//		String name = scan.next();
		
		int index = indexOfStudent(stds, count, tmp);

		if(index == -1 && count < stds.length) {
			stds[count] = tmp;
//			count++;	-> 카운트는 증가해봤자 메인에 아무 영향을 주지 않기 때문에 return true로 대체
			return true;
		}
		return false;
	}
	
	private static Student scanStudentBaseInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		return new Student(grade, classNum, num);
	}
	
	private static Score scanScore() {
		Scanner scan = new Scanner(System.in);
		System.out.print("과목 : ");
		String title = scan.next();
		System.out.print("학기 : ");
		int term = scan.nextInt();
		System.out.print("중간 : ");
		int midScore = scan.nextInt();
		System.out.print("기말 : ");
		int finalScore = scan.nextInt();
		System.out.print("수행평가 : ");
		int perfomance = scan.nextInt();
		return new Score(title, term, midScore, finalScore, perfomance);
	}
	
	private static int indexOfStudent(Student[] stds, int count, Student tmp) {
		int index = -1;	// 학생 정보가 있는지 확인해줄 변수
		for(int i = 0; i <count; i++) {
			if(stds[i].equals(tmp)) {
				return i; //일치하는 학생의 위치(번지)
			}
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
