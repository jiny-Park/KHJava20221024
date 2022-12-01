package day11;

public class StringEx02_1 {

	public static void main(String[] args) {
		
		String str = "Hello world! My name is Hong";
		String search = "o";
		
		int count = 0;
		String tmp = str;
		
		while(true) {

			int index = tmp.indexOf(search);
			System.out.println(index);
			
			if(index == -1) {
				break;
			}
			System.out.println(tmp);
			tmp = tmp.substring(index + search.length());
			System.out.println(tmp);
			
			count++;
		}

	}

}
