package quiz;

import java.util.ArrayList;

// ArrayList �� �����迭�̴�
// ArrayList<Integer> arr ó�� ���� �ȿ��� Ŭ������ WrapperŸ���� ���� �� �ִ�.
// ArrayList�� ���� �߰��Ϸ��� arr.add(��);
// ArrayList�� ���̸� �˰� �ʹٸ� arr.size();
// ArrayList�� 0��° ���� �˰� �ʹٸ� arr.get(0);
// ArrayList�� 0��° ���� ����� arr.remove(0);

// �Ʒ� arr ����Ʈ�� 5���� ���� �ٸ� ���ڸ� �߰��ϰ�
// ���̸� ����ϰ�
// 4��° ���ڸ� ����ϰ�
// 1��° ���ڸ� ����������


public class Quiz020 {
	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(6);
		arr.add(7);
		arr.add(8);
		arr.add(9);
		System.out.println(arr.size());
		System.out.println(arr.get(3));
		arr.remove(0);
		System.out.println(arr.get(0));
	}
}
