package day24;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMainTeacher {
	
	private static Scanner scan = new Scanner(System.in);
	/* 학생 정보를 관리 프로그램을 작성하세요.
	 * 1. 학생 추가 (이름, 학년, 반, 번호)
	 * 2. 학생 출력
	 * 3. 종료
	 * - 프로그램 시작 전 학생 정보를 읽어오는 기능 추가(load)
	 * - 프로그램 종료 전 학생 정보를 저장하는 기능 추가(save)
	 */
	public static void main(String[] args) {
		String fileName = "Student.txt";
		
		int menu = -1;
		ArrayList<Student> list = new ArrayList<Student>();
		load(list, fileName);
		do {
			printMenu();
			menu = scan.nextInt();
			printBar();
			runMenu(menu, list);
			
		}while(menu != 3);
		save(list, fileName);
	}

	//▼▼▼▼▼▼ M e t h o d ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	private static void printBar() {
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆");
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	private static void printMenu() {
		System.out.println("☆☆ 학생정보 메뉴 ☆☆");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 출력");
		System.out.println("3. 종   료");
		printBar();
		System.out.print("메뉴 선택 : ");	
	}

	private static void runMenu(int menu, ArrayList<Student> list) {
		switch(menu) {
		case 1:
			addStudent(list);
			break;
			
		case 2:
			printStudent(list);
			break;
			
		case 3:
			printStr("프로그램 종료!");
			break;
			
		default:
			printStr("잘못된 메뉴 입니다!");
			
		}
		
	}

	private static void addStudent(ArrayList<Student> list) {
		if(list == null) {
			throw new RuntimeException("학생을 관리할 list가 생성되지 않았습니다!");
		}
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print(" 반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int number = scan.nextInt();
		System.out.print("이름 : ");
		String name = scan.next();
		
		Student std = new Student(grade, classNum, number, name);
		
		list.add(std);
		printStr("학생 추가가 완료 됐습니다!");
	}
	
	private static void printStudent(ArrayList<Student> list) {
		if(list == null) {
			throw new RuntimeException("학생을 관리할 list가 생성되지 않았습니다!");
		}
		if(list.size() == 0) {
			printStr("학생 정보가 없습니다!");
		}
		
		for(Student std : list) {
			System.out.println(std);
		}
		printBar();
	}
	
	private static void load(ArrayList<Student> list, String fileName) {
		if(list == null) {
			throw new RuntimeException("예외 발생 : 학생 정보 리스트가 없습니다!");
		}
		
		try(ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream(fileName))) {
			while(true) {
				Student std = (Student)ois.readObject();
				list.add(std);
			}
		}catch(FileNotFoundException e) {
			printStr(fileName + "이 없어서 불러오기에 실패했습니다!");
		}catch(EOFException e) {
			printStr("불러오기 완료!");
		}catch(Exception e) {
			printStr("불러오기 실패했습니다!");
		}
	}
	
	private static void save(ArrayList<Student> list, String fileName) {
		if(list == null) {
			throw new RuntimeException("예외 발생 : 학생 정보 리스트가 없습니다!");
		}
		
		try(ObjectOutputStream oos
				= new ObjectOutputStream(new FileOutputStream(fileName))) {
			for(Student std : list) {
				oos.writeObject(std);
			}
			printStr("저장 했습니다!");
		}catch(FileNotFoundException e) {
			printStr(fileName + "을 생성할 수 없어서 저장에 실패했습니다!");
		}catch(IOException e) {
			printStr("저장에 실패했습니다!");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
