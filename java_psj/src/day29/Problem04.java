package day29;

public class Problem04 {
	
	static String str;
	
	public static void main(String[] args) {
		// 아래 코드 실행 시 발생되는 결과를 작성하고 원인을 설명하세요.
		
		// 결과 : null  출력이 됨.
		// 원인 : substring은 위치를 지정하고 지정한 위치의 문자가 무엇인지 보여주는 메소드인데, 
		//  현재 str은 필드로 선언만 했을뿐 값은 정의하지 않았기 때문에, 초기화 값인 null이 출력된다.
		
		//정답
		// 결과 : NullPointerException이 발생.
		//		필드 str은 null로 초기화 되어 있는데, 문자열을 저장하지 않고 메소드를 호출하기 때문에
		
		// 원인 : 필드 str은 null로 초기화 되어 있는데, 문자열을 저장하지 않고 메소드를 호출하기 때문에
		
		System.out.println(str.substring(0));
	}

}
