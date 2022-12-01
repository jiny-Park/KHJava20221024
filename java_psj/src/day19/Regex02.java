package day19;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex02 {

	public static void main(String[] args) {
		// 전화번호 정규표현식을 작성하여 입력받은 번호가 전화번호가 맞는지 출력하는 코드
		// 규칙1.
		// 010-1234-5678 [o]
		// 01012345678	 [x]
		// 011-1234-5678 [x]
		
		// 010-[0-9]{4}-[0-9]{4}
		// 010-\d{4}-\d{4}
		// 010(-\d{4}){2}
		
		// 서진 풀이 -> "^[010]{0,3}+\\-[0-9]{0,4}+\\-[0-9]{0,4}$"
		
		Scanner scan = new Scanner(System.in);
		
		String regex = "^010(-\\d{4}){2}$";
		System.out.print("전화번호 : ");
		String numBer = scan.next();
		if(Pattern.matches(regex, numBer)) {
			System.out.println(numBer + "은 올바른 형식");
		}else {
			System.out.println(numBer + "올바른 형식이 아님");
		}
		
	
	}

}
