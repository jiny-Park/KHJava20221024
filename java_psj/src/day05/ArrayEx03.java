package day05;

public class ArrayEx03 {

	public static void main(String[] args) {
		/* 5개짜리 배열을 생성하여 2부터 10까지 짝수를 차레대로 저장하고 출력하는 코드 작성
		 * 
		 */
		
//		int arr[] = new int[5];
//		for(int i = 1; i <= 5; i++) {
//				arr[i] = i * 2;
//				System.out.print(arr[i] + " ");
//		}
		
		int arr[] = new int[5];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = 2*(i+1);
			System.out.print(arr[i] + " ");
		}

	}

}
