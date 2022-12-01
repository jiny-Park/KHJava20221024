package day27;

import java.util.regex.Pattern;

import lombok.Data;

@Data
public class Member {
	// 1. 회원가입 선택시 보여질 것 : 가입 절차 
	// 	1-1. ID, PW, 성명, 생년월일, 성별, 폰 번호
	//  1-2. ID, PW, 생년월일, 폰번호는 일정한 규칙으로 저장해야함
	//  1-3. ID는 동일해선 안 됨. 다른 것 입력 전에 동일한 id가 있는지 없는지 확인 필요.
	//  1-4. 동일한 id가 없다면 등록
	
	private String id, pw, name, birth, gender, phoneNum;
	
	public void setId(String id) {
		// 소문자, 숫자, _, - 만 사용하여 5~20자 입력 가능합니다.
		String regex = "^[a-z0-9_\\-]{5, 20}$";
		if(Pattern.matches(regex, id)) {
			this.id = id;
		}else {
			throw new RuntimeException("[ 예외 발생 : ID를 잘 못 입력했습니다 ]");
		}
	}
	
	public void setPw(String pw) {
		// 소문자, 숫자, _, - 만 사용하여 5~20자 입력 가능합니다.
		String regex = "^[a-z0-9_\\-]{5, 20}$";
		if(Pattern.matches(regex, pw)) {
			this.pw = pw;
		}else {
			throw new RuntimeException("[ 예외 발생 : PW를 잘 못 입력했습니다 ]");
		}
	}
	
	public void setBirth(String birth) {
		String regex = "^\\d{4}(-\\d{2}){2}$";
		if(Pattern.matches(regex, birth)) {
			this.birth = birth;
		}else {
			throw new RuntimeException("[ 예외 발생 : 생일를 잘 못 입력했습니다 ]");
		}
	}
	
	public void setPhoneNum(String phoneNum) {
		String regex = "^010(-\\d{4}){2}$";
		if(Pattern.matches(regex, phoneNum)) {
			this.phoneNum = phoneNum;
		}else {
			throw new RuntimeException("[ 예외 발생 : 폰번호를 잘 못 입력했습니다 ]");
		}
	}
	
	public Member(String id, String pw, String name, String birth, String gender, String phoneNum) {
		setId(id);
		setPw(pw);
		this.name = name;
		setBirth(birth);
		this.gender = gender;
		setPhoneNum(phoneNum);		
	}

	public Member(String id) {
		setId(id);
	}

	
}
