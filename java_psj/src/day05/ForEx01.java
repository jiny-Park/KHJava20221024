package day05;

public class ForEx01 {

	public static void main(String[] args) {
		// ; 을 제대로된 위치에서 잘 사용해야 한다. 
		
		int i;
//		for(i=1; i<=5; i++);{		 -> ; 이 잘 못 들어간 예시
//			System.out.println(i);
//		}
		
		i = 5;
//		if(i%2 == 0); {					-> ; 이 잘 못 들어간 예시
//			System.out.println(" ");
//		}else {
//			System.out.println(" ");
//		}
		
		// 조건문, 반복문은 실행문이 1줄이면 { }을 생략 가능하다. 이때 ; 를 유의해서 사용하자.
		for(i=1;i<=5;i++)
			System.out.println(i);
		
	}

}
