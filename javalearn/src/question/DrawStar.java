package question;

import java.util.Scanner;

public class DrawStar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��Ͻÿ�>>");
		int n = sc.nextInt();
		if (n <= 0) {
			System.out.println("0���� Ŀ���մϴ�.");
			sc.close();
			return;
		}
		for (int i=n; i>0; i--) {
			for (int j=0; j<i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		sc.close();
	}

}
