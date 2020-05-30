package gui.user;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Kiosk extends JFrame {
	private JTextField tfHamburgerCount;
	private JTextField tfColaCount;
	private JTextField tfPotatoCount;
	private JTextField tfCoffeeCount;
	
	private JTextField tfHamburgerPrice;
	private JTextField tfColaPrice;
	private JTextField tfPotatoPrice;
	private JTextField tfCoffeePrice;
	private JTextField textField;

	
	public Kiosk() {
		getContentPane().setLayout(null);
		
		AddCartListener acl = new AddCartListener();
		
		JButton btnNewButton1 = new JButton("햄버거");
		btnNewButton1.addActionListener(acl);
		btnNewButton1.setBounds(14, 12, 165, 117);
		getContentPane().add(btnNewButton1);
		
		JButton btnNewButton2 = new JButton("콜라");
		btnNewButton2.addActionListener(acl);
		btnNewButton2.setBounds(193, 12, 165, 117);
		getContentPane().add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("감자튀김");
		btnNewButton3.addActionListener(acl);
		btnNewButton3.setBounds(14, 185, 165, 117);
		getContentPane().add(btnNewButton3);
		
		JButton btnNewButton4 = new JButton("커피");
		btnNewButton4.addActionListener(acl);
		btnNewButton4.setBounds(193, 185, 165, 117);
		getContentPane().add(btnNewButton4);
		
		JButton btnMinusHamburger = new JButton("-");
		btnMinusHamburger.addActionListener(acl);
		btnMinusHamburger.setName("btnMinusHamburger");
		btnMinusHamburger.setBounds(24, 141, 41, 27);
		getContentPane().add(btnMinusHamburger);
		
		// txtCount1은 햄버거 버튼 아래의 햄버거 수량을 표시함.
		// 일단 처음 뜰 때 0으로 표시되도록!
		tfHamburgerCount = new JTextField("0");
		tfHamburgerCount.setBounds(73, 141, 41, 24);
		getContentPane().add(tfHamburgerCount);
		tfHamburgerCount.setColumns(10);
		
		
		JButton btnPlusHamburger = new JButton("+");
		btnPlusHamburger.addActionListener(acl);
		btnPlusHamburger.setName("btnPlusHamburger");
		btnPlusHamburger.setBounds(124, 141, 41, 27);
		getContentPane().add(btnPlusHamburger);
		
		
		JButton btnMinusCola = new JButton("-");
		btnMinusCola.addActionListener(acl);
		btnMinusCola.setName("btnMinusCola");
		btnMinusCola.setBounds(203, 141, 41, 27);
		getContentPane().add(btnMinusCola);
		
		// txtCount2은 콜라 버튼 아래의 햄버거 수량을 표시함.
		// 일단 처음 뜰 때 0으로 표시되도록!
		tfColaCount = new JTextField("0");
		tfColaCount.setColumns(10);
		tfColaCount.setBounds(252, 141, 41, 24);
		getContentPane().add(tfColaCount);
		
		
		
		JButton btnPlusCola = new JButton("+");
		btnPlusCola.addActionListener(acl);
		btnPlusCola.setName("btnPlusCola");
		btnPlusCola.setBounds(303, 141, 41, 27);
		getContentPane().add(btnPlusCola);
		
		JButton btnMinusPotato = new JButton("-");
		btnMinusPotato.addActionListener(acl);
		btnMinusPotato.setName("btnMinusPotato");
		btnMinusPotato.setBounds(24, 314, 41, 27);
		getContentPane().add(btnMinusPotato);
		
		tfPotatoCount = new JTextField("0");	// 일단 처음 뜰 때 0으로 표시되도록!
		tfPotatoCount.setColumns(10);
		tfPotatoCount.setBounds(73, 314, 41, 24);
		getContentPane().add(tfPotatoCount);
		
		JButton btnPlusPotato = new JButton("+");
		btnPlusPotato.addActionListener(acl);
		btnPlusPotato.setName("btnPlusPotato");
		btnPlusPotato.setBounds(124, 314, 41, 27);
		getContentPane().add(btnPlusPotato);
		
		JButton btnMinusCoffee = new JButton("-");
		btnMinusCoffee.addActionListener(acl);
		btnMinusCoffee.setName("btnMinusCoffee");
		btnMinusCoffee.setBounds(203, 314, 41, 27);
		getContentPane().add(btnMinusCoffee);
		
		tfCoffeeCount = new JTextField("0");	// 일단 처음 뜰 때 0으로 표시되도록!
		tfCoffeeCount.setColumns(10);
		tfCoffeeCount.setBounds(252, 314, 41, 24);
		getContentPane().add(tfCoffeeCount);
		
		
		
		JButton btnPlusCoffee = new JButton("+");
		btnPlusCoffee.addActionListener(acl);
		btnPlusCoffee.setName("btnPlusCoffee");
		btnPlusCoffee.setBounds(303, 314, 41, 27);
		getContentPane().add(btnPlusCoffee);
		
		tfHamburgerPrice = new JTextField();
		tfHamburgerPrice.setBackground(UIManager.getColor("Button.background"));
		tfHamburgerPrice.setBounds(403, 31, 159, 27);
		getContentPane().add(tfHamburgerPrice);
		tfHamburgerPrice.setColumns(10);
		
		tfColaPrice = new JTextField();
		tfColaPrice.setBackground(UIManager.getColor("Button.background"));
		tfColaPrice.setBounds(402, 87, 160, 24);
		getContentPane().add(tfColaPrice);
		tfColaPrice.setColumns(10);
		
		tfPotatoPrice = new JTextField();
		tfPotatoPrice.setBackground(UIManager.getColor("Button.background"));
		tfPotatoPrice.setBounds(403, 142, 159, 24);
		getContentPane().add(tfPotatoPrice);
		tfPotatoPrice.setColumns(10);
		
		tfCoffeePrice = new JTextField();
		tfCoffeePrice.setBackground(UIManager.getColor("Button.background"));
		tfCoffeePrice.setBounds(403, 197, 159, 24);
		getContentPane().add(tfCoffeePrice);
		tfCoffeePrice.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(454, 317, 108, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,500);
		setVisible(true);
	}
	
	class AddCartListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			System.out.println(b.getName());
			
			if (b.getText().equals("햄버거")) {
				plusHamburger();
			} else if (b.getText().equals("콜라")){
				plusCola();
			} else if (b.getText().equals("감자튀김")){
				plusPotato();
			} else if (b.getText().equals("커피")){
				plusCoffee();
			} else if (b.getName().equals("btnMinusHamburger")) {
				minusHamburger();
			} else if (b.getName().equals("btnPlusHamburger")) {
				plusHamburger();
			} else if (b.getName().equals("btnMinusCola")) {
				minusCola();
			} else if (b.getName().equals("btnPlusCola")) {
				plusCola();
			} else if (b.getName().equals("btnMinusPotato")) {
				minusPotato();
			} else if (b.getName().equals("btnPlusPotato")) {
				plusPotato();
			} else if (b.getName().equals("btnMinusCoffee")) {
				minusCoffee();
			} else if (b.getName().equals("btnPlusCoffee")) {
				plusCoffee();
			}
		}
		
		public void plusHamburger() {
			String s = tfHamburgerCount.getText();
			int count = Integer.parseInt(s);
			count++;
			tfHamburgerCount.setText(String.valueOf(count));
			tfHamburgerPrice.setText("햄버거 : 3000 x " + count + " = " + 3000*count);
		}
		
		public void minusHamburger() {
			String s = tfHamburgerCount.getText();
			int count = Integer.parseInt(s);
			if (count>0) count--;
			tfHamburgerCount.setText(String.valueOf(count));
			
			if (count == 0) {
				tfHamburgerPrice.setText("");
			} else {
				tfHamburgerPrice.setText("햄버거 : 3000 x " + count + " = " + 3000*count);
			}
		}
		
		public void plusCola() {
			String s = tfColaCount.getText();
			int count = Integer.parseInt(s);
			count++;
			tfColaCount.setText(String.valueOf(count));
			tfColaPrice.setText("콜라 : 1000 x " + count + " = " + 1000*count);
		}
		
		public void minusCola() {
			String s = tfColaCount.getText();
			int count = Integer.parseInt(s);
			if (count>0) count--;
			tfColaCount.setText(String.valueOf(count));
			
			if (count == 0) {
				tfColaPrice.setText("");
			} else {
				tfColaPrice.setText("콜라 : 1000 x " + count + " = " + 1000*count);
			}
		}
		
		public void plusPotato() {
			String s = tfPotatoCount.getText();
			int count = Integer.parseInt(s);
			count++;
			tfPotatoCount.setText(String.valueOf(count));
			tfPotatoPrice.setText("감자튀김 : 1500 x " + count + " = " + 1500*count);
		}
		
		public void minusPotato() {
			String s = tfPotatoCount.getText();
			int count = Integer.parseInt(s);
			if (count>0) count--;
			tfPotatoCount.setText(String.valueOf(count));
			
			if (count == 0) {
				tfPotatoPrice.setText("");
			} else {
				tfPotatoPrice.setText("감자튀김 : 1500 x " + count + " = " + 1500*count);
			}
		}
		
		public void plusCoffee() {
			String s = tfCoffeeCount.getText();
			int count = Integer.parseInt(s);
			count++;
			tfCoffeeCount.setText(String.valueOf(count));
			tfCoffeePrice.setText("커피 : 1200 x " + count + " = " + 1200*count);
		}
		
		public void minusCoffee() {
			String s = tfCoffeeCount.getText();
			int count = Integer.parseInt(s);
			if (count>0) count--;
			tfCoffeeCount.setText(String.valueOf(count));
			
			if (count == 0) {
				tfCoffeePrice.setText("");
			} else {
				tfCoffeePrice.setText("커피 : 1200 x " + count + " = " + 1200*count);
			}
		}
		
		public void sumMenu() {
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new Kiosk();
	}
}
