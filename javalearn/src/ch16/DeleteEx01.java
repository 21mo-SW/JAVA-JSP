package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteEx01 {

	public static void main(String[] args) {
		try {
			final String SQL = "delete from users where id = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##ssar", "bitc5600");
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,1);
			pstmt.executeUpdate();
			System.out.println("delete ¿Ï·á");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
