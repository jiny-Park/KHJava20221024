package day02;

import java.util.Scanner;

public class OperatorEx08 {

	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수가 홀수인지 짝수인지 출력하는 코드를 작성하세요.
		 * 예시
		 * 정수를 입력하세요 : 5
		 * 5는 홀수입니다.
		 */
		// 서진 문제 풀이(*단계를 쪼개서 진행해보자!)
		// 1.변수
//		int num;
//		String result;
		
		// 2.Scanner을 통해 콘솔에 입력 받기
//		Scanner scan = new Scanner(System.in);
//		System.out.print("정수를 입력하세요 : ");
//		num = scan.nextInt();
		
		// 3.조건식
		// reult = num 값이 2로 %때 0이 되면 홀수이고, 1이 되면 짝수이다.
//		result = num % 2 == 0 ? "짝수" : "홀수";
// if문으로 한다면		
//		if(num % 2 == 0) {
//			System.out.println("짝수");
//		} else {
//			System.out.println("홀수");
//		}
		
		// 4.출력
//		System.out.println(num + "의 값은 " + result + "입니다.");
		

		// 강사님 답안
		// 정수를 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		// 입력받은 정수를 2로 나누었을 때 나머지가 0과 같은지를 변수에 저장
		boolean isEven = num % 2 == 0; 
		
		// 나머지가 0과 같으면 "짝수"를, 같지 않으면 "홀수"를 저장
		String result = isEven ? "짝수" : "홀수";
		
		// 결과를 출력
		System.out.println(num + "는 " + result + "입니다.");
		
		scan.close();
	}

}
