package day05;

public class whileEx01 {

	public static void main(String[] args) {
		/* while문 문법
		 * 
		 * while(조건식) {
		 * 		실행문;
		 * }
		 * 
		 * 초기화;
		 * while(조건식) {
		 * 		실행문;
		 * 		증감식;			// while문에는 증감식 위치가 따로 없다.
		 * }
		 * 
		 * continue 는 while문에서 조건식으로 이동
		 * 
		 */
//		
//		int i = 1;
//		for(i=1; i<=5; i++) {
//			System.out.println("hi");
//		}
//		
		// 상황에 따라 while문이 유용할 때도 있다. 
		int i = 1;
		while(i++<=5) {
			System.out.println("hello world");
//			i++;
		}
		
		/* while 문에서는 조건식을 생략할 수 없다. 
		 * while 문에서 무한루프를 만들려면 조건식에 true를 넣어주면 된다.
		 */
//		int i = 1;
//		while(true) {
//			System.out.println("hello world");	
//		}

	}

}
