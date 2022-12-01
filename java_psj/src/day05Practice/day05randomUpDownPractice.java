package day05Practice;

import java.util.Scanner;

public class day05randomUpDownPractice {
	public static void main(String[] args) {
		// 랜덤 숫자 맞추기.
		// 프로그램 종료를 할 때까지 계속 게임 진행
		// 프로그램 종료 전 무한루프문 필요.
		// 랜덤숫자 필요
		// 입력 받을 변수 필요
		// 랜덤수와 입력 받은 수에 대한 비교 업, 다운 필요. 
		// 램덤수와 입력 받은 수가 같다면 '프로그램을 종료할건지(y/n)'문 출력
		// y 입력시 프로그램 종료
		// n 입력시 다시 랜덤수를 뽑으면서 다시 진행
		
		Scanner scan = new Scanner(System.in);
		int random;
		int min = 1, max = 100;
		
		System.out.println("램덤 숫자 맞추기 업다운 게임");
		for(;;) {
			random = (int)((Math.random() * ((max - min + 1)+ min))); 
			
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
