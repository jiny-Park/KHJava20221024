package day04;

public class NestingForStarEx02 {

	public static void main(String[] args) {
		/* 
		 * 
		 */
		int row, col;
		for(row = 1; row <= 5; row++) {
			for(col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/* 강사님 풀이
		 * * 		row=1	*=1
		 * **		row=2	*=2
		 * ***		row=3	*=3
		 * ****		row=4	*=4
		 * *****	row=5	*=5
		 */
		for(row = 1; row <= 5; row++) {
			for(col = 4; col >= row; col--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*     * row=1	공백=4 *=1
		 *    ** row=2	공백=3 *=2
		 *   *** row=3	공백=2 *=3
		 *  **** row=4	공백=1 *=4
		 * ***** row=5	공백=0 *=5
		 */
		// 서진 풀이
		for(row = 1; row <= 5; row++) {
			for(int i = 4; i >= 5-row; i--) {
				System.out.print(" ");
				}
				for(col = 1; col <= row; col++) {
					System.out.print("*");
				}
			System.out.println();	
		}
		
		// 강사님 풀이
		for(row = 1; row <= 5; row++) {
			// 공백 출력 5-row개
			for(col = 1; col <= 5-row; col++) {
				System.out.print(" ");
			}// * 출력 row게
			for(col = 1; col <= row; col++) {
				System.out.print("*");
			}// 엔터
			System.out.println();
		}
		
			
		/*		*		row=1 공백=4 *=1 *=0
		 * 	   ** *		row=2 공백=3 *=2 *=1
		 *    *** **		row=3 공백=2 *=3 *=2
		 *   **** ***   	row=4 공백=1 *=4 *=3
		 *  ***** ****   row=5 공백=0 *=5 *=4
		 */
		
		for(row = 1; row <= 5; row++) {
			// 공백 출력 5-row개
			for(col = 1; col <= 5-row; col++) {
				System.out.print(" ");
			}// * 출력 row게
			for(col = 1; col <= row; col++) {
				System.out.print("*");
			}// 엔터
			for(col = 1; col <= row-1; col++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 주말 숙제. 다른 삼각형 모양 출력 연습하기.

	}
}
