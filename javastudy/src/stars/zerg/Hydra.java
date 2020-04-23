package stars.zerg;

import stars.Behavior;

public class Hydra extends Zerg {
	private String name;
	private int hp;
	static int attack = 20;
	
	public Hydra(String name, int hp) {
		super();
		this.name = name;
		this.hp = 100;
	}

	@Override
	public void attack(Behavior unit) {
		System.out.println("독침 공격");
	}
	
	
}