package day03Parctice;


public class day03forPractice {

	public static void main(String[] args) {
		
	
		for(int i = 0; i < 6; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 1; i <= 5; i++) {
			System.out.println("I can do it!");
		}
		
		int sum = 0;
		for(int i = 0; i <= 10; i++) {
			sum += i;	// sum = sum + i;
		}
		System.out.println(sum);
		
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
		}
	}

}
