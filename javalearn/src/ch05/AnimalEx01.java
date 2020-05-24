package ch05;

abstract class Animal {  //abstract는 추상클래스 앞에 준다. 또한 new를 할 수 없다.
	abstract String getNAME();
}

class Mouse extends Animal {
	final String NAME = "쥐";
	public String getNAME() {
		return NAME;
	}
}

class Dog extends Animal {
	final String NAME = "강아지";
	
	public String getNAME() {
		return NAME;
	}
	
}

class Cat extends Animal {
	final String NAME = "고양이";

	public String getNAME() {
		return NAME;
	}
	
}

class Bird extends Animal {
	final String NAME = "새";

	public String getNAME() {
		return NAME;
	}
	
}

public class AnimalEx01 {
	
	/*static void attack(Dog u1, Cat u2) {
		System.out.println(u2.NAME + "가 " + u1.NAME + "에게 공격당했습니다.");
	}	
	static void attack(Dog u1, Bird u2) {
		System.out.println(u2.NAME + "가 " + u1.NAME + "에게 공격당했습니다.");
	}		
	static void attack(Cat u1, Bird u2) {
		System.out.println(u2.NAME + "가 " + u1.NAME + "에게 공격당했습니다.");
	}*/
	static void attack(Animal u1, Animal u2) {
		System.out.println(u2.getNAME() + "가 " + u1.getNAME() + "에게 공격당했습니다.");
	}
	
	public static void main(String[] args) {
		Dog d1 = new Dog();
		Cat c1 = new Cat();
		Bird b1 = new Bird();
		
		System.out.println(d1.NAME + " 탄생");
		System.out.println(c1.NAME + " 탄생");
		System.out.println(b1.NAME + " 탄생");

		//강아지 vs 고양이
		attack(d1, c1);
		
		//강아지 vs 새
		attack(d1, b1);
		
		//고양이 vs 새
		attack(c1, b1);
		
		//새 vs 강아지
		attack(b1, d1);
	}

}
