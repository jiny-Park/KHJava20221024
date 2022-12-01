package day07;

public class MethodEx05 {

	public static void main(String[] args) {
		/* 1부터 10까지 합을 구하는 코드를 작성하세요. 단, 메소드를 이용할 것
		 * 
		 */
		numTotal(10);
		
		System.out.println(numTotal1(10));;
		
		numTotal2(5, 10);
		
		System.out.println(numTotal3(1, 10));;
		
		int start = 1, end = 10;
		System.out.println(start + " ~ " + end + " 까지의 총합 : " + sum(1, 10));;
		
		int num1 = 10, num2 = 1;
		System.out.println(num1 + " ~ " + num2 + " 까지의 총합 : " + sum1(1, 10));;
		
		// 강사님 풀이 출력 : 숫자가 앞 뒤가 바뀐다면
		int num3 = 10, num4 = 1;
		System.out.println(num3 + " ~ " + num4 + " 까지의 총합 : " + sum2(10, 1));;
		
	}
	/* 기능 : 1부터 10까지 합을 구하는 코드
	 * 매개변수 : 1~10까지 합을 구할 때 가장 큰 수인 10을 저장한 정수 => int num
	 * 리턴타입 : 없음 => void
	 * 메소드명 : numTotal
	 */
	public static void numTotal(int num) {
		int sum = 0;
		for(int i = 0; i <= num; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	/* 기능 : 1부터 10까지 합을 구하는 코드
	 * 매개변수 : 1~10까지 합을 구할 때 가장 큰 수인 10을 저장한 정수 => int num
	 * 리턴타입 : 총합을 정수로 리턴 => return
	 * 메소드명 : numTotal1
	 */
	public static int numTotal1(int num) {
		int sum = 0;
		for(int i = 0; i <= num; i++) {
			sum += i;
		}
		return sum;
	}
	
	/* 기능 : 1부터 10까지 합을 구하는 코드
	 * 매개변수 : 시작수 끝수를 입력할 정수 => int strat, int end
	 * 리턴타입 : 없음 => void
	 * 메소드명 : numTotal2
	 */
	public static void numTotal2(int start, int end) {
		int sum = 0;
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		System.out.println(start + " ~ " + end + " 까지의 총합 : " + sum);
	}
	
	/* 기능 : 1부터 10까지 합을 구하는 코드
	 * 매개변수 : 최소수와 최대수를 입력할 정수 => int min, int max
	 * 리턴타입 : 최소수와 최대수와 합계 => int 
	 * 메소드명 : numTotal3
	 */
	
	public static int numTotal3(int start, int end) {
		int sum = 0;
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		return sum;
	}
	
	// 강사님 풀이 1
	/* 기능 : 시작숫자부터 끝숫자 사이의 모든 정수를 더하는 메소드를 더하고, 더한 결과를 알려주는 메소드
	 * 매개변수 : 시작숫자, 끝숫자 => int start, int end
	 * 리턴타입 : 더한 결과 => 정수 => int
	 * 메소드명 : sum
	 */
	public static int sum(int start, int end) {	// 메소드 이름과 변수 이름은 같아도 된다. 
		int sum = 0;	// 멤버 변수
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		return sum;
	}
	
	/*응용 -> 서진 풀이 -> 문제점 : num1의 값과 num2의 값이 각각 for문에서 따로 돌기 때문에, 아예 다른 결과값이 나오게 된다.
	 * 						 예를 들어 num1의 값이 3이면 for문에서 총합이 6이 나오고, 
	 * 						 마찬가지로 num2의 값도 3이면 for문에서 총합이 6이 됨으로 num1, num2의 총합은 12가 되버린다.
	 * 						 문제 의도와는 아예 다른 결과값이 되버리는 것이다.
	 * 						 문제는 10~1으로 입력하든, 1~10으로 입력하든 그 사이의 총합을 구하는 것인데,
	 * 						 내가 풀었을때는, 아예 서로 다른 값으로 정해지고 다른 값으로 더해지니 결과값이 아예 문제와는 다르게 나오게 된다.
	*/
	// 숫자 앞뒤가 바뀌었을때 (예)10~1까지라고 입력했을시) 
	public static int sum1(int num1, int num2) {
		int sum = 0;
		int sum1 = 0;
		int total;
		for(int i = 0; i <= num1; i++) {
			sum += i;
		}
		for(int i = 0; i <= num2; i++) {
			sum1 += i;
		}
		total = sum + sum1;
		return total;
	}
	
	// 응용 -> 강사님 풀이
	// 숫자 앞뒤가 바뀌었을때 (예)10~1까지라고 입력했을시) 
	public static int sum2(int start, int end) {	// 메소드 이름과 변수 이름은 같아도 된다. 
		if(start > end) {			// 입력받은 숫자 두 개를 서로 비교하여 
			int tmp = start;		// 큰 숫자가 앞에 정렬할 수 있도록 해줌으로 해결.
			start = end;
			end = tmp;
		}
		int sum = 0;	// 멤버 변수
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		return sum;
	}

}
