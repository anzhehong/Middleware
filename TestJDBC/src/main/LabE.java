package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LabE {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://10.60.42.66/stu_1352834";
		
		String USER_NAME = "1352834";
		String USER_PASSWORD = "4ccstu5x";
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
			if (conn != null) {
				System.out.println("ok");
			}
			String sql = "{call count_fruit_per_country(?,?)}";

			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "USA");
			cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
			cstmt.execute();
			
			System.out.println(cstmt.getInt(2));
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
	}

}
