package dateex;

public class MathEx {

	public static void main(String[] args) {
//		System.out.println(Math.PI); //������ ��� ���
//		System.out.println(Math.ceil(a)); //ceil(�ø�)
//		System.out.println(Math.floor(a)); //floor(����)
//		System.out.println(Math.sqrt(a));  //������
//		System.out.println(Math.exp(2));	//e�� 2��
//		System.out.println(Math.round(3.14)); //�ݿø�
		
		//[1,45]������ ������ ���� 5�� �߻�
		System.out.println("�̹��� ����� ��ȣ�� ");
		for (int i = 0; i < 6; i++) {
			System.out.println((int)(Math.random()*45 + 1) + " "); //���� �߻�
		}
	}

}
