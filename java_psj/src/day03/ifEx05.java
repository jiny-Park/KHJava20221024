package day03;

import java.util.Scanner;

public class ifEx05 {
	public static void main(String[] args) {
	/* 정수 num가 2의 배수이면 2의 배수라고 출력하고
	 * 3의 배수이면 3의 배수라고 출력하고
	 * 6의 배수이면 6의 배수라고 출력하고
	 * 2, 3, 6의 배수가 아니면 2, 3, 6의 배수가 아닙니다라고 출력하는 코드를 작성
	 * 단, 6의 배수는 6의 배수라고만 출력
	 */
		// 변수 선언
		int num;
		// scan으로 정수 입력 받기
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		num = scan.nextInt();
	
		// 정수 num가 6의 배수이면 6의 배수라고 출력하고
		if(num % 6 == 0) {
			System.out.println(num + "은 6의 배수이다.");
		}
		
		// 2의 배수이면 2의 배수라고 출력하고
		else if(num % 2 == 0) {
			System.out.println(num + "은 2의 배수이다.");
		}
		
		// 3의 배수이면 3의 배수라고 출력하고
		else if(num % 3 == 0) {
			System.out.println(num + "은 3의 배수이다.");
		}
		// 2, 3, 6의 배수가 아니면 2, 3, 6의 배수가 아닙니다라고 출력하는 코드를 작성
		else {
			System.out.println(num + "은 2, 3, 6의 배수가 아니다.");
		}
		
		// 강사님 답안
		// 방법 1. 조건식을 더 달아준다
		if(num % 2 == 0 && num % 3 != 0) {				// num을 2로 %했을때 0이고, num을 3으로 %했을때 0이 아니면 참으로 실행
			System.out.println(num + "은 2의 배수이다.");
		} else if(num % 3 == 0 && num %2 != 0) {		// num을 3으로 %했을때 0이고, num을 2로 %했을때 0이 아니면 참으로 실행
			System.out.println(num + "은 3의 배수이다.");
		} else if(num % 6 == 0) {						// num을 6으로 %했을때 0이라면
			System.out.println(num + "은 6의 배수이다.");
		} else {
			System.out.println(num + "은 2, 3, 6의 배수가 아니다.");
		}
		
		// 방법 2. 서진이 푼 것처럼 조건식의 숫자를 바꺼준다.
		
		
		
	}
}
