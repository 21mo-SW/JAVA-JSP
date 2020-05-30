package lotteporject.test;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class KioskTest1 extends JFrame {
	
	private JTextArea textArea;
	
	public KioskTest1() {
		getContentPane().setLayout(null);
		Object o = getContentPane();
		System.out.println(o.getClass().getName());
		
		JButton btnNewButton = new JButton("불고기버거");
		btnNewButton.setBounds(32, 50, 137, 163);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("감자튀김");
		btnNewButton_1.setBounds(181, 50, 137, 163);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("콜라");
		btnNewButton_2.setBounds(32, 271, 137, 163);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("콘샐러드");
		btnNewButton_3.setBounds(181, 271, 137, 163);
		getContentPane().add(btnNewButton_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(345, 51, 201, 383);
		getContentPane().add(textArea);
		
		JButton btnNewButton_4 = new JButton("주문하기");
		btnNewButton_4.setBounds(12, 472, 321, 51);
		getContentPane().add(btnNewButton_4);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton.getText().equals("불고기버거")) {
					textArea.append("불고기버거\n");
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

	
	
//	public static void main(String[] args) {
//		new KioskTest1();
//	}
}
