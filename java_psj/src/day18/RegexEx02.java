package day18;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regex = "^[a-z0-9_\\-]{5,20}$";	//	\\ 두 번 넣어야 문자열로 인식 됨.
		Scanner scan = new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String str = scan.next();
		if(Pattern.matches(regex, str)) {
			System.out.println(str + "는 올바른 아이디 ");
		}else {
			System.out.println("아이디는 5~20자의 영문 소문자, 숫자와 특수기호 _와 -만 사용 가능합니다.");
		}
	}

}

