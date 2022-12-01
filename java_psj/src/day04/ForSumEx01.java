package day04;

public class ForSumEx01 {

	public static void main(String[] args) {
		/* 1부터 10사이의 짝수의 합을 구하는 코드를 작성하세요.
		 * 반복횟수 : 10번이 반복이 되지만 2의 배수만 sum에 저장하며 반복해서 저장된 sum의 값에 반복되는 2의 배수를 더해준다.
		 * 규칙성 : 2, 4, 6, 8, 10 곧 2의 배수만 출력
		 * - 0 + (0%2)
		 * - 1 + (1%2 == 1) 
		 * - 2 + (2%2 == 0) = 2를 sum에 저장
		 * - sum + 3 + (3%2 == 1) 
		 * - sum + 4 + (4%2 == 0) 2 + 4 = 6을 sum에 저장
		 * 반복문 종료 후 : 
		 */
		
		int i, sum;
		for(i = 1, sum = 0; i <= 10; i++) {
			if(i % 2 == 0) {
				sum += i;	// sum = sum + i;
			}
		}
		System.out.println(sum);
		
		// 강사님 풀이
		/* 반복횟수 : i는 1부터 10까지 1씩 증가 -> for( ; ; )의 조건식으로 들어감.
		 * 규칙성 : i가 짝수이면 sum += i를 실행 -> 면이 보이면 조건문 들어간다고 생각하는 것이 좋다.
		 * 반복문 종료 후 : sum 출력
		 */
		i = 0;
		sum = 0;
		for(i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("1~10까지 짝수 합 : " + sum);

	}
}
