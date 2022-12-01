package day03;

public class ForEx05 {

	public static void main(String[] args) {
		/* 1부터 10까지의 합을 구하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : sum = sum + i
		 * 반복문 종료 후 : sum을 출력
		 * 		sum = 0; 변수를 선언
		 * i	 -> sum = 0 + i 이라면
		 * i = 1 -> sum = 0 + 1 
		 * i = 2 -> sum = 0 + 1 + 2
		 * i = 3 -> sum = 0 + 1 + 2 + 3
		 * ....
		 * i = 10 -> sum = 0 + 1 + ... + 10
		 * 
		 * sum에 숫자를 넣어보고 규칙성을 알아보자
		 * i = 1 -> sum1 = 0 + 1 
		 * i = 2 -> sum2 = 0 + 1 + 2
		 * i = 3 -> sum3 = 0 + 1 + 2 + 3
		 * ....
		 * i = 10 -> sum10 = 0 + 1 + ... + 10
		 * ----------------------------------
		 * i = 1 -> sum = sum1 + 1 
		 * i = 2 -> sum = sum2 + 2
		 * i = 3 -> sum = 0 + 1 + 2 + 3
		 * ....
		 * i = 10 -> sum = 0 + 1 + ... + 10
		 */
		
		int i;
		int sum = 0;
		for(i = 1; i <= 10; i++) {
			System.out.println(sum + " + " + i + " = " + (sum + i));
			sum += i;
		}
		System.out.println("1~10까지의 총합 : " + sum);

		// 강사님 풀이
		int j, sum1;
		for(j = 1, sum1 = 0; j <= 10; j++) {
			sum1 = sum1 + j; // sum += i;
		}
		System.out.println("1부터 10까지 합은 " + sum1 + "입니다.");
	
		int sum2 = 0;
		for(int p = 1; p <=10; p++) {
			sum2 = sum2 + p; //sum2 += p;
		}
		System.out.println(sum2);
		
	}
}
