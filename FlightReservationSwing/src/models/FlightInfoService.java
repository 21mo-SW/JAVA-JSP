package models;

import java.util.HashMap;

public class FlightInfoService {

	// 이 필드는 만들긴 했지만 쓰임이 없어서 일단 주석처리함
	// setAirLineId() 메서드도 함께!
	// public static HashMap<String, String> airLineId = new HashMap<>();

	public static HashMap<String, String> airPortId = new HashMap<>();

	
	// 클래스 로딩시 아래 클래스 초기화 블록이 단 한번 실행된다.
	static {
		// setAirLineId();
		setAirPortId();
	}

	/*
	public static void setAirLineId() {
		airLineId.put("아시아나항공", "AAR");
		airLineId.put("에어부산", "ABL");
		airLineId.put("이스타항공", "ESR");
		airLineId.put("제주항공", "JJA");
		airLineId.put("진 에어", "JNA");
		airLineId.put("대한 항공", "KAL");
		airLineId.put("티웨이항공", "TWB");
	}
	*/

	public static void setAirPortId() {
		airPortId.put("NAARKJB","무안");
		airPortId.put("NAARKJJ", "광주");
		airPortId.put("NAARKJK", "군산");
		airPortId.put("NAARKJY", "여수");
		airPortId.put("NAARKNW", "원주");
		airPortId.put("NAARKNY", "양양");
		airPortId.put("NAARKPC", "제주");
		airPortId.put("NAARKPK", "김해");
		airPortId.put("NAARKPS", "사천");
		airPortId.put("NAARKPU", "울산");
		airPortId.put("NAARKSI", "인천");
		airPortId.put("NAARKSS", "김포");
		airPortId.put("NAARKTH", "포항");
		airPortId.put("NAARKTN", "대구");
		airPortId.put("NAARKTU", "청주");
	}
}
