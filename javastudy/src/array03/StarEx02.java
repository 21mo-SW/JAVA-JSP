package array03;

public class StarEx02 {

	static void printStars(int i) {

		for (int j = 0; j < 10-i; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < i; j++) {
			System.out.print("*");
		}
		for (int j = 0; j < i; j++) {
			System.out.print("*");
		}
		for (int j = 0; j < 10-i; j++) {
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			printStars(i);
		} 
		
	}
}
