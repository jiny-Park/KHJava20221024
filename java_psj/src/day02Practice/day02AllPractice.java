package day02Practice;

import java.util.Scanner;

public class day02AllPractice {

	public static void main(String[] args) {
		// 세 가지 과일을 입력 받고, 세 가지 과일의 갯수를 입력 받아, 각 과일마다 총 몇개인지 출력합니다.
		// 변수
//		String fruit1, fruit2, fruit3;
//		int num1, num2, num3, num4;
//		int total;
		
		// 세 가지 과일 입력 받기
//		Scanner scan = new Scanner(System.in);
//		System.out.println("세 가지 과일을 입력하세요.");
//		System.out.print("첫 번째 과일 : ");
//		fruit1 = scan.nextLine();
//		System.out.print("두 번째 과일 : ");
//		fruit2 = scan.nextLine();
//		System.out.print("세 번째 과일 : ");
//		fruit3 = scan.nextLine();
		
		// 세 가지 과일의 갯수 입력 받기
//		System.out.print(fruit1 + "의 갯수를 입력하세요 : ");
//		num1 = scan.nextInt();
//		System.out.print(fruit2 + "의 갯수를 입력하세요 : ");
//		num2 = scan.nextInt();
//		System.out.print(fruit3 + "의 갯수를 입력하세요 : ");
//		num3 = scan.nextInt();
		
		// 각 과일마다 총 몇 개인지 출력하기
//		total = num1 + num2 + num3;
//		System.out.println(fruit1 + "의 갯수는 " + num1 +"개 입니다.");
//		System.out.println(fruit2 + "의 갯수는 " + num2 +"개 입니다.");
//		System.out.println(fruit3 + "의 갯수는 " + num3 +"개 입니다.");
//		System.out.println("-----------------------");
//		System.out.println("모든 과일의 갯수는 총 " + total +"개 입니다.");
//		
//		scan.close();
		
		int array[][] = {
				{100, 300, 0},
				{20, 100, 300},
				{10, 100, 100}
				};
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("array[%d][%d] = %d\n", i, j, array[i][j]);
				
				sum += array[i][j];
			}
		}
		System.out.println("sum = " + sum);
		
		for(int i = 10; i > 0; i--) {
			for(int j = 0; j < i; j++) {
			System.out.print("*");
			}
			System.out.println();
		}

		
	}
}












