package ch03;

//�޼���(�Լ�)�� Ŭ�����ȿ� �ۼ��� �� �ִ�.
//�޼���(�Լ�)�� �޼���(�Լ�) �ȿ� �ۼ��� �� ����.
public class MethodEx01 {

	public static void main(String[] args) {  //��ǻ�ʹ� static�� ������ ���� �޴´�. static�� main�� �߿�. JVM�� ���� ���� static�� ���� �� �ִ�.
		int num = Cal.add(5, 3);
		System.out.println("���� ��:" + num);
		
		int num1 = Cal.minus(5, 3);
		System.out.println("�� ��:" + num1);
		
		int num2 = Cal.multi(5, 3);
		System.out.println("���� ��:" + num2);
		
		int num3 = Cal.devide(5, 3);
		System.out.println("���� ��:" + num3);
	}

	
}