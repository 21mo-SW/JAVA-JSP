package stars.protoss;

import stars.Behavior;

public class Dragoon extends Protoss {
	String name;
	int hp;
	int sh; //��ȣ��
	static int attack = 15;
	
	public Dragoon(String name) {
		this.name = name;
		this.hp = 100;
		this.sh = 100;
	}

	@Override
	public void attack(Behavior unit) {
		System.out.println("���� ����");
	}

	

	
	
	

	
}