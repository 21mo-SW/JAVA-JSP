package coffeeshop;

import java.util.ArrayList;

public class CoffeeApp {

	public static void main(String[] args) {
		//�޴�, �ٸ���Ÿ, �մ�
		Consumer consumer = new Consumer();
		Barista barista = new Barista();
		
		Menuitem m1 = new Menuitem("�Ƹ޸�ī��", 1500);
		Menuitem m2 = new Menuitem("ī���", 2500);
		Menuitem m3 = new Menuitem("īǪġ��", 4000);
		
		ArrayList<Menuitem> menuitems =
				new ArrayList<>();
		
		menuitems.add(m1);
		menuitems.add(m2);
		menuitems.add(m3);
		
		Menu menu = new Menu(menuitems);
		//System.out.println(menuitems.get(1).getName()); //m2
		
		consumer.�ֹ�("�Ƹ޸�ī��", menu, barista);
	}

}
