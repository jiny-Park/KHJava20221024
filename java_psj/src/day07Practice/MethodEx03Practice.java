package day07Practice;

public class MethodEx03Practice {

	public static void main(String[] args) {
		/* 주어진 정수 num가 소수인지 아닌지 판별하는 코드를 작성
		 * 단, 메소드를 이용할 것
		 */

		System.out.println(isPrimeNumber(12));
	}
	
	/* 기능 : 주어진 정수 num이 소수인지 아닌지 판별(true, false)하는 메소드
	 * 매개 변수 : 주어질 정수 => int num
	 * 리턴타입 : 소수인지 아닌지 => boolean(인지 아닌지 판별할때 사용)
	 * 메소드명 : isPrimeNumber
	 */
	public static boolean isPrimeNumber(int num) {
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return num <= 1 ? false : true;
	}

}
