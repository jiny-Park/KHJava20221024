package day17;

import lombok.Data;

@Data
// map을 이용할 것이기 때문에 id를 빼서 진행.
// map의 키에 id를 넣을 것
// 키만 비교하면 되기 때문에, map 응용해선 equals를 넣을 필요는 없음

public class Member {
	public Member(String pw, String name, String residentNumber, int age) {
		this.pw = pw;
		this.name = name;
		this.residentNumber = residentNumber;
		this.age = age;
	}
	
	private String pw, name, residentNumber;
	private int age;
	public void update(String newPw, String name, String residentNumber, int age) {
		this.pw = newPw;
		this.name = name;
		this.residentNumber = residentNumber;
		this.age = age;
		
	}
	
	
	
	
	

}
