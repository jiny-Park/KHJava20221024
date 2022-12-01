package example.Post;



import java.util.regex.Pattern;

import lombok.Data;

@Data
//1-1. id, pw, 이름, 나이, 주민등록번호, 주소, 이메
public class Member {
	private String id, pw, name, residentNum, address, email, phoneNum;
	private int age;
	
	public Member(String id, String pw, String residentNum, String address, String email, String phoneNum, int age) {
		setId(id);
		this.pw = pw;
		this.residentNum = residentNum;
		this.address = address;
		this.email = email;
		this.phoneNum = phoneNum;
		this.age = age;
	}
	
	public void setId(String id) {
		String regex = "^[a-z0-9_\\-]{5,20}$";
		if(Pattern.matches(regex, id)) {
			this.id = id;
		}else {
			throw new RuntimeException("예외 발생 : ID를 잘 못 입력하셨습니다!");
		}
	} 
	
}
