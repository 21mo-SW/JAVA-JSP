package coffeeshop;

//책임:주문
public class Consumer {

	public void 주문(String menuName, Menu menu, Barista barista) {
		
		//손님 -> 메뉴판 메시지를 보낸다. (메뉴 선택해줘)
		Menuitem menuitem = menu.메뉴선택(menuName);
		
		if(menuitem == null) {
			System.out.println(menuName + "은 우리 매장에 없습니다.");
		}else {
			//손님 - > 바리스타 메시지를 보낸다.(커피 생성해줘)
			Coffee coffee = barista.커피생성(menuitem);
			System.out.println("커피 나왔습니다.");
			System.out.println(coffee.getName());
			System.out.println(coffee.getPrice());
		}
	}
}
