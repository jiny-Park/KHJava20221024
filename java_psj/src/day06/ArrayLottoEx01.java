package day06;

import java.util.Scanner;

public class ArrayLottoEx01 {

	public static void main(String[] args) {
		/* 로또 번호를 랜덤으로 생성하고, 당첨번호를 입력하여 몇등 당첨됐는지 출력하는 코드를 작성
		 * 숫자 범위 : 1 ~ 45
		 * 1등 : 6개
		 * 2등 : 5개 + 보너스 번호
		 * 3등 : 5개
		 * 4등 : 4개
		 * 5등 : 3개
		 * 로또 번호 : 번호 6개와 + 보너스 번호까지 총 7개 생성해야 함
		 */
		
		// 로또 번호를 생성한다
		int min = 1, max = 45;
		int size = 6;
		int lottoNum[] = new int[size]; // 랜덤수를 저장할 배열
		int count = 0; // 저장된 랜덤수의 개수

		while(count < 6) {
			int r = (int)(Math.random() * (max - min + 1) + 1);
			boolean isDuplicated = false;
			for(int i = 0; i < count; i++) {
				if(lottoNum[i] == r) {
					isDuplicated = true;
				}
				if(isDuplicated) {
					continue;
				}
			}
				lottoNum[count] = r;	// 이 실행문에 else를 뺄 수 있는 이유는, 위에 continue가 있기 때문에 ㅏ능.
				count++;		// 이 두 줄을 한 줄로 줄인다면 -> arr1[count++] = r;
		}
		System.out.print("로또 번호 확인 : ");
		for(int tmp : lottoNum) {
			System.out.print(tmp + " ");
		}
		// 보너스 번호를 랜덤으로 생성
		// 보너스 번호는 위에서 생성한 로또 번호와 중복되지 않게 
		int bonus = 0;
		while(true) {
			int r = (int)(Math.random() * (max - min + 1) + 1);
			boolean isDuplicated = false;
			for(int i = 0; i < lottoNum.length; i++) {
				if(lottoNum[i] == r) {
					isDuplicated = true;
				}
			}
			if(isDuplicated) {
				continue;
			}
			bonus = r;
			break;
			
		}
		System.out.println("보너스 : " + bonus);
		
		// 당첨 번호 6개를 입력 받음
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("당첨 번호 입력 : ");
		int user[] = new int[size];
		for(int i = 0; i < size; i++) {
			user[i] = scan.nextInt();
		}
		scan.close();
		// 일치하는 번호 개수를 구함(보너스 번호 제외)
		int sameCount = 0;
		for(int i = 0; i < lottoNum.length; i++) {
			for(int j = 0; j < user.length; j++) {
				if(lottoNum[i] == user[j]) {
					sameCount++;
				}
			}
		}
		//등수 판별
		switch(sameCount) {
		case 6:
			System.out.println("1등");
			break;
		case 5:
			boolean isDuplicated = false;
			for(int i = 0; i < user.length; i++) {
				if(user[i] == bonus) {
					isDuplicated = true;
				}
			}
			if(isDuplicated) {
				System.out.println("2등");
			} else {
				System.out.println("3등");
			}
			break;
		case 4:
			System.out.println("4등");
			break;
		case 3:
			System.out.println("5등");
			break;
		default:
			System.out.println("꽝!");
		}

	}
}
