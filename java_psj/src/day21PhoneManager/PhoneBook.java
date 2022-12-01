package day21PhoneManager;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PhoneBook {
	private String name, company;
	ArrayList<PhoneNumber> pnList;

	// 생성자는 객체를 초기화함으로 더 편리하게 사용하기 위해서 필요함!
	public PhoneBook(String name, String company, ArrayList<PhoneNumber> pnList) {
		this.name = name;
		this.company = company;
		this.pnList = pnList;
	}

	public void print() {
		System.out.println("===============");
		System.out.println("이름 : " + name);
		System.out.println("직장 : " + company);
		for(PhoneNumber tmp : pnList) {
			System.out.println(tmp);
		}
		System.out.println("===============");	
	}

	public void update(String name, String company) {		// <- 애를 만들지 않으면 두 번 호출해서 변경해야함. 
		this.name = name;
		this.company = company;
		
	}

	public void printPhoneNumber() {
		for(int i = 0; i < pnList.size(); i++) {
			System.out.println(i+1 + ". " + pnList.get(i).toString());
		}
	}


	
	

	


	
	
	
}
