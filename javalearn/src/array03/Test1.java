package array03;

public class Test1 {

	public static void main(String[] args) {
		char arr[] = {'��', '��', '��', '��', '��'};
		
		char newArr[];
		newArr = new char[arr.length];
		
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = arr[arr.length-1-i];
			System.out.print(newArr[i]);
		}
		
	}

}
