package ex03;

import java.util.Scanner;

public class q03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��Ͻÿ�>>");
		int a = sc.nextInt();
		
		if (a <= 0) {
			System.out.println("0���� Ŀ�� �մϴ�.");
			sc.close();
		}
		
		for (int i = a; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
