package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEx01 {

	public static void main(String[] args) {
		try {
			final String SQL = "select id, name, email, password from users where id = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##ssar", "bitc5600");
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,2);
			//버퍼에쓰기(ResultSet을 리턴받음)
			ResultSet rs = 
					pstmt.executeQuery();
			Users users = null;
			if(rs.next()) {
				users = new Users(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("password"));
			}
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getString("password"));
			System.out.println("Select 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
