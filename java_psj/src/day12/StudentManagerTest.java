package day12;

import java.util.Scanner;

public class StudentManagerTest {
// 코드 작성은 쉬운 것 부터!
	public static void main(String[] args) {
		// 학생 성적 관리 프로그램을 작성
		/* 작성하기 위해 필요한 작업들을 주석으로 정리
		 * 
		 * 1. 프로그램에 필요한 기능을 정리
		 * 	메뉴
		 * 1) 학생 정보 추가
		 * 2) 학생 성적 추가
		 * 3) 학생 정보 출력
		 * 4) 프로그램 종료 
		 * 
		 * 2. 프로그램 실행 과정은 어떻게 할 건지?
		 * 기능
		 * 1) 학생 정보 추가
		 * 	- 학년, 반, 번호, 이름을 입력하여 학생 정보 추가
		 * 	- 학년, 반, 번호가 같은 학생이 이미 있으면 추가하지 않음
		 * 2) 학생 성적 추가
		 * 	- 학년, 반, 번호로 학생을 검색한 후 있으면 성적을 추가
		 *  - 성적 추가시 과목명, 학기, 중간, 기말, 수행 평가를 입력하여 추가한다
		 *  - 이미 추가된 과목(학기랑 과목명이 같으면)이면 추가하지 않음 
		 * 3) 학생 정보 출력
		 * 
		 * 3. 정보를 효율적으로 관리하기 위해 클래스를 만들것인가? 만든다면 어떤 클래스를 만들건지?
		 * - 학생 클래스 HighStudent
		 * - 성적 클래스 Score
		 * 
		 * 4. 프로그램 실행 과정을 주석으로 작성
		 */
		
		Scanner scan = new Scanner(System.in);
		int grade, classNum, num;
		String name;

		// 반복
		for( ; ; ) {
			// 메뉴 출력
			System.out.println("-----메뉴-----");
			System.out.println("1.학생 정보 추가");
			System.out.println("2.학생 성적 추가");
			System.out.println("3.학생 정보 출력");
			System.out.println("4.프로그램 종료");
			System.out.print("메뉴 선택 : ");
			
			// 메뉴 선택
			int menu = scan.nextInt();
			
			
			if(menu == 1) {
				// 선택한 메뉴에 따른 기능 실행
				System.out.println("1. 학생 정보 추가 기능 구현 예정");
				// 1. 학생 정보 추가
				// 학생 정보 입력(학년, 반, 번호, 이름)
				System.out.println("추가할 학생 정보 입력");
				System.out.print("학년 : ");
				grade = scan.nextInt();
				System.out.print("반 : ");
				classNum = scan.nextInt();
				System.out.print("번호 : ");
				num = scan.nextInt();
				System.out.print("이름 : ");
				name = scan.next();
				System.out.println(grade + "학년, " + classNum + "반, " + num + "번, " + name);
				// 입력한 학생 정보가 없으면 추가
				// 학생 정보들 중에서 하나씩 비교하여 학년, 반, 번호가 같은 학생이 있는지 확인해서 없으면 마지막 학생 뒤에 추가
				// 입력한 학생정보가 순차적으로 저장이 되어야 함.
				
				
			}else if(menu == 2) {
				System.out.println("2. 학생 성적 추가 기능 구현 예정");
				// 2. 학생 성적 추가
				// 학생 정보를 입력(학년, 반, 번호) -> 학생 정보를 입력했을때, 저장했던 학생 정보중에 같은 값이 있는지 판별해야 함.
				System.out.println("성적을 추가할 학생 정보 입력");
				System.out.print("학년 : ");
				grade = scan.nextInt();
				System.out.print("반 : ");
				classNum = scan.nextInt();
				System.out.print("번호 : ");
				num = scan.nextInt();
				System.out.println(grade + "학년, " + classNum + "반, " + num + "번");
				// 등록한 학생 정보가 없으면 끝
				// 학생 정보들 중에서 하나씩 비교하여 학년, 반, 번호가 같은 학생이 있는지 확인해서 없으면 continue을 통해 다시 조건식으로
				
				// 성적 정보를 입력(과목, 학기, 중간, 기말, 수행평가)			
				System.out.println("성적 정보를 입력");
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
				// 입력한 성적 정보가 없으면 추가
				// 선택한 학생의 성적 정보들 중에서 과목, 학기가 같은 성정 정보가 없으면 추가
				// 학생 정보를 입력했을때, 저장했던 학생 정보중에 같은 값이 있는지 판별해야 함. 
				
				
				
				
			}else if(menu == 3) {
				System.out.println("3. 학생 정보 출력 기능 구현 예정");
				// 3. 학생 정보 출력
				// 저장된 학생 정보를 출력
			}else if(menu == 4) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못된 메뉴!!");
			}
			
		
			
			
		
		}
		scan.close();
	}
	
//-------------------------------------------------------------
	
}
