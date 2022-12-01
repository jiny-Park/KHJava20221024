package day04;

public class BreakEx01 {

	public static void main(String[] args) {
		// break문은 반복문에서의 사용은 의미가 없다. if과 같은 조건식에서 사용해야 의미가 있어진다.
		// break를 만나면 증감식으로 가지 않고, 반복문을 빠져 나감.
		int i;
		for(i = 1; i <= 5; i++) {
			System.out.println("HELLO WORLD!");
			if(i == 3) {
				break;
				
			}
		}
	}

}
