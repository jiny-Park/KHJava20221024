package day16;

import java.util.HashMap;
import java.util.Scanner;

import lombok.Data;

public class MapEx02 {

	public static void main(String[] args) {
		/*
		 * 
		 */
		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("user", new User("abc", "def"));
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		map.put("user", new User(name, "as1", "adf1"));
		map.put("age", 22);
		map.put("address", "서울시");
		System.out.println(map.get("user"));;
		System.out.println(map.get("age"));
		System.out.println(map.get("address"));
		System.out.println(map.get("123"));	// 저장된 키 값을 get하면 null로 출력됨.
		
		// 스프링에서 set은 활용도가 낮지만, list와 map은 스프링에서 활용도가 높은편임. 그중에서도 list연습을 많이 하는 것이 좋다!
	
	}
}

@Data
class User{
	private String id, pw, name;
	public User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		
	}
}
