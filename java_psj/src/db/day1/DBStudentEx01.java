package db.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DBStudentEx01 {
	
	static Scanner scan = new Scanner(System.in);
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public static void main(String[] args) {
		/* 1. DB를 이용하여 학생 정보를 추가하고 조회하는 프로그램을 작성하세요.
		 * 메뉴 출력
		 * 	1. 학생 추가
		 * 	2. 학생 조회
		 * 	3. 프로그램 종료
		 * 
		 * 	1. 학생 추가 
		 * 		- 학번
		 * 		- 이름
		 * 		- 학기
		 * 		- 상태(재학, 휴학등)
		 * 		- 담당 지도 교수
		 * 	2. 학생 조회
		 * 		- 학번 입력 
		 * 		-(조건 : 학번으로만 일단 조회 -> 추후 다른 것으로도 조회 가능하도록 설정 가능) 
		 * 
		 */
        Connection con = null;
        String url = "jdbc:mysql://localhost/university";
        String id = "root";
        String pw = "root";
        ArrayList<Student1> list = null;
        con = connect(url, id, pw);
		
		int menu = -1;
		
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			printBar();
			
	        try {
				stmt = con.createStatement();
				runMenu(menu, con, list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}while(menu != 3);
		
		 connectClose(con);
	}
	
	private static void runMenu(int menu, Connection con, ArrayList<Student1> list) throws SQLException {
		String st_num, st_name, st_state, st_pr_num;
		int st_semester;
		switch(menu) {
		case 1:
			System.out.print("학번 : ");
			st_num = scan.nextLine();
			System.out.print("이름 : ");
			st_name = scan.nextLine();
			System.out.print("학기 : ");
			st_semester = scan.nextInt();
			scan.nextLine();
			System.out.print("재학, 휴학 : ");
			st_state = scan.nextLine();
			System.out.print("지도교수번호 : ");
			st_pr_num = scan.nextLine();
			insertStudent(con, st_num, st_name, st_semester, st_state, st_pr_num);
			printBar();
			break;
		case 2:
			// 검색 조회는 완성못함.
			System.out.println("-검색 학번 입력-");
			System.out.print("학번 : ");
			st_num = scan.nextLine();
			list = selectAllStudent(con);
			
			//list안에 입력 받은 st_num이 있는지만 확인하면 되는데, 
			boolean index = list.contains(st_num);

			if(index == true) {
				System.out.println(list);
			} else {
				System.out.println("결과 값이 존재하지 않습니다.");
			}
			

		

			printBar();
			break;
		case 3:
			System.out.println("프로그램 종료");
			printBar();
			break;
		default: 
			System.out.println("잘못된 메뉴 선택");
			printBar();
		}	
	}
	
	private static ArrayList<Student1> selectAllStudent(Connection con) throws SQLException {
		String sql = "select st_num, st_name, st_semester, st_state, st_pr_num from student";
		rs = stmt.executeQuery(sql);
		ArrayList<Student1> list = new ArrayList<Student1>();
		
		while(rs.next()) {
			String st_num = rs.getString(1);
			String st_name = rs.getString(2);
			int st_semester = rs.getInt(3);
			String st_state = rs.getString(4);
			String st_pr_num = rs.getString(5);
			System.out.println(st_num + ", " + st_name + ", " + st_semester + ", " 
								+ st_state + ", " + st_pr_num);
			Student1 std = new Student1(st_num, st_name, st_semester, st_state, st_pr_num);
			list.add(std);
		}
		return list;
	}

	private static void insertStudent(Connection con, String st_num, String st_name, 
						int st_semester, String st_state, String st_pr_num) throws SQLException {
		String sql = "insert into student(st_num, st_name, st_semester, "+
				"st_state, st_pr_num) values(?, ?, ?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, st_num);
		pstmt.setString(2, st_name);
		pstmt.setInt(3, st_semester);
		pstmt.setString(4, st_state);
		pstmt.setString(5, st_pr_num);
		
		int count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("[추가 실패]");
		} else {
			System.out.println("[추가 성공]");
		}
		
	}

	private static void printBar() {
		System.out.println("---------------------");
	}
	
	private static void printMenu() {
		System.out.println(" 메 뉴 ");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종 료 ");
		System.out.print("메뉴 선택 : ");	
	}
	
	public static Connection connect(String url, String id, String pw) {
		Connection con = null;
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, id, pw);
            System.out.println("연결 성공");

        } catch (ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        } catch (SQLException e){
            System.out.println("에러: " + e);
        }
		return con;
	}

	public static void connectClose(Connection con) {
        try{
            if( con != null && !con.isClosed()){
                con.close();
                System.out.println("[연결 해제]");
            }
        } catch ( SQLException e){
        	e.printStackTrace();
        }
	}
}
