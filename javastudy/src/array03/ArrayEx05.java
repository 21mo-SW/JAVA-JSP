package array03;

import java.util.Scanner; //import�� �ٸ� ������� Ŭ������ ����ϱ� ���� �ִ� ��
/**
 * 
 * ���� 1000000000 �� �Է¹ް�(10��)
 *3�ڸ� ���� �޸��� �� ���!!
 *1,000,000,000
 */
public class ArrayEx05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String tempNum = num + "";
		String tempNum2[] = tempNum.split("");
		
		//�ڸ��� ����� ���� ����
		int p = (tempNum2.length % 3);
		for(int i = 0; i<tempNum2.length; i++) {
			//ù°�ڸ� �տ� ,�� ������ �ȵǴ� ù ��������.
			if (i==0) tempNum2[i] = "" + tempNum2[i];
			//i�� 3���� ���� ���� p���� ������ �տ� ,�� ����
			else if(i%3==p) tempNum2[i]="," + tempNum2[i];
			//�ڸ��� ��� ���
			System.out.print(tempNum2[i]);					
		} //end of fot
		
	}

}
