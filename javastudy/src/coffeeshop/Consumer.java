package coffeeshop;

//å��:�ֹ�
public class Consumer {

	public void �ֹ�(String menuName, Menu menu, Barista barista) {
		
		//�մ� -> �޴��� �޽����� ������. (�޴� ��������)
		Menuitem menuitem = menu.�޴�����(menuName);
		
		if(menuitem == null) {
			System.out.println(menuName + "�� �츮 ���忡 �����ϴ�.");
		}else {
			//�մ� - > �ٸ���Ÿ �޽����� ������.(Ŀ�� ��������)
			Coffee coffee = barista.Ŀ�ǻ���(menuitem);
			System.out.println("Ŀ�� ���Խ��ϴ�.");
			System.out.println(coffee.getName());
			System.out.println(coffee.getPrice());
		}
	}
}
