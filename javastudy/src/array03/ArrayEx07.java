package array03;

import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("6�ڸ� ���ڸ� �Է��ϼ���.");
		int num = sc.nextInt(); //6�ڸ��� �Է�
		
		String strNum=num + "";
		//System.out.println(strNum.charAt(2));
		//System.out.println(strNum.length());
		for (int i = 0; i < strNum.length(); i++) {
			if(strNum.charAt(i) == '3') {
				System.out.println("���ڿ�" + i + "�� 3�� �����մϴ�.");
			}
			
		}
	
	}

}
