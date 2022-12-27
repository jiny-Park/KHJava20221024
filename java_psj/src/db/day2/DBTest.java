package db.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lombok.Data;

public class DBTest {
	
	Connection con = null;
	ResultSet rs;
    // Statement : 고정된 쿼리를 사용하고 싶을 때 사용
	Statement stmt;
	PreparedStatement pstmt;


	public static void main(String[] args) {
		DBTest dbTest = new DBTest();
		ArrayList<StudentVO1> list = new ArrayList<StudentVO1>();
		
	    try{     
	        String url = "jdbc:mysql://localhost/university";
	        String id = "root";
	        String pw = "root";
	        dbTest.connect(url, id, pw);

	        StudentDAOImp studentDao = new StudentDAOImp(dbTest.con);
	       
	        list = studentDao.selectAllStudent();
	        // 조회 기능
//	        System.out.println(studentDao.selectStudentBySt_num("2022160002"));
	        
	        // 추가 기능
//	        StudentVO1 std = new StudentVO1("2022160001", "홍홍홍", 3, "휴학", "2022160001");
//	        if(studentDao.insertStudent(std)) {
//	        	System.out.println("추가 성공");
//	        } else {
//	        	System.out.println("추가 실패");
//	        }
	        
	        // 삭제 기능
//	        if(studentDao.deleteStudent("2022160002")) {
//	        	System.out.println("삭제 성공");
//	        } else {
//	        	System.out.println("삭제 실패");
//	        }
	        
	        // 수정 기능
	        if(studentDao.updateStudent("2022160001", "Monster")) {
        	System.out.println("수정 성공");
	        } else {
        	System.out.println("수정 실패");
	        }
	        
	        
	        System.out.println(list);
	        System.out.println("연결 성공");
	    } catch (SQLException e){
	        System.out.println("에러: " + e);
	    } finally {
	    	dbTest.closeConnect();
	    }
	}

	public void connect(String url, String id, String pw) throws SQLException {
		 con = DriverManager.getConnection(url, id, pw);
	     stmt = con.createStatement();
	}
	
	public void closeConnect() {
		try{
            if( con != null && !con.isClosed())
                con.close();
            if( stmt != null && !stmt.isClosed())
            	stmt.close();
            if( rs != null && !rs.isClosed())
                rs.close();
            if( pstmt != null && !pstmt.isClosed())
            	pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}

@Data
class StudentVO1{
		String st_num, st_name, st_state, st_pr_num;
		int st_semester;
		
		public StudentVO1(String st_num, String st_name, int st_semester, String st_state, String st_pr_num) {
			this.st_num = st_num;
			this.st_name = st_name;
			this.st_semester = st_semester;
			this.st_state = st_state;
			this.st_pr_num = st_pr_num;
		}

		@Override
		public String toString() {
			return "[학번: " + st_num + ", 이름: " + st_name + ", 학기: " + st_semester +
					", 상태: " + st_state + ", 지도교수: " + st_pr_num + "]";
		}
		
		
		
		
}










