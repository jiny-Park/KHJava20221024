package day05;

import java.util.Scanner;

public class ForUpDownEx01 {

	public static void main(String[] args) {
		/* 랜덤한 수를 생성하여 해당 수를 맞추는 코드를 작성하세요. 
		 * 예시 : (생성한 랜덤한 수 70)
		 * 
		 * 랜덤한 수 생성
		 * 입력 받는 수 
		 * 랜덤한 수와 해당수가 같다면
		 * 맞췄습니다를 출력 
		 * 아니라면 틀렸습니다 출력
		 */


		
		// 랜덤 수 생성
		int min = 1, max = 99;				// 이렇게 설정한 이유는 Maht.random을 곱할 때 
											// 일일이 숫자로 입력하지 않아도 min과 max의 변수만 
											// 바꺼주면 숫자의 법위를 정해줄 수 있기 때문이다.
		int r = (int)(Math.random() * ((max - min + 1) + min));

		System.out.println(r);	// 정답 체크하기 위한 출력문
		
		/* 랜덤수를 맞추기
		 * 반복횟수 : 맞출때까지 => 랜덤수  r과 입력한 수가 동일할 때까지
		 * 규칙성 : 
		 * 	1. 숫자 입력 안내 문구 출력
		 *  2. 정수 입력 받기
		 *  3. 입력 받은 정수가 r과 같으면 정답 출력하고 
		 *     입력 받은 정수가 r보다 크면 다운이라고 출력하고
		 *     아니면 업이라고 출력한다.
		 */
		// 서진 풀이
//		System.out.println("랜덤수 Up&Down 맞추기 게임!");
//		Scanner scan = new Scanner(System.in);
//		int num = 0;
//		for(; num != r; ) {
//			System.out.print("정수 입력 :");
//			num = scan.nextInt();
//			
//			if(num == r) {
//				System.out.print("정답");
//			} else if(num < r) {
//				System.out.println("up");
//			} else if(num > r) {
//				System.out.println("down");
//			}
//		} 
		
		
		// 강사님 풀이
		int num = min -1;
		Scanner scan = new Scanner(System.in);
		for(; r != num; ) {
			System.out.println("숫자를 입력 : ");
			num = scan.nextInt();
			if(num==r) {
				System.out.println("정답");
			} else if(num > r) {
				System.out.println("down");
			} else {
				System.out.println("up");
			}
		}

		

	}

}
