package airplane.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import airplane.mvc.model.FlightInfo;
import airplane.mvc.model.FlightInfoService;
import airplane.mvc.model.Item;

public class FlightApp {
	private String depAirportId;
	private String arrAirportId;
	private long depPlandTime;

	// 생성자
	public FlightApp(String depAirportId, String arrAirportId, String depPlandTime) {
		this.depAirportId = depAirportId;
		this.arrAirportId = arrAirportId;

		// "2020-04-15" 형식의 문자열에서 하이픈을 떼어
		// "20200415" 와 같이 바꾸고 long 타입으로 변환함
		String temp = depPlandTime.replaceAll("-", "");
		this.depPlandTime = Long.parseLong(temp);
	}

	// 출발지, 도착지, 출발날짜 지정(이 세 값은 이미 FlightApp 생성자로 받아와 있음)으로 공공데이터포털 조회 후 결과가 몇건인지
	// 반환함
	public int getTotalCount() {

		int totalCount = 0;
		FlightInfo.firstPage = null;
		
		// FlightInfo의 첫페이지만 가져오면 그 안에 totalCount 정보가 들어있음
		FlightInfo flightInfo = getFlightInfo(1);

		// 0건일 경우에는 flightInfo가 null로 반환됨
		if (flightInfo == null)
			totalCount = 0;
		else {
			// totalCount가 0건이 아닌 경우 건수 확인을 위해 읽어왔던 FlightInfo 객체의 참조값을
			// FlightInfo.firstPage에 저장해 둠
			totalCount = flightInfo.getResponse().getBody().getTotalCount();
			FlightInfo.firstPage = flightInfo;
		}

		return totalCount;
	}

	// 출발지, 도착지, 출발날짜 지정(이 세 값은 이미 FlightApp 생성자로 받아와 있음)으로 검색한 후 여러 페이지일 경우
	// 페이지를 바꿔가며 차례로 가져올 수 있는 메서드. 페이지 수는 1로 시작!
	public FlightInfo getFlightInfo(int page) {

		FlightInfo flightInfo = null;

		// getTotalCount() 실행시 서버로부터 가져와 저장해 둔 firstPage가 있는 경우에는
		// 서버로부터 동일한 정보를 다시 읽어올 필요없이 바로 그 firstPage를 반환하도록 함
		if (page == 1 && FlightInfo.firstPage != null) {
			flightInfo = FlightInfo.firstPage;
			return flightInfo;
		}

		try {

			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=6Aj6QvTKUdFZT5TLrIZQGfv6iEyrS2GiE1EUSE1nkNCSv81UudjGXMKgW1LD3uR2UtxJVDG5w5Kf7h4zO7itJQ%3D%3D&numOfRows=50&pageNo="
							+ page + "&depAirportId=" + this.depAirportId + "&arrAirportId=" + this.arrAirportId
							+ "&depPlandTime=" + this.depPlandTime + "&_type=json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

			StringBuilder sb = new StringBuilder();

			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
			}

			br.close();
			conn.disconnect();

			Gson gson = new Gson();
			flightInfo = gson.fromJson(sb.toString(), FlightInfo.class);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			/*
			 * Gson은 items의 value값으로 JSON 객체가 오기를 기대하고 오브젝트의 시작을 표시하는 '{'가 올거로 예상하고 있는데 특이하게
			 * 조회결과 건수가 0일 때는 공공데이터포털 서버는 items의 value값으로 빈 객체 {}가 아닌 ""라는 빈 문자열을 반환한다. 즉,
			 * JSON 오브젝트가 와야할 자리에 문자열이 오고 있기 때문에 JsonSyntaxException 에러를 발생시키게 되는 것이다. 이 예외
			 * 발생시 gson.fromJson()에서 예외 발생하고 flightInfo 값은 세팅되지 못해 null이 반환된다.
			 */
		}

		return flightInfo;
	}

	public List<Item> search() {

		int totalCount = getTotalCount();

		// 바로 위의 getTotalCount() 호출에서 결과가 0건인 경우에는 아래 if문만 실행하고 종료함
		if (totalCount == 0) {
			return null;
		}

		// totalCount 0건이 아닌 경우는 아래로 진행함

		// 항공기운항정보 페이지에 페이지당 50건씩 출력하도록 설정되어 있으므로
		// totalCount로부터 몇페이지까지 읽어와야 하는지를 알아낼 수 있다.
		// 50으로 나누어 떨어지는 경우는(나머지가 0) 50으로 나눈 몫을 pageCount에 넣고
		// 나머지가 있는 경우는 50으로 나눈 후 1을 더한 값을 pageCount에 넣도록 함
		// 50건 100건인 경우는 각각 1페이지 2페이지로 충분하지만
		// 51건, 101건인 경우는 각각 2페이지 3페이지가 되어야 하므로

		int pageCount = (totalCount % 50 == 0) ? (totalCount / 50) : (totalCount / 50 + 1); // 삼항연산자
		List<Item> allFlights = new ArrayList<>();

		for (int page = 1; page <= pageCount; page++) {
			FlightInfo flightInfo = getFlightInfo(page);
			List<Item> flightItems = flightInfo.getResponse().getBody().getItems().getItem();

			allFlights.addAll(flightItems);

		}

		return allFlights;
	}

}
