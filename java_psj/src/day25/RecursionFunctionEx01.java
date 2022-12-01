package day25;

public class RecursionFunctionEx01 {

	/* 재귀함수 : 함수의 실행문으로 자신을 다시 호출함
	 * - 잘못 작성하면 스택 오버 플로우(StackOverflowError)가 발생할 수 있음.
	 * - 탐색 같은 것을 진행할 때 사용을 함. 알고리즘에서 재귀함수를 많이 사용함. 일반적인 상황에서는 잘 사용하지 않음.
	 * 
	 */
	public static void main(String[] args) {
//		print(10); -> StackOverflowError 발생
		
		/* 양수 정수 n!을 구하는 코드를 작성하세요
		 * n! = 1*2*3*...n 
		 * n*(n-1)! 
		 * n*
		 */
		System.out.println(factorial(5));
		// 5 * f(4)
		//	-> 4 * f(3)
		//		-> 3 * f(2)
		//			-> 2 * f(1)
		
		// 120
		//	-> 24
		//		-> 6
		//			-> 2	
		
		// 5 * 24
		//	-> 24
		//		-> 6
		//			-> 2	
				
		// 5 * f(4)
		//	-> 24
		//		-> 6
		//			-> 2
		
		// 5 * f(4)
		//	-> 4 * 6
		//		-> 6
		//			-> 2
		
		// 5 * f(4)
		//	-> 4 * f(3)
		//		-> 3 * 2
		//			-> 2
		
		// 5 * f(4)
		//	-> 4 * f(3)
		//		-> 3 * f(2)
		//			-> 2 * 1
		
		

	}
	
	public static void print(int num) {
		System.out.println(num);
		print(num);
	}
	
	public static long factorial(int num) {
		if(num < 0) {
			throw new RuntimeException("음수는 팩토리얼을 구할 수 없습니다!");
		}
		if(num == 1 || num ==0) {
			return 1; // 탈출 조건
		}
		return num * factorial(num - 1);
	}

}
