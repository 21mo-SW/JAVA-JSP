package awtswing;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class BingoGame {
	static JPanel panelNorth; //Top View
	static JPanel panelCenter; //Game View
	static JLabel labelMessage;
	static JButton[] buttons = new JButton[16];
	static String[] images = {
			"fruit01.png", "fruit02.png", "fruit03.png", "fruit04.png", 
			"fruit05.png", "fruit06.png", "fruit07.png", "fruit08.png", 
			"fruit01.png", "fruit02.png", "fruit03.png", "fruit04.png", 
			"fruit05.png", "fruit06.png", "fruit07.png", "fruit08.png"
			};
	static int openCount = 0; //Opened Card Count: 0, 1, 2
	static int buttonIndexSave1 = 0; //First Opened Card Index 0~15
	static int buttonIndexSave2 = 0; //First Opened Card Index 0~15
	static Timer timer;
	static int tryCount = 0; //Try Count
	static int successCount = 0; //Bingo Count
	
	static class MyFrame extends JFrame implements ActionListener{
		public MyFrame(String title) {
			super(title);
			this.setLayout(new BorderLayout());
			this.setSize(400, 500);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			initUI(this); //Screen UI Set
			mixCard(); //Mix Fruit Card
			
			this.pack(); //Pack Empty Space
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			int index = getButtonIndex(btn);
			
			btn.setIcon(changeImage(images[index]));
		}
		public int getButtonIndex(JButton btn) {
			int index = 0;
			for (int i = 0; i < 16; i++) {
				if(buttons[i] == btn) { //Same instance?
					index = i;
				}
			}
			return index;
		}
	}
	static void mixCard() {
		Random rand = new Random();
		for (int i = 0; i < 1000; i++) {
			int random = rand.nextInt(15) + 1;
			String temp = images[0];
			images[0] = images[random];
			images[random] = temp;
		}
	}
	
	static void initUI(MyFrame myFrame) {
		panelNorth = new JPanel();
		panelNorth.setPreferredSize(new Dimension(400, 100));
		panelNorth.setBackground(Color.RED);
		labelMessage = new JLabel("Find Same Fruit!" + "Try 0");
		labelMessage.setPreferredSize(new Dimension(400, 100));
		labelMessage.setForeground(Color.WHITE);
		labelMessage.setFont(new Font("Monaco", Font.BOLD, 20));
		labelMessage.setHorizontalAlignment(JLabel.CENTER);
		panelNorth.add(labelMessage);
		myFrame.add("North", panelNorth);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(4, 4));
		panelCenter.setPreferredSize(new Dimension(400, 400));
		for (int i = 0; i < 16; i++) {
			buttons[i] = new JButton();
			buttons[i].setPreferredSize(new Dimension(100, 100));
			buttons[i].setIcon(changeImage("question.png"));
			buttons[i].addActionListener(myFrame);
			panelCenter.add(buttons[i]);
		}
		myFrame.add("Center", panelCenter);
		
	}
	
	static ImageIcon changeImage(String filename) {
		ImageIcon icon = new ImageIcon("./img/" + filename);
		Image originImage = icon.getImage();
		Image changedImage = originImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(changedImage);
		return icon_new;
	}
	public static void main(String[] args) {
		new MyFrame("Bingo Game");
	}

}
