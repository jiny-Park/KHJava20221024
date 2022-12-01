package example.AccountPractice;

import java.util.Scanner;

public class AccountBookMain {
	
	public static void main(String[] args) {
		AccountBook ab = new AccountBook(new Scanner(System.in));
		ab.run();
		
		
		/* 메인에서는 실행만 될 수 있도록 구성함. 
		 * 
		 */
	} 
}
