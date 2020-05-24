package coffeeshop;

import lombok.Data;

@Data
public class Coffee {
	private String name;
	private int price;
	
	public Coffee(Menuitem menuitem) {
		this.name = menuitem.getName();
		this.price = menuitem.getPrice();
	}
	
	
}
