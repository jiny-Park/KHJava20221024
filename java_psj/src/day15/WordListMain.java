package day15;

import java.util.ArrayList;
import java.util.Scanner;


public class WordListMain {
	
	public static void main(String[] args) {
		/* 영어 단어장 프로그램을 구현하세요.
		 * 메뉴 
		 * 1. 단어 추가
		 * 2. 단어 확인
		 * 3. 단어 수정
		 * 4. 단어 삭제
		 * 5. 종료
		 * 메뉴 선택 : 
		 * 
		 * 메뉴선택 : 1
		 * 단어 : apple 예)[한 단어, 공백 입력 안함]
		 * 뜻 : 사각 예)[한 문장]
		 * 
		 * 1. 단어 추가
		 * 2. 단어 확인
		 * 3. 단어 수정
		 * 4. 단어 삭제
		 * 5. 종료
		 * 메뉴 선택 :  2
		 * 
		 * 단어 입력 : apple(검색기능)
		 * 뜻 : 사가
		 * 
		 * 1. 단어 추가
		 * 2. 단어 확인
		 * 3. 단어 수정
		 * 4. 단어 삭제
		 * 5. 종료
		 * 메뉴 선택 : 3
		 * 
		 * 단어 입력 : apple (검색기능)
		 * 1. apple : 사가
		 * 수정할 번호 : 1
		 * 뜻 : 사과
		 * 수정이 완료됐습니다.
		 * 
		 * 1. 단어 추가
		 * 2. 단어 확인
		 * 3. 단어 수정
		 * 4. 단어 삭제
		 * 5. 종료
		 * 메뉴 선택 : 4
		 * 
		 * 단어 입력 : apple (검색기능)
		 * 1.apple : 사과
		 * 삭제할 번호 : 1
		 * 삭제가 완료 됐습니다!
		 * 
		 * 1. 단어 추가
		 * 2. 단어 확인
		 * 3. 단어 수정
		 * 4. 단어 삭제
		 * 5. 종료
		 * 메뉴 선택 : 5
		 * 
		 * 프로그램 종료!
		 */
		
		
		// 단어와 뜻을 저장할 리스트
		ArrayList<WordList> wordList = new ArrayList<WordList>();
		// 입력 받을 스캐너
		Scanner scan = new Scanner(System.in);
		int menu = -1;
		
		do {
		// 메뉴 출력
			printMenu();
			// 메뉴 선택
			try {
			menu = scan.nextInt();
			
			// 선택에 따른 메뉴 출력
			runMenu(menu, wordList);
			}catch(Exception e) {
				System.out.println("----------------");
				System.out.println(e.getMessage());
				System.out.println("----------------");
			}
			
		}while(menu != 5);
		
		
		
		
		
	}

	//--------------------------------------------------------------------
private static void runMenu(int menu, ArrayList<WordList> wordList) throws Exception {
		Scanner scan = new Scanner(System.in);
		String search;
		switch(menu) {
		case 1: 
			System.out.print("단어 입력 : ");
			String word = scan.nextLine();
			System.out.print(" 뜻 입력 : ");
			String mean = scan.nextLine();
			wordList.add(new WordList(word, mean));
			break;
		case 2: 
			System.out.print("검색할 단어 입력 : ");
			search = scan.nextLine();	
			
			//저장된 단어와 입력한 단어를 비교하여 동일한 단어가 있다면 출력
						
			if(search.equals(wordList)) {
				System.out.println(wordList);
				return;
			}
			
//			WordList tmp = WordList();
//			for(int i = 0; i < wordList.size(); i++) {
//				if(wordList(i).equals(search)) {
//					System.out.println();
//					throw new Exception("검색한 단어가 존재하지 않습니다.");
//				}
//			}
//			printWord(wordList);
			
			break;
		case 3: 
			System.out.print("수정할 단어 입력 : ");
			search = scan.nextLine();
			
			//저장된 단어와 입력한 단어를 비교하여 동일한 단어가 있다면 출력
//			wordList.set();	//set으로 변경 가능
			
			break;
		case 4: 
			System.out.print("삭제할 단어 입력 : ");
			search = scan.nextLine();
			
			//저장된 단어와 입력한 단어를 비교하여 동일한 단어가 있다면 출력
			
			printWord(wordList);
			System.out.print("삭제할 단어 번호 선택");
			int index = scan.nextInt()-1;
			wordList.remove(index);
			System.out.println("삭제가 완료 됐습니다!");
			
			break;
		case 5: 
			System.out.println("프로그램 종료");
			break;
		default:
			throw new Exception("예외 발생 : 잘못 입력하셨습니다!");
		}
		
	}

	private static void printWord(ArrayList<WordList> wordList) {
		if(wordList == null || wordList.size() == 0) {
			System.out.println("------------------");
			System.out.println("저장된 단어가 없습니다.");
			System.out.println("------------------");
			return;
		}
		for(int i = 0; i < wordList.size(); i++) {
			System.out.println(i + 1 + ". " + wordList.get(i));
		}
}

	private static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 확인");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 삭제");
		System.out.println("5.  종 료");
		System.out.print("메뉴 선택: ");
	}
	

}
