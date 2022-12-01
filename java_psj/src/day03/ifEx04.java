package day03;

public class ifEx04 {
	
	public static void main(String[] args) {
		// 정수 num가 3의 배수이면 3의 배수라고 출력하고, 아니면 3의 배수가 아닙니다를 출력하는 코드 작성
		
		// 변수 선언
		int num = 1;
		
		// 정수 num가 3의 배수이면
		if(num % 3 == 0) {
		// 3의 배수라고 출력
			System.out.println(num + "은 3의 배수이다.");
		}
		// 아니라면 
		else {
		// 3의 배수가 아닙니다를 출력
			System.out.println(num + "은 3의 배수가 아니다.");
		}
		

	}
}
