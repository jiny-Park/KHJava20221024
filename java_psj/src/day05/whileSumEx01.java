package day05;

public class whileSumEx01 {

	public static void main(String[] args) {
		/* 1부터 10사이의 홀수의 합을 구하는 코드를 while문으로 작성
		 * 반복 : i를 1~10까지 반복
		 * 규칙 : i % 2 == 1일 때 sum변수에 저장
		 */
		
		int i = 1;
		int sum = 0;
		while(i<=10) {						// -> ++i <= 10 으로 해서 응용도 가능.
			if(i % 2 != 0) {
				sum = sum + i;
				System.out.println(sum);
			}
			i++;
		}
		System.out.println("1~10사이 홀수의 합 : " + sum);
		
		
	}

}
