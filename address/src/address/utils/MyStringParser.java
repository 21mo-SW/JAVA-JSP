package address.utils;

public class MyStringParser {
	public static int getId(String selectedList) {
		
		return Integer.parseInt(selectedList.split("\\.")[0]);
		// return Integer.parseInt(selectedList.split("[.]")[0]);	// 이걸로 해도 됨
	}
}