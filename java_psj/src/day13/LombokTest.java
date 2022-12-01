package day13;

import lombok.Data;

public class LombokTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestA a = new TestA();
	
		a.setNum(10);
		System.out.println(a.getNum());
		System.out.println(a);	// toString() 확인
		TestA b = new TestA();
		b.setNum(10);
		System.out.println(b);
		System.out.println(a.equals(b)); // equals() 확인
		
		
	}

}

@Data	// @Getter, @Setter, @ToString @EqualsAndHashCode, @RequiredArgsConstructor 가 들어가 있음



class TestA {
	private int num;
}
