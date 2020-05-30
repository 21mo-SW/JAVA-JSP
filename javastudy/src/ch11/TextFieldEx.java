package ch11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFieldEx extends JFrame {

	private JTextField tf;
	private JTextArea ta;
	private ScrollPane sp;    //스크롤패인과 제이스크롤패인이 있는데 제이스크롤패인은 색깔을 잡아먹어서 지양
	
	public TextFieldEx() {
		setTitle("텍스트 에디터, 텍스트 박스 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		tf = new JTextField("", 20);

		// 텍스트필드 디자인
		tf.setFont(new Font("Arial", Font.BOLD, 30));
		tf.setPreferredSize(new Dimension(100, 50)); // 입력창 높이 조절

		sp = new ScrollPane();
		
		ta = new JTextArea("", 5, 20);
		ta.setBackground(Color.WHITE);
		
		ta.setEnabled(false);
		ta.setFont(new Font("Arial", Font.BOLD, 30));
		
		sp.add(ta);
		ta.setForeground(Color.BLACK);

		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String value = tf.getText();
					ta.append(value+"\n");
					tf.setText(""); //입력후 초기화
				}
			}
		});
		c.add(tf, BorderLayout.SOUTH);
		c.add(sp, BorderLayout.CENTER);

		setSize(400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextFieldEx();
	}

}
