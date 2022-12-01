package day13Practice;

import java.util.Scanner;

public class StudentManagerTestPractice {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		StudentPractice[] stds = new StudentPractice[30];
		int count = 0;
		int menu = -1;
		
		do {
			System.out.println("==== 메 뉴 ====");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 성적 추가");
			System.out.println("3. 학생 정보 출력");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴선택 : ");
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				System.out.println("추가 학생 정보 입력");
				System.out.println("학년 : ");
				int grade = scan.nextInt();
				System.out.println("반 : ");
				int classNum = scan.nextInt();
				System.out.println("번호 : ");
				int num = scan.nextInt();
				
//				StudentPractice tmp = new StudentPractice(grade, classNum, num);
				
				
				
				
				
				
				break;
				
			case 2:
				System.out.println("추가 예정");
				break;
			case 3:
				System.out.println("추가 예정");
				break;
			case 4:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못된 메뉴");
			}
			
			count++;
			
		}while(menu != 4);
		
		
		
	}

}
