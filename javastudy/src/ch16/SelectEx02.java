package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SelectEx02 {

	public static void main(String[] args) {
		try {
			final String SQL = "select id, name, email, password from users";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##ssar", "bitc5600");
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			//버퍼에쓰기(ResultSet을 리턴받음)
			ResultSet rs = pstmt.executeQuery();
			List<Users> users = new ArrayList<>();
			while(rs.next()) {
				Users user = new Users(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("password"));
				users.add(user);
			}
			
			for (Users user : users) {
				System.out.println(user.getId());
				System.out.println(user.getName());
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				System.out.println();
			}
			
			System.out.println("Select 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
