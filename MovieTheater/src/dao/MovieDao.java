package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import models.Movies;

// 아래 MovieDao 클래스에서는 DB의 Movie 테이블로부터 id, title, price, age, running_time을 읽어와
// Movies 타입 클래스 객체에 각 값을 세팅해 단독으로나 (여러개인 경우 Vector에 담아) 반환하는 형식을 주로 취한다.
// 이때 쓰이는 Movies 클래스는 실제로는 위 5개 필드 외에도 place_id, theater_id, startDate, endDate,
// startTime, placeName, theaterName, seat, screen_id 등의 수많은 필드를 갖고 있다.
// 이 코드 맨 아래의 selectPrice(int id) 메서드의 경우에는 심지어 price 필드 하나만 세팅해서 반환하고 있다.

// ScreenDao 에서도 Movie 클래스를 활용하고 있는데 여기서는 place_id, theater_id, startDate, endDate,
// startTime 등의 필드를 활용하고 있다.

public class MovieDao {
	private MovieDao(){}
	private static MovieDao instance = new MovieDao();
	
	public static MovieDao getInstance() {
		return instance;
	}
	
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public Movies selectOne(int id) {
		String sql = "SELECT * FROM MOVIE WHERE ID = ?";
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			Movies movie = new Movies();
			if (rs.next()) {
				movie.setId(rs.getInt("ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setPrice(rs.getInt("PRICE"));
				movie.setAge(rs.getInt("AGE"));
				movie.setRunningTime(rs.getInt("RUNNING_TIME"));
				conn.close();
				return movie;
			} else {
				conn.close();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Vector<Movies> selectAll() {
		Vector<Movies> movies = new Vector<>();
		String sql = "SELECT * FROM MOVIE";
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Movies movie = new Movies();
				movie.setId(rs.getInt("ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setPrice(rs.getInt("PRICE"));
				movie.setAge(rs.getInt("AGE"));
				movie.setRunningTime(rs.getInt("RUNNING_TIME"));
				movies.add(movie);
			}

			conn.close();

			return movies;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Vector<Movies> selectKeyword(String keyword) {
		Vector<Movies> movies = new Vector<>();
		String sql = "SELECT *";
		sql += " FROM MOVIE";
		sql += " WHERE TITLE LIKE '%" + keyword + "%'";
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Movies movie = new Movies();
				movie.setId(rs.getInt("ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setPrice(rs.getInt("PRICE"));
				movie.setAge(rs.getInt("AGE"));
				movie.setRunningTime(rs.getInt("RUNNING_TIME"));
				movies.add(movie);
			}
			conn.close();
			return movies;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int insert(String title, int price, int age, int running) {
		String sql = "INSERT INTO MOVIE SELECT MOVIE_SEQ.NEXTVAL, ?, ?, ?, ? FROM DUAL ";
		sql += " WHERE NOT EXISTS (SELECT 0 FROM MOVIE WHERE TITLE = ? AND PRICE = ? AND AGE = ? AND RUNNING_TIME = ?)";
		conn = DBConnection.getConnection();

		int returnCnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, price);
			pstmt.setInt(3, age);
			pstmt.setInt(4, running);
			pstmt.setString(5, title);
			pstmt.setInt(6, price);
			pstmt.setInt(7, age);
			pstmt.setInt(8, running);
			returnCnt = pstmt.executeUpdate();
			
			conn.close();

			return returnCnt;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int update(int id, String title, int price, int age, int running) {
		String sql = "UPDATE MOVIE SET TITLE = ?, PRICE = ?, AGE = ?, RUNNING_TIME = ? WHERE ID = ?";
		sql += " AND NOT EXISTS (SELECT 0 FROM SEAT WHERE TITLE = ? AND PRICE = ? AND AGE = ? AND RUNNING_TIME = ?)";
		conn = DBConnection.getConnection();

		int returnCnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, price);
			pstmt.setInt(3, age);
			pstmt.setInt(4, running);
			pstmt.setInt(5, id);
			pstmt.setString(6, title);
			pstmt.setInt(7, price);
			pstmt.setInt(8, age);
			pstmt.setInt(9, running);
			returnCnt = pstmt.executeUpdate();

			conn.close();
			return returnCnt;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int delete(int id) {
		String sql = "DELETE FROM MOVIE WHERE ID = ?";
		conn = DBConnection.getConnection();

		int returnCnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			returnCnt = pstmt.executeUpdate();

			conn.close();
			return returnCnt;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
	
	// Movie 테이블로부터 특정 ID(primary key)값을 갖는 영화의 요금 정보를 갖고옴
	// 이때는 아래 코드에서 생성한 Movies 타입 객체 하나에 price 필드값 하나만 세팅해서 반환함
	public Movies selectPrice(int id) {
		String sql ="SELECT PRICE FROM MOVIE WHERE ID = ?";
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			Movies movie = new Movies();
			if(rs.next()) {
				movie.setPrice(rs.getInt("PRICE"));

				conn.close();
				return movie;
			} else {
				conn.close();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
