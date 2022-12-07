package day33;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw = null;

		try {
			fw = new FileWriter("test1.txt");
			fw.write(97);
			fw.write(65);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(fw);
		

	}
}
