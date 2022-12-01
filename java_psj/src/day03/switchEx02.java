package day03;

import java.util.Scanner;

public class switchEx02 {

	public static void main(String[] args) {
		/* 두 정수와 산술연산자를 입력 받아 산술연산 결과를 하는 코드를 switch문으로 작성
		 * 
		 */
		
		// 서진 풀이
		// 입력 받을 안내문을 출력
		System.out.print("두 정수와 산술연산자를 입력하세요(예) 2 + 1) : ");
		// Scanner을 통하여 값을 입력 받고, 변수에 저장
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		// 입력 받은 값을 switch문을 통해 출력
		switch(operator) {
				// 입력 받은 산술연산자가 '+'라면 출력
			case '+' :
				// 출력문
				System.out.println("" + num1 + operator + num2 + " = " +(num1 + num2));
				break;	// break문이 없다면 break문을 만날때까지 실행이 되며, 값이 일치하지 않아도 실행이 된다. 
				// 입력 받은 산술연산자가 '-'라면 출력
			case '-' :
				System.out.println("" + num1 + operator + num2 + " = " +(num1 - num2));
				break;
			case '*' :
				System.out.println("" + num1 + operator + num2 + " = " +(num1 * num2));
				break;
			case '/' :
				System.out.println("" + num1 + operator + num2 + " = " +(num1 / (double)num2));
				break;
			case '%' :
				System.out.println("" + num1 + operator + num2 + " = " +(num1 % num2));
				break;
			default :
				System.out.println(operator + "는 산술연산자가 아닙니다.");
		}
		
		// 강사님 풀이 -> 서진 풀이와 비슷
		
		
		scan.close();
	}
}
