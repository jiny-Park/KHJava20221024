package day03;

public class switchEx03 {

	public static void main(String[] args) {
		// ifEx06 예제를 switch문으로 변경
		char ch = '+';
		
		switch(ch) {
		case '+', '-', '*', '/', '%':
			System.out.println(ch + "는 산술연산자 입니다.");
			break;
		default:
			System.out.println(ch + "는 산술연산자가 아닙니다.");
		}

	}

}
