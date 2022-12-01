package day09;

public class ThisEx01 {

	public static void main(String[] args) {
		
		Test03 t1 = new Test03();
		Test03 t2 = new Test03(1000);
		t1.print();
		t2.print();
	}

}
/* this : 객체 본인을 나타내는 참조변수
 * 	- 주로 매개변수의 이름과 멤버변수의 이름이 같은 경우 사용
 * 		=> 메소드에서 매개변수의 이름과 필드의 이름이 같으면 변수를 호출했을 때 매개변수가 불러짐.
 *  - 메소드명이 길때 자동완성을 위해서 사용
 *  
 *  this() : 해당 클래스의 생성자를 호출, 생성자에서 첫번째줄에 추가
 */	
class Test03 {
	private int num;
//	public void setNum(int num) {
//		num = num;		-> 이같은 경우엔 매개변수 = 매개변수를 가리키기 때문에 아무 효과를 볼 수 없다고 나온다. 곧 의미가 없는 메소드인 것.
//	}
	public void setNum(int num) {
		this.num = num; // -> this를 사용함으로 this뒤에 붙는 num이 필드변수라는 것을 지정해줌.
	}
	public int getNum() {
		return num;
	}
	public void print() {
		System.out.println(this.getNum());
	}
	
	public Test03() {
//		this();  -> 본인이 본인을 호출하는 것이기 때문에 무한루프에 빠짐.
		this(10);
		num = 20;

	}
	public Test03(int num) {
		this.num = num;
	}
}
 