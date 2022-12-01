package day24;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
	
	static Scanner scan = new Scanner(System.in);
	/* 학생 정보를 관리 프로그램을 작성하세요.
	 * 1. 학생 추가 (이름, 학년, 반, 번호)
	 * 2. 학생 출력
	 * 3. 종료
	 * - 프로그램 시작 전 학생 정보를 읽어오는 기능 추가(load)
	 * - 프로그램 종료 전 학생 정보를 저장하는 기능 추가(save)
	 */
	public static void main(String[] args) {

		ArrayList<StudentDate> list = new ArrayList<StudentDate>();
	
		
		int menu = -1;
		
		
		load(list);
		do {
			try {
				printMenu();
				
				menu = scan.nextInt();
				printBar();
				
				runMenu(menu, list);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}while(menu != 3);
		save(list);
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
		System.out.println("☆ 학생정보 메뉴 ☆");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 출력");
		System.out.println("3. 종   료");
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆");
		System.out.print("메뉴 선택 : ");
	}
	
	
	
	private static void runMenu(int menu, ArrayList<StudentDate> list) {
		
		switch(menu) {
		case 1: 
			if(addStudentDate(list)) {
				printStr("학생 정보를 추가했습니다!");
			}else {
				printStr("학생 정보를 추가하지 못했습니다!");
			}
			break;
			
		case 2:
			printStudentDate(list);
			break;
			
		case 3:
			printStr("프 로 그 램 종 료");
			break;
		default:
			printStr("잘못 선택했쟈나!");
		}		
	}
	
	
	private static boolean addStudentDate(ArrayList<StudentDate> list) {
		scan.nextLine();
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print(" 반 : ");
		int classNumber = scan.nextInt();
		System.out.print("번호 : ");
		int number = scan.nextInt();
		
		StudentDate std = new StudentDate(name, grade, classNumber, number);
		
		if(list.contains(std)) {
			printStr("동일한 학생 정보가 존재합니다!");
			return false;
		}
		return list.add(std);
	} 
	

	private static void printStudentDate(ArrayList<StudentDate> list) {
		if(list == null || list.size() == 0) {
			throw new RuntimeException("※예외발생 : 학생 정보에 등록된 정보가 없습니다!");
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));

		}	
	}
	
	private static void load(ArrayList<StudentDate> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("test1.txt");
			oos = new ObjectOutputStream(fos);
			
//			oos.writeObject(new StudentDate());
				
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료 됐습니다!");
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
		
	}
	
	
	private static void save(ArrayList<StudentDate> list) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("text1.txt");
			ois = new ObjectInputStream(fis);
			
			while(true) {
				StudentDate std = (StudentDate)ois.readObject();
				System.out.println(std);
			}
			
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료됐습니다!");
		}catch(Exception e) {
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
