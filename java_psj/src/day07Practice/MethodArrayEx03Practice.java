package day07Practice;

public class MethodArrayEx03Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {1, 3, 5, 8};
		int num = 5;
		if(contians(arr, num)) {
			System.out.println(num + "은 배열에 있습니다.");
		} else {
			System.out.println(num + "은 배열에 없습니다.");
		}
			
		
	}
	

	public static boolean contians(int []arr, int num) {
		for(int tmp : arr) {
			if(num == tmp) {
				return true;
			}
		}
		return false;
	}
}
