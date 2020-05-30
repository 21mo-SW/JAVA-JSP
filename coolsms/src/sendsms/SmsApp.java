package sendsms;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JFrame;

import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Send {
	public Send(String phoneNumber, String conTents) {
		String api_key = "NCSTFTVLLMIF8KXY";
		String api_secret = "DSQRPQQVBOLVLLKZG4W13M1ZTSOYKHS1";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phoneNumber);
		params.put("from", "01083443909");
		params.put("type", "SMS");
		params.put("text", conTents);
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params); // obj는 데이터를 잘받앗는지 응답해주는것을 담은 변수
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}

public class SmsApp extends JFrame {
	private JTextField tf;
	private JTextArea ta;
	private JButton jb;
	private JLabel jl1;
	private JLabel jl2;
	private JFrame fm;

	public SmsApp() {
		getContentPane().setLayout(null);

		tf = new JTextField();
		tf.setBounds(90, 46, 191, 21);
		getContentPane().add(tf);
		tf.setColumns(10);

		ta = new JTextArea();
		ta.setBounds(90, 107, 190, 103);
		getContentPane().add(ta);

		jb = new JButton("전송");
		jb.setBounds(311, 187, 97, 23);
		getContentPane().add(jb);
		jb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Send(tf.getText(), ta.getText());
			}
			
		});

		jl1 = new JLabel("수신번호");
		jl1.setBounds(91, 21, 82, 15);
		getContentPane().add(jl1);

		jl2 = new JLabel("발신내용");
		jl2.setBounds(91, 81, 76, 15);
		getContentPane().add(jl2);

		setTitle("SMS발송 Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SmsApp();
	}
}
