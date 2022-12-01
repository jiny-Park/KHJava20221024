package day02Practice;

import javax.naming.spi.DirStateFactory.Result;

public class day02OperatorPractice {

	public static void main(String[] args) {
		
		boolean isMale = true;
		System.out.println("남성입니까? : " + isMale);
		System.out.println("여성입니까? : " + !isMale);

		//정수 / 실수 => 실수 -> 실수 결과값을 얻기 위해선 정수중에 하나를 실수로 형변환 해줘야 한다.
		int num1 = 1, num2 = 2;
		double result = num1 / (double)num2;
		System.out.println(result);
		
		int age = 17;
		System.out.println(age + "은 성인인가? : " + (age >= 19));
		System.out.println(age + "은 청소년인가? : " + (age <= 19));
		
		
		
		
	}

}
