package coffeeshop;

import java.util.ArrayList;

public class CoffeeApp {

	public static void main(String[] args) {
		//메뉴, 바리스타, 손님
		Consumer consumer = new Consumer();
		Barista barista = new Barista();
		
		Menuitem m1 = new Menuitem("아메리카노", 1500);
		Menuitem m2 = new Menuitem("카페라떼", 2500);
		Menuitem m3 = new Menuitem("카푸치노", 4000);
		
		ArrayList<Menuitem> menuitems =
				new ArrayList<>();
		
		menuitems.add(m1);
		menuitems.add(m2);
		menuitems.add(m3);
		
		Menu menu = new Menu(menuitems);
		//System.out.println(menuitems.get(1).getName()); //m2
		
		consumer.주문("아메리카노", menu, barista);
	}

}
