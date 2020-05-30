package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertEx01 {

	public static void main(String[] args) {
		try {
			final String SQL = "insert into USERS(id, name, email, password) values(?,?,?,?)";
			Class.forName("oracle.jdbc.driver.OracleDriver");  //Class.forName은 new해서 메모리에 올리는것이랑 같다. 즉 클래스 로드
			//드라이버매니저는 자바에서의 주소를 찾을 수 있는 클래스이기에 오라클 주소만 입력해주면된다. 겟커넥션은 conn에 값을 리턴해준다.
			//또한 드라이버매니저는 DB와 연결된 모든 heap들을 관리한다.
			//jdbc: 뒤에있는 oracle은 사용하는 DBMS에 따라 명칭이 달리질수 있다.
			//thin은 자바가 들고있는 API로 연결한다는 것이고 oci가 들어가면 운영체제가 들고있는 라이브러리로 통해서 연결한다는 것이다.
			//XE는 리스너가 들고 있는 이름으로 리스너 파일에서 명칭을 바꿔주면 바꿔준 명칭을 입력해주면된다.
			//스트림연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##ssar", "bitc5600");
			//버퍼 달기 (?를 사용하게 해준다.)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			//자바는 index가 0부터시작하지만 DB는 index가 1부터시작
			pstmt.setInt(1,4);
			pstmt.setString(2, "강동원");
			pstmt.setString(3, "dongwon@nate.com");
			pstmt.setString(4, "1234");
			
			//버퍼에 쓰기 (업데이트는 내부적으로 commit이 달려있다.)
			//execute는 select할때만 사용하고 insert,delete,update는 executeUpdate를 써준다.
			pstmt.executeUpdate();
			System.out.println("insert 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
