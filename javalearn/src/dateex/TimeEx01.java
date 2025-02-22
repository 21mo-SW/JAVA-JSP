package dateex;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

//구버전 자바 1.7이하
//java.sql.Date 
//java.sql.Time (x)
//java.sql.Timestamp
//java.sql.Calendar (x)
//java.util.Date

//신버전 자바 1.8이상
//java.time.LocalDate
//java.time.LocalDateTime
//java.time.LocalTime

public class TimeEx01 {
	
	public static void main(String[] args) {
		//Calendar 잘안씀
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today = formater.format(cal.getTime());
		System.out.println("cal.getTime():" + cal.getTime());
		System.out.println("today:" + today);
		
		//2.java.util.Date 잘안씀 1970.01.01 기준으로 해서 경과된 밀리초를 계산
		Date time2 = new Date();
		System.out.println("time2:" + time2);
		System.out.println("time2.getTime():" + time2.getTime());
		String today2 = formater.format(time2);
		System.out.println("today2:" + today2);
		
		//3.java.sql.Date 잘안씀.
		java.sql.Date time3 = new java.sql.Date(24*3600*1000);
		System.out.println("time3:" + time3);
		
		//4.java.sql.Timestamp 많이 씀. (타임스탬프타입은 자바와 DB 둘다 가지고 있는 타입.)
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = new Date();
		String timestamp = sf.format(d.getTime());
		Timestamp ts = Timestamp.valueOf(timestamp);
		System.out.println("ts:" + ts);
		
		//5.Localdate - LocalDate to Timestamp  (DB는 들고있지않고 자바만 들고있다.)
		Timestamp nowDate = Timestamp.valueOf(LocalDateTime.now());
		System.out.println("nowDate:" + nowDate);
		
		//6.LocalDateTime - Timestamp to LocaldateTime
		LocalDateTime ldt = nowDate.toLocalDateTime();
		System.out.println("ldt:" + ldt);
		System.out.println("LocalDateTime:" + LocalDateTime.now());
		System.out.println("LocalDate:" + LocalDate.now());
		System.out.println("LocalTime:" + LocalTime.now());
	}

}
