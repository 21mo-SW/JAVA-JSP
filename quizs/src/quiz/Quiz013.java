package quiz;

import java.util.Scanner;

// Scanner ���� ���� ���ͳݿ��� �˻�

// if�� �� ������ �ɾ �ڵ带 �����ϴ� ����̴�

// if - else if - else �����̴�

// 0���� ������ "0���� �۽��ϴ�" �� ���
// 10���� ������ "10���� �۽��ϴ�" �� ���
// 10�̻��̸� "10�̻� �Դϴ�" �� ���

public class Quiz013 {

	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num < 0) {
			System.out.println("0���� �۽��ϴ�");
		} else if (0 <= num && num < 10) {
			System.out.println("10���� �۽��ϴ�");
		} else if (10 <= num) {
			System.out.println("10�̻� �Դϴ�.");
		}
	}
}
