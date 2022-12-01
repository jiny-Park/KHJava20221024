package day20;

import java.util.ArrayList;
import java.util.Scanner;
// 프로그램 코딩 전에 먼저 프로그램에 내한 내용 및 과정을 그리는 것이 더 중요하다. 코드 작성은 그 다음이다.
public class BookManagerMain {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 도서 관리 프로그램을 작성하세요.
		 * 도서 정보 : 
		 *  - ISBN (ISBN으로 정렬)
		 * 	- 도서명 
		 * 	- 저자(여러명, 엮은이, 옮긴이 다 포함)
		 * 	- 가격
		 * 	- 출판사
		 * 	- 분류
		 * 
		 * 기능 
		 * 	- 1. 도서 추가
		 * 		- ISBN으로 정렬
		 *  - 2. 도서 조회
		 *  	- 2-1. 도서명으로 조회
		 *  	- 2-2. 저자로 조회
		 *  	- 2-3. 출판사로 조회
		 *  	- 2-4. 분류로 조회
		 *  - 3. 프로그램 종료
		 */
		
		// 도서정보 리스트를 담을 BookInfor 클래스 생성 -> ISBN, 도서명, 저자(여러명, 엮은이, 옮긴이 다포함), 가격, 출판사, 분류
		
		// 필요한 메서드 : 메뉴 출력, 메뉴 선택, 메뉴 실행(기능 : 각 기능별 메서드 필요), 
		
		
		// 반복
		int menu = -1;
		String title, author, publisher, genre, isbn;
		int price;
		ArrayList<Book> list = new ArrayList<Book>();
		
		do {
			// 메뉴를 출력
			System.out.println(" 메 뉴 ");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 검색");
			System.out.println("3. 종 료");
			System.out.println("-------------");
			System.out.print("메뉴 선택 → ");
			// 메뉴를 선택		
			menu = scan.nextInt();
			System.out.println("====================");
			// 선택한 메뉴에 대한 기능 실행
			// 선택 메뉴가 1번이면 도서 추가
			switch(menu) {
			case 1:
				// 추가할 도서 정보를 입력
				System.out.println("추가할 도서정보를 입력");
				// 도서명, 저자(여러명, 엮은이, 옮긴이 다포함), 가격, 출판사, 장르, isbn
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
				Book book = new Book(title, author, publisher, genre, isbn, price);
				
				// isbn 중복 체크해서 중복되면 건너뜀
				if(list.contains(book)) {
					System.out.println("이미 등록된 ISBN 번호 입니다!");
					System.out.println("====================");
					continue;
				}
				
				// 중복 되지 않으면 추가
				// 생성된 도서 객체를 리스트에 추가
				list.add(book);
				
				break;
				
			// 선택 메뉴가 2번이면 도서 조회
			case 2:
				 /*  - 2. 도서 조회
				 *  	- 2-1. 도서명으로 조회
				 *  	- 2-2. 저자로 조회
				 *  	- 2-3. 출판사로 조회
				 *  	- 2-4. 분류로 조회
				 */
				// 서브 메뉴 출력
				System.out.println("====================");
				System.out.println("1. 도서명으로 조회");
				System.out.println("2. 저자로 조회");
				System.out.println("3. 출판사로 조회");
				System.out.println("4. 장르로 조회");
				System.out.println("5. 취 소");
				System.out.println("====================");
				System.out.print("메뉴 선택 → ");
				
				// 서브 메뉴 선택
				int subMenu = scan.nextInt();
				System.out.println("====================");
				
				// 선택한 메뉴에 대한 기능 실행
				int count = 0;
				switch(subMenu) {
				case 1:
					// 서브메뉴가 1이면 도서명으로 조회
					System.out.print("도서명 : ");
					scan.nextLine();//엔터처리
					title = scan.nextLine();
					
					for(Book tmp : list) {
						if(tmp.getTitle().contains(title.trim())) {	//trim 공백 제거 -> 공백으로 검색시 전체조회가 되도록
							System.out.println(tmp);
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다!");
						System.out.println("====================");
					}
					break;
					
				case 2:
					// 서브메뉴가 2이면 저자명으로 조회
					System.out.print("저자명 : ");
					scan.nextLine();//엔터처리
					author = scan.nextLine();
					
					for(Book tmp : list) {
						if(tmp.getAuthor().contains(author.trim())) {	//trim 공백 제거 -> 공백으로 검색시 전체조회가 되도록
							System.out.println(tmp);
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다!");
						System.out.println("====================");
					}
					break;
				
				case 3:
					// 서브메뉴가 3이면 출판사로 조회
					System.out.print("출판사 : ");
					scan.nextLine();//엔터처리
					publisher = scan.nextLine();
					
					for(Book tmp : list) {
						if(tmp.getPublisher().contains(publisher.trim())) {	//trim 공백 제거 -> 공백으로 검색시 전체조회가 되도록
							System.out.println(tmp);
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다!");
						System.out.println("====================");
					}
					break;
					
				case 4:
					// 서브메뉴가 4이면 장르로 조회
					System.out.print("장 르 : ");
					scan.nextLine();//엔터처리
					genre = scan.nextLine();
					
					for(Book tmp : list) {
						if(tmp.getGenre().contains(genre.trim())) {	//trim 공백 제거 -> 공백으로 검색시 전체조회가 되도록
							System.out.println(tmp);
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다!");
						System.out.println("====================");
					}
					break;
					
				case 5:
					// 서브메뉴가 5이면 취소
					System.out.println("조회 메뉴를 취소합니다!");
					System.out.println("====================");
					break;
					
				default:
					System.out.println("잘못된 메뉴 입니다!");
					System.out.println("====================");
				}

				break;
			
			// 선택 메뉴가 3번이면 프로그램 종료 출력
			case 3:
				System.out.println("===========");
				System.out.println("|프로그램 종료|");
				System.out.println("===========");
				break;
			
			// 선택 메뉴가 1, 2, 3이 아니면 잘못된 메뉴라고 출력
			default:
				System.out.println("===========");
				System.out.println("|잘못된 메뉴!|");
				System.out.println("===========");
			}
		}while(menu != 3);
		scan.close();
		
	}
	
	
	
	
	
	
	
}
