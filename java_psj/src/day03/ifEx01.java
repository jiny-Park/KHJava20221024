package day03;

public class ifEx01 {

	public static void main(String[] args) {
		/* "~하면 ...한다"라는 문제가 생긴다면 if문으로  
		 * ~ : 조건식
		 * ... : 실행문
		 * if(조건식){
		 * 실행문;
		 * }
		 */
		// 정수 num가 0보다 크면 양수라고 출력하는 코드를 입력
		/* if(정수 num가 0보다 크면) {
		 * 			양수라고 출력;
		 * }
		 * if(num가 0보다 크면) {
		 * 			양수라고 출력
		 * }
		 * if(num > 0) {
		 * 			System.out.println(num + "은 양수입니다.");
		 * }
		 * 
		 */
		int num = -1;
		if(num > 0) {
			System.out.println(num + "은 양수입니다.");
		}
		
		// 정수 num가 0과 같으면 0이라고 출력
		if(num == 0 ) {
			System.out.println(num + "은 0입니다.");
		}
		
		// 정수 num가 0보다 작으면 음수라고 출력
		if(num < 0) {
			System.out.println(num + "은 음수입니다.");
		}
		
		
	}
}
