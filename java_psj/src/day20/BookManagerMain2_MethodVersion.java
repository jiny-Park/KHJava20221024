package day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;
// 프로그램 코딩 전에 먼저 프로그램에 내한 내용 및 과정을 그리는 것이 더 중요하다. 코드 작성은 그 다음이다.
public class BookManagerMain2_MethodVersion {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		int menu = -1;
		
		ArrayList<Book> list = new ArrayList<Book>();
		
		do {
			// 메뉴를 출력
			printMenu();
			
			// 메뉴를 선택		
			menu = scan.nextInt();
			printBar();
			
			runMenu(menu, list);
			
		}while(menu != 3);
		scan.close();
		
	}
	
	
	//▼▼▼▼ Method ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	
	public static void printMenu() {
		System.out.println(" 메 뉴 ");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 검색");
		System.out.println("3. 종 료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 → ");
	}
	
	public static void printBar() {
		System.out.println("====================");
	}
	
	public static void runMenu(int menu, ArrayList<Book> list) {	
		// 선택한 메뉴에 대한 기능 실행
		// 선택 메뉴가 1번이면 도서 추가
		switch(menu) {
		case 1:
			// 도서 추가
			Book book = creatBook();
			
			if(insertBook(list, book)) {
				System.out.println("이미 등록된 ISBN 번호 입니다!");
			}else {
				System.out.println("도서 추가가 완료됐습니다.");
				printBar();
			}
			break;
			
		// 선택 메뉴가 2번이면 도서 조회
		case 2:
			// 서브 메뉴 출력

			searchMenu();
			
			// 서브 메뉴 선택
			int subMenu = scan.nextInt();
			printBar();
			
			// 선택한 메뉴에 대한 기능 실행
			runPrintMenu(subMenu, list);

			break;
		
		// 선택 메뉴가 3번이면 프로그램 종료 출력
		case 3:
			System.out.println(" ㅡ 프로그램 종료 ㅡ ");
			printBar();
			break;
		
		// 선택 메뉴가 1, 2, 3이 아니면 잘못된 메뉴라고 출력
		default:
			System.out.println(" ㅡ 잘못된 메뉴 ㅡ ");
			printBar();
		}
	}
	
	public static Book creatBook() {
		// 추가할 도서 정보를 입력
		// 도서명, 저자(여러명, 엮은이, 옮긴이 다포함), 가격, 출판사, 장르, isbn
		String title, author, publisher, genre, isbn;
		int price;
		scan.nextLine();//엔터 처리
		System.out.print("도서명 : ");
		title = scan.nextLine();
		System.out.print("저 자 : ");
		author = scan.nextLine();
		System.out.print("가 격 : ");
		price = scan.nextInt();
		scan.nextLine();//엔터 처리
		System.out.print("출판사 : ");
		publisher = scan.nextLine();
		System.out.print("장 르 : ");
		genre = scan.nextLine();
		System.out.print("ISBN : ");
		isbn = scan.next();
		
		// 도서 목록에 새 도서를 추가
		// 위에서 입력 받은 도서 정보를 이용하여 도서 객체를 생성
		return new Book(title, author, publisher, genre, isbn, price);
	}
	
	public static boolean insertBook(ArrayList<Book> list, Book book) {
		// isbn 중복 체크해서 중복되면 건너뜀
		if(list.contains(book)) {
			return false;	// 빠져나가기 위해 retrun
		}
		
		// ISBN 정렬 만들기
		Collections.sort(list, (o1, o2) -> o1.getIsbn().compareTo(o2.getIsbn()));	
		// Collections.sort(list, (o1, o2) -> -o1.getIsbn().compareTo(o2.getIsbn())); -> -를 붙여주면 반대로 정렬
		
		
		// 중복 되지 않으면 추가
		// 생성된 도서 객체를 리스트에 추가
		list.add(book);
		return true;	// Set은 중복 허용을 하지 않지만, list는 중복을 허용함.
	}
	
	public static void searchMenu() {
		System.out.println("1. 도서명으로 조회");
		System.out.println("2. 저자로 조회");
		System.out.println("3. 출판사로 조회");
		System.out.println("4. 장르로 조회");
		System.out.println("5. 취 소");
		printBar();
		System.out.print("조회 방법 선택 → ");
	}
	
	public static void runPrintMenu(int subMenu, ArrayList<Book> list) {
		String title, author, publisher, genre;
		int price;
		int count = 0;
		switch(subMenu) {
		case 1:
			// 서브메뉴가 1이면 도서명으로 조회
			System.out.print("도서명 : ");
			scan.nextLine();//엔터처리
			title = scan.nextLine();
			
			printBookList(list, b->b.getTitle().contains(title.trim()));
			// ->b.getTitle().contains(title.trim()) -> Predicate 객체를 만든 것
			
			break;
			
		case 2:
			// 서브메뉴가 2이면 저자명으로 조회
			System.out.print("저자명 : ");
			scan.nextLine();//엔터처리
			author = scan.nextLine();
			
			printBookList(list, b->b.getAuthor().contains(author.trim()));
			
			break;
		
		case 3:
			// 서브메뉴가 3이면 출판사로 조회
			System.out.print("출판사 : ");
			scan.nextLine();//엔터처리
			publisher = scan.nextLine();
			
			printBookList(list, b->b.getPublisher().contains(publisher.trim()));
			
			break;
			
		case 4:
			// 서브메뉴가 4이면 장르로 조회
			System.out.print("장 르 : ");
			scan.nextLine();//엔터처리
			genre = scan.nextLine();
			
			printBookList(list, b->b.getGenre().contains(genre.trim()));
			
			break;
			
		case 5:
			// 서브메뉴가 5이면 취소
			System.out.println("조회 메뉴를 취소합니다!");
			printBar();
			break;
			
		default:
			System.out.println("잘못된 메뉴 입니다!");
			printBar();
		}
	}
	
	// 람다식 이용 : 람다식 이용을 하지 않는다면, 도서명, 저자명 등으로 조회해서 검색하는 메소드를 각각 다 만들어야 한다.
	public static void printBookList(ArrayList<Book> list, Predicate<Book> p) {
		int count = 0;
		for(Book tmp : list) {
			if(p.test(tmp)) {	// 조건에 맞는 도서들만 출력이 되도록
				System.out.println(tmp);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("검색 결과가 없습니다!");
			printBar();
		}
	}
	
	
}
