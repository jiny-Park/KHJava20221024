package day10Practice;

public class RecordPractice {
	private int count;
	private String name;
	
	public RecordPractice(int count, String name) {
		this.count = count;
		this.name = name;
	}
	
	public void print() {
		System.out.println(name + ", 도전 횟수 : " + count);
	}
	
	public int getCount() {
		return count;
	}
	
	
}
