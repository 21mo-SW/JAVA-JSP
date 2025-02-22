package ch11; 	

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//589p예제
public class JComponentEx extends JFrame {
	
	private JButton b1,b2,b3;
	
	public JComponentEx() {
		setTitle("JComponent의 공통 메소드 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		b1 = new JButton("Magenta/Yellow Button");
		b2 = new JButton("   Disabled Button  ");
		b3 = new JButton("getX(), getY()");
		
		b1.setBackground(Color.YELLOW); //배경
		b2.setForeground(Color.MAGENTA); //포그라운드
		b3.setFont(new Font("Arial", Font.ITALIC,20));
		b2.setEnabled(false); //버튼 비활성화
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JButton b = (JButton)e.getSource(); //Object를 리턴하기 때문에 다운캐스팅
				b3.setText("안녕");
			}
		});
		c.add(b1);
		c.add(b2);
		c.add(b3);
		setSize(260,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JComponentEx();
	}

}
