package ch06;

class Animal {
	@Override
	public int hashCode() {
		return 1111;
	}
}

public class ObjectEx01 {

	public static void main(String[] args) {
		String d1 = "물";
		String d2 = "물";
		
		System.out.println(d1.equals(d2));
		System.out.println(d1 == d2);
		
		String d3 = new String("물");
		String d4 = new String("물");
		
		System.out.println(d3.equals(d4));
		System.out.println(d3 == d4);
		
		System.out.println(d3.getClass());
		System.out.println(new ObjectEx01().getClass());
		
		//해쉬코드 -> 해쉬 알고리즘 = 동일한 길이의 숫자로 리턴
		//String클래스에서 오버라이딩되어서 주소가 다르지만 값이 같이면 같은 해쉬코드가 나온다.
		System.out.println(d3.hashCode());
		System.out.println(d4.hashCode());
		
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		
		System.out.println(a1 instanceof Animal);
		System.out.println(a2 instanceof Animal);
	}

}
