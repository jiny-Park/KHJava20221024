package example.AccountPractice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountBook {
	ArrayList<Item> list = new ArrayList<Item>();
	AccountService accountService = new AccountServiceImp();
	Scanner scan;
	
	public void run() {
		System.out.println("가계부 프로그램을 실행합니다!");
		int menu = -1; // menu선택에 들어가는 숫자만 아니면 상관 없음.
		
		
		do {
			try {
				accountService.printMenu();
				menu = scan.nextInt();
				accountService.runMenu(list, menu, scan);
			}catch(ParseException e) {
				System.out.println("날짜 형태가 잘못 되었습니다.");
			} 
			
			
		}while(menu != 5);
		System.out.println("가계부 프로그램을 종료합니다! Good bye~");
		
		
	}
	

	public AccountBook(Scanner scanner) {
		if(scan == null) {
			this.scan = new Scanner(System.in);
		}else {
			this.scan = scan;		
		}
	}









}
