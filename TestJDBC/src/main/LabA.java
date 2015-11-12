package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.regexp.internal.recompile;



public class LabA {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://10.60.42.66/stu_1352834";
		
		String USER_NAME = "1352834";
		String USER_PASSWORD = "4ccstu5x";
		
		Connection conn = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
			Statement stmt = conn.createStatement();
			if (conn != null) {
				System.out.println("ok");
				
				String sql = "SELECT fruit_id, name,price,country FROM t_fruit";
				ResultSet rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					int id = rs.getInt("fruit_id");
					String name = rs.getString("name");
					float price = rs.getFloat("price");
					String country = rs.getString("country");
					
					System.out.println("id+name+price+country = " + id + name + price + country);
				}
				
				rs.close();
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
