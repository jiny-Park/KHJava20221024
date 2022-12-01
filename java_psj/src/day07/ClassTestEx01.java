package day07;

public class ClassTestEx01 {

	public static void main(String[] args) {
		/* 인스턴스화 방법 
		 * 클래스명 객체명 = new 클래스명();
		 */	
		String str = new String("ad");
		Person person1 = new Person();
		// pNo에 private을 추가하기 전에는 외부에서 접근이 가능했지만
		// 캡슐화를 통해 pNo의 접근제한자를 private로 설정하면 직접 접근이 불가능하다. 그래서 에러 발생.
//		person1.pNo = "123456-123456"; -> 아래와 같이 접근해야 Person 클래스의 안의 변수에 접근할 수 있다.
		// 캡슐화된 pNo에 접근하기 위해서는 getter와 setter를 통해 접근해야 한다. 
		person1.setpNo("123456-1234567");
		System.out.println("주민번호 : " + person1.getpNo());
		System.out.println(str.charAt(0));
	}
}
/*
class 클래스명 {	-> 클래스와 인터페이스는 첫글자를 대문자로 쓴다
	접근제한자 자료형 변수명; -> 클래스의 멤버변수, 일반적으로 멤버변수는 private로 쓴다.
}

 접근 제한자 종류
 - private	 : 본인 클래스내에서만 사용이 가능
 - (default) : 본인 클래스 + 같은 패키지, 아래의 Person의 클래스에서 String 앞에 아무것도 입력 안할 때 기본적으로 붙는 접근 제한자이다.	
 - protected : 본인 클래스 + 같은 패키지 + 자식 클래스
 - public 	 : 본인 클래스 + 같은 패키지 + 자식 클래스 + 외부 클래스 => '전부'라고 할 수 있다!
*/
class Person {
	private String pNo;
	private String name;
	private char gender;
	private String address;
	private String phone;
	private int age;
	
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}



















