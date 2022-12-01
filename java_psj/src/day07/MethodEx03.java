package day07;

public class MethodEx03 {

	public static void main(String[] args) {
		/* 주어진 정수 num가 소수인지 아닌지 판별하는 코드를 작성
		 * 단, 메소드를 이용할 것
		 */

		primeNumber(11);
		
		printPrimeNumber(11);
// 출력시 입력한 값을 재사용할 수 없다? 때문에, isPrimeNuber이 재사용성에서 좋다.
// 콘솔에 값을 아예 출력한다는 것 -> 예)1번 학생아 칠판에 7이 소수인지 아닌지 써봐라. -> 이랬을때 내가 칠판을 봐야지만 확인할 수 있고 이미 칠판에 썼기 때문에 재사용할 수가 없다.
// 콘솔에 값을 출력한다는 것이 아니라 판별을 한다는 것 -> 예) 1번 학생아 7이 소수인지 아닌지 말해봐 -> 이랬을때 나는 듣기만해도 값이 무엇인지 확인할 수 있고 계속해서 재사용을 할수가 있다.
		System.out.println(isPrimeNumber(11));
	}
	// 서진 풀이
	/* 기능 : 주어진 정수 num이 소수인지 아닌지 '출력'하는 코드
	 * 매개변수 : 주어지는 정수 1개 => int num
	 * 리턴타입 : 없음 => void
	 * 메소드명 : primeNumber
	 */
	public static void primeNumber(int num) {
		int count = 0;
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				count += 1;		// count = count + 1; // ++count; // count++;
			}
		}
		if(count == 2) {
			System.out.println(num + "는 소수");
		} else {
			System.out.println(num + "는 소수가 아님");
		}
	}
	
	/* 기능 : 주어진 정수 num이 소수인지 아닌지 '판별'하는 코드		#'출력'과 '판별'은 다름.
	 * 매개변수 : 주어지는 정수 1개 => int num
	 * 리턴타입 : num이 소수인지 아닌지 => 
	 * 메소드명 : primeNumber1
	 */
//	public static int primeNumber1(int num) {
//		return num;
//		int count = 0;
//		for(int i = 1; i <= num; i++) {
//			if(num % i == 0) {
//				count += 1;		// count = count + 1; // ++count; // count++;
//			}
//		}
//		if(count == 2) {
//			System.out.println(num + "는 소수");
//		} else {
//			System.out.println(num + "는 소수가 아님");
//		}
//	}
	
	/* 강사님 풀이 1.
	 * 기능 : 정수가 주어지면 소수인지 아닌지 출력하는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printPrimeNumber
	 */
	public static void printPrimeNumber(int num) {
		int count = 0;
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				count += 1;	
			}
		}
		if(count == 2) {
			System.out.println(num + "는 소수");
		} else {
			System.out.println(num + "는 소수가 아님");
		}
	}

	/* 강사님 풀이 2.
	 * 기능 : 정수가 주어지면 소수인지 아닌지 판별하는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 소수인지 아닌지 => boolean(A 아니면 B 이런식이면 보통 boolean
	 * 메소드명 : isPrimeNumber(is는 보통 참거짓을 애기할때 사용)
	 */
	public static boolean isPrimeNumber(int num) {
		for(int i = 2; i < num; i++) {
			// 1과 num을 제외한 약수
			if(num % i == 0) {
				return false;
			}
		}
		return num <= 1 ? false : true;
	}
}
