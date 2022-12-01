package day16;

import java.nio.charset.Charset;
import java.util.HashSet;

public class SetEx01 {

	public static void main(String[] args) {
		/* list와 set은 set에 get이 없는 것 빼곤 구성이 거의 비슷
		 * set은 저장된 순서가 따로 없음. 하지만 반복문으로 출력은 할 수 있음.
		 * list는 배열처럼 번지가 있어 순서대로 저장및 출력이 됨.
		 */
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(10);
		set.add(5);
		set.add(10);
		set.add(1);
		set.add(100);
		set.add(22);
		System.out.println(set);
		
		HashSet<String> str = new HashSet<String>();
		str.add("hi");
		str.add("good");
		str.add("welcome");
		str.add("who am i");
		System.out.println(str);
		
		HashSet<Double> dou = new HashSet<Double>();
		dou.add(3.14);
		dou.add(8.1);
		System.out.println(dou);

	}

}
