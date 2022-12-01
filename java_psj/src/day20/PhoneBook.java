package day20;

import java.util.ArrayList;

import lombok.Data;

//*참고 : day13의 StudentManagerTest2/Student2/Score2 참고

@Data
public class PhoneBook {
	// 1. 전화번호 정보만 (성, 이름, 직장, 전화번호들(폰/집/회사/학교 : 전화번호)
	private String name, company;
	ArrayList<PhoneNumber> pnList;
	
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
		System.out.println("==============");
		
	}

	public void update(String name, String company) {
		this.name = name;
		this.company = company;
		
	}

	public void printPhoneNumber() {
		for(int i = 0; i < pnList.size(); i++) {
			System.out.println(i+1 + ". " + pnList.get(i).toString());
		}
		
	}




	
	


	
	
	
	
}
