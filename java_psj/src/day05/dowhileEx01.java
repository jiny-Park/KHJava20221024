package day05;

public class dowhileEx01 {

	public static void main(String[] args) {
		/* for문, while문 상황에 따라서 한번도 동작하지 않을 수 있다. 
		 * do while문은 최소 1번은 실행된다.
		 * do {
		 * 		실행문;
		 * } while(조건식); -> 여기에 있는 ;은 필수!
		 */
		
		// hello 출력되지 않음.
		for(int i = 1; i >= 5; i++) {
			System.out.println("hello");
		}
		
		//
		int j = 1;
		do {
			System.out.println("hello jiny");
		} while(j >= 5);

	}

}
