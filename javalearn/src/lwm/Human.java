package lwm;

class Be {
	public int num = 1;

	public int getNum() {
		return num;
	}
}

class Ani extends Be {
	public int num = 2;

	public int getNum() {
		return num;
	}
}

public class Human extends Ani {
	public int num = 3;

	public Human() {
		System.out.println(this.getNum());
	}

	public static void main(String[] args) {
		Human h = new Human();
	}

}
