package booklist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerList {
	Connection con; // 멤버변수

	public CustomerList() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		/* 11g express edition은 orcl 대신 XE를 입력한다. */
		String userid = "c##madang";
		String pwd = "c##madang";

		try { // 드라이버를 찾는 과정 - 파일 입출력
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try { // 데이터베이스를 연결하는 과정 - 네트워크 입출력
			System.out.println("데이터베이스 연결 준비...");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (Exception e) {

		}
	}

	private void sqlRun() {
		String query = "SELECT NAME, ADDRESS\r\n" + "FROM CUSTOMER CS \r\n" + "WHERE EXISTS (SELECT *\r\n"
				+ "              FROM ORDERS OD\r\n" + "              WHERE CS.CUSTID = OD.CUSTID)"; // SQL문
		try { // 데이터베이스에 질의 결과를 가져오는 과정
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("\tNAME\tAREA");
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.println("\t" + rs.getString(2));
				// System.out.print("\t" + rs.getString(3));
				// System.out.println("\t" + rs.getString(4));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CustomerList so = new CustomerList();
		so.sqlRun();
	}

}
