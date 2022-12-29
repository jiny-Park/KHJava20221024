package day02;

public class OperatorEx01 {

	public static void main(String[] args) {
		// !(Not) 연산자 (원하는 결과의 반대로 바꺼줌) : 참 또는 거짓인 값(변수, 리터럴, 조건식) 앞에 옴, 상황에 맞게끔 유의해서 사용
		boolean isMale = true;
		System.out.println("남성입니까? : " + isMale);
		System.out.println("여성입니까? : " + !isMale);
		
		int a = 10;
		int b = ++a;
		System.out.println(a +","+ b);
		
		a = 10;
		System.out.println(a);
		b = a++;
		System.out.println(a +", "+ b);
		
	}

}
