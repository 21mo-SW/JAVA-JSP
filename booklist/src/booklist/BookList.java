package booklist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookList {
	Connection con;  //멤버변수
	Statement stmt;	 //멤버변수
	ResultSet rs;	 //멤버변수
	
	//멤버변수
	//1.변수
//	int bookid;
//	String bookname;
//	String publisher;
//	int price;
	
	//2.배열
//	int bookid_arr[] = new int[11];
//	String bookname_arr[] = new String[11];
//	String publisher_arr[] = new String[11];
//	int price_arr[] = new int[11];
	//3.객체
	//4.객체배열
	
	public BookList() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		/*11g express edition은 orcl 대신 XE를 입력한다. */
		String userid = "c##madang";
		String pwd = "c##madang";
		
		try { //드라이버를 찾는 과정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try { //데이터베이스를 연결하는 과정
			System.out.println("데이터베이스 연결 준비...");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (Exception e) {
			
		}
	}
	
	void printBook() {
		String query = "SELECT * FROM BOOK"; //SQL문
		try { //데이터베이스에 질의 결과를 가져오는 과정
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("BOOK NO \tBOOK NAME \t\tPUBLISHER \tPRICE");
			while(rs.next()) 
			{
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.println("\t" + rs.getInt(4));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BookList so = new BookList();
		so.printBook();
	}

}
