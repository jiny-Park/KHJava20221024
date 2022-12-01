package day02;

public class OperatorEx03 {

	public static void main(String[] args) {
		/* 산술연산자 : + - * / %
		 * 정수 산술연산자 정수 => 정수
		 * 실수 산술연산자 실수 => 실수
		 * 정수 산술연산자 실수 => 실수
		 * 실수 산술연산자 실수 => 실수
		 */
		
		int num1 = 1, num2 = 2;
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.println(num1 + " + " + num2 + " = " + num1 + num2);	// ()를 통해 산술연산자를 먼저 할 수 있도록 진행해야 한다. 
																		// 그렇지 않으면 결과값처럼 정수 num1, num2가 문자열로 출력된다
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		System.out.println(num1 + " / " + num2 + " = " + ((double)num1 / num2));
		System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
	}

}
