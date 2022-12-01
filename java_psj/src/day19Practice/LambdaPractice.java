package day19Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class LambdaPractice {

	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(2);
//		list.add(333);
//		list.add(100);
//		list.add(-1);
//		
//		System.out.println(list);
//		Collections.sort(list, (a, b) -> a-b);
//		System.out.println(list);

		Sum sum = (a, b)-> a+b;
		System.out.println(sum.run(1,2));
		
		Print<String> print = ddd -> System.out.println(ddd);  
		print.run("안녕");
		
		Consumer<String> print2 = str -> System.out.println(str); 
		print2.accept("10");
		
		Consumer<String> print3 = eee -> System.out.println(eee); 
		print3.accept("10");
		
		
		
	}

}
interface Sum{
	double run(double a, double b);
}

interface Print<T>{
	void run(T num);
}
