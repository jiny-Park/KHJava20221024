package day10;

public class Record {
	private int count;
	private String name;
	
	public Record(int count, String name) {
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
