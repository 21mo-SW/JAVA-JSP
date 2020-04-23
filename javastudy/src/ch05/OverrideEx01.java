package ch05;

class A {
	void run() {
		System.out.println("A 달린다.");
	}
}

class B extends A{
	@Override
	void run() {
		System.out.println("B 달린다.");
	}
}

class C extends B {
	String name = "C";
	@Override
	void run() {
		System.out.println(name + "달린다.");
	}
}

public class OverrideEx01 {

	public static void main(String[] args) {
		A a1 = new A();
		a1.run();
		
		A a2 = new B();
		a2.run();

		A a3 = new C();
		a3.run();

		B b2 = new B();
		b2.run();
		
		B b3 = new C();
		b3.run();
		
		C c1 = new C();
		c1.run();

		
	}
}
