package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.mysql.jdbc.UpdatableResultSet;

import jdk.nashorn.internal.objects.annotations.Where;

public class LabB {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://55fea50417850.sh.cdb.myqcloud.com:8354";
		
//		String USER_NAME = "1352834";
//		String USER_PASSWORD = "4ccstu5x";
		String USER_NAME = "xiaoyu";
		String USER_PASSWORD = "wangzeyuwoaini";
		
		Connection conn = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
			Statement stmt = conn.createStatement();
			if (conn != null) {
				System.out.println("ok");
				
//				String sql = "UPDATE t_fruit Set country = 'USA' Where country = 'china'"; 
//				int i = stmt.executeUpdate(sql);
			}
		} catch (ClassNotFoundException e) {
			// : handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
//				stmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
	}

}
