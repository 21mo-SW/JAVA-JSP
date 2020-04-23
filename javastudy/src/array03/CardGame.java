package array03;

import java.util.Random;
import java.util.Scanner;

public class CardGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int k = r.nextInt(100); // 0~99까지 임의의 정수 생성

		System.out.print("수를 결정하였습니다. 맞추어 보세요.");
		System.out.println(" (0~99)");

		boolean wrong = true; // 추측 값이 틀림을 표시

		while (wrong) {
			int input = sc.nextInt();

			if (input > k) {
				System.out.println("더낮게");
			} else if (input < k) {
				System.out.println("더 높게");
			} else {
				System.out.println("정답입니다.");
				System.out.println("다시하시겠습니까(y/n)");
			}

		}
	}

}
