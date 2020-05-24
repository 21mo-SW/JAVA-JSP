package coffeeshop;

import java.util.ArrayList;

import lombok.Data;

//å��:�޴� ����
@Data
public class Menu {
	
	
	//�޴� �����۵�(�÷���)
	private ArrayList<Menuitem> menuitems;
	
	public Menu(ArrayList<Menuitem> menuitems) {
		this.menuitems = menuitems;
	}
	

		public Menuitem �޴�����(String menuName) {
			for (Menuitem menuitem : menuitems) { //foreach��
				if(menuitem.getName().equals(menuName)) {
					return menuitem;
				}
			}
			return null;
		}
}
