package day04Practice;

public class day04allPractice {

	public static void main(String[] args) {
		// 별 5줄, 한 줄에 5개 별 
		for(int row=1; row<=5; row++) {
			for(int col=1; col<=5; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 별 5열, 1열 부터 별 하나씩 증가
		for(int row=1; row<=5; row++) {
			for(int col=1; col<=row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 별 5열, 삼각형 모양으로
		/*     *
		 *    ** *
		 *   *** **
		 *  **** ***
		 * ***** ****
		 */
		for(int row=1; row<=5; row++) {
			for(int col=4; col>=row-1; col--) {
				System.out.print(" ");
			}
			System.out.print("*");
		}
		
		

	}

}
