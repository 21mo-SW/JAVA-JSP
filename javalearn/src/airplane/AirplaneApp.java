package airplane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class AirplaneApp {
	
	public static AirplaneInfo getAirplaneInfo(String depAirportId, String arrAirportId, Long depPlandTime) {
		
		AirplaneInfo airplaneInfo = null;
		
		try {
			URL url = new URL("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=6Aj6QvTKUdFZT5TLrIZQGfv6iEyrS2GiE1EUSE1nkNCSv81UudjGXMKgW1LD3uR2UtxJVDG5w5Kf7h4zO7itJQ%3D%3D&numOfRows=50&pageNo=1" + "&depAirportId=" + AirplaneInfoService.airPortId.get(depAirportId) + "&arrAirportId=" + AirplaneInfoService.airPortId.get(arrAirportId) + "&depPlandTime=" + depPlandTime + "&_type=json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			
			StringBuilder sb = new StringBuilder();
			String input = "";
			while((input = br.readLine())!=null) {
				sb.append(input);
			}
		
			br.close();
			conn.disconnect();
			
			Gson gson = new Gson();
			airplaneInfo = gson.fromJson(sb.toString(), AirplaneInfo.class);
		
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return airplaneInfo;
		
	}
	
	
	
	public static void main(String[] args) {
		AirplaneInfoService.setAirLine();
		AirplaneInfoService.setAirPortId();
		
		for(String key : AirplaneInfoService.airPortId.keySet()) {
			System.out.print(key + ", ");
		}
		System.out.println();
		System.out.println("출발지를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String depAirportId = sc.next();
		
		System.out.println("도착지를 입력하세요.");
		String arrAirportId = sc.next();
		
		System.out.println("출발일자를 입력하세요");
		String depPlandTimeTemp = sc.next();
		
		
		
		
		
		long depPlandTime = Long.parseLong(depPlandTimeTemp);
		Integer depPlandTimeInteger = Integer.parseInt(depPlandTimeTemp);
		Double depPlandTimedouble = Double.parseDouble(depPlandTimeTemp);
		
		String strTemp = depPlandTime + "";
		String strTemp2 = depPlandTimeInteger.toString();
		String strTemp3 = depPlandTimedouble.toString();
		
		
		AirplaneInfo airplaneInfo = getAirplaneInfo(depAirportId, arrAirportId, depPlandTime);
		List<Item> item = airplaneInfo.getResponse().getBody().getItems().getItem();
		
		//iterator(반복)
		for (Item it : item) { //for-each문
			System.out.println("항공사 : "+it.getAirlineNm());
			System.out.println("출발지 : "+it.getDepAirportNm());
			System.out.println("도착지 : "+it.getArrAirportNm());
			System.out.println("출발시간 : "+it.getDepPlandTime());
			System.out.println("도착시간 : "+it.getArrPlandTime());
			System.out.println("요금 : "+it.getEconomyCharge());
			System.out.println();
		
		}
		
	}
}
		

