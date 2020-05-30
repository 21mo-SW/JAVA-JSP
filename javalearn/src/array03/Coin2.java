package array03;

import java.util.Scanner;

public class Coin2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int count = 0;
		int money[] = {50000, 10000, 1000, 100, 50, 10, 1};
		
		for (int i = 0; i < 7; i++) {
			count = a/money[i];
			a = a%money[i];
			System.out.println( + count + "¸Å");
		}
	}

}
