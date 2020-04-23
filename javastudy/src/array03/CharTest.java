package array03;

public class CharTest {

	public static void main(String[] args) {
		int ch = 65;
		System.out.println((char)ch);
		int ch2 = 66;
		System.out.println((char)ch2);
		
		String input = "A";
		char c = input.charAt(0);
		System.out.println((int)c);
		
		System.out.println((int)'A');
		System.out.println((int)'Z');
		
		for (int i = (int)'A'; i <= (int)'Z'; i++) {
			System.out.println((char)i + " = " + i);
		}
	
	}

}
