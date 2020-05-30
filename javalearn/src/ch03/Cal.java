package ch03;

public class Cal {

		static int add(int n1, int n2) {  //void는 예약어(키워드) void선언은 return하지 않는다.  int는 타입이고 add는 메소이다.
			int result = n1 + n2;
			//System.out.println("result:" + result);
			return result;  //return은 가장 마지막에
		}
		
		static int minus(int n1, int n2) {
			int result = n1 - n2;
			return result;
		}
		
		static int multi(int n1, int n2) {
			int result = n1 * n2;
			return result;
		}
		
		static int devide(int n1, int n2) {
			int result = n1 / n2;
			return result;

	}

}
