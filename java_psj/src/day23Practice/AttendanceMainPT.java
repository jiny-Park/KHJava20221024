package day23Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import day03.ifEx01;
import day23.Log;
import day23.StudentLog;

public class AttendanceMainPT {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int menu = -1;
		AttendancePT attendance = new AttendancePT();
		
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			System.out.println("--------------");
			runMenu(menu, attendance);
			
		}while(menu != 3); 

	}
	
//▼▼▼▼▼▼▼▼▼▼ M e t h o d ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	private static void printBar() {
		System.out.println("=====================");
	}
	
	private static void printStr(String str) {

		System.out.println(str);
		printBar();
	}
	
	private static void printMenu() {
		System.out.println("--- 출 석 부 메 뉴 ---");
		System.out.println("1. 학생 관리");
		System.out.println("2. 출석 관리");
		System.out.println("3. 종 료");
		System.out.print("메 뉴 선 택 : ");
	}
	
	private static void printSubMenu(int menu) {
		switch (menu) {
		case 1: 
			System.out.println("학생관리 메뉴");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 수정");
			System.out.println("3. 학생 삭제");
			System.out.print("메 뉴 선 택 : ");
			break;
			
		case 2:
			System.out.println("출석관리 메뉴");
			System.out.println("1. 출석 체크 - 전체");
			System.out.println("2. 출석 확인 - 개별");
			System.out.println("3. 출석 확인 - 날짜");
			System.out.println("4. 출석 수정");
			System.out.println("5. 출석 삭제");
			System.out.println("6. 취 소");
			System.out.print("메 뉴 선 택 : ");
			break;
			
		default:
			printStr("잘못된 메뉴 입니다!");
		}
	}

	private static void runMenu(int menu, AttendancePT attendance) {
		ArrayList<StudentPT> stds = attendance.getStds();
		ArrayList<LogPT> logs = attendance.getLogs(); 
		
		switch (menu) {
		case 1: 
			managementStudents(stds);
			break;
			
		case 2:
			managementLogs(logs, stds);
			break;
			
		case 3:
			System.out.println("프로그램 종");
			break;
			
		default:
			printStr("잘못된 메뉴입니다!");
		}
	}
	
	private static void managementStudents(ArrayList<StudentPT> stds) {
		printSubMenu(1);
		int subMenu = scan.nextInt();
		scan.nextLine();
		printBar();
		switch (subMenu) {
		case 1:		addStudent(stds);		break;
		case 2:		updateStudent(stds);	break;
		case 3:		deleteStudent(stds);	break;
		case 4:		printStr("취소 했습니다!");	break;
		default:	printStr("잘못된 메뉴 입니다!");
		}
	}
	
	private static void addStudent(ArrayList<StudentPT> stds) {
		if(stds == null) {
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다!");
		}

		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("생일(0000-00-00) : ");
		String birth = scan.nextLine();
		
		StudentPT std = new StudentPT(name, birth);
		if(stds.indexOf(std) != -1) {
			printStr("학생 정보를 추가하지 못했습니다!");
			return;
		}
		
		stds.add(std);
		printStr("학생 정보를 추가했습니다!");
	}

	private static void updateStudent(ArrayList<StudentPT> stds) {
		if(stds == null) {
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다!");
		}
		
		System.out.println("수정할 학생 정보 검색");
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("생일(0000-00-00) : ");
		String birth = scan.nextLine();
		
		StudentPT std = new StudentPT(name, birth);
		int index = stds.indexOf(std);	// std에 저장된 값을 찾지 못하면 -1을 반환!
		if(index == -1) {
			printStr("검색 정보와 일치하는 학생이 없습니다!");
			return;
		}
		
		System.out.print("수정할 이름 입력 : ");
		name = scan.nextLine();
		System.out.print("수정할 생일 입력(0000-00-00) : ");
		birth = scan.nextLine();
		std = new StudentPT(name, birth); // 덮어쓰기 : 어차피 전체 수정이기 때문에!
		stds.set(index, std);
		printStr("학생 정보를 수정했습니다!");
	} 
	
	private static void deleteStudent(ArrayList<StudentPT> stds) {
		if(stds == null) {
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다!");
		}
		
		System.out.println("삭제할 학생 정보 검색");
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("생일(0000-00-00) : ");
		String birth = scan.nextLine();
		
		StudentPT std = new StudentPT(name, birth);
		int index = stds.indexOf(std);
		if(index == -1) {
			printStr("검색 정보와 일치하는 학생이 없습니다!");
		}
		
		stds.remove(index);
		printStr("학생 정보를 삭제했습니다!");
	}
	
	private static void managementLogs(ArrayList<LogPT> logs, ArrayList<StudentPT> stds) {
		printSubMenu(2);
		int subMenu = scan.nextInt();
		scan.nextLine();
		printBar();
		switch (subMenu) {
		case 1:		checkLog(logs, stds);		
					sortLogs(logs);
					break;
		case 2:		printLogsStudent(logs);	break;
		case 3:		printLogsByDate(logs);	break;
		case 4:		upDateLogs(logs);		break;
		case 5:		deleteLogs(logs);		break;
		case 6:		printStr("취소 했습니다!");	break;
		default:	printStr("잘못된 메뉴 입니다!");
		}
	}

	private static void checkLog(ArrayList<LogPT> logs, ArrayList<StudentPT> stds) {
		System.out.print("출석 일자(0000-00-00) : ");
		String date = scan.nextLine();
		printBar();
		
		if(checkLogDate(logs, date)) {
			printStr("이미 출석 체크한 일자입니다!");
			return;
		}		
		printStr("출석 : O, 결석 : X, 지각 : /, 조퇴 : \\");
		
		ArrayList<StudentLogPT> stdLogs = new ArrayList<StudentLogPT>();
		
		for(StudentPT std : stds) {
			System.out.print(std.getName() + "(" + std.getBirthday() + ") : ");
			String state = scan.nextLine();
			StudentLogPT stdLog = new StudentLogPT(std, state);
			stdLogs.add(stdLog);
		} 
		LogPT log = new LogPT(stdLogs, date);
		logs.add(log);
		
	}
	
	private static boolean checkLogDate(ArrayList<LogPT> logs, String date) {
		if(logs == null || date == null) {
			throw new RuntimeException("예외발생 : 일지 리스트가 없거나 날짜가 없습니다!");	
		}
		if(logs.size() == 0) {
			return false;
		}
		for(LogPT log : logs) {
			if(log.getDate().equals(date)) {
				return true;
			}
		}
		return false;
	}
	
	private static void sortLogs(ArrayList<LogPT> logs) {
		if(logs == null || logs.size() == 0){
			return;
		} 
		Collections.sort(logs, (o1, o2)->o1.getDate().compareTo(o2.getDate()));
	}
	
	private static void printLogsStudent(ArrayList<LogPT> logs) {
		if(logs == null || logs.size() == 0) {
			printStr("등록된 출석체크가 없습니다!");
			return;
		}
		System.out.print("이름 : ");
		String name = scan.nextLine();
		printBar();
		for(LogPT log : logs) {
			for(StudentLogPT slog : log.getSlogs()) {
				if(slog.getStd().getName().equals(name)) {
					System.out.println(log.getDate() + " : " + slog.getState());
				}
			}
		}
	}
	
	private static void printLogsByDate(ArrayList<LogPT> logs) {
		if(logs == null || logs.size() == 0) {
			printStr("등록된 출석체크가 없습니다!");
			return;
		}
		System.out.println("날짜(예: 0000-00-00) : ");
		String date = scan.nextLine();
		printBar();
		for(LogPT log : logs) {
			if(log.getDate().equals(date)) {
				for(StudentLogPT slog : log.getSlogs()) {
					String name = slog.getStd().getName();
					String birth = slog.getStd().getBirthday();
					System.out.println(name + "(" + birth + ") : " + slog.getState());
				}
			}
		} 	
	}
	
	private static void upDateLogs(ArrayList<LogPT> logs) {
		System.out.println("날짜(예:0000-00-00) : ");
		String date = scan.nextLine();
		printBar();
		if(checkLogDate(logs, date)) {
			printStr("해당 날짜에 등록된 출석체크가 없습니다!");
			return;
		}
		
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("생일 입력(0000-00-00) : ");
		String birth = scan.nextLine();
		
		System.out.println("상태 입력 : ");
		String state = scan.nextLine();
		printBar();
		for(LogPT log : logs) {
			if(log.getDate().equals(date)) {
				for(StudentLogPT slog : log.getSlogs()) {
					String tmpName = slog.getStd().getName();
					String tmpBirth = slog.getStd().getBirthday();
					if(tmpName.equals(name) && tmpBirth.equals(birth)) {
						slog.setState(state);
					}
				}
				printStr("수정이 완료 됐습니다!");
				return;
			}
		} 
	}
	
	private static void deleteLogs(ArrayList<LogPT> logs) {
		System.out.print("날짜(예:0000-00-00) : ");
		String date = scan.nextLine();
		printBar();
		if(!checkLogDate(logs, date)) {
			printStr("해당 날짜에 등록된 출석체크가 없습니다!");
			return;
		}
		
		for(int i = 0; i < logs.size(); i++) {
			if(logs.get(i).getDate().equals(date)) {
				logs.remove(i);
				printStr("삭제가 완료 됐습니다!");
				return;
			}
		}
		 
		
	}
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
