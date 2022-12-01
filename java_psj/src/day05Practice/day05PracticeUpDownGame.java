package day05Practice;

import java.util.Scanner;

import day03.ifEx01;

public class day05PracticeUpDownGame {
	public static void main(String[] args) {
		// 랜덤숫자 맞추기!!
		// 컴퓨터가 랜덤숫자를 제시한다.
		
		// 사용자가 숫자를 입력
		
		// 사용자가 입력한 숫자와 컴퓨터가 제시한 랜덤수와 비교
		
		// 사용자가 입력한 숫자가 컴퓨터가 제시한 랜덤수보다 작다면 UP
		
		// 사용자가 입력한 숫자가 컴퓨터가 제시한 랜덤수보다 크다면 DOWN
		
		// 같은 숫자가 나왔다면 정답! 프로그램 종료!
		
		
		int min, max, num = 0;
		min = 1;
		max = 9;
		
		int random = (int)(Math.random() * (max - min + 1) + min);
		System.out.println(random);
		
		Scanner scan = new Scanner(System.in);
		
		for( ;random != num; ) {
			System.out.print("정수 입력 : ");
			num = scan.nextInt();
			if(num < random) {
				System.out.println("UP!");
			} else if(num > random) {
				System.out.println("DOWN");
			} else{
				System.out.println("정답!");
			}
			
		} 
		
		
	}
}
