package test;

class Car {
	String option;
	int window;
	void drive() {
		System.out.println("drive");
	}
	void stop() {
		System.out.println("stop");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("water");
	}
}

class Ambulance extends Car {
	void siren() {
		System.out.println("siren");
	}
}

public class Test {

	public static void main(String[] args) {
		
		
		
	}
}
