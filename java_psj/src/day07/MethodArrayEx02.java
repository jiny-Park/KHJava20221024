package day07;

public class MethodArrayEx02 {
	public static void main(String[] args) {
	// 1~9 사이의 랜덤한 수를 배열에 저장하는 코드를 작성. 메소드를 이용할 것!

		randomArr(1, 9, 5);
		
		System.out.println();
		
		System.out.println(randomArr1(10, 100, 2));
		
		System.out.println();
		
		int min = 1, max = 9;
		int arr1[] = new int[3];
		createRandomArray1(arr1, min, max);
		printArray(arr1);
		
		System.out.println();
		
		int arr2[] = createRandomArray2(min, max, 4);
		printArray(arr2);
	}
	
	
	
	
	public static void printArray(int arr[]) {
		for(int i= 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	/* 기능 : 1~9 사이의 랜덤한 수를 배열에 저장하는 코드
	 * 매개변수 : 최소수, 최대수, 정수 배열의 사이즈 => int min, int max, int size
	 * 리턴타입 : 없음 => void
	 * 메소드명 : randomArr
	 */
	public static void randomArr(int min, int max, int size) {
		int num1 = min;
		int num2 = max;
		int arrSize = size;
		int randomArr[] = new int[size];
		for(int i = 0; i < randomArr.length; i++) {
			int r = (int)(Math.random() * (num2 - num1 + 1) + num1);
			randomArr[i] = r;
		}
		for(int i = 0; i < randomArr.length; i++) {
			System.out.print(randomArr[i] + " ");
		}
	}
	/* 기능 : 1~9 사이의 랜덤한 수를 배열에 저장하는 코드
	 * 매개변수 : 시작수, 끝수, 정수 배열의 사이즈 => int start, int end, int size
	 * 리턴타입 : 정수 배열에 저장한 결과 => int randomArr[];
	 * 메소드명 : randomArr1
	 */
	public static int [] randomArr1(int min, int max, int size) {
		int num1 = min;
		int num2 = max;
		int arrSize = size;
		int randomArr1[] = new int[size];
		for(int i = 0; i < randomArr1.length; i++) {
			int r = (int)(Math.random() * (num2 - num1 + 1) + num1);
			randomArr1[i] = r;
		}
		return randomArr1;
	}
	
	// 강사님 풀이 1. (예)선생님이 표를 만들어서 내세요.
	/* 기능 : 최소값과 최대값 사이의 랜덤한 수를 주어진 배열에 저장하는 메소드
	 * 매개변수 : 최소값, 최대값, 배열 => int arr[], int min, int max
	 * 리턴타입 : 없음 => void
	 * 메소드명 : createRandomArray1
	 */
	public static void createRandomArray1(int arr[], int min, int max) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*(max - min + 1) + min);
		}
	}
	
	// 강사님 풀이 2 (예)선생님 왈 : 너가 표도 만들고 숫자도 정해서 넣어서 와.
	/* 기능 : 최소값과 최대값 사이의 랜덤한 수를 size개 만들어 배열에 저장한 후,
	 * 		 저장된 배열을 반환하는 메소드
	 * 매개변수 : 최소값, 최대값, 만들 개수 => int min, int max, int size
	 * 리턴타입 : 랜덤한 수가 저장된 배열 => int []
	 * 메소드명 : createRandomArray2
	 */
	public static int [] createRandomArray2(int min, int max, int size) {
		int arr[] = new int[size];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random(min, max);
		}
		return arr;
	}
	
	/* 기능 : 최소값과 최대값 사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 매개변수 : 최소값, 최대값 => int min, int max
	 * 리턴타입 : 랜덤한 수 => 정수 => int
	 * 메소드명 : random
	 */
	public static int random(int min, int max) {
		return (int)(Math.random()*(max - min + 1) + min);
	}

}
