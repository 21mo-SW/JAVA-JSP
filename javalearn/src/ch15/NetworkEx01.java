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
			//1번 주소 객체 만들기
			URL url = new URL("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=NpWoK%2B9TXI2ANBiLmAIG1KE0t8YevjqBYbvwmUc1btYTqfeRmnuhE7QJQOYaY3zdHsmbb%2BMVw03q2adzmFp1Tw%3D%3D&numOfRows=10&pageNo=1&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20200407&airlineId=AAR&_type=json");
			
			//2번 스트림 연결
			HttpURLConnection con =  //con은 스트림을 말함
					(HttpURLConnection)url.openConnection();
			
			//3번 버퍼연결(문자열)
			BufferedReader br =
					new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			
			//파일에 스트림 연결
			//FileWriter fr = new FileWriter("c:\\utils\\test.html");
			
			//문자 더하기
			StringBuilder sb = new StringBuilder();

			String input = "";
			while((input = br.readLine()) != null) { //readline은 한줄씩 읽어낸다.
				sb.append(input); //append 는 하나씩 넣는것이다?
			}
			//fr.write(sb.toString()); //.toStirng은 전부 문자열로한다는
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace(); //오류를 추적해서 빨간줄을 다 보여주는 문장
		
	}
  }
}
