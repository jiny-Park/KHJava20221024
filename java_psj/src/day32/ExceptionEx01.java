package day32;

public class ExceptionEx01 {

	public static void main(String[] args) {
		try {
			test();
//			System.out.println(1/0);
		}catch(ArithmeticException e) {
			System.out.println("예외 발생 : " + e.getMessage());		
		}catch(Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());		
		}

	}
	public static void test() {	// throw new RuntimeException과 이 자손 클래스는 생략이 가능, Exception은 생략 불가능
		throw new RuntimeException("런타임 예외 발생");
	}

}
