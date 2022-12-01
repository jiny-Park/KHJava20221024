package day11;

public class StringEx02 {
	public static void main(String[] args) {
		/* 문자열 str의 search가 몇번 등장하는지 확인하는 코드 작성
		 * 
		 */
		
		String str = "Hello world! My name is Hong";
		String search = "o";
		
		// str에서 search가 있는 위치를 찾음.
		// -1이 아니면 부분문자열을 추출하고, count를 1증가
		// -이면 반복문 종료
		
		int count = 0;
		String tmp = str;
		// 전체 문자열을 탐색하기 위해서는 반복문을 이용해야 한다.
		while(true) {
//			System.out.println(tmp);
			int index = tmp.indexOf(search);	// index라는 변수에 tmp의 변수안에 있는 "o"라는 문자를 찾아서 저장함.
//			System.out.println(index);
			if(index == -1) {
				System.out.println("index == -1 => " + index);
				break;
			}
			System.out.println("int index = tmp.indexOf(search); " + index);
			tmp = tmp.substring(index + search.length()); // + search.length() 를 안하면 무한루프에 빠짐. 

			count++;
			System.out.println("count : "+ count);
		}
		System.out.println(str + "에는 " + search + "가 " + count + "번 있습니다.");

	}

}
