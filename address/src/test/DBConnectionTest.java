package test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBConnectionTest {
	
	@Test
	public void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##ssar", "bitc5600");
			
			
		} catch (Exception e) {
			System.out.println("DB 연결 실패:" + e.getMessage());
		}
	
	}
}
