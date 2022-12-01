package day11Practice;

import day03.ifEx01;

public class StringPractice {

	public static void main(String[] args) {
//		String str = "Welcome";
		// length는 문자열의 길이를 알려줌
//		System.out.println(str.length());
//		
		// indexOf는 문자열의 문자의 위치를 알려줌. 0번지부터 시작하고,
		// lastIndexOf는 뒤에서 시작하여 마지막번째의 문자를 알려줌
		// contains는 문자열에 문자가 있는지 true, false로 알려줌
//		System.out.println("e의 첫번째 위치 : " + str.indexOf("e"));
//		System.out.println("e의 마지막번째 위치 : " + str.lastIndexOf("e"));
//		System.out.println("l이란 문자가 있는지 : " + str.contains("l"));
//		
		// substring은 부분 문자열을 찾아서 출력해줌
//		System.out.println("0번지부터 부분 문자열 : " + str.substring(0));
//		System.out.println("2번지부터 부분 문자열 : " + str.substring(2,4)); 
//		
//		// 문자열의 비교는 equals로 사용
//		String str1 = "abc";
//		String str2 = "abc";
//		String str3 = new String("abc");
//		System.out.println("str1과 str2가 같다?(==) :" + (str1 == str2));
//		System.out.println("str1과 str3가 같다?(==) :" + (str1 == str3));
//		System.out.println("str1과 str3가 같다?(equals) :" + (str1.equals(str2)));
//		System.out.println("str1과 str3가 같다?(equals) :" + (str1.equals(str3)));
//		
		// charAt은 원하는 위치의 문자를 알려줌
//		System.out.println(str + "의 문자열에 4번지에 있는 문자 : " + str.charAt(4));
//		
		// split은 정규표현식의 문자열을 배열로 바꺼줌
//		String car = "k3, k5, k8, k9";
//		String []cars = car.split(",");
//		for(String tmp : cars) {
//			System.out.print(tmp);
//		}
		
		// String 예제 1. 
		// 문자열 str의 search가 몇번 등장하는지 확인하는 코드 
		String str = "Welcome! We are the world!";
		String search = "o";
		System.out.println(search.length());
		
		int count = 0;
		String tmp = str;
		while(true) {
			System.out.println(tmp);
			int index = tmp.indexOf(search);
			System.out.println(index);
			if(index == -1) {
				// 왜 index가 -1 이 될수 있는거지?? -> indexOf는 문법은 찾으라고 한 요소를 찾기 못하면 자동적으로 -1이란 숫자를 리턴하도록 설계되어 있기 때문에
												// 자동적으로 -1이 리턴이 되는 것이다!
				System.out.println("index == -1 => " + index);
				break;
			}
			tmp = tmp.substring(index + search.length());
										//index + search.length() 가 어떻게 index에 -1이라는 숫자에 영향을 주는거지???
			System.out.println(tmp.length());
			count++;
			
		}
		System.out.println(str + "에는 " + search + "가 " + count + "번 있습니다!");
		
		int count1 = 0;
		String tmp1 = str;
		while(true) {
			int index1 = tmp1.indexOf(search);
			if(index1 == -1) {
				break;
			}
			tmp1 = tmp1.substring(index1 + search.length());
			count1++;
		}
		System.out.println(count1);
		
		
		int count2 = 0;
		String tmp2 = str;
		while(true) {
			int index2 = tmp2.indexOf(search);
			if(index2 == -1) {
				break;
			}
			tmp2 = tmp2.substring(index2+search.length());
			count2++;
		}
		System.out.println(count2);
		
		int count3 = 0;
		String tmp3 = str;
		while(true) {
			int index3 = tmp3.indexOf(search);
			if(index3 == -1) {
				break;
			}
			tmp3 = tmp3.substring(index3+search.length());
			count3++;
		}
		System.out.println(count3);
		
	}

}
