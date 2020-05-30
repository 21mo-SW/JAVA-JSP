package ch11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame {

	private JLabel textLabel, imageLabel, label;
	private ImageIcon beauty, normalIcon; 
	private BorderLayout bl;
	
	public LabelEx() {
		setTitle("���̺� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//���ڿ� ���̺� ����
		textLabel = new JLabel("����մϴ�");
		
		//�̹��� ���̺� ����
		beauty = new ImageIcon("img/beauty.jpg");
		imageLabel = new JLabel(beauty); //�̹��� ���̺� ����
		
		//���ڿ��� �̹����� ��� ���� ���̺� ����
		normalIcon = new ImageIcon("img/normalIcon.gif"); //�̹��� �ε�
		label = new JLabel("������ ���� �������", normalIcon, SwingConstants.CENTER); //���̺� ����
		
		//����Ʈ�ҿ� 3���� ���̺� ����
		c.add(textLabel);
		c.add(imageLabel);
		c.add(label);
		
		setSize(400, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LabelEx();
	}

}
