package day02;

public class PrintEx01 {

	public static void main(String[] args) {
		/* println(); : 원하는 값을 출력한 후 엔터(줄을 바꺼줌), ()안에 값을 생략 가능
		 * print(); : 원하는 값을 출력, ()안에 값을 생략할 수 없다
		 * 
		 * 문자열 + 정수 => 문자열
		 * 정수 + 문자열 => 문자열
		 * 문자 + 문자열 => 문자열
		 * 
		 * 정수 + 문자 => 정수
		 * 
		 */

		String name = "박서진";
		int age = 20;
		System.out.println(name + "의 나이는 " + age + "살 입니다.");
		
		
		int num1 = 10;
		int num2 = 20;
		char operator = '+';

		
		// 10+20
		// -Dfile.enxoding=UTF-8
		System.out.println(num1 + "+" + num2);
		System.out.println(num1 + operator + num2);	// 정수 + 문자 => 정수
		System.out.println(""+num1 + operator + num2);	// 문자열 + 문자 => 문자열, 빈 문자열에 따라서 값이 달라진다는 점을 유의하자

		
	}

}
