package day23;

import java.io.*;

import lombok.Data;

public class FileStreamEx04 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		

		
		try {		
			fos = new FileOutputStream("test.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new Student1("박서진", "2000-00-00"));
			oos.writeObject(new Student1("송혜교", "2000-03-02"));
			oos.writeObject(new Student1("유재석", "2000-04-04"));
			
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료됐습니다!");
		}catch(Exception e) {	// 최상위 클래스 Exception을 통해 다른 예외 클래스를 미리 차단
			e.printStackTrace();
		}finally{
			try {
				fos.close();
				oos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		try {	
			fis = new FileInputStream("test.txt");
			ois = new ObjectInputStream(fis);

			while(true) {
				Student1 std = (Student1)ois.readObject();
				System.out.println(std);
			}

		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료됐습니다!");
		}catch(Exception e) {	// 최상위 클래스 Exception을 통해 다른 예외 클래스를 미리 차단
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				ois.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}


@Data
class Student1 implements Serializable{
	private static final long serialVersionUID = 1700858336115503227L;
	private String name;
	private String birthday;

	public Student1(String name, String birth) {
		this.name= name;
		this.birthday = birth;
	}
}
