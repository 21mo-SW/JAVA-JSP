package ch02;

public class VarEx06 {

	public static void main(String[] args) {
		class 사람 {
			String name = "이원모";
			int age = 27;
			char gender = '남';
			String email = "asd@naver.com";
			String phone = "010-2345-2352";
		}
	  //타입 변수 = 생성자 클래스명();
		사람 a = new 사람();
		System.out.println(a.name);
		System.out.println(a.age);
		System.out.println(a.gender);
		System.out.println(a.email);
		System.out.println(a.phone);

	}

}
