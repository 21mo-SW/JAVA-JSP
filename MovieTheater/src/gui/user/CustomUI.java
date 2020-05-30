package gui.user;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import models.Combo;

@SuppressWarnings("serial")
class CustomUI {
	JPanel backgroundPanel;	// CustomUI를 상속한 자식 클래스들에서도 동일한 이름의 필드를 추가하고 있으므로
							// CustomeUI의 backgroundPanel이 가려지는 현상이 발생함
	
	public CustomUI() {}
	
	public CustomUI(JPanel backgroundPanel) {
		this.backgroundPanel = backgroundPanel;
	}

	protected void setPanel() {
		backgroundPanel.setLayout(null);
		backgroundPanel.setBackground(Color.WHITE);
		
		JPanel topBluePanel = new JPanel();
		topBluePanel.setBounds(0, 0, 420, 70);
		topBluePanel.setBackground(new Color(53, 121, 247));
		backgroundPanel.add(topBluePanel);
		
		JPanel topGrayPanel = new JPanel();
		topGrayPanel.setBounds(0, 70, 420, 50);
		topGrayPanel.setBackground(new Color(230, 236, 240));
		backgroundPanel.add(topGrayPanel);
	}
	
	protected JTextField setTextField(String name, String placeholder, int x, int y, int width, int height) {
		JTextField txt = new JTextField();
		
		if (placeholder == null) {
			txt.setText("Please input here");
		} else {
			txt.setText(placeholder);
		}
		
		// placeholder 에 해당하는 텍스트를 좀 희미하게 표시되도록 하는 코드
		Font tfFont = new Font("Arial", Font.PLAIN, 20);
		txt.setFont(tfFont);
		txt.setBackground(Color.white);
		txt.setForeground(Color.gray.brighter());
		
		txt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				JTextField tf = (JTextField)e.getComponent();
				if(tf.getText().equals("")) {
					if (placeholder == null) {
						tf.setForeground(Color.gray.brighter());
						tf.setText("Please input here");
					} else {
						tf.setForeground(Color.gray.brighter());
						tf.setText(placeholder);
					}
				}
			}
			public void focusGained(FocusEvent e) {
				JTextField tf = (JTextField)e.getComponent();
				if (tf.getText().equals(placeholder) || tf.getText().equals("Please input here") || tf.getText().equals("")) {
					tf.setText("");
					tf.setForeground(Color.BLACK);
				}
			}
		});
		
		txt.setBounds(x, y, width, height);
		backgroundPanel.add(txt);
		txt.setName(name);
		
		return txt;
	}
	
	protected JPasswordField setPasswordField(String name, String placeholder, int x, int y, int width, int height) {
		JPasswordField txt = new JPasswordField();
		
		if (placeholder == null) {
			txt.setText("Please input here");
		} else {
			txt.setText(placeholder);
		}
		
		Font tfFont = new Font("Arial", Font.PLAIN, 20);
		txt.setFont(tfFont);
		txt.setBackground(Color.white);
		txt.setForeground(Color.gray.brighter());
		
		txt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				JTextField tf = (JTextField)e.getComponent();
				if(tf.getText().equals("")) {
					if (placeholder == null) {
						tf.setForeground(Color.gray.brighter());
						tf.setText("Please input here");
					} else {
						tf.setForeground(Color.gray.brighter());
						tf.setText(placeholder);
					}
				}
			}
			public void focusGained(FocusEvent e) {
				JTextField tf = (JTextField)e.getComponent();
				if (tf.getText().equals(placeholder) || tf.getText().equals("Please input here") || tf.getText().equals("")) {
					tf.setText("");
					tf.setForeground(Color.BLACK);
				}
			}
		});
		
		txt.setBounds(x, y, width, height);
		backgroundPanel.add(txt);
		txt.setName(name);
		
		return txt;
	}

	protected JButton setBtnBlue(String name, String text, int y) {

		// 지역 클래스
		class RoundedButton extends JButton {
			public RoundedButton() {
				super();
				decorate();
			}

			protected void decorate() {
				setBorderPainted(false);
				setOpaque(false);
			}

			protected void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 15, 15);
				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
				int textX = (width - stringBounds.width) / 2;
				int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
				graphics.setColor(getForeground());
				graphics.setFont(getFont());
				graphics.drawString(getText(), textX, textY);
				super.paintComponent(g);
			}
		}

		// 바로 위에 선언한 지역 클래스 객체를 생성하고 있음
		RoundedButton btn = new RoundedButton();
		btn.setBackground(new Color(53, 121, 247));	// 푸른색
		Font btnFont = new Font("맑은 고딕", Font.PLAIN, 20);
		btn.setFont(btnFont);
		btn.setBackground(new Color(53, 121, 247));
		btn.setForeground(Color.WHITE);
		btn.setBounds(35, y, 350, 45);
		btn.setText(text);
		backgroundPanel.add(btn);
		btn.setName(name);

		return btn;
	}

	protected JButton setBtnWhite(String name, String text, int y) {

		class RoundedBorder implements Border {
			int radius;

			RoundedBorder(int radius) {
				this.radius = radius;
			}

			public Insets getBorderInsets(Component c) {
				return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
			}

			public boolean isBorderOpaque() {
				return true;
			}

			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
				g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
			}
		}

		JButton btn = new JButton();
		btn.setBorder(new RoundedBorder(15));
		Font btnFont = new Font("맑은 고딕", Font.PLAIN, 20);
		btn.setFont(btnFont);
		btn.setBackground(Color.WHITE);
		btn.setForeground(new Color(53, 121, 247));
		btn.setBounds(35, y, 350, 45);
		btn.setText(text);
		backgroundPanel.add(btn);
		btn.setName(name);

		return btn;
	}
	
	protected JButton setBtnMovie(String name, String time, String seatCnt, int x, int y) {
		JButton btn = new JButton("<html>" + time + "<br/>" + seatCnt + "</html>");
		
		btn.setBackground(new Color(230, 236, 240));
		btn.setForeground(new Color(114, 114, 114));
		btn.setBorderPainted(false);
		btn.setBounds(x, y, 90, 70);

		backgroundPanel.add(btn);
		btn.setName(name);
		
		return btn;
	}
	
	protected JButton setBtnSeat(String name, String seat, int x, int y) {
		JButton btn = new JButton(seat);
		
		Font btnFont = new Font("맑은 고딕", Font.BOLD, 14);
		btn.setFont(btnFont);
		btn.setBackground(new Color(230, 236, 240));
		btn.setForeground(new Color(114, 114, 114));
		btn.setBorderPainted(false);
		btn.setBounds(x, y, 53, 48);
		backgroundPanel.add(btn);
		btn.setName(name);
		
		return btn;
	}
	
	protected JButton setbtnBar(String name, String text, int y) {
		JButton btn = new JButton();
		
		Font btnFont = new Font("맑은 고딕", Font.BOLD, 14);
		btn.setFont(btnFont);
		btn.setBackground(new Color(230, 236, 240));
		btn.setForeground(new Color(114, 114, 114));
		btn.setBorderPainted(false);
		btn.setBounds(45, y, 334, 40);
		btn.setText(text);
		backgroundPanel.add(btn);
		btn.setName(name);
		
		return btn;
	}

	protected JButton setBtnImg(String name, String text, int x, int y) {
		ImageIcon icon = new ImageIcon("img/icon5.png");
		JButton btn = new JButton(text, icon);

		Font btnFont = new Font("맑은 고딕", Font.PLAIN, 18);
		btn.setFont(btnFont);
		btn.setBackground(new Color(53, 121, 247));		// 푸른색
		btn.setForeground(Color.WHITE);
		// 버튼에서 텍스트의 아이콘에 대한 상대적 수직 위치값을 설정함. SwingConstants.CENTER (기본값)
		// SwingConstants.TOP, SwingConstants.BOTTOM 중 선택가능
		btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		// 버튼에서 텍스트의 아이콘에 대한 상대적 수평 위치값을 설정함. SwingConstants.TRAILING (기본값)
		// 그외 SwingConstants.RIGHT, LEFT, CENTER, LEADING 등이 선택가능
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
		// 버튼에 border로 설정된 것이 있더라도 그리지 않도록 함
		btn.setBorderPainted(false);
		// 버튼의 위치와 크기를 설정함. x,y가 버튼의 top-left 좌표값이고, 170, 150은 각 width, height값임
		btn.setBounds(x, y, 170, 150);
		// 버튼에 텍스트 설정
		btn.setText(text);
		backgroundPanel.add(btn);
		// 버튼 컴포넌트의 이름을 name으로 설정함
		btn.setName(name);

		return btn;
	}

	protected JLabel setLb(String name, String text, int x, int y, int width, int height, String alignment, int fontSize, String weight) {
		JLabel lb = new JLabel(text);	// 라벨에 표시할 문자열은 text
		Font lbFont = new Font("맑은 고딕", setWeight(weight), fontSize);
		lb.setFont(lbFont);
		lb.setForeground(new Color(114, 114, 114));	// 쥐색, 어두운 회색 정도..
		// 라벨의 내용을 x축을 따라 정렬함. 정렬 기준은 SwingConstants.LEADING (텍스트 라벨의 기본값)
		// SwingConstants.CENTER (이미지 라벨의 기본값), LEFT, RIGHT, TRAILING.
		lb.setHorizontalAlignment(setAlign(alignment));	// setAlign()은 저 아래에
		// 컴포넌트의 위치와 크기를 설정함. x,y가 라벨의 top-left 좌표값이고, width, height는 크기값
		lb.setBounds(x, y, width, height);
		// backgroundPanel은 CustomUI 클래스의 멤버 필드(기본 접근자)이고 CustomUI를 상속한 클래스에서도 직접 접근 가능함
		// 실제 setLb(이 메서드)는 주로 CustomUI를 상속받은 클래스들에서 호출해서 사용하고 있다.
		backgroundPanel.add(lb);
		// 라벨 컴포넌트의 이름을 name으로 설정함
		lb.setName(name);
		
		return lb;
	}
	
	// 바로 위 setLb()와 오버로딩 관계.
	// 이 메서드가 맨 마지막에 JPanel panel이라는 매개값 하나를 더 가진다.
	// 위 메서드는 생성된 라벨을 backgroundPanel에 바로 추가하는 거에 비해 아래의 메서드는 그 추가과정이 생략됨
	// 그러나 아래 메서드를 직접 사용한 코드 부분을 보면 아래 메서드를 호출한 직후에 직접 panel에 추가해주는 코드가 따로 존재한다.
	protected JLabel setLb(String name, String text, int x, int y, int width, int height, String alignment, int fontSize, String weight, JPanel panel) {
		JLabel lb = new JLabel(text);
		Font lbFont = new Font("맑은 고딕", setWeight(weight), fontSize);
		lb.setFont(lbFont);
		lb.setForeground(new Color(114, 114, 114));
		lb.setHorizontalAlignment(setAlign(alignment));	
		lb.setBounds(x, y, width, height);
		lb.setName(name);
		
		return lb;
	}

	protected JLabel setLbBox(String name, String text, int x, int y) {
		JLabel lb = new JLabel(text);	// 라벨에 표시할 문자열은 text
		int age = Integer.parseInt(text);
		
		if(age == 99) {
			lb.setFont(new Font("맑은 고딕", Font.BOLD, 0));	// Font 생성자의 세번째 매개값은 폰트 크기
			lb.setBackground(new Color(53, 121, 247));		// 푸른색
		} else if(age >= 19) {
			lb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lb.setBackground(Color.RED);
		} else if (age <= 0) {
			lb.setFont(new Font("맑은 고딕", Font.BOLD, 10));
			lb.setBackground(Color.BLUE);
			lb.setText("전체");
		} else {
			lb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lb.setBackground(Color.GREEN);
		}
		lb.setOpaque(true);
		lb.setForeground(Color.WHITE);
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		lb.setBounds(x, y, 27, 27);
		backgroundPanel.add(lb);
		lb.setName(name);
		
		return lb;
	}
	
	protected JLabel setLbBox(String name, String text, int x, int y, JPanel panel) {
		JLabel lb = new JLabel(text);
		int age = Integer.parseInt(text);
		
		if(age == 99) {
			lb.setFont(new Font("맑은 고딕", Font.BOLD, 0));
			lb.setBackground(new Color(53, 121, 247));
		} else if(age >= 19) {
			lb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lb.setBackground(Color.RED);
		} else if (age <= 0) {
			lb.setFont(new Font("맑은 고딕", Font.BOLD, 10));
			lb.setBackground(Color.BLUE);
			lb.setText("전체");
		} else {
			lb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lb.setBackground(Color.GREEN);
		}
		lb.setOpaque(true);
		lb.setForeground(Color.WHITE);
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		lb.setBounds(x, y, 27, 27);
		lb.setName(name);
		
		return lb;
	}
	
	protected JLabel setLbImg(String name, int iconNum, int x, int y) {
		JLabel lb = new JLabel();

		ImageIcon imgIc = new ImageIcon("img/icon"+iconNum+".png");
		Image img = imgIc.getImage();
		// 아래 90,90이나 100,70 등 숫자는 해당 이미지의 실제 픽셀 크기임
		if(iconNum == 1 || iconNum == 2) {
			img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		} else if(iconNum == 3) {
			img = img.getScaledInstance(100, 70, Image.SCALE_SMOOTH);
		} else if(iconNum == 4) {
			img = img.getScaledInstance(80, 56, Image.SCALE_SMOOTH);
		} else if(iconNum == 5) {
			img = img.getScaledInstance(60, 55, Image.SCALE_SMOOTH);
		}
		ImageIcon resizeImgIc = new ImageIcon(img);
		lb.setIcon(resizeImgIc);
		lb.setHorizontalAlignment(SwingConstants.CENTER);		
		lb.setBounds(x, y, 100, 100);
		backgroundPanel.add(lb);
		lb.setName(name);
		
		return lb;
	}
	
	protected JCheckBox setCheckBox(String name, String text, int x, int y) {
		JCheckBox cb = new JCheckBox();
		cb.setBackground(Color.WHITE);
		cb.setIcon(new ImageIcon("img/checkbox.png"));
		cb.setSelectedIcon(new ImageIcon("img/selectedcheckbox.png"));
		cb.setBounds(x, y, 31, 31);
		backgroundPanel.add(cb);
		cb.setName(name);
		
		JLabel lb = new JLabel(text);
		Font lbFont = new Font("맑은 고딕", Font.PLAIN, 16);
		lb.setFont(lbFont);
		lb.setForeground(new Color(114, 114, 114));
		lb.setLocation(x+35, y-3);
		lb.setSize(300, 35);
		backgroundPanel.add(lb);
		
		return cb;
	}
	
	protected JComboBox<Combo> setCombo(String name, Vector<Combo> combos, int x, int y, int width, int height){
		JComboBox<Combo> combo = null;
		
		
		if(combos == null) {
			combo = new JComboBox<>();
			System.out.println("combo값은 null임");
			Combo comboNull = new Combo(0, "없음");
			combo.addItem(comboNull);
		} else {
			System.out.println("combo값은 null이 아님");
			// 원래의 코드는 아래와 같이 for문으로 벡터에서 하나씩 꺼내와 combo에 다시 넣고 있는데 그보다는
			// new JComboBox<>(combos) 로 벡터 객체를 JComboBox 생성자에 매개값으로 던져주는 더 간단한 방법이 있다.
			/*
			for (Combo c : combos) {
				combo.addItem(c);
			}
			*/
			// JComboBox 클래스 생성자 중에 public JComboBox(Vector<E> items) 인 형태의 것을 아래에서 사용
			combo = new JComboBox<>(combos);
		}
		
		combo.setBackground(Color.WHITE);
		combo.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		combo.setBounds(x, y, width, height);
		backgroundPanel.add(combo);
		combo.setName(name);
		
		return combo;
	}
	
	protected JComboBox<String> setCombo(String name, String[] text, int x, int y, int width, int height){
		// JComboBox 생성자의 종류
		//  - public JComboBox(E[] items) : 배열 객체를 매개값으로. E 타입 배열 객체라 함은 어떠한 타입의 배열도 가능함을 표시. 기본형 데이터 배열인 경우는 래퍼클래스 배열로
		//  - public JComboBox(Vector<E> items) : Vector 객체를 매개값으로
		// 아래에서는 이 중 배열 객체를 매개값으로 받는 생성자 사용하면서 text 배열 객체를 던져주고 있음
		JComboBox<String> combo = new JComboBox<>(text);
		
		combo.setBackground(Color.WHITE);
		combo.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		combo.setBounds(x, y, width, height);
		backgroundPanel.add(combo);
		combo.setName(name);
		
		return combo;
	}
	
	// alignment 값을 문자열로 손쉽게 지정할 수 있도록 하기 위해 만든 메서드임
	// 대소문자 구분할 필요없이 "CENTER", "LEFT", "RIGHT" 중 하나를 사용할 수!
	private int setAlign(String alignment) {
		if(alignment.toUpperCase().equals("CENTER")) {
			return 0;	// SwingConstants.CENTER
		} else if(alignment.toUpperCase().equals("LEFT")) {
			return 2;	// SwingConstants.LEFT
		}  else if(alignment.toUpperCase().equals("RIGHT")) {
			return 4;	// SwingConstants.RIGHT
		} else {		// 그외 모든 경우는(실수로 값을 잘못 입력한 경우도) SwingConstants.CENTER로 설정하겠다는 것
			return 0;
		}
	}
	
	private int setWeight(String weight) {
		if(weight.toUpperCase().equals("BOLD")) {
			return 1;
		}  else if(weight.toUpperCase().equals("ITALIC")) {
			return 2;
		} else {
			return 0;
		}
	}

	protected JList<Combo> setList(String name, DefaultListModel<Combo> listModel, int x) {
		JList<Combo> list = new JList<Combo>(listModel);
		list.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		list.setForeground(new Color(114, 114, 114));

		JLabel lb = (JLabel) list.getCellRenderer();
		lb.setPreferredSize(new Dimension(200, 50));

		JScrollPane sp = new JScrollPane(list);
		sp.setBounds(x, 120, 420, 500);
		backgroundPanel.add(sp);
		list.setName(name);

		return list;
	}
}