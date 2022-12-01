package day04;

public class ForPrimeNumberEx01 {

	public static void main(String[] args) {
		/* 정수 num가 소수인지 아닌지 판별하는 코드를 작성
		 * 소수는 약수가 1과 자기 자신뿐인 수
		 * 1은 소수가 아님
		 */
		// 서진 풀이
		int num = 9;
		// 반복성 : i가 num의 크기만큼 1씩 증가
		int i;
		// 규칙성 : 
//		for(i = 0; i <= num; i++) {
//			if(num % i != 0) {
//				System.out.println(i);
//			}
//		}
		
		// 강사님 풀이
		// 반복성 : i는 1부터 num까지 1씩 증가
		// 규칙성 : i가 num의 약수이면 count(약수의 개수)를 1증가
		//			num을 i로 나누었을 때 나머지가 0과 같다면 count(약수의 개수)를 1증가
		// 반복문 종료 후 : count가 2이면 소수라고 출력하고 2보다 크면 소수가 아님
		int count = 0;
		for(i = 1; i <= num; i++) {
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
}
