package testmask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

import airplane.FlightInfo;
import airplane.FlightInfoService;

public class MaskApp {

	public static Maskinfo maskInfo(int page) {
		// 매개변수로 페이지를 입력하면 해당페이지객체가 반환됨
		try {
			// 1번 주소 객체 만들기
			URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=" + page);

			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3번 버퍼 연결 (문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 4. 문자 더하기
			StringBuilder sb = new StringBuilder();

			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
			}

			System.out.println(sb.toString());
			System.out.println();

			br.close(); // 버퍼 닫기
			con.disconnect(); // 스트림 닫기

			// 5. 자바 오브젝트로 변환
			Gson gson = new Gson();
			Maskinfo maskInfo = gson.fromJson(sb.toString(), Maskinfo.class);

			return maskInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		// 약국 주소와 이름을 검색
		// 직접 주소를 타이핑해서 검색가능
		Scanner sc = new Scanner(System.in);
		String location = sc.nextLine();

		for (int j = 1; j <= 1; j++) {
			
			Maskinfo test = maskInfo(j);
			
			for (int i = 0; i < test.getStoreInfos().size(); i++) {
				if (test.getStoreInfos().get(i).getAddr().contains(location)) {
					System.out.println(test.getStoreInfos().get(i).getAddr());
					System.out.println(test.getStoreInfos().get(i).getName());
					System.out.println();
				}
			}
		}

	}
}
