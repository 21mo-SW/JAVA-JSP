package dateex;

import java.util.Calendar;

public class CalendarEx {
	
	public static void printCalendar(String msg, Calendar cal) {
		int year = cal.get(Calendar.YEAR); //2020
		int month = cal.get(Calendar.MONTH);
		String mon = (month < 10)? "0" + month: "" + month; // if���� ����ص��ǰ� ��ó�� ���׿����ڸ� �ᵵ�ȴ�.
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.print(year +"-" + mon + "-" + day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR);
		int ampm = cal.get(Calendar.AM_PM);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millisecond = cal.get(Calendar.MILLISECOND);
		
		if(ampm == Calendar.AM) {
			System.out.print("����");
		}else {
			System.out.print("����");
		}
		System.out.println(hour + "�� " + minute + "�� " + second + "��");
	}

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance(); //�̱���
		printCalendar("����", now);
	}

}
