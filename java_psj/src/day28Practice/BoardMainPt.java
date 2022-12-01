package day28Practice;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardMainPt {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static List<MemberPt> memberList = new ArrayList<MemberPt>();
	private static List<Object> boardList	 = new ArrayList<Object>();
	private static List<String> categoryList = new ArrayList<String>();
	private static MemberPt user = null;

	public static void main(String[] args) {
		int menu = -1;
		
		loadMember("memberPt.txt");
		loadCategory("categoryPt.txt");
		
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			printBar();
			runMenu(menu);
				
		}while(menu != 4);
		saveMember("memberPt.txt");
		saveCategory("CategoryPt.txt");
	}

	private static void loadMember(String filename) {
		try (ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(filename))){
			while(true) {
				MemberPt member = (MemberPt)ois.readObject();
				memberList.add(member);
			}
		} catch (ClassNotFoundException e) {
			printStr("불러오기 실패");
		} catch (EOFException e) {
			printStr("불러오기 성공");
		} catch (IOException e) {
			printStr("불러오기 실패");
		}
		
	}
	
	private static void saveMember(String filename) {
		if(memberList.size() == 0) 
			return;
		try (ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(filename))){
			for(MemberPt member : memberList) {
				oos.writeObject(member);
			}
			System.out.println("파일 저장 완료");
		} catch (IOException e) {
			printStr("불러오기 실패");
		}
		
	}


}
