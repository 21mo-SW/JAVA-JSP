package coffeeshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Ŭ���� �ڷ��� : Beans = Table(DB)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menuitem {
	private String name;
	private int price;
}
