package ch05;

//�߻�Ŭ������ new�� �� ����. ������Ʈ�� �ƴϱ� ������!!
//�߻�Ŭ������ �߻� �޼��带 ���� �� �ִ�.

abstract class Food1 {
	abstract void eat();
	
}

class ���1 extends Food1 {

	String NAME = "���1";
		
	@Override
	void eat() {
		System.out.println(NAME + "�� �Ծ����ϴ�.");
		
	}

	
	
}

class �Ұ��1 extends Food1 {

	String NAME = "�Ұ��1";
	
	@Override
	void eat() {
		System.out.println(NAME + "�� �Ծ����ϴ�.");
		
	}
	
}

class ����1 extends Food1 {

	String NAME = "����1";
	
	@Override
	void eat() {
		System.out.println(NAME + "�� �Ծ����ϴ�.");
		
	}
	
}

public class FoodEx01 {

	static void start(Food1 f) {
		f.eat();
	}
	
	public static void main(String[] args) {
		start(new �Ұ��1());
		start(new ���1());

	}

}
