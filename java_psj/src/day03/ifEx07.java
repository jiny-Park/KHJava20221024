package day03;

import java.util.Scanner;

public class ifEx07 {

	public static void main(String[] args) {
		/* 두 정수와 문자를 입력받아 산술연산자이면 산술연산 결과를 출력하는 코드를 작성하세요
		 * 예시
		 * 두 정수와 문자를 입력하세요(예 : 1 + 2) : 1 / 2
		 * 1 / 2 = 0.5
		 * 예시 
		 * 두 정수와 문자를 입력하세요(예 : 1 + 2) : 1 ? 2
		 * ?는 산술연산자가 아닙니다.
		 */
		
		// 서진 풀이
		// 변수 선언과 Scanner을 통한 두 정수와 문자를 입력 받기
		int num1, num2;
		char operator;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 2개와 문자 하나를 입력하세요.");
		System.out.print("첫번째 정수 : ");
		num1 = scan.nextInt();
		System.out.print("두번째 정수 : ");
		num2 = scan.nextInt();
		
		System.out.print("문자 입력 : ");
		operator = scan.next().charAt(0);
		
		// 입력받은 문자가 산술연산자이면 산술연산 결과를 출력
		if(operator == '+') {
			System.out.println("" + num1 + operator + num2 + " = " + (num1 + num2));  // 문자열 + 정수 => 문자열
		} else if(operator == '-') {
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		} else if(operator == '*') {
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		} else if(operator == '/') {
			System.out.println(num1 + " / " + num2 + " = " + (num1 / (float)num2));
		} else if(operator == '%') {
			System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
		}// 아니라면 산술연산자가 아닙니다라고 출력
		else {
			System.out.println(operator +"은 산술연산자가 아닙니다.");
		}
		
		
		// 강사님 답안
		/* 두 정수 num1, num2와 문자 ch를 입력받고
		 * ch가 '+'와 같다면 'num1 + num2'를 출력하고,
		 * ch가 '-'와 같다면 'num1 - num2'를 출력하고,
		 * ch가 '*'와 같다면 'num1 * num2'를 출력하고,
		 * ch가 '/'와 같다면 'num1 / num2'를 출력하고,
		 * ch가 '%'와 같다면 'num1 % num2'를 출력하고,
		 * ch가 산술연산자가 아니라면 산술연산자가 아님을 출력
		 */
//		System.out.print("두 정수와 문자를 입력하세요(예: 1 + 2) : ");
//		Scanner scan = new Scanner(System.in);
//		int num1 = scan.nextInt();
//		char ch = scan.next().charAt(0);
//		int num2 = scan.nextInt();
//		
//		if(ch == '+') {
//			System.out.println("" + num1 + ch + num2 + " = " + (num1 + num2));
//		} else if(ch == '-') {
//			System.out.println("" + num1 + ch + num2 + " = " + (num1 - num2));
//		} else if(ch == '*') {
//			System.out.println("" + num1 + ch + num2 + " = " + (num1 * num2));
//		} else if(ch == '/') {
//			System.out.println("" + num1 + ch + num2 + " = " + ((float)num1 / num2));
//		} else if(ch == '%') {
//			System.out.println("" + num1 + ch + num2 + " = " + (num1 % num2));
//		} else {
//			System.out.println(ch + "은 산술연산자가 아닙니다.");
//		}
		
		
		scan.close();
	}
}
