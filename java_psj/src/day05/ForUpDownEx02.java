package day05;

import java.util.Scanner;

public class ForUpDownEx02 {

	public static void main(String[] args) {
		/* 랜덤한 정수를 맞추는 up down 게임
		 * /* 랜덤수를 맞추기
		 * 반복횟수 : 맞출때까지 => 랜덤수  r과 입력한 수가 동일할 때까지
		 * 규칙성 : 
		 * 	1. 숫자 입력 안내 문구 출력
		 *  2. 정수 입력 받기
		 *  3. 입력 받은 정수가 r과 같으면 정답 출력하고 
		 *     입력 받은 정수가 r보다 크면 다운이라고 출력하고
		 *     아니면 업이라고 출력한다.
		 *  4. 게임을 더 할거면 y, 아니라면 n을 입력
		 */
		
//		int min = 1, max = 100;
//		int r = (int)(Math.random() * ((max - min + 1) + min));
//		System.out.println(r);
//		System.out.println(min + " ~ " + max + "사이의 랜덤한 수를 맞추세요");
//
//		Scanner scan = new Scanner(System.in);
//		int num = 0;
//		for(; r != num; ) {
//			System.out.print("정수 입력 : ");
//			num = scan.nextInt();
//			
//			if(num < r) {
//				System.out.println("UP");
//			} else if(num > r) {
//				System.out.println("DOWN");
//			} else if(num == r) {
//				System.out.println("정답");
//			}
//
//			}
//		System.out.print("계속 하시겠습니까? (y/n 으로 입력) : ");
//		char ch = scan.next().charAt(0);
//		if(ch == 'n') {
//			System.out.println("게임을 종료합니다.");
//		}
		
		// 강사님 풀이
		/* 반복횟수 : 없음
		 * 규칙성 : 
		 */
		int min = 1, max = 100;
		int r;
		int num = 0;
		Scanner scan = new Scanner(System.in);
		
		for(; ;) {
		r = (int)(Math.random() * ((max - min + 1) + min));
		System.out.println(r);
		System.out.println(min + " ~ " + max + "사이의 랜덤한 수를 맞추세요");
			for(; r != num; ) {
				System.out.print("정수 입력 : ");
				num = scan.nextInt();
				if(num < r) {
					System.out.println("UP");
				} else if(num > r) {
					System.out.println("DOWN");
				} else if(num == r) {
					System.out.println("정답");
				}
			}
			System.out.print("계속 하시겠습니까? (y/n 으로 입력) : ");
			char ch = scan.next().charAt(0);
			if(ch == 'n') {
				 break;
			}
				
		}
		System.out.println("프로그램을 종료합니다.");
		scan.close();
	}

}
