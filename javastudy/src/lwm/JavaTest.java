package lwm;

class Power {
	private int kick;
	private int punch;
	
	public Power(int kick, int punch) {
		this.kick = kick;
		this.punch = punch;
		System.out.println(kick);
	}
}


public class JavaTest {
	public static void main(String[] args) {
		Power robot = new Power(10, 20);
		}
	}
	
