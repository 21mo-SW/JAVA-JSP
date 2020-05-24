package stars;



//인터페이스는
//추상클래스와 유사
//추상 메서드만 존재가능
//인터페이스에서는 퍼블릭과 앱스트랙트가 없어도 존재한다.
public interface Behavior {
	public void move(); 
	void repair();
	void attack(Behavior unit);
}
