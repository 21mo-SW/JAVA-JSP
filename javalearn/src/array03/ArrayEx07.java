package array03;

import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("6자리 숫자를 입력하세요.");
		int num = sc.nextInt(); //6자리수 입력
		
		String strNum=num + "";
		//System.out.println(strNum.charAt(2));
		//System.out.println(strNum.length());
		for (int i = 0; i < strNum.length(); i++) {
			if(strNum.charAt(i) == '3') {
				System.out.println("문자열" + i + "에 3이 존재합니다.");
			}
			
		}
	
	}

}
