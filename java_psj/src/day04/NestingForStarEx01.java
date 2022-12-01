package day04;

public class NestingForStarEx01 {

	public static void main(String[] args) {
		/* *****
		 * *****
		 * *****
		 * *****
		 * *****
		 */
		int i, j;
		
		for(i = 1; i <= 3; i++) {
			for(j = 1; j <= 3; j++) {
			System.out.print("$");
		}
			System.out.println();
	}
		
		// 강사님 풀이
		int col, row;
		for(row = 1; row <= 5; row++) {
			System.out.println("*****");
		}
		
		System.out.println("------------------");
		
		for(row = 1; row <= 5; row++) {
			for(col = 1; col <= 5; col++) {		// 이중 반복문을 통하면 입력 숫자만 바꾸고도 출력문을 수정할 수 있다.
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
	}
}
