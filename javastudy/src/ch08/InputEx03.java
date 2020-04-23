package ch08;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputEx03 {
	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader reader = 
				new InputStreamReader(in);
		BufferedReader br =
				new BufferedReader(reader);
		
		//위에문장들 요약하면 br2
		BufferedReader br2 =
				new BufferedReader(new InputStreamReader(System.in));
		String data = "";
			try {
				while((data = br2.readLine()) != null) {
				System.out.println(data);
			} 
			}	catch (Exception e) {
				e.printStackTrace();
			}
			
			}
	
	}


