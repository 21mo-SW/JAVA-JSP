package ch08;

import com.google.gson.Gson;

class Family {
	int sharp = 2;
	String father = "ȫ�Ǽ�";
	String mother = "�ἶ";
}

class Person {
	String name = "ȫ�浿";
	int age = 25;
	String gender = "��";
	String address = "����Ư���� ��õ�� ��";
	String[]hobby = {"��", "����"};
	Family family = new Family();
	String company = "��� ������ �ȴޱ� �츸��";
	}

public class JsonEx01 {

	public static void main(String[] args) {
		Gson gson = new Gson();
		//fromJson()�Լ� : Json => java object
		//toJson()�Լ� : java object = > json
		Person p = new Person();
		String personJson = gson.toJson(p);
		System.out.println(personJson);
	}

}
