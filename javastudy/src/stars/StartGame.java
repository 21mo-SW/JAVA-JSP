package stars;

import stars.protoss.Dragoon;
import stars.protoss.Protoss;
import stars.protoss.Zealot;

public class StartGame {
	
	public static void move(Behavior b) {
		b.move();
	}
	
	public static void repair(Behavior b) {
		b.repair();
	}
	
	public static void attack(Behavior b1, Behavior b2) {
		b1.attack(b2);
	}
	
	public static void getName(Behavior b) {
		b.getName();
	}
	
	public static void getHp(Behavior b) {
		b.getHp();
	}
	
	public static void setHp(Behavior b) {
		b.setHp();
	}

	public static void main(String[] args) {
		Protoss.upgrade();
		Zealot z1 = new Zealot("Áú·µ1");
		Dragoon d1 = new Dragoon("µå¶ó±º1");
		move(z1);
		repair(z1);
		attack(z1, d1);
	}

}
