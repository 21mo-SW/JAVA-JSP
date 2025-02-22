package gui.user;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SelectDate {
	private JFrame frame = new JFrame();
	private JPanel backgroundPanel;	// 원본소스에서는 gui.user 패키지의 모든 클래스에 backgroundPanel을 멤버 필드로
						// 넣어주고 있는데 유독 SelectDate 클래스만 빠뜨리고 있음. 실수인 듯!
	private JLabel lbTitle, lbDayNames[], lbDay;
	private JButton btnBack;
	
	private MouseListener listener;
	
	private String userId, beforePage;
	private int placeId;
	
	public SelectDate(String userId, int placeId, String beforePage) {
		this.userId = userId;
		this.placeId = placeId;
		this.beforePage = beforePage;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		listener = new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() instanceof JLabel) {
					JLabel lb = (JLabel)e.getSource();
					// 테이블 내의 영화 상영일자는 대충 2019년 10월경이므로 오늘 날짜도 그때인 것처럼 해야 함
					// int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
					Calendar c = Calendar.getInstance();
					c.set(2019,10-1,15);
					int today = c.get(Calendar.DAY_OF_MONTH);
					
					int selectDay = Integer.parseInt(lb.getText());
					
					if(today > selectDay) {
						JOptionPane.showMessageDialog(frame, "이전 일자는 선택할 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					} else {
						String reserveDate = lbTitle.getText().substring(0, 4) + "-" + lbTitle.getText().substring(6, 8) + "-" + lb.getText();

						if(beforePage.equals("Movie")) {
							new SelectMovie1(userId, reserveDate);
							frame.dispose();
						} else {
							new SelectTheater2(userId, placeId, reserveDate);
							frame.dispose();
						}
					}
				}
			}
		};
				
		init();
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(beforePage.equals("Movie")) {
					new Main(userId);
					frame.dispose();
				} else {
					new SelectTheater1(userId);
					frame.dispose();
				}
			}
		});
		
		frame.setSize(426, 779);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private void init() {
		backgroundPanel = new JPanel();
		frame.setContentPane(backgroundPanel);
		frame.setTitle("영화 예매 프로그램 ver1.0");

		CustomUI custom = new CustomUI(backgroundPanel);
		custom.setPanel();
		
		Calendar current = Calendar.getInstance();
		// 원래 코드에는 아래 한줄이 없지만 시스템의 현재 날짜로(2020-05-01)는 영화 예매가 불가능하다
		// 이 프로그램과 DB에는 2019년 10월 경의 영화 상영일을 예정하고 데이터가 들어있기 때문임
		// 그래서 아래 한줄로 현재 날짜를 마치 2019년 10월 15일인 것처럼 설정함
		current.set(2019,10-1,15);
		
		int year = current.get(Calendar.YEAR);
		int month = current.get(Calendar.MONTH);
		int day = current.get(Calendar.DAY_OF_MONTH);
		
		String dayNames[] = {"일", "월", "화", "수", "목", "금", "토"};
		
        lbTitle = custom.setLb("lbTitle", year + "년 " + (month+1) + "월", 100, 85, 220, 185, "center", 20, "bold");

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		Calendar iterator = (Calendar) calendar.clone();
		iterator.add(Calendar.DAY_OF_MONTH, -(iterator.get(Calendar.DAY_OF_WEEK) - 1));

		Calendar maximum = (Calendar) calendar.clone();
		maximum.add(Calendar.MONTH, +1);

		lbDayNames = new JLabel[dayNames.length];
		int moveX = 0;
		for (int i = 0; i < dayNames.length; i++) {
			lbDayNames[i] = custom.setLb("lbDayNames", dayNames[i], 50 + moveX, 210, 35, 30, "center", 20, "bold");
			backgroundPanel.add(lbDayNames[i]);
			moveX += 50;
		}
		
		moveX = 0;
		int moveY = 0;
		while (iterator.getTimeInMillis() < maximum.getTimeInMillis()) {
			int iMonth = iterator.get(Calendar.MONTH);
			int iYear = iterator.get(Calendar.YEAR);

			if(50+moveX > 380) {
				moveY += 50;
				moveX = 0;
			}

			lbDay = custom.setLb("lbDay"+iterator.getTimeInMillis(), "", 50 + moveX, 260 + moveY, 35, 30, "center", 20, "bold");
			
			if ((year == iYear) && (month == iMonth)) {
				int iDay = iterator.get(Calendar.DAY_OF_MONTH);
				lbDay.setText(Integer.toString(iDay));
				
				if(day == iDay) {
					lbDay.setForeground(Color.ORANGE);
				}
				
				if(day > iDay) {
					lbDay.setForeground(Color.LIGHT_GRAY);
				}

				lbDay.addMouseListener(listener);
			}

			backgroundPanel.add(lbDay);
			iterator.add(Calendar.DAY_OF_YEAR, +1);
			moveX += 50;
		}
		
		btnBack = custom.setBtnWhite("btnBack", "이전으로", 655);
	}
}
