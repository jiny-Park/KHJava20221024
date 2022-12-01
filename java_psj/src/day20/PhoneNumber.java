package day20;

import java.util.regex.Pattern;

import lombok.Data;

@Data
public class PhoneNumber {
	// 전화번호들만 모음 클래스
	private String pName, number;
	
	public void setNumber(String number) {
		String regex = "\\d{2,3}-\\d{3,4}-\\d{4}";
		
		if(Pattern.matches(regex, number)) {
			this.number = number;
		}else {
			throw new RuntimeException("예외 발생 : 번호를 잘 못 입력!");
		}
	}

	public PhoneNumber(String pName, String number) {
		this.pName = pName;
		setNumber(number);
	}

	public void update(String pName, String number) {
		this.pName = pName;
		this.number = number;
		
	}
	
	
	

}
