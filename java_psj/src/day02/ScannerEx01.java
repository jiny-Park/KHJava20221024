package day02;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int num = scan.nextInt();
		System.out.println(num);
		
		System.out.println("실수를 입력하세요 : ");
		double num2 = scan.nextDouble();
		System.out.println(num2);
		
		// 내 답안
		System.out.println("정수 A와 정수 B를 입력하세요 : ");
		System.out.println("정수 A : ");
		int num3 = scan.nextInt();
		System.out.println("정수 B : ");
		int num4 = scan.nextInt();
		System.out.println("정수 A : " + num3);
		System.out.println("정수 B : " + num4);
		
		/* 강사님 답안
		System.out.println("정수 A와 정수 B를 입력하세요 : ");
		int num3 = scan.nextInt();
		int num4 = scan.nextInt();
		System.out.println(num3);
		System.out.println(num4);
		*/
		scan.close();	// scan.close();는 꼭 넣지 않아도 되지만, 넣지 않으면 노란줄이 뜨기 때문에 써도 나쁘지 않음
				
	}
}
