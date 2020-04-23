package ch13;

//OS�� Runnable Ÿ���� heap������ run�޼��带 ȣ���ؾߵȴٴ� �� �̹� �˰� ����.
class Sub implements Runnable{
	@Override
	public void run() {
		for (int i = 1; i < 40; i++) {
			System.out.println("���� ������ :" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx01 {

	
	//���� ������
	public static void main(String[] args) {
		Sub s = new Sub();
		Thread t1 = new Thread(new Sub());
		t1.start();
		
		
		for (int i = 1; i < 30; i++) {
			System.out.println("���� ������ :" + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
