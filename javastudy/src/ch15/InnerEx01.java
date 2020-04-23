package ch15;

class MyOuterClass {
	int outernum = 10;

	class MyInnerClass {
		int innerNum = 20;
	}
}

public class InnerEx01 {
	public static void main(String[] args) {
		MyOuterClass moc = new MyOuterClass();
		moc.new MyInnerClass();
	}

}


