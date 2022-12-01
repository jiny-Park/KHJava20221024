package day05Practice;

public class RandomEx01PT {

	public static void main(String[] args) {
		int min = 1, max = 9;
		

		for(int i = 0; i < 10; i++) {
			int randomNumber = (int)(Math.random() * (max - min + 1) + min);
			System.out.println(randomNumber);
		}
	

	}

}
