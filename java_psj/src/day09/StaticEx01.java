package day09;

public class StaticEx01 {

	public static void main(String[] args) {

		KiaCar car1 = new KiaCar("모닝");
		KiaCar car2 = new KiaCar("레이");
		KiaCar car3 = new KiaCar("k3");
		
		car1.print();
		car2.print();
		car3.print();
		car1.name = "k5";
		KiaCar.logo = "kia";	// -> static은 클래스명으로 호출하는것이 일반적. static은 공유하는 것
//		car1.logo = "Kia";		// -> 가능은 하지만 일반적이지 않음.
		System.out.println("--------------");
		car1.print();
		car2.print();
		car3.print();
	}

}

class KiaCar {
	public static String logo = "KIA";		// -> 필드변수(멤버변수)이지만 static 이 붙었으므로 클래스 변수라고 부름.
	public String name;		// -> 필드변수(멤버변수)이면서 static이 붙어있지 않으므로 인스턴스 변수, 객체 필드라고도 부름
	
	public KiaCar(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.print(logo);
		System.out.println(" : " + name);
	}
	
	public static void printLogo() {
		System.out.print(logo);
//		System.out.println(" : " + name); -> static이 붙지 않은 필드변수이기에 에러 발생.
	}
}