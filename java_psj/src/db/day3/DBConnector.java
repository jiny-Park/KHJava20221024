package db.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.Data;

@Data
public class DBConnector {
	public Connection con;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	public DBConnector(String url, String id, String pw) {
		try {
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
		} catch (SQLException e) {	
			System.out.println("[ DB 연결 실패 ]");
			e.printStackTrace(); // -> 에러 원인 찾기 위해. 필요없다면 주석 처리 가능.
		}
	}
	
	public void close() {
		try {
			if(con != null && !con.isClosed())
				con.close();
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			if(pstmt != null && !pstmt.isClosed())
				pstmt.close();
			if(rs != null && !rs.isClosed())
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
