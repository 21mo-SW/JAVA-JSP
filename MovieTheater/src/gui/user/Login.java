package gui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.DBConnection;

@SuppressWarnings("serial")
public class Login {

	private JFrame frame = new JFrame();
	private JPanel backgroundPanel;
	private JTextField txtUserId;
	private JPasswordField txtPassword;
	private JButton btnLogin, btnJoin;
	private JLabel lbLogo, lbSearch;

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static final String SQL = "SELECT * FROM USERS WHERE USER_ID = ? AND PASSWORD = ? AND DEL_FG = 'N'";

	public Login() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		
		
		// MouseListener 대신 MouseAdapter를 사용하는 게 나을 듯!
		// 아이디찾기/비밀번호찾기 라벨 위에서 마우스 클릭시
		lbSearch.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "관리자에게 문의하세요.", "오류", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		/*	원래의 이 소스보다는 ActionListener를 이용하는 저 아래의 것이 간단함
		txtPassword.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
			public void keyPressed(KeyEvent e) {}
		});
		*/
		
		/*
		액션 이벤트가 발생하는 경우 세가지
			- 사용자가 button 클릭시
			- menu item, 콤보 박스 아이템 선택시
			- TextField에서 엔터키 입력시
		
		위 세 경우에는 해당 컴포넌트에 등록된 ActionListener 구현 객체에게 actionPerformed 메세지가 보내진다.
		아래 경우에는 JPasswordField는 TextField에 해당하므로 엔터키 입력시에 액션 이벤트 발생하고 등록된 객체의 acitonPerformed가 실행된다.
		*/
		// 암호  입력 텍스트필드에서 엔터키 입력시
		txtPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogin.doClick();
			}
		});
		
		// 로그인 버튼 클릭시
		// button 클릭시에 액션 이벤트 발생하고 등록된 ActionListener 구현 객체의 actionPerformed() 실행됨
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId = txtUserId.getText();
				// JPasswordField의 getPassword()는 char[] 타입으로 문자열 반환하고
				// String.valueOf()는 char[] 타입 매개값을 String 타입 문자열로 바꿔 반환함
				String password = String.valueOf(txtPassword.getPassword());
				
				conn = DBConnection.getConnection();
				
				try {
					pstmt = conn.prepareStatement(SQL);
					pstmt.setString(1, userId);
					pstmt.setString(2, password);
					rs = pstmt.executeQuery();
					System.out.println(SQL);
					System.out.println(userId);
					System.out.println(password);

					// rs.next()가 true인 것은 해당 아이디와 비밀번호의 사용자가 Users 테이블에 존재한다는 것!
					if (rs.next()) {
						// 아래 if문은 해당 사용자가 관리자인 경우와 그외 일반 사용자인 경우에 로그인 후 각기 다른 창을 보여준다.
						if(rs.getString("ADMIN_FG").equals("Y")) {	// 해당 사용자가 관리자인 경우
							new gui.admin.Main(); // 관리자용 새창 띄우고
							frame.dispose();	 // 현재창 닫기
						} else {
							new Main(userId);	//  일반 사용자용 새창 띄우고
							frame.dispose();	// 현재창 닫기
						}
					} else {	// 해당 아이디 비번으로 Users 테이블에 사용자가 없는 경우
						JOptionPane.showMessageDialog(frame, "일치하는 사용자가 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(frame, "인증되지 않았습니다.");	// 주로 데이터베이스 연결이 안되었을 경우
				}
			}
		});
		
		// 회원가입 버튼 클릭시
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Join();			// 회원가입창 열고
				frame.dispose();	// 현재창 닫기
			}
		});

		// MouseListener 대신 MouseAdapter를 사용하는 게 나을 듯!
		// 프레임창 위에서 마우스 클릭시
		frame.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				frame.requestFocus();	// TextField나 Button 등을 제외한 Frame의 나머지 부분을 클릭시
			}							// 포커스가 frame에 가도록 함. 이것 호출 직후 탭키를 누를 시 첫번째 컴포넌트에 포커스가 이동
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
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
		
		// 아래 컴포넌트들을 패널이나 프레임에 올리는 코드는 어디에?
		// 바로 custom의 setLbImg(), setTextField(), setBtnBlue() 등 메서드 내에
		// backgroundPanel.add(xx) 메서드가 실행됨으로써 해당 객체가 backgroundPanel 객체에 올려진다.
		lbLogo = custom.setLbImg("lbLogo", 4, 150, 150);	// gui 첫화면 상단에 보이는 로고
		txtUserId = custom.setTextField("txtUserId", "ID", 35, 290, 350, 45);
		txtPassword = custom.setPasswordField("txtPassword", "Password", 35, 345, 350, 45);
		btnLogin = custom.setBtnBlue("btnLogin", "로그인", 425);
		btnJoin = custom.setBtnWhite("btnJoin", "회원가입", 480);
		lbSearch = custom.setLb("lbSearch", "아이디 찾기 ｜ 비밀번호 찾기", 100, 535, 200, 40, "center", 15, "plain");
	}

	public static void main(String[] args) {
		new Login();	// 실행시 뜨는 첫화면
	}
}