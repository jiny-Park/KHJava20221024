package day14;

public class Test04 {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();

	}

	
}

class Singleton{
	private static Singleton obj;
	private Singleton() {}
	public static Singleton getInstance() {
		obj = new Singleton();
		return obj;
	}
	
}
