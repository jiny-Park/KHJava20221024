package day08;

public class ReferenceEx01 {
	
	static String str2; //멤버변수 or 필드변수 or 전역변수

	public static void main(String[] args) {
		/* 잠조변수 : 주소를 저장하는 변수, 객체, 배열 등
		 * null : 값이 없음을 알려주는 키워드로 참조 변수에서 사용
		 * 
		 */
		String str = null; // 아직 할당이 안 되어 있다고 null로 표시를 함. 
		System.out.println(str);
		
		String str1;
//		System.out.println(str1); // 에러 발생 -> 초기화가 안된 지역변수들은 값을 활용 할 수 없다. 
		
		System.out.println(str2); // 멤버변수들은 초기화를 하지 않아도 기본값으로 초기화가 됨
								  // 정수 : 0, 실수 : 0.0f, 0.0d, char : \u0000, boolean : false로 초기화됨.
								  // 참조변수는 null로 초기화가 됨.
		
		if(str2 != null)
			System.out.println(str2.charAt(0));
		
	}

}
