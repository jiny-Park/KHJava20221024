package day03;

public class ForEx03 {

	public static void main(String[] args) {
		/* 구구단 2단을 출력하는 코드를 작성하세요.
		 * 반복횟수 : 1~9까지
		 * 규칙성 : 2 * ? = ??를 출력
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 */
		
		int i = 1;
		int num = 3;
		for(i = 1; i <= 9; i++) {
			System.out.println(num + " * " + i + " = " + (num * i));
		}
		
		for(i = 1; i <= 9; i++) {
			System.out.println(num + " * " + i + " = " + (num * i));
		}
		
	}

}
