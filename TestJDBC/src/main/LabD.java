package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.PreparedStatement;

public class LabD {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://10.60.42.66/stu_1352834";
		
		String USER_NAME = "1352834";
		String USER_PASSWORD = "4ccstu5x";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
			if (conn != null) {
				System.out.println("ok");
			}
			String sql = "UPDATE t_fruit set price = ? where country = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, 110);
			pstmt.setString(2, "USA");
			pstmt.executeUpdate();
			
//			pstmt.setFloat(1, 20);
//			pstmt.setString(2, "USaA");
//			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
	}

}
