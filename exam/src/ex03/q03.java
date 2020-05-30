package ex03;

import java.util.Scanner;

public class q03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하시오>>");
		int a = sc.nextInt();
		
		if (a <= 0) {
			System.out.println("0보다 커야 합니다.");
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
