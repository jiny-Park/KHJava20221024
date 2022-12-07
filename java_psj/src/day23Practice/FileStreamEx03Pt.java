package day23Practice;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.Data;

public class FileStreamEx03Pt {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		
		try {
			fos = new FileOutputStream("fileTest.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new Person("박서진", 33));
			oos.writeObject(new Person("송혜교", 29));
			oos.writeObject(new Person("이광수", 23));
			
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료 됐습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				oos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fis = new FileInputStream("fileTest.txt");
			ois = new ObjectInputStream(fis);
			
			while(true) {
				Person ps = (Person)ois.readObject();
				System.out.println(ps);
			}
			
		}catch (EOFException e) {
			System.out.println("파일 읽기가 완료됐습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				ois.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}

@Data
class Person implements Serializable{
	private static final long serialVersionUID = -6958570464679925396L;
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
}