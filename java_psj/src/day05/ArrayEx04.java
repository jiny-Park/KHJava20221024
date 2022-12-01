package day05;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		/* 학생 5명의 국어 성적을 입력 받고 출력하는 코드를 작성하세요
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		
		int score[] = new int[5];
		for(int i = 0; i < score.length; i++) {
			System.out.print("학생 " + (i + 1) + "의 성적 입력 : ");
			int num = scan.nextInt();
			score[i] = num;
		}
		
		System.out.println("------------------");
		
		for(int i = 0; i < score.length; i++) {
			System.out.println("학생 " + (i + 1) + "의 점수 : " + score[i]);
		}
		
	
		
		// 학생 성적의 평균을 구하는 코드를 작성
		// 다 더한 값 / arr.length 길이만큼 나누어야 함.
		// 반복횟수 : i는 0부터 배열의 크기보다 작을때까지 1씩 증가
		// 규칙성 : sum에 배열 i번지에 있는 값을 누적
		// 반복문 종료 후 : sum을 배열의 크기로 나눈 값을 출력(나누기 조심)
		int sum = 0;
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		double avg = sum / (double)score.length;
		System.out.println("5명의 학생 성적 평균 : " + avg);
		
		// 강사님 풀이 : 향상된 for문
		sum = 0;
		for(int tmp : score) {
			sum += tmp;
		}
		avg = sum / (double)score.length;
		System.out.println("5명의 학생 성적 평균 : " + avg);
		
		
		
		scan.close();
	}
}
