package day01;

public class VariableEx01 {

	public static void main(String[] args) {
		/* - 변수선언
		 * 	1. 자료형 변수명;  
		 * 	2. 자료형 변수명 = 초기값;
		 * 
		 * - 자료형 종류(외워야 함!)
		 * 	(tip : C언어는 char가 1byte임)
		 * 	-기본자료형과 참조형(String)
		 */
		// 기본 자료형
		boolean isEven = false;  // is를 통해 물어보듯 대중적으로 많이 사용
		char operator = '+';	 // char형은 빈문자 불가능
		int age = 20;
		float pi1 = 3.1415f;	 // float은 접미사 뒤에 F or f를 반드시 넣어야 함
		double pi2 = 3.1415;
		
		// 참조형 변수
		String str = "Hi";		 // 빈문자 가능함
		
		
		// 변수 이름은 길게 작성할 수 있기 때문에, 의미있게 지어주는 것이 좋다
		// 1. 사과의 개수를 저장하기 위한 변수를 선언해보세요.
		int appleCount;  // 카멜표기법
				
		// 2. 학생 평균 성적을 저장하기 위한 변수를 선언해보세요.
		double socoreAverage;
		
		int num;
//		int num; // 중복된 변수는 선언 불가능
		int NUM; // 대소문자 구분
//		int 1num;// 숫자로 시작할 수 없다
		int _num, $num; // _, $만 특수문자 가능
//		int int; // 예약어 사용 금지
		
		/* 관례 : 안지켜도 되지만 많은 개발자들이 지키며 사용함
		 *   - 변수는 소문자로 시작
		 *   - 카멜 표기법을 따라서 두 번째 글자부터 첫 글자를 대문자로 사용
		 *   - 클래스와 인터페이스는 대문자로 시작
		 */
		
		
		
	}
}

