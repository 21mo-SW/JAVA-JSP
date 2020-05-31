package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
<<<<<<< HEAD
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "movie", "theater");
=======
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##theater", "movie");
>>>>>>> 22a8a26df6a60d74416eefecfbbe9f245d61659a
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.50:1521:xe", "movie", "theater");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}