package day06;

public class ArrayLottoEx01_01 {

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
		
		int min = 1, max = 45;	
		int lottoNum[] = new int[6];
//		int bonusLottoNum[] = new int[1];
		
		
		for(int i = 0; i < lottoNum.length; i++) {
			lottoNum[i] = (int)(Math.random() * (max - min + 1) + 1); 
			
			for(int j = 0; j < i; j++) {
				if(lottoNum[i] == lottoNum[j]) {
					i--;
				}
			}
		}
		
		for(int i = 0; i < lottoNum.length; i++) {
			System.out.println(lottoNum + " ");
		}
		
	

		
		
		// 로또 번호를 생성한다
		
			
		// 보너스 번호를 랜덤으로 생성
		// 보너스 번호는 위에서 생성한 로또 번호와 중복되지 않게 
			
		// 당첨 번호 6개를 입력 받음
		
		// 일치하는 번호 개수를 구함(보너스 번호 제외)
		
		//등수 판별
		
		
		
	}

}
