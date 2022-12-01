package day06;

public class ArrayRandomEx02 {

	public static void main(String[] args) {
		// 랜덤으로 1~9사이의 숫자를 중복되지 않게 3개 생성하여 배열에 저장하는 코드 작성
		int min = 1, max = 9;
		int arr[] = new int[3];
		
		for(int i = 0; i < arr.length; i++) {
				arr[i] = (int)(Math.random() * (max - min + 1) + 1);

				for(int j = 0; j < i; j++) {
					if(arr[i] == arr[j]) {
						i--;
					}
				}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	
		
		// 강사님 풀이
		// 배열에 저장된 중복되지 않은 수가 3개가 될 때까지 반복해야 함
//		while(저장된 숫자가 3보다 작을때까지;) {
		int size = 3;
		int arr1[] = new int[size]; // 랜덤수를 저장할 배열
		int count = 0; // 저장된 랜덤수의 개수
//		int min = 1, max = 9; // 랜덤수 범위

		
		while(count < 3) {
			// 랜덤한 수 생성
			int r = (int)(Math.random() * (max - min + 1) + 1);
			
			boolean isDuplicated = false;
			
			// 배열에 저장된 수 중에서 랜덤한 수와 일치하는 숫자가 있는지 없는지 확인하여
			// 저장된 숫자갯수만큼 반복 => i는 0번지부터 저장한 개수보다 작을때까지
			for(int i = 0; i < count; i++) {
				// 배열에 저장된 숫자개수만큼 확인 
				// i번지에 있는 숫자와 랜덤수가 같으면 isDuplicated를 true로
				if(arr1[i] == r) {
					isDuplicated = true;
				}
			
			// 있으면 다시 처음으로, 
			// isDuplicated가 ture이면 
				if(isDuplicated) {
					continue;
				}

				}
			
			// 배열에 저장하고, 저장된 개수 1 증가
			// isDuplicated가 false이면
					
				arr1[count] = r;	// 이 실행문에 else를 뺄 수 있는 이유는, 위에 continue가 있기 때문에 ㅏ능.
				count++;		// 이 두 줄을 한 줄로 줄인다면 -> arr1[count++] = r;

			}
		for(int tmp : arr) {
			System.out.println(tmp + " ");
		}


	}

}
