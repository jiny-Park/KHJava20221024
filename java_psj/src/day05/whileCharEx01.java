package day05;

import java.util.Scanner;

public class whileCharEx01 {

	public static void main(String[] args) {
		// 문자를 입력받아 q이면 종료하고 아니면 반복하는 코드를 작성
		// q 입력 되어 있는 변수, 반복하여 입력 받을 반복문 필요
		

		Scanner scan = new Scanner(System.in);
		System.out.println("q를 입력하여 프로그램을 종료하세요.");
		
		char ch = ' ';
		while(ch != 'q') {
			System.out.print("입력 : ");
			ch = scan.next().charAt(0);
			if(ch != 'q') {
				System.out.println("잘 못 입력했습니다.");
			} else if(ch == 'q') {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
		// 강사님 풀이
		//break를 이용하여 무한루트를 빠져 나오는 예제
		char ch1;
		while(true) {
			System.out.println("문자를 입력하세요.(종료 : q) : ");
			ch1 = scan.next().charAt(0);
			if(ch1 == 'q') {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
		// ch의 초기값을 잘 설정하여 while문 조건식을 이용한 예제
		char ch2 = ' ';
		while(ch2 != 'q') {
			System.out.println("문자를 입력하세요.(종료 : q) : ");
			ch2 = scan.next().charAt(0);
			
			}
		
	scan.close();
	}

}
