package day02;

public class TypeCatingEx01 {

	public static void main(String[] args) {
		// 접미사 f(F)가 없는 실수 리터럴은 double형
		// 1.23은 8byte인 double이고, num1은 4byte인 float이기 때문에 자동형변환이 불가능하다 => 접미사를 붙이거나 강제형변환을 해줘야 함
//		float num1 = 1.23;
		float num1 = (float)1.23;
		
		// 정수 리터럴은 자료형에 맞는 타입으로 설정이 된다 
		byte num2 = 3;
		long num3 = 3;
		
//		int num4 = 12345678901;	// int의 범위를 벗어난 상황
		int num4 = (int)12345678901L;
		
		
	}

}
