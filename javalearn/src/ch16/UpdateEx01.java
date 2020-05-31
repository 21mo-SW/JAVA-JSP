package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateEx01 {

	public static void main(String[] args) {
		try {
			final String SQL = "update users set password = ? where id = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##ssar", "bitc5600");
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,"5678");
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			System.out.println("update ¿Ï·á");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
