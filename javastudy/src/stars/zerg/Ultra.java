package stars.zerg;

import stars.Behavior;

public class Ultra extends Zerg {
	private String name;
	private int hp;
	static int attack = 50;
	
	public Ultra(String name, int hp) {
		super();
		this.name = name;
		this.hp = 100;
	}

	@Override
	public void attack(Behavior unit) {
		System.out.println("박치기 공격");
	}
	
}