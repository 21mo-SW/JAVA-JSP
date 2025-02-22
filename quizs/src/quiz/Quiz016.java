package quiz;

import java.util.Scanner;

// 타이머를 만들려고 한다
// 숫자를 입력하면 카운트를 출력하고 카운트가 완료되면 "종료" 라고 떠야한다
// 1초 간격을 주는 코드는 Thread.sleep(1000) 이다

public class Quiz016 {

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 0; i < 10; i++) {
			System.out.println(num + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
