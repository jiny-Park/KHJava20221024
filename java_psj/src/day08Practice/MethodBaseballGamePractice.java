package day08Practice;

import java.util.Scanner;

import day03.ifEx01;

public class MethodBaseballGamePractice {

	public static void main(String[] args) {
		// 1~9 사이의 중복되지 않은 3개의 숫자가 랜덤으로 생성 되고, 생성된 숫자를 맞추는 게임
		// 규칙 : - 숫자가 같고 같은 자리면 Strike
		//		 - 숫자가 같지만 다른 자리 Ball
		//		 - 일치하는 숫자가 하나도 없다 OUT
		
		// 1.랜덤으로 세개의 수를 선택
		int min = 1, max = 9;
		int size = 3;
		int arr[] = createRandomArray(min, max, size);
		
		printArray(arr);
		
		// 2.사용자가 숫자를 선택
		
		
		// 3.판별
		// => Strike를 판별하는 기능 구현
		// => 카운트를 통해 일치하는 일치하는 개수 - Strike 개수
		// => 카운트를 통해 일치하는 일치하는 개수 - Strike 개수 = Ball의 개수가 됨 
		
		
		// 4.2~3을 반복(3Strike가 될때까지)

	}
	// - Array출력
	public static void printArray(int arr[]) {
		if(arr == null) {	// -> arr배열의 값이 null(값이 없다면)이면 return
			return;
		}
		for(int i = 0; i < arr.length; i++) { // -> i를 arr.length의 길이보다 작을때까지 반복
			System.out.print(arr[i] + " "); // -> 반복되는 i를 arr[i]에 저장 
		}
	}
	// 1.랜덤으로 세개의 수를 선택
	// - 랜덤수 생성 메소드(메소드는 하나의 기능만 갖출수 있도록 만드는 것이 좋다)
	public static int random(int min, int max) {
		if(min > max) {		// -> 만약 min 입력값이 최대값이고, max의 값이 최소값으로 입력될 경우
			int tmp = min;	// -> tmp라는 변수(임시그릇)에 최대값인 min을 저장하고
			min = max;		// -> 최대값인 min의 변수에 최소값인 max의 값을 저장하고
			max = tmp;		// -> 최소값이 저장되었던 max의 변수에 최대값 min의 값이 저장되있던 tmp의 값을 저장한다.
		}
		return (int)(Math.random() * (max - min + 1) + min); // -> return값으로 랜덤값을 넘겨준다.
	}
	
	// - 랜던수 배열에 담는 메소드
	public static int[] createRandomArray(int min, int max, int size) { 
		if(max - min + 1 <= size) {		// -> 최소값과 최대값의 사이보다 배열의 크기 size가 크다면 값을 null로 리턴해
			return null;
		} 
		int arr[] = new int[size];		// -> arr[]의 배열의 사이즈는 사용자가 입력한 size에 따라서 달라짐
		for(int i = 0; i < arr.length;) {	// -> i는 0부터 arr.length의 길이만큼 반
			int r = random(min, max);	// -> 랜덤수를 r이란 변수에 저
			if(!contains(arr, r)) {		// -> arr번지에 저장되어 있는 숫자와 랜던수 r과 일치하는지 체크. 
										//  ! 부정형이 들어갔기 때문에, 일치하지 않다면 그 아래 실행문 실
				arr[i] = r; 			//  일치하지 않았다면 r의 수를 arr[i]번지에 저
				i++;					//  마지막 for 반복문 실행문으로 일치하지 않았다면 i의 수를 1 증
			}							//  i는 결국 arr.length의 수만큼 증가하면서 중복되지 않는 숫자로 저장  
		}
		return arr;						// 모든 위에 조건을 코드를 실행한 후에 저장된 arr의 값을 리턴 
	}
	
	// - 같은 숫자가 중복되지 않게 처리하는 메소드
	public static boolean contains(int []arr, int num) {	// -> 참과 거짓을 판별하기 위한 boolean형 메소드
															// -> int []arr과 int num을 비교
		if(arr == null || arr.length == 0) {		// -> arr의 값이 null이거나 arr.length의 길이가 0이라
			return false;							// -> false로 리
		}
		for(int tmp : arr) {		// -> int tmp에 arr의 값을 넣어
			if(num == tmp) {		// -> num의 숫자와 num의 값이 같다면 true로 리턴,
				return true;		// -> 아니라면 그 아래의 false의 값으로 리
			}
		} 
		return false;				 
	}
	
	// 2.사용자가 숫자를 선택
	/**
	 * 기능 : Scanner가 주어지면 정수를 size개만큼 입력받아 배열에 저장하고 저장된 배열을 돌려주는 메소드
	 * 매개변수 : Scanner, size 개 => Scanner scan, int size
	 * 리턴타입 : 정수 배열 => int []
	 * 메소드명 : scanArray
	 * @param scan Scanner
	 * @param size 입력받을 정수의 개수
	 * @return 입력받은 값들이 저장된 배열 
	 */
	public static int[] scanArray(Scanner scan, int size) {
		if(size <= 0) {
			return null;
		}
		int [] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		return arr;
	}
	
	

}
