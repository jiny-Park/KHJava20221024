package day10Practice;


public class randomMeth {
	
	public static void printArray(int arr[]) {
		if(arr == null) {
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			max = min;
			min = tmp;
		} 
		return (int)(Math.random() * (max - min + 1)+min);
	}
	
	public static int[] createRandomArray(int min, int max, int size) {
		if(max - min + 1 <= size) {
			return null;
		}
		int arr[] = new int[size];
		for(int i = 0; i < arr.length; ) {
			int r = random(min, max);
			if(!contains(arr, max)) {
				arr[i] = r;
				i++;
			}
		}
		return arr;
	}
	
	public static boolean contains(int []arr, int num) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		for(int tmp : arr) {
			if(num == tmp) {
				return true;
			} 
		} 
		return false;
	}

}
