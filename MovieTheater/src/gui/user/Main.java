package gui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main extends CustomUI{

	private JFrame frame = new JFrame();
	private JPanel backgroundPanel;
	private JButton btnMovie, btnTheater, btnList, btnInfo, btnLogout;
	
	private String userId;

	public Main(String userId) {
		this.userId = userId;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();

		btnMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectDate(userId, 0, "Movie");	// 영화별 예매 클릭시 띄우는 새창
				frame.dispose();	// 기존창 닫기
			}
		});
		
		btnTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectTheater1(userId);	// 상영관별 예매 클릭시 띄우는 새창
				frame.dispose();	// 기존창 닫기
			}
		});
		
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookingList(userId);	// 예매확인 클릭시 띄우는 새창
				frame.dispose();	// 기존창 닫기
			}
		});
		
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserInfo(userId);	// 내 정보 보기 클릭시 띄우는 새창
				frame.dispose();	// 기존창 닫기
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frame.dispose();	// 기존창 닫기
			}
		});

		frame.setSize(426, 779);
		frame.setResizable(false);
		frame.setVisible(true);
		
		// 원본 소스에 없던 코드임. Main도 CustomUI를 상속받도록 한 원본소스에 의하면
		// Main 창도 화면에 독립적으로 띄울 수 있음을 보여주기 위함
		// this.setSize(1000, 500);
		// this.setVisible(true);
	}

	private void init() {
		backgroundPanel = new JPanel();
		frame.setContentPane(backgroundPanel);
		frame.setTitle("영화 예매 프로그램 ver1.0");

		CustomUI custom = new CustomUI(backgroundPanel);
		custom.setPanel();
		
		// 일반 사용자로 로그인 직후에 뜨는 메인 화면 중앙에 배치되는 버튼들임
		btnMovie = custom.setBtnImg("btnMovie", "영화별 예매", 33, 240);
		btnTheater = custom.setBtnImg("btnTheater", "상영관별 예매", 212, 240);
		btnList = custom.setBtnImg("btnList", "예매 확인", 33, 400);
		btnInfo = custom.setBtnImg("btnInfo", "내 정보 보기", 212, 400);
		// 화면 하단의 로그아웃 버튼
		btnLogout = custom.setBtnWhite("btnLogout", "로그아웃", 650);
	}
}