package gui.user;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.user.CustomUI;

public class MainT {

	private JFrame frame = new JFrame();
	private JPanel backgroundPanel;
	private JButton btnMovie, btnTheater, btnList, btnInfo, btnLogout;
	private String userId;
	
	public MainT(String userId) {
		this.userId = userId;
		init();
		
		frame.setSize(700, 779);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private void init() {
		backgroundPanel = new JPanel();
		frame.setContentPane(backgroundPanel);
		frame.setTitle("키오스크");

		CustomUI custom = new CustomUI(backgroundPanel);
		custom.setPanel();
		
		btnMovie = custom.setBtnImg("btnMovie", "불고기버거", 33, 240);
		btnTheater = custom.setBtnImg("btnTheater", "콜라", 212, 240);
		btnList = custom.setBtnImg("btnList", "감자튀김", 33, 400);
		btnInfo = custom.setBtnImg("btnInfo", "콘샐러드", 212, 400);
		btnLogout = custom.setBtnWhite("btnLogout", "주문", 650);
	}
}

