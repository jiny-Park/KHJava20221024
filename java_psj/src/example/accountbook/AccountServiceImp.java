package example.accountbook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.management.RuntimeErrorException;


public class AccountServiceImp implements AccountService {
	public static Scanner scan = new Scanner(System.in);

	@Override
	public void insertItem(ArrayList<Item> list, Item item) {
		list.add(item);
		// 날짜를 기준으로 정렬
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
	public void printItem(ArrayList<Item> list) {
		if(list.size() == 0) {
			System.out.println("기록된 내역이 없습니다!");
		}
		
		for(Item item : list) {
			System.out.println(item);
		}
	}
	
	@Override
	public void printItem(ArrayList<Item> list, int... dates) {
		String date = "";
		
		// -2022
		// -2022-10
		// -2022-10-11
		for(int tmp : dates) {
			date += "-" + (tmp < 10 ? "0"+tmp : tmp);
		}

		date = date.substring(1); // 년도 안에 -(마이너스)를 제거하기 위해
		
		int size = date.length();
		for(Item item : list) {
			if(item.getDateStr().substring(0, size).equals(date)) {
				System.out.println(item);
			}
		}
		
	}

	@Override
	public boolean updateItem(ArrayList<Item> list, int index, Item item) {
		if(index < 0 || index >= list.size()) {
			return false;
		}
		list.set(index, item);
		return true;
	}

	@Override
	public boolean deleteItem(ArrayList<Item> list, int index) {
		if(index < 0 || index >= list.size()) {
			throw new RuntimeException("예외 발생 : 내역을 잘못 선택했습니다!");
		}
		list.remove(index);
		return true;
	}

	@Override
	public void printMenu() {

		System.out.println("▣  메 뉴  ▣");
		System.out.println("1. 내역 추가");
		System.out.println("2. 내역 확인");
		System.out.println("3. 내역 수정");
		System.out.println("4. 내역 삭제");
		System.out.println("5.  종 료");
		System.out.println("--------------");
		System.out.print("메뉴 선택 → ");		
	}

	// 선언부와 구현부의 차이?
	@Override
	public void runMenu(ArrayList<Item> list, int menu, Scanner scan) throws ParseException {
		
		switch(menu) {
		case 1:
			// 내역 추가
			
			// 가계부에 내역을 추가
			// 입력받은 정보를 이용하여 내역 객체를 생성
			
			// 내역 리스트에 내역을 추가
			insertItem(list, inputItem(scan));
			break;
			
		case 2:
			printSubMenu();
			
			// 서브 메뉴 선택
			int subMenu = scan.nextInt();
			runPrint(list, subMenu, scan);
			
			break;
			
		case 3:
			// 년, 월, 일을 입력(2022-11-16)
			String date = inputDate(scan);
			
			int index = selectItem(list, date, scan);
			
			// 수정할 내역 전체를 입력함
			Item item = inputItem(scan);
			
			// 입력된 내용으로 수정 -> updateItem 메소드로
			updateItem(list, index, item);
			break;
			
		case 4:
			// 년, 월, 일을 입력(2022-11-16)
			String date2 = inputDate(scan);
			// 해당 일자에 기록된 내역들을 출력
			// 삭제할 내역을 선택
			int index2 = selectItem(list, date2, scan);
					
			// 내역 삭제
			deleteItem(list, index2);
			break;
			
		case 5:
			break;
			
		default:
			System.out.println("없는 메뉴 입니다!");
		}
	}

	@Override
	public Item inputItem(Scanner scan) throws ParseException {
		// 내역 정보 입력
		// 구분, 분류, 내용, 금액, 일시
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
	public int selectItem(ArrayList<Item> list, String date, Scanner scan) {
		// 해당 일자에 기록된 내역들을 출력
		// 날짜가 같은 내역들의 번지를 정수형 리스트에 저장
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		// 날짜가 같은 내역들을 모음
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getDateStr().equals(date)) {
				indexList.add(i);
			}
		}
		
		if(indexList.size() == 0) {
			throw new RuntimeException("예외발생 : 해당 일시에는 내역이 없습니다!");
		}
		
		// 날짜가 같은 내역들을 출력
		for(int i = 0; i < indexList.size(); i++) {
			System.out.println(i+1 +"번 내역");
			list.get(indexList.get(i)).print();
		}
		
		// 수정할 내역을 선택
		System.out.print("내역 선택 → ");
		int index = scan.nextInt() -1;
		
		if(index < 0 || index >= indexList.size()) {
			throw new RuntimeException("예외 발생 : 내역을 잘 못 선택했습니다!");
		}

		return indexList.get(index);
	}

	// 예외를 발생시키기 위해서 만든 메소드
	@Override
	public String inputDate(Scanner scan) throws ParseException {
		System.out.print("검색할 일시(0000-00-00) 입력 : ");
		String date = scan.next();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		f.parse(date);
		return date;
	}

	@Override
	public int inputYear(Scanner scan) {
		System.out.print("연도 입력(0000) : ");
		int year = scan.nextInt();
		if(year < 0) {
			throw new RuntimeException("예외 발생 : 연도를 잘못 입력했습니다!");
		}
		return year;
	}

	@Override
	public int inputMonth(Scanner scan) {
		System.out.print("월 입력(00) : ");
		int month = scan.nextInt();
		if(month < 0 || month > 12) {
			throw new RuntimeException("예외 발생 : 월을 잘못 입력했습니다!");
		}
		return month;
	}

	@Override
	public int inputDay(Scanner scan) {
		System.out.print("일 입력(00) : ");
		int day = scan.nextInt();
		if(day < 0 || day > 31) {
			throw new RuntimeException("예외 발생 : 일을 잘못 입력했습니다!");
		}
		return day;
	}

	@Override
	public void printSubMenu() {
		System.out.println("* 확 인 메 뉴 *");
		System.out.println("1. 전체 확인");
		System.out.println("2. 년 확인");
		System.out.println("3. 달 확인");
		System.out.println("4. 일 확인");
		System.out.println("--------------");
		System.out.print("메뉴 선택 → ");
	}

	@Override
	public void runPrint(ArrayList<Item> list, int subMenu, Scanner scan) {
		int year, month, day;
		// 메뉴에 따른 출력 기능 실행
		switch(subMenu) {
		case 1:
			System.out.println("+ 전 체 확 인 +");
			printItem(list);
			break;
			
		case 2:
			year = inputYear(scan);
			printItem(list, year);
			break;
			
		case 3:
			year = inputYear(scan);
			month = inputMonth(scan);
			printItem(list, year, month);
			break;
			
		case 4:
			year = inputYear(scan);
			month = inputMonth(scan);
			day = inputDay(scan);
			printItem(list, year, month, day);
			break;
			
		default:
		}
		
	}



}