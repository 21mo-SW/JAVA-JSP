package ch04;

//���¿� �ൿ
public class Person {
	String name;
	String job;
	int age;
	char gender;
	String bloodType;
	
	//������ = �ʱ�ȭ�ϴ� ��.
	//����Ʈ ������ = �Ű������� ���� ��   
	//ctrl + space�� �ٷ� ����� �ְ� 
	//������Ʈ�� ctrl + Ŭ���ϸ� �����ڷ� �̵��Ѵ�
	public Person() {
	
	}
	
	//�����ε�
	public Person(String name, String job, int age, char gender, String bloodType) {
		this.name = name;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.bloodType = bloodType;
	}
	
		
	
}
