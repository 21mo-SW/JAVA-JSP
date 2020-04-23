package array03;

import java.util.Scanner;

public class ArrayEx051 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String tempNum = num + "";
		String tempNum2[] = tempNum.split("");
		String result = "";
		
		for (int i = tempNum2.length-1, j=1; i >= 0; i--,j++) {
			result = tempNum2[i] + result;
		
			if ((j%3==0) && (i!=0)) {
				result = "," + result;
			}
			
			System.out.println("중간결과 : " + result);	// 코드를 이해하기 쉽도록 중간 결과 출력해 봄
		}
		
		System.out.println(result);
	}
	

}
