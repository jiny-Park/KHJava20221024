package day19;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex01 {

	public static void main(String[] args) {
		// 이메일 주소를 입력받아 이메일 형식이 맞는지 확인하는 정규식 코드 작성
		// 예)abc123@naver.com
		
		// @을 기준으로 (abc123 @ naver.com)
		// ^[a-zA-Z0-9\-_]+@[a-zA-Z0-9\-]{2,}(\.[a-zA-Z]+){1,2}$
		
		// 정규표현식을 사용할때는 규칙을 정확하게 잘 정해놔야 된다!
		
		String regex = "^[a-zA-Z0-9\\-_]+@[a-zA-Z0-9\\-]{2,}(\\.[a-zA-Z]+){1,2}$";
		Scanner scan = new Scanner(System.in);
		System.out.print("이메일 입력 : ");
		String email = scan.next();
		if(Pattern.matches(regex, email)) {
			System.out.println(email + "은 올바른 mail 형식");
		}else {
			System.out.println(email + "은 올바른 형식이 아닙니다.");
		}
		
		
		

	}

}
