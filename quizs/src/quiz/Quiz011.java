package quiz;

// 아래 배열을 20개로 초기화 하고
// for 문을 이용하여  20 에서  1 까지 입력하고 한 줄로 출력하세요

public class Quiz011 {

	public static void main(String[] args) {
		
		int[] a = new int[20];
		for (int i = 20; i > 0; i--) {
			 a[i] = i + 1; 
			 
			 
			 
		}
		System.out.println(a);
	}
}
