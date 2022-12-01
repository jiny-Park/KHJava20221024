package example.AccountPractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import day03.ifEx01;

public class AccountServiceImp implements AccountService {
	public static Scanner scan = new Scanner(System.in);


	@Override
	public void runMenu(ArrayList<Item> list, int menu, Scanner scan) throws ParseException {
		switch(menu) {
		case 1:
			// 내역 추가
			insertItem(list, inputItem(scan));
			break;
			
		case 2:
			break;
		case 3:
			String date = inputDate(scan);
			
			int index = selectItem(list, date, scan);
			
			Item item = inputItem(scan);
			
			updateItem(list, index, item);
			break;
			
		case 4:
			break;
		case 5:
			break;
		default:
			System.out.println("없는 메뉴!");	
		}
	}

	@Override
	public void printMenu() {
		System.out.println("메 뉴");
		System.out.println("1.내역 추가");
		System.out.println("2.내역 조회");
		System.out.println("3.내역 수정");
		System.out.println("4.내역 삭제");
		System.out.println("5.프로그램 종료");
		System.out.print("메뉴 선택: ");
	}
	
	@Override
	public void insertItem(ArrayList<Item> list, Item item) {
		list.add(item);
		
		// 날짜 기준 정렬
		Collections.sort(list, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				if(o1 == null)
					return 1;
				if(o2 == null)
					return -1;
				return o1.getDate().compareTo(o2.getDate());
			}
		});
	}

	@Override
	public Item inputItem(Scanner scan) throws ParseException {
		System.out.print("구분(수입/지출) : ");
		String type = scan.next();
		System.out.print("분류(식비/교통비 등) : ");
		String purpose = scan.next();
		scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		System.out.print("금액(정수) : ");
		int money = scan.nextInt();
		System.out.print("일시(2022-11-16) : ");
		String date = scan.next();
				
		return new Item(type, purpose, content, money, date);
	}
	
	@Override
	public String inputDate(Scanner scan) throws ParseException {
		System.out.print("검색할 일시(0000-00-00) 입력 : ");
		String date = scan.next();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		f.parse(date);
		return date;
	}


	@Override
	public void printItem(ArrayList<Item> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printSubMenu() {
		System.out.println("조 회 메 뉴");
		System.out.println("1.전체 조회");
		System.out.println("2.상세 조회");
		System.out.println("메뉴 선택 : ");
		
	}

	@Override
	public void runPrint(ArrayList<Item> list, int subMenu, Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printItem(ArrayList<Item> list, int... dates) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int inputYear(Scanner scan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inputMonth(Scanner scan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inputDay(Scanner scan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateItem(ArrayList<Item> list, int index, Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectItem(ArrayList<Item> list, String date, Scanner scan) {
		// 해당 일지 기록 내역 출력, 날짜가 같은 내역들의 번지를 정수형 리스트에 저장
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		// 날짜가 같은 내역들만 모음
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getDateStr().equals(date)) {
				indexList.add(i);
			}
		}
		if(indexList.size() == 0) {
			throw new RuntimeException("예외발생 : 해당 일시에는 내역이 없습니다");
		}
		
		for(int i = 0; i < indexList.size(); i++) {
			System.out.println(i + 1 + "번 내역");
			list.get(indexList.get(i)).print();
		}
		
		System.out.print("내역 선택 : ");
		int index = scan.nextInt() -1;
		
		if(index < 0 || index >= indexList.size()) {
			throw new RuntimeException("예외발생 : 내역을 잘못 선택했습니다!");
		}
		return indexList.get(index);
	}

	@Override
	public void deleteItem(ArrayList<Item> list, int index) {
		// TODO Auto-generated method stub
		
	}

	
	
}
