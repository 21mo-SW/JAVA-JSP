package ch09;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx01 extends JFrame{
	
	public SwingEx01() {
		//JFrame안에 기본적으로 있는 panel에 접근하기
		Container contentPane = getContentPane(); 
		//JFrame의 기본 패널은 BorderLayout - > FlowLayout변경
		contentPane.setLayout(new FlowLayout());
		//기본 패널에 버튼 그리기
		contentPane.add(new JButton("첫번째버튼")); 
		//제목그리기
		setTitle("500x300 스윙 프레임 만들기");
		//크기 500, 300 그리기
		setSize(500, 300);
		//painting (이때 그림이 그려짐)
		setVisible(true); 
	}

	public static void main(String[] args) {
		new SwingEx01();
	}

}
