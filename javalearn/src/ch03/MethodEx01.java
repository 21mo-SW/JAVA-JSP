package ch03;

//메서드(함수)는 클래스안에 작성할 수 있다.
//메서드(함수)는 메서드(함수) 안에 작성할 수 없다.
public class MethodEx01 {

	public static void main(String[] args) {  //컴퓨터는 static과 메인을 먼저 받는다. static과 main은 중요. JVM은 메인 덕에 static을 받을 수 있다.
		int num = Cal.add(5, 3);
		System.out.println("더한 값:" + num);
		
		int num1 = Cal.minus(5, 3);
		System.out.println("뺀 값:" + num1);
		
		int num2 = Cal.multi(5, 3);
		System.out.println("곱한 값:" + num2);
		
		int num3 = Cal.devide(5, 3);
		System.out.println("나눈 값:" + num3);
	}

	
}