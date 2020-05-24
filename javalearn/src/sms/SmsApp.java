package sms;

import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class SmsApp extends JFrame {
	private JTextField jf;
	private JButton jb;
	private JTextArea ja;
	private JLabel jl;

	public SmsApp() {
		setTitle("문자전송 프로젝트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jf = new JTextField();
		jf.setBounds(218, 61, 116, 21);
		getContentPane().add(jf);
		jf.setColumns(10);

		jb = new JButton("전송");
		jb.setBounds(237, 206, 97, 23);
		getContentPane().add(jb);

		ja = new JTextArea();
		ja.setBounds(218, 103, 116, 86);
		getContentPane().add(ja);

		jl = DefaultComponentFactory.getInstance().createTitle("문자전송 Program");
		jl.setBounds(149, 10, 114, 34);
		getContentPane().add(jl);

		jl = DefaultComponentFactory.getInstance().createLabel("수신번호");
		jl.setBounds(72, 64, 114, 15);
		getContentPane().add(jl);

		jl = DefaultComponentFactory.getInstance().createLabel("보낼 메시지 입력");
		jl.setBounds(72, 107, 114, 15);
		getContentPane().add(jl);

		jb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ExampleSend(jf.getText(), ja.getText());
			}
		});
		
		setSize(500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SmsApp();
	}
}
