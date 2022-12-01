package example.AccountPractice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public interface AccountService {
	// 가계부 메뉴 내역 / 내역 리스트-추가할 아이템 / 내역 리스트 / 수정 / 삭

	void printMenu();

	void runMenu(ArrayList<Item> list, int menu, Scanner scan) throws ParseException;
	
	void insertItem(ArrayList<Item> list, Item item);
	
	String inputDate(Scanner scan)throws ParseException;
	
	Item inputItem(Scanner scan) throws ParseException; 
	
	void printItem(ArrayList<Item> list);
	
	void printSubMenu();
	
	void runPrint(ArrayList<Item> list, int subMenu, Scanner scan);
	
	void printItem(ArrayList<Item> list, int ...dates);
	
	int inputYear(Scanner scan);
	
	int inputMonth(Scanner scan);
	
	int inputDay(Scanner scan);
	
	void updateItem(ArrayList<Item> list, int index, Item item);
	
	int selectItem(ArrayList<Item> list, String date, Scanner scan);
	
	void deleteItem(ArrayList<Item> list, int index);

}
