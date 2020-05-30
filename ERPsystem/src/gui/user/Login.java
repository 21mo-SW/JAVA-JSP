package gui.user;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.DBconnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;

public class Login  {
	private JFrame frame = new JFrame();
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static final String SQL = "INSERT INTO USERS (ID, USER_ID, PASSWORD) VALUES (USER_SEQ.NEXTVAL, ?, ?)";
	private static final String SQL2 = "SELECT * FROM USERS WHERE USER_ID = ? AND PASSWORD = ?";
	
	public Login() {
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(90, 42, 86, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 92, 116, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setBounds(30, 139, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBounds(142, 139, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId = textField.getText();
				String password = String.valueOf(textField_1.getText());
				
				conn = DBconnection.getConnection();
				
				try {
					pstmt = conn.prepareStatement(SQL2);
					pstmt.setString(1, userId);
					pstmt.setString(2, password);
					rs = pstmt.executeQuery();
					System.out.println(SQL2);
					System.out.println(userId);
					System.out.println(password);
					
					if (rs.next()) {
						if(rs.getString("PASSWORD").equals("user")) {	
							new gui.user.KioskTest1(); 
							System.out.println("로그인 성공");
						} else {
							System.out.println("로그인 실패");
						}
					}

					
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId = textField.getText();
				String password = String.valueOf(textField_1.getText());
				
				conn = DBconnection.getConnection();
				
				int returnCnt = 0;
				try {
					pstmt = conn.prepareStatement(SQL);
					pstmt.setString(1, userId);
					pstmt.setString(2, password);
					System.out.println(SQL);
					System.out.println(userId);
					System.out.println(password);

					returnCnt = pstmt.executeUpdate();
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
	

	public static void main(String[] args) {
		new Login();
	}
}
