package ex03;

import java.util.Scanner;

public class q04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("소문자 알파벳 하나를 입력하시오>>");
		String a = sc.next();
		if(a.length() != 1) {
			System.out.println("알파벳 하나만 입력하세요.");
			sc.close();
		}
		char b = a.charAt(0);
		if (b < 'a' || b >'z') {
			System.out.println("소문자 알바벳이 아닙니다.");
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
