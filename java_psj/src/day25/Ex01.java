package day25;

import java.util.Scanner;

public class Ex01 {
	
	static Scanner scan = new Scanner(System.in);	

	/* 정수를 입력받아 입력받은 정수가 0이상이면 0부터 입력받은 수까지 합을 구하고,
	 * 입력받은 정수가 0미만이면 0부터 입력받은 수까지 차를 구하는 코드를 작성하세요 
	 * ex)
	 * 정수 입력 : 3
	 * 0부터 3까지 누적 합 : 6
	 * 정수 입력 : -3
	 * 0부터 -3까지 누적 차 : 6
	 */

	public static void main(String[] args) {
		// 정수 입력 : 
		// 1. 안내 문구와, 
		// 2. 콘솔에 입력 받기
		System.out.print("정수 및 음수 입력 : ");
		int num = scan.nextInt();
		
		// 3. 합을 저장할 변수 sum
		int sum = 0;
		
		// 4. if문을 통하여 정수가 0이상이면 
		if(num >= 0) { 
			// 4-1. 0부터 입력받은 수까지 합을 구하고
			for(int i = 0; i <= num; i++) {
				sum += i;
			}
			System.out.println(num + "까지의 합 : " + sum);	
		// 5. 아니라면 곧 0 미만이라면 
		}else if(num < 0){	//-> else 문으로 진행해도 됨. 위에서 어차피 0이상이라는 조건을 걸었기 때문이다. 만약에 코드가 만줄이라면 더 간결하게 if else로만 사용하는 것이 if else if를 사용하는 것보다 낫다.
			// 5-1. 0부터 입력받은 수까지 차를 구하는 코드를 작성
			for(int i = 0; i >= num; i--) {
				sum -= i;
			}
			System.out.println(num + "까지의 차 : " + sum);
		}
		
//		int i = 0;
//		if(num >= 0) {
//			while(i <= num) {
//				sum += i;
//				i++;
//			}
//			System.out.println(sum);
//		} else{
//			while(i >= num) {
//				sum -= i;
//				i--;
//			}
//			System.out.println(sum);
//		}
		
		
		
		
	}
}
