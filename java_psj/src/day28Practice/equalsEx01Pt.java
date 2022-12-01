package day28Practice;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

import lombok.Data;

public class equalsEx01Pt {

	public static void main(String[] args) {
		List<Test> list = new ArrayList<Test>();
		list.add(new Test(1,1));
		list.add(new Test(1,2));
		list.add(new Test(1,3));
		list.add(new Test(2,1));
		list.add(new Test(3,1));
		list.add(new Test(4,1));
		System.out.println(list);
		int index = list.indexOf(new Test(2,2));
		System.out.println("indexOf : " + index);
		Test t = new Test(2, 1);
		System.out.println("equals : " + t.equals(new Test(2,2)));

		index = list.indexOf((Integer)2);
		System.out.println("indexOf : " + index);
		System.out.println("equals : " + t.equals((Integer)2));
		
		System.out.println(Objects.equals(new Test(2,1), (Integer)2));
		System.out.println(Objects.equals((Integer)2, new Test(2,1)));
		List<Test> list2 = new ArrayList<Test>();
		list2.add(new Test(1,1));
		list2.add(new Test(1,2));
		System.out.println("두 리스트 비교 : " + list.containsAll(list2));
		list2.add(new Test(10,1));
		System.out.println("두 리스트 비교 : " + list.containsAll(list2));
	}

}


@Data
class Test {
	int num1, num2;
	public Test(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;		
	}
	@Override
	public boolean equals(Object obj) {	//2개의 객체가 동일한지 검사하기 위해 사용
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			if(obj instanceof Integer) {
				if(num1 == (Integer) obj) {
					return false;
				}
			}
			return true;
		}
		Test other = (Test) obj;
		if (num1 != other.num1)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num1;
		return result;
	}

}