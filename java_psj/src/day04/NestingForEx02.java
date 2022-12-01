package day04;

public class NestingForEx02 {

	public static void main(String[] args) {
		/* 2부터 100사이의 소수를 출력하는 코드를 작성
		 * 반복횟수 : num를 2부터 100까지 1씩 증가
		 * 규칙성 : num가 소수이면 num를 출력
		 * 		반복횟수 : i는 1부터 num까지 1씩 증가
		 * 		규칙성 : num을 i로 나누었을 때 나머지가 0과 같다면 count를 1증가
		 * 		반복문 종료 후 : count가 2이면 num을 출력
		 * 반복문 종료 후 : 없음
		 */
//		int num = 0;
//		int count = 0;
//		int i;
//		for(num = 2; num <= 100; num++) {
//			count = 0;
//			for(i = 1; i <= num; i++) {
//				if(num % i == 0) {
//					count += 1;
//				}
//			}
//			if(count == 2) {
//				System.out.print(num + " ");
//		}
//		}
		
		// 강사님 풀이
		int num = 2, i, count;
		for(num = 2; num <= 100; num++) {
			count = 0;
			for(i = 1; i <= num; i++) {
				if(num % i == 0) {
					count += 1;
				}
			}
			if(count == 2) {
				System.out.print(num + " ");
			}
		}

		
		
		
	}

}
