package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import models.Item;

public class ScheduleDao {
	private ScheduleDao() {}
	private static ScheduleDao instance = new ScheduleDao();
	
	public static ScheduleDao getInstance() {
		return instance;
	}
	
	
	public void bulkInsert(List<Item> allFlights) {
		String sql = "INSERT INTO SCHEDULE VALUES (SCHEDULE_SEQ.NEXTVAL ,?,?,?,?,?,?,?,?)";
		Connection conn = DBConnection.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			for (Item item : allFlights) {
				pstmt.setString(2, item.getAirlineNm());
				pstmt.setString(3, item.getDepAirportNm());
				pstmt.setString(4, item.getArrAirportNm());
				pstmt.setLong(5, item.getDepPlandTime());
				pstmt.setLong(6, item.getArrPlandTime());
				pstmt.setInt(7, item.getEconomyCharge());
				pstmt.setInt(8, item.getPrestigeCharge());
				pstmt.setString(9, item.getVihicleId());
				
				// pstmt.executeUpdate();
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
