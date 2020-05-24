package coffeeshop;

import java.util.ArrayList;

import lombok.Data;

//책임:메뉴 선택
@Data
public class Menu {
	
	
	//메뉴 아이템들(컬렉션)
	private ArrayList<Menuitem> menuitems;
	
	public Menu(ArrayList<Menuitem> menuitems) {
		this.menuitems = menuitems;
	}
	

		public Menuitem 메뉴선택(String menuName) {
			for (Menuitem menuitem : menuitems) { //foreach문
				if(menuitem.getName().equals(menuName)) {
					return menuitem;
				}
			}
			return null;
		}
}
