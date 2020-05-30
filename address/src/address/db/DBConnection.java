package address.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBConnection {
	
	@Test
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##ssar", "bitc5600");
			return conn;
			
		} catch (Exception e) {
			System.out.println("DB 연결 실패:" + e.getMessage());
		}
		return null;
	}
}
