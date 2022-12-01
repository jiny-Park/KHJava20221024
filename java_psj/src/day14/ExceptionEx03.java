package day14;

import java.util.Scanner;

public class ExceptionEx03 {

	public static void main(String[] args) {
		/* 다음과 같은 메뉴를 출력하고 정수를 입력 받는 코드를 작성
		 * 단, 종료를 선택하면 프로그램이 종료되고, 예외 처리를 적용하여 
		 * 정수가 아닌 문자열이 입력되도 프로그램이 계속 진행되도록 하세요
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 
		 */
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		for( ; menu != 3 ; ) {
			System.out.println("-----메뉴 출력-----");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");

			try {
				System.out.print("메뉴 선택 : ");
				menu = scan.nextInt();
			}catch(Exception e) {
				System.out.println("잘못 입력했습니다! 정수를 입력하세요!!!");
				scan.nextLine();
			}

			if(menu == 3) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
		
		scan.close();
	}
	
	

}
