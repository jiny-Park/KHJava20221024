package day07Practice;

public class MethodExPractice {

	public static void main(String[] args) {
		String str = new String("ad");
		Person person1 = new Person();
		
		person1.setAge(12);
		System.out.println("나이 : " + person1.getAge());
		

	}
}
class Person {
	private String pno;
	private String name;
	private String address;
	private char gender;
	private String phone;
	private int age;
	
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
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
