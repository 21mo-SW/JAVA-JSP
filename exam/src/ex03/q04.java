package ex03;

import java.util.Scanner;

public class q04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ҹ��� ���ĺ� �ϳ��� �Է��Ͻÿ�>>");
		String a = sc.next();
		if(a.length() != 1) {
			System.out.println("���ĺ� �ϳ��� �Է��ϼ���.");
			sc.close();
		}
		char b = a.charAt(0);
		if (b < 'a' || b >'z') {
			System.out.println("�ҹ��� �˹ٺ��� �ƴմϴ�.");
			sc.close();
		}
		
		for (char i = b; i >='a'; i--) {
			for (char j = 'a'; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		sc.close();
	}

}
