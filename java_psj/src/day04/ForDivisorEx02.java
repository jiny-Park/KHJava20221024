package day04;

public class ForDivisorEx02 {

	public static void main(String[] args) {
		/* 정수 num의 약수를 출력하는 코드를 작성
		 * 약수 : 나누었을 때 나머지가 0이 되게 하는
		 * 6의 약수 : 1 2 3 6
		 */
		int num = 6;
		int i;
		for(i = 1; i <= num; i++) {
			if(num % i == 0) {
				System.out.println(num + "의 약수는 " + i);
			}
		}
		
		// 강사님 풀이
		// 반복횟수 : i는 1부터 num까지 1씩 증가
		// 규칙성 : num를 i로 나누었을 때 나머지가 0과 같다면 i를 출력
		// 반복문 종료 후 : 없음 		
//		for(i는 1부터 num까지 1씩 증가) {
//			if(num를 i로 나누었을 때 나머지가 0과 같다면) {
//				i를 출력;
//			}
//		}
		

	}

}
