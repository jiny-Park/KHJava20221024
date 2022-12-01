package day12;

import java.util.Scanner;
			// 프로그래밍 언어 활용 Test
public class programmingLanguageUsesTest {

	public static void main(String[] args) {
		
		// 프로그래밍 언어 활용 문제였음.
				
//				for(int i = 1; i <= 20; i++) {
//					switch(i % 5) {
//					case 0:
//						System.out.println(i + ": 5의 배수");
//						break;
//					default:
//						System.out.println(i + ": 5의 배수 아님");
//					}
//				}
		

		// 프로그래밍 언어 활용 문제
		int[] arr = new int[4];
		for(int i = 0; i <= arr.length; i++) { // -> 배열의 번지는 배열의 크기 -1이기 때문에 배열의 <=로 코드를 쓰면 배열의 번지수보다 더 커지기 때문에 에러가 발생한다.
											   // 	 때문에 <으로 변경해줘야 옳다.
			arr[i] += (10 + i);	// += 에서 +가 붙어도 잘못된 코드는 아니다. 왜냐하면 배열은 기본 0으로 초기값이 들어가 있기 때문이다. 
								// 하지만 +는 큰 의미가 없긴 없는 코드다. 그래서 =만 있어도 되긴 함.
			System.out.println("arr["+ i + "] = " + arr[i]);
		}
		
		
		// 프로그래밍 언어 활용 문제
//		Scanner sc = new Scanner(System.in);
//		
//		while(true) {						// while문은 조건식이 참일때 실행문이 실행이 되기 때문에, false가 되면 실행문이 실행이 되지 않는다.
//			System.out.print("문자를 입력 : ");
//			String str = sc.nextLine();
//			if(str.equals("exit")) {		// 문자열 비교는 ==로 쓰면 안 되며, equals를 사용해야 한다. 
//				break;
//			} else{
//				System.out.println(str.length() + "글자");
//	
//			}
//		}
//		System.out.println("프로그램 종료");

	}
}