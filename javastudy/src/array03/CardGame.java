package array03;

import java.util.Random;
import java.util.Scanner;

public class CardGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int k = r.nextInt(100); // 0~99���� ������ ���� ����

		System.out.print("���� �����Ͽ����ϴ�. ���߾� ������.");
		System.out.println(" (0~99)");

		boolean wrong = true; // ���� ���� Ʋ���� ǥ��

		while (wrong) {
			int input = sc.nextInt();

			if (input > k) {
				System.out.println("������");
			} else if (input < k) {
				System.out.println("�� ����");
			} else {
				System.out.println("�����Դϴ�.");
				System.out.println("�ٽ��Ͻðڽ��ϱ�(y/n)");
			}

		}
	}

}
