package virus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;


public class CoronaApp {
	
	public static int getTotalPages() {
		try {
			// 1. 주소 객체 만들기
			URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=1");

			// 2. 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3. 버퍼 연결 (문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 4. 문자 더하기
			StringBuilder sb = new StringBuilder();

			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
			}

			System.out.println(sb.toString());
			System.out.println();

			br.close();
			con.disconnect();

			
			Gson gson = new Gson();
			Corona corona = gson.fromJson(sb.toString(), Corona.class);

			return corona.getTotalPages();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	public static Corona getCorona(int page) {
		
	try {
		URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page="+page);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		
		StringBuilder sb = new StringBuilder();
		String line = "";
		while((line = br.readLine())!=null) {
			sb.append(line);
		}
		
		//버퍼리더 닫고 URL커넥션 끊기
		br.close();
		conn.disconnect();
		
		//Gson 불러오고 Corona클래스 자바로 변환 
		Gson gson = new Gson();
		Corona corona = gson.fromJson(sb.toString(), Corona.class);
		
		return corona;
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	return null;
}

	public static void main(String[] args) {
		System.out.println();
		System.out.println("지역을 입력하시오.");
		Scanner sc = new Scanner(System.in);
		String lc = sc.nextLine();
		
		//어레이배열생성
		ArrayList<Corona> coronas = new ArrayList<>();
		int totalPages = getTotalPages();
		
		//코로나 페이지 증가
		for (int page = 1; page <= totalPages; page++) {
			Corona corona = getCorona(page);
			page++;
			coronas.add(corona);
		}
		
		
		for(Corona corona : coronas) {
			List<StoreInfo> storeInfos = corona.getStoreInfos();
		
		
		for (StoreInfo storeInfo : storeInfos) { 
			if (storeInfo.getAddr().contains(lc)) {
				System.out.println("약국명: " + storeInfo.getName());
				System.out.println("주소: " + storeInfo.getAddr());
			}
		}
	}
}
}
	
	

