package day25;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import day03.ifEx01;


public class Ex04 {
	/* 컴퓨터와 가위, 바위, 보를 하는 프로그램을 작성
	 * 예)
	 * 사용자 : 가위
	 * 컴퓨터 : 보
	 * 사용자가 이겼습니다. 더 하겠습니까? (y/n) : y
	 * 사용자 : 가위
	 * 컴퓨터 : 주먹
	 * 컴퓨터가 이겼습니다. 더 하겠습니까? (y/n) : n
	 * 
	 */
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// 컴퓨터에 가위, 바위, 보를 저장하고
		// 컴퓨터가 랜덤으로 가위, 바위, 보 중에 하나를 출력
		do {
			System.out.print("사용자 : ");
			String user = scan.next();
			
			String com = randomRPS();
			System.out.println("컴퓨터 : " + com);
			
			int res = compare(user, com);
			printResult(res);
			
			System.out.print("더 하겠습니까?(y/n) : ");
			
		} while(!scan.next().equals("n"));
		
	}
	//▼▼▼▼▼▼▼ M e t h o d ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	public static String randomRPS() {
		List<String> list = Arrays.asList("가위", "바위", "보");
		int r = (int)(Math.random() * 3);
		return list.get(r);
	}
	
	private static int compare(String user, String com) {
		if(user.equals(com)) {
			System.out.println("비겼습니다!");
			return 0;
		}
		
		switch (user) {
		case "가위" : 
			return com.equals("보") ? 1 : -1;
		case "바위" : 
			return com.equals("가위") ? 1 : -1;	
		default:
			return com.equals("바위") ? 1 : -1;
		}
	}
	
	private static void printResult(int res) {
		switch(res) {
		case 1: 
			System.out.println("사용자가 이겼습니다!");
			break;
		case -1: 
			System.out.println("컴퓨터가 이겼습니다!");
			break;
		default:
		} 
	}

}
