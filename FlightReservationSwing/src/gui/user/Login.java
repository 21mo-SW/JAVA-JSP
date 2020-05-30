package gui.user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.DBConnection;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private JTextField tfUserId;
	private JPasswordField pwPassword;
	
	public Login() {
		getContentPane().setLayout(null);
		
		JLabel lbLogo = new JLabel("New label");
		lbLogo.setBounds(119, 12, 324, 116);
		getContentPane().add(lbLogo);
		
		tfUserId = new JTextField();
		tfUserId.setBounds(191, 152, 211, 33);
		getContentPane().add(tfUserId);
		tfUserId.setColumns(10);
		
		pwPassword = new JPasswordField();
		pwPassword.setBounds(191, 197, 211, 32);
		getContentPane().add(pwPassword);
		
		JButton btnLogin = new JButton("로 그 인");
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId = tfUserId.getText();
				// JPasswordField의 getPassword()는 char[] 타입으로 문자열 반환하고
				// String.valueOf()는 char[] 타입 매개값을 String 타입 문자열로 바꿔 반환함
				String password = String.valueOf(pwPassword.getPassword());
				
				
				Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt;
				ResultSet rs;
				
				try {
					final String SQL = "SELECT * FROM USERS WHERE USERID = ? AND PASSWORD = ?";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setString(1, userId);
					pstmt.setString(2, password);
					rs = pstmt.executeQuery();
					System.out.println(rs);
					System.out.println(SQL);
					System.out.println(userId);
					System.out.println(password);

					// rs.next()가 true인 것은 해당 아이디와 비밀번호의 사용자가 Users 테이블에 존재한다는 것!
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "성공");
					} else {	
						JOptionPane.showMessageDialog(Login.this, "일치하는 사용자가 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(Login.this, "인증되지 않았습니다.");	// 주로 데이터베이스 연결이 안되었을 경우
				}
			}
		});
		btnLogin.setBounds(191, 241, 211, 33);
		getContentPane().add(btnLogin);
		
		JButton btnSignup = new JButton("회 원 가 입");
		btnSignup.setBounds(191, 286, 211, 33);
		getContentPane().add(btnSignup);
		
		setSize(600,500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Login();
	}
}
