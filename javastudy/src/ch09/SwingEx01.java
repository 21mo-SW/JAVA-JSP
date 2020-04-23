package ch09;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx01 extends JFrame{
	
	public SwingEx01() {
		//JFrame�ȿ� �⺻������ �ִ� panel�� �����ϱ�
		Container contentPane = getContentPane(); 
		//JFrame�� �⺻ �г��� BorderLayout - > FlowLayout����
		contentPane.setLayout(new FlowLayout());
		//�⺻ �гο� ��ư �׸���
		contentPane.add(new JButton("ù��°��ư")); 
		//����׸���
		setTitle("500x300 ���� ������ �����");
		//ũ�� 500, 300 �׸���
		setSize(500, 300);
		//painting (�̶� �׸��� �׷���)
		setVisible(true); 
	}

	public static void main(String[] args) {
		new SwingEx01();
	}

}
