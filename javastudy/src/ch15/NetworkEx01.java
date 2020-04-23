package ch15;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx01 {

	public static void main(String[] args) {
		
		try {
			//1�� �ּ� ��ü �����
			URL url = new URL("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=NpWoK%2B9TXI2ANBiLmAIG1KE0t8YevjqBYbvwmUc1btYTqfeRmnuhE7QJQOYaY3zdHsmbb%2BMVw03q2adzmFp1Tw%3D%3D&numOfRows=10&pageNo=1&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20200407&airlineId=AAR&_type=json");
			
			//2�� ��Ʈ�� ����
			HttpURLConnection con =  //con�� ��Ʈ���� ����
					(HttpURLConnection)url.openConnection();
			
			//3�� ���ۿ���(���ڿ�)
			BufferedReader br =
					new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			
			//���Ͽ� ��Ʈ�� ����
			//FileWriter fr = new FileWriter("c:\\utils\\test.html");
			
			//���� ���ϱ�
			StringBuilder sb = new StringBuilder();

			String input = "";
			while((input = br.readLine()) != null) { //readline�� ���پ� �о��.
				sb.append(input); //append �� �ϳ��� �ִ°��̴�?
			}
			//fr.write(sb.toString()); //.toStirng�� ���� ���ڿ����Ѵٴ�
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace(); //������ �����ؼ� �������� �� �����ִ� ����
		
	}
  }
}
