package ch04;

//상태와 행동
public class Person {
	String name;
	String job;
	int age;
	char gender;
	String bloodType;
	
	//생성자 = 초기화하는 것.
	//디폴트 생성자 = 매개변수가 없는 것   
	//ctrl + space로 바로 만들수 있고 
	//오브젝트에 ctrl + 클릭하면 생성자로 이동한다
	public Person() {
	
	}
	
	//오버로딩
	public Person(String name, String job, int age, char gender, String bloodType) {
		this.name = name;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.bloodType = bloodType;
	}
	
		
	
}
