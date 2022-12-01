package day29;

import java.util.Scanner;

public class Problem01 {

	public static void main(String[] args) {
		// 아래 코드를 실행했을 때 결과와 결과가 그렇게 나오는 이유를 설명하세요.
		// 두 결과가 모두 true가 되려면 코드를 어떻게 수정 해야 하는지 설명하세요.
		
		// 결과 : 
		// 원인 : 
		// 두 결과가 모두 true가 되려면 :
		
		
		//정답
		// 결과 : true, false
		// (참조변수의 경우)
		// 원인 : "abc"는 리터럴 문자열이다.
		//		이미 사용된 리터럴 문자열을 이용하는 경우, 
		//		새로 선언하는 것이 아니라 기존에 선언된 리터럴 문자열의 주소를 알려준다. 
		//		그래서 서로 공유한다. 그래서 첫번째 출력은 true가 된다. 
		//		scanner을 이용하여 입력받은 문자열은 리터럴 문자열이 아니기 때문에
		//		입력한 문자열이 앞에 사용중인 리터럴 문자열이라도 새로 할당하여 주소를 넘겨준다.
		//		그래서 출력은 공유하는 것이 아니기 때문에 false가 된다.
		// 올바르게 동작 시키려면 equals를 이용해야 한다.
		// 두 결과가 모두 true가 되려면 : str1.equals(str2) / str1.equals(str3)
		
		Scanner scan = new Scanner(System.in);

		String str1 = "abc";	// 리터럴 문자열임. 밑에서 abc 선언할 때, 값을 저장하는 것이 아니라 리터럴은 주소값을 공유하기 때문에 
								// true가 나옴.
		String str2 = "abc";
		String str3 = scan.next();	//abc를 입력했다고 가정 -> 애는 공유하는게 아니고 따로 값을 새로 저장함.
		
		System.out.println(str1 == str2);	// true가 나옴. 
		System.out.println(str1 == str3);	// false가 나옴
		scan.close();
		

	}

}
