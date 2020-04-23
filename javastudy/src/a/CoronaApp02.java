package virus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class CoronaApp {

	public static Corona getTotalCount(int page) {
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

			// 5. 자바 오브젝트로 변환
			Gson gson = new Gson();
			Corona corona = gson.fromJson(sb.toString(), Corona.class);

			return corona;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	
	
	
	public static Corona getCorona(int page) {
		
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

			// 5. 자바 오브젝트로 변환
			Gson gson = new Gson();
			Corona corona = gson.fromJson(sb.toString(), Corona.class);

			return corona;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		System.out.println();
		System.out.println("지역을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String loc = sc.nextLine(); // 부산

		int page = 1;

		ArrayList<Corona> coronas = new ArrayList<>();

		for (int i = 0; i < 1; i++) {
			Corona corona = getCorona(page);
			page++;
			coronas.add(corona);
		}

		for (Corona corona : coronas) {
			List<StoreInfo> storeInfos = corona.getStoreInfos();

			for (StoreInfo storeInfo : storeInfos) {
				if (storeInfo.getAddr().contains(loc)) {
					System.out.println("약국명: " + storeInfo.getName());
					System.out.println("주소: " + storeInfo.getAddr());
				}

			}
		}

	}

}
