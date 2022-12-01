package day20Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManegerMainPt {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu = -1;
		ArrayList<BookPt> list = new ArrayList<BookPt>();
		
		do {
			// 메뉴 출력
			System.out.println(" 메 뉴 ");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 검색 & 조회");
			System.out.println("3. 종 료");
			System.out.print("메뉴 선택 : ");
			
			// 메뉴 선택
			menu = scan.nextInt();
			
			// 메뉴에 따른 기능 실행
			String isbn, title, author, publisher, genre;
			int price;
			
			switch(menu) {
			case 1:
				System.out.println("==============");
				// 도서 추가 : ISBN, 도서명, 저자, 가격, 장르, 출판사
				System.out.print("ISBN : ");
				isbn = scan.next();
				scan.nextLine();
				System.out.print("도서명 : ");
				title = scan.nextLine();
				System.out.print("저 자: ");
				author = scan.nextLine();
				System.out.print("가 격 : ");
				price = scan.nextInt();
				scan.nextLine();
				System.out.print("장 르 : ");
				genre = scan.nextLine();
				System.out.print("출판사 : ");
				publisher = scan.nextLine();
				System.out.println("==============");
				
				BookPt book = new BookPt(title, author, publisher, genre, isbn, price);
				
				// isbn 비교
				if(list.contains(book)) {
					System.out.println("이미 등록된 ISBN 번호 입니다!");
					System.out.println("-----------------------");
					continue;
				}
				
				list.add(book);
				break;
				
			case 2:
				// 서브메뉴 
				System.out.println("==============");
				System.out.println("1. 도서명으로 조회");
				System.out.println("2. 저자로 조회");
				System.out.println("3. 출판사로 조회");
				System.out.println("4. 장르로 조회");
				System.out.println("5. 취 소 ");
				System.out.println("==============");
				System.out.println("메 뉴 선 택 : ");
				
				// 서브메뉴 선택
				int subMenu = scan.nextInt();
				System.out.println("==============");
				
				int count = 0;
				switch(subMenu) {
				case 1:
					System.out.println("도서명 : ");
					scan.nextLine();
					title = scan.nextLine();
					
					for(BookPt tmp : list) {
						if(tmp.getTitle().contains(title.trim())) { //trim 공백 제거 -> 공객으로 검색시 전체조회
							System.out.println(tmp);
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다!");
						System.out.println("===============");
					}
					break;
					
				case 2:
					System.out.println("예정");
					break;
				case 3:
					System.out.println("예정");
					break;
				case 4:
					System.out.println("예정");
					break;
				case 5:
					System.out.println("취소 하였습니다!");
					break;
				default:
					System.out.println("잘못 선택!");
				}
				
				break;
				
			case 3:
				System.out.println("==============");
				System.out.println("프로그램 종료 Good bye~");
				System.out.println("==============");
				break;
			default:
				System.out.println("==============");
				System.out.println("잘못된 메뉴 입니다!");
				System.out.println("==============");
			}
			
		}while(menu != 3);
		
	}

}
