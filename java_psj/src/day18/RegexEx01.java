package day18;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx01 {

	public static void main(String[] args) {
		// 정규표현식
		
		String regex = "^...$";
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		boolean res = Pattern.matches(regex, str);	// 순서 매우 중요!
		if(res) {
			System.out.println(str + "는 3글자로 되어 있습니다.");
		}else {
			System.out.println(str + "는 3글자로 되어 있지 않습니다.");
		}
		

		scan.close();
	}

}
