package util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.ScheduleDao;
import models.FlightApp;
import models.FlightInfoService;
import models.Item;

public class BulkSearch {

	public static void main(String[] args) {
		
		
		////////// 공항 목록 가져오기 ////////////
		Set<Map.Entry<String,String>> entrySet = FlightInfoService.airPortId.entrySet();
		List<String> airportList = new ArrayList<>();
		
		for (Map.Entry<String,String> entry : entrySet) {
			airportList.add(entry.getKey());
		}
		
		////////// 오늘 날짜를 20200506 형식으로 가져오기 ///////////
		LocalDate startDate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		// String dateStr = startDate.format(dtf);
		String dateStr;
		
		////////// 
		
		for (int i = 0; i < airportList.size(); i++) {
			List<String> airportClone = (List<String>)((ArrayList)airportList).clone();
			String departAirportName = airportClone.remove(i);
			
			for (int j = 0; j < airportClone.size(); j++) {
				String arrivalAirportName = airportClone.get(j);
				
				for (int k = 0; k < 7; k++) {
					dateStr = startDate.plusDays(k).format(dtf);
					
					FlightApp fapp = new FlightApp(departAirportName, arrivalAirportName, dateStr);
					List<Item> result = fapp.search();
					
					
			// nullpointexception 이 발생해서 원인을 알아보기 위해 임시로 작성한 코드인데
			// 확인 결과 하루 검색 건수 1000건을 초과해서 발생한 오류였음!
			/* for debug only
			String departAirportName = "NAARKPC";
			String arrivalAirportName = "NAARKNW";
			dateStr = "20200510";
			FlightApp fapp = new FlightApp("NAARKPC", "NAARKNW", "20200510");
			List<Item> result = fapp.search();
			*/
					
					int resultCount = (result == null)? 0 : result.size();
					
					System.out.println("출발지: " + FlightInfoService.airPortId.get(departAirportName)
									+ " / 도착지: " + FlightInfoService.airPortId.get(arrivalAirportName)
									+ " / 출발일자: " + dateStr + " / 총 비행편: " + resultCount);
					
					/*
					if (result.size() != 0) {
						ScheduleDao dao = ScheduleDao.getInstance();
						dao.bulkInsert(result);
					}
					*/
				}
			}
		}
	}

}
