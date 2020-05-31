package gui.user;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;

public class KioskTest1 extends JFrame {
	
	private JButton btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3;
	private JTextArea textArea;
	private JTextField textField;
	
	public KioskTest1() {
		getContentPane().setLayout(null);
		
		btnNewButton = new JButton("불고기버거");
		btnNewButton.setBounds(32, 50, 137, 163);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("감자튀김");
		btnNewButton_1.setBounds(181, 50, 137, 163);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("콜라");
		btnNewButton_2.setBounds(32, 271, 137, 163);
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("콘샐러드");
		btnNewButton_3.setBounds(181, 271, 137, 163);
		getContentPane().add(btnNewButton_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(345, 51, 137, 194);
		textArea.setEditable(false);
		getContentPane().add(textArea);
		
		JButton btnNewButton_4 = new JButton("주문하기");
		btnNewButton_4.setBounds(12, 472, 321, 51);
		getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("총 구매금액 :");
		lblNewLabel.setBounds(345, 490, 83, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(430, 487, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton.getText().equals("불고기버거")) {
					textArea.append("불고기버거\n");
					textField.setText("3000");
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_1.getText().equals("감자튀김")) {
					textArea.append("감자튀김\n");
				}
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_2.getText().equals("콜라")) {
					textArea.append("콜라\n");
				}
			}
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_3.getText().equals("콘샐러드")) {
					textArea.append("콘샐러드\n");
				}
			}
		});
		
	}
}
