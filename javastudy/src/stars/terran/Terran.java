package stars.terran;

import stars.Behavior;

public abstract class Terran implements Behavior {
	public void move() {
		System.out.println("이동");
	}
	
	public void repair() {
		System.out.println("SCV 치료");
	}
	
	//public abstract void attack();
	
	public static void upgrade() {
		Marine.attack++;
		Tank.attack++;
		}
}

