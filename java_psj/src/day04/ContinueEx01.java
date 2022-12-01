package day04;

public class ContinueEx01 {

	public static void main(String[] args) {
		/* for문에서 continue를 만나면 증감식으로 이동
		 * continue문은 현직에서 거의 사용하지 않음. 알아만 두자.
		 */
		
		int i;
		for(i=1; i<=5; i++) {
			System.out.print("Hello World!");
			if(i == 3) {
				continue;	
			}
			System.out.println();
		}

	}

}
