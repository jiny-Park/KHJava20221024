package day32;

import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		String str = "abc,def,.ghi";
		String [] arr = str.split(",."); // 정규표현식으로 적용되어 ,와 문자하나(.)를 구분자로 봄
		for(String tmp : arr) {
			System.out.println(tmp);
		}
		
		System.out.println("-----------------");
		StringTokenizer st = new StringTokenizer(str, ".,"); // .또는 ,를 구분자로 봄.
		System.out.println("개수 : " + st.countTokens());
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			System.out.println(tmp);
		}
		
		System.out.println("-----------------");
		st = new StringTokenizer(str, ".,", true); //-> true를 넣으면 구분자도 같이 출력되게 함.
		System.out.println("개수 : " + st.countTokens());
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			System.out.println(tmp);
		}
		
		
	}

}
