package day19;

import java.util.function.Consumer;

public class LambdaEx02 {

	public static void main(String[] args) {
		/* 람다식 특징 : new를 쓰지 않음, 타입 생략 가능
		 *			  실행문이 하나일 경우 {} 생략 가능 			  
		 * 
		 */
		Sum sum = (a, b) -> a + b;
		System.out.println(sum.run(1, 2));

		Print<String> print = (num) -> System.out.println(num);
		print.run("안녕");
		
		Consumer<String> print2 = str -> System.out.println(str);
		print2.accept("10");
		
	}

}


interface Sum{
	double run(double a, double b);
}

interface Print<T>{	//<T> 제네릭을 사용함으로 다양하게 객채들을 넘겨줄 수 있음. 
				//T가 의미가 있다기보다 다른 문자를 써도 사용가능하며 위아래 같은 문자로만 맞추면 된다.
	void run(T num);
}

