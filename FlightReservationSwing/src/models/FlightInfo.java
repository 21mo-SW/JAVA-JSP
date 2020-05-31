
package models;


public class FlightInfo {
	/* firstPage 필드 :
	FlightApp에서는 주어진 검색조건(출발지,도착지,출발일자)으로 결과 건수가 0인지 아닌지 또 몇 페이지인지 분량인지 판별하기 위해
	우선적으로 getTotalCount()를 호출하고 0건이 아닌 경우에 다시 getFlightInfo()를 호출해
	서버로부터 FlightInfo에 해당하는 데이터들을 가져온다. 이때 getTotalCount()도 내부적으로는
	getFlightInfo(1)으로 첫페이지의 데이터 전체를 가져와서 결과 건수를 확인하므로, 결과적으로는
	1페이지의 데이터는 서버로부터 두 번을 받아오게 된다.
	이런 문제점을 해결하기 위해 getTotalCount() 호출시 0건이 아니면 곧바로 확인을 위해 읽어왔던 FlightInfo
	객체의 참조값을 아래 firstPage에 저장하도록 한다. FlightApp의 getTotalCount() 메서드 참조
	*/
	public static FlightInfo firstPage;
	
	private Response response;

	public Response getResponse() {
		return response;
	}
	
}
