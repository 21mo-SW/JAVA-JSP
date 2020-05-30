package dateex;

import java.util.Calendar;

public class CalendarEx {
	
	public static void printCalendar(String msg, Calendar cal) {
		int year = cal.get(Calendar.YEAR); //2020
		int month = cal.get(Calendar.MONTH);
		String mon = (month < 10)? "0" + month: "" + month; // if문을 사용해도되고 이처럼 삼항연산자를 써도된다.
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.print(year +"-" + mon + "-" + day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR);
		int ampm = cal.get(Calendar.AM_PM);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millisecond = cal.get(Calendar.MILLISECOND);
		
		if(ampm == Calendar.AM) {
			System.out.print("오전");
		}else {
			System.out.print("오후");
		}
		System.out.println(hour + "시 " + minute + "분 " + second + "초");
	}

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance(); //싱글톤
		printCalendar("현재", now);
	}

}
