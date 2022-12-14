package day07;

public class MethodEx02 {

	public static void main(String[] args) {
		/* 7단을 출력하는 코드를 작성하세요. 단, 메소드를 이용할 것
		 * 
		 */
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(mul(7, i));
		}
		
		System.out.println("----------------");
		
		for(int i = 1; i <= 9; i++) {
			mul2(7, i);
		}
		
		printTimesTable1(6);
		System.out.println("----------------");
		
		printTimesTable2(5, 1, 5);	// 지금 이상황에서는 두번째 예제의 메소드가 가장 이상적이다. 그 이유는 반복문 없이 깔끔하게 출력이 되며
									// 시작 단수와 끝단수까지도 한 번의 수정으로도 수정이 가깝기 때문이다.
		System.out.println("----------------");
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(multi(3, i));
		}
	}
	
	/* 기능 : 두 정수의 값을 곱하는 기능
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 두 정수의 곱한 값 => 정수 * 정수 = 정수
	 * 메소드명 : mul
	 */
	public static int mul(int num1, int num2) {
		return num1 * num2;
		}
	public static void mul2(int num1, int num2) {
		System.out.println(num1 * num2);
		return;
	}
	
	// 강사님 풀이 1 
	/* 기능 : 단이 주어지면 해당하는 단을 콘솔에 출력하는 메소드
	 * 매개변수 : 단 => 정수 => int num
	 * 리턴타입 : 없음 -> void
	 * 메소드명 : printTimesTable1
	 */
	public static void printTimesTable1(int num) {
		for(int i = 1; i <= 9; i++) {
			System.out.println(num + " * " + i + " = " + (num * i));
		}
	}
	
	
	// 강사님 풀이 2
	/* 기능 : 단과 시작정수, 끝장수가 주어지면 해당 하는 단을 '단 x 시작숫자'에서 '단 x 끝숫자'까지 콘솔에 출력하는 메소드
	 * 매개변수 : 단, 시작숫자, 끝숫자 => int num, int start, int ent
	 * 리턴타입 : 없음 -> void
	 * 메소드명 : printTimesTable2
	 */
	public static void printTimesTable2(int num, int start, int end) {
		for(int i = start; i <= end; i++) {
			System.out.println(num + " * " + i + " = " + (num * i));
		}
	}
	// 강사님 풀이 3
	/* 기능 : 두 정수가 주어지면 두 정수의 곱을 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 두 정수의 곱 => 정수 => int 
	 * 메소드명 : multi
	 */
	public static int multi(int num1, int num2) {
		return num1*num2;
	}
	
}
	