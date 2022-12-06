package day32;

public class WrapperEx01 {

	public static void main(String[] args) {
		String str = "123";
		
		// 문자열을 정수로
		int num = Integer.parseInt(str); // parseInt(변수) 는 잘 기억!
		System.out.println(num);
		
		// 문자열을 실수로
		str = "3.14";
		double dnum = Double.parseDouble(str);
		System.out.println(dnum);
		
		// 정수를 문자열로
		num = 30;
		str = String.valueOf(num); // or str = "" + num;
		System.out.println(str);
		
		int i = Math.min(1, 2);
		int i2 = Math.max(1, 2);
		System.out.println(i);
		System.out.println(i2);
		
		Integer i3 = null;
		System.out.println(i3);
//		int num1 = i3;
//		System.out.println(num1);
	}
}
