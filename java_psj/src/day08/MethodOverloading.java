package day08;

// Method Overloading 매우 중요!
public class MethodOverloading {

	public static void main(String[] args) {
		/* 메소드 오버로딩 : 동일한 이름을 가진 메소드가 여러개 있는 것
		 * 규칙 : 
		 * 		- 매개변수의 개수가 다름
		 * 		- 매개변수의 자료형이 다름
		 * 메소드 오버로딩 쓰는 이유 : 편하기 때문에
		 */
		/* 그동안 모르게 사용되었던 메소드 오버로딩 : println -> 자료형이 다른 경우
		System.out.println(1);
		System.out.println("1");
		System.out.println(1.1f);
		System.out.println(1.0);
		System.out.println('1');
		System.out.println();
		*/
		
		System.out.println(sum(1,2,3, 4));
		
		

	}
	
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	// 매개변수의 개수가 달라서 매소드 오버로딩이 가능
	public static int sum(int num1, int num2, int num3) {	//=> 매개변수를 정수 2개로 했을시 위의 메소드와 같기 때문에 에러가 생김.
		return num1 + num2 + num3;
	}
	
	public static int sum(int num1, int num2, int num3, int num4) {	
		return num1 + num2 + num3 + num4;
	}
	// 매개변수의 자료형이 달라서 메소드 오버로딩 가능
	public static double sum(double num1, double num2) {	
		return num1 + num2;
	}
	
	// 리턴타입이 메소드 오버로딩과 상관이 없음 => 에러 발생
//	public static double sum(int num1, int num2) {	
//		return num1 + num2;
//	}
	
	

}
