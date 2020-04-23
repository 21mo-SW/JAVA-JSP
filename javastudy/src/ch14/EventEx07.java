package ch14;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventEx07 extends JFrame {
	
	int imgX = 600;
	int imgY = 20;
	
	public EventEx07() {
		setTitle("��ǳ����");
		setSize(700,300);
		setLocationRelativeTo(null); //�������� ȭ�� ��� ��ġ
		setContentPane(new MyPanel());
		setVisible(true);
	}
	
	//paintComponent �Լ��� JFrame�ȿ��� �۵�����.
	class MyPanel extends JPanel {
		
		public MyPanel() {
			setFocusable(true);
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					System.out.println("keycode:" + e.getKeyCode());
					System.out.println("keychar:" + e.getKeyChar());
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						imgX = imgX - 10;
						break;
					case KeyEvent.VK_RIGHT:
						imgX = imgX + 10;
						break;
					case KeyEvent.VK_SPACE:
						new Thread(new Runnable() {
							public void run() {
								int time = 50;
								while(time > 0) {
									imgX = imgX - 10;
									time--;
									try {
										Thread.sleep(100);
									} catch (Exception e1) {
										e1.printStackTrace();
									}
									repaint();
									}
								}
							}).start();
							break;
					}
					
					
				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			ImageIcon imgRyu = new ImageIcon("img/Ryu.png"); 
			ImageIcon imgPa = new ImageIcon("img/ham1.jpg"); 
			
			//�̹��� ����
			Image ryu = imgRyu.getImage();
			Image pa = imgPa.getImage();
			
			g.drawImage(ryu, 0, 0, null);
			g.drawImage(pa, imgX, imgY, null);
		}
	}
	
	public static void main(String[] args) {
		new EventEx07();
	}

}
