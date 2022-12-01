package day19;

public class ChainingEx01 {

	public static void main(String[] args) {
		/* 체이닝 : .이 연달아 나와 메소드를 연속해서 호출
		 * 앞에 있는 메소드 리턴 값(객체)이 이어서 메소드를 호출
		 */
		// . 을 붙일수 있는건 객체에만 붙일 수 있음.
		String str = "Hello";
		/* 문자열 str에 2번지부터 부분문자열을 추출한 후, 0번지 문자를 가져옴.
		 * 0번지 문자를 가져왔기 때문에 charAt()다음에는 .을 통해 메소드를 호출할 수 없음.
		 * 
		 */
		
		System.out.println(str.substring(2).charAt(0));

//		System.out.println(1.);
		// toString 을 통해 숫자가 객체 string으로 변환되기 때문에 . 을 사용하여 charAt를 사용가능케 함
		System.out.println(toString(100).charAt(0));
		
		// print()는 리턴타입이 없기 때문에 체이닝을 쓸 수 없다.
		// 리턴타입이 일반 변수(int, char 등)인 경우도 체이닝을 쓸 수 없다.
//		print(10.);	. 점 사용 불가
		
	}
	
	public static String toString(int num) {
		return num +"";
	}
	
	public static void print(int num) {
		System.out.println(num);
	}

}
