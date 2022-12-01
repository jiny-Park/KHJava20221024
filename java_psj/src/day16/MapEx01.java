package day16;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx01 {

	public static void main(String[] args) {
		/* 컬렉션 클래스에 속하진 않고 따로 분류 되어 있다.
		 * 키 , 벨류
		 * Map은 키와 벨류로 이루어져 있고 키는 id처럼 중복이 되면 안 되지만 벨류는 비번처럼 중복이 되도 된다.
		 */
		HashMap<String, String> userList = new HashMap<String, String>();
		userList.put("id1", "pw1");
		userList.put("id2", "pw2");
		userList.put("id3", "pw2");		
		userList.put("id3", "pw3");		// id(키)의 값이 같다면 중복되지 않고 그 전의 값을 덮어쓰기 함.
										// map 은 순서를 보장하지 않음.
		// map은 값이 두 개라 향상된 for문을 이용할 수 없다.
		System.out.println(userList);
		// map에서의 get은 키값에 대한 벨류 값을 가져오는 역할을 한다. 특정번지의 값을 가져오는 역할을 하진 않음. 이유는 저장되어지는 순서가 따로 없는 것이 map의 특징이기 때문에.
		System.out.println("==================");
		// map에서 반복문에 접근하는 방법
		// 방법 1. keySet을 이용
		// keySet()은 map에 있는 key들을 하나의 set에 담아 반환하는 메소드
		Set<String> keySet = (Set<String>)userList.keySet();
		for(String tmp : keySet) {
			System.out.println(tmp + " : " + userList.get(tmp));
		}
		
		System.out.println("==================");
		
		// 방법 2. EntrySet을 이용
		Set<Entry<String, String>> entrySet = userList.entrySet();
		for(Entry<String, String> tmp : entrySet) {
			System.out.println(tmp.getKey() + " : " + tmp.getValue());
		}
		
	}
	

}
