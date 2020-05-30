<%@page import="java.text.DecimalFormat"%>
<%@page import="airplane.mvc.model.FlightInfoService"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="airplane.mvc.model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table {
  		border-collapse: collapse;
	}
	table, th, td {
  		border: 1px solid black;
	}
	td, th {
		text-align: center;
		padding: 3px;
	}
	th {
		background-color:  LightSalmon;
	}
	td {
		background-color: Snow;
	}
</style>
<title>검색 결과</title>
</head>
<body>
<%
	String depart = request.getParameter("depart");
	String arrival = request.getParameter("arrival");
	String departTime = request.getParameter("departTime");
%>
	<h3>출발지 : <%= FlightInfoService.airPortId.get(depart) %> / 도착지: <%= FlightInfoService.airPortId.get(arrival) %> / 출발일자: <%= departTime %>에 대한 검색결과입니다.</h3>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>출발시간</th>
				<th>도착시간</th>
				<th>항공사</th>
				<th>이코노미 요금</th>
				<th>비즈니스 요금</th>
			</tr>
		</thead>
<%
	List<Item> allFlights = (List<Item>)request.getAttribute("result");

	int num = 1;	// 출력결과 테이블에서 일련번호
	DecimalFormat formatter = new DecimalFormat("###,###");	// 요금 숫자에 콤마 찍기
	
	
	for (Item item : allFlights) {
		// 202004271020(년월일시분)에서 1020(시분)만 남김
		String depTimeStr = String.valueOf(item.getDepPlandTime()).substring(8);	// 출발
		String arrTimeStr = String.valueOf(item.getArrPlandTime()).substring(8);	// 도착
		// 1020(시분) 문자열의 가운데에 ':'를 넣어 10:20으로 수정함
		String depTime = depTimeStr.replaceAll("..(?!$)", "$0:");	// (?!$) - 문자열 끝이 아니어야
		String arrTime = arrTimeStr.replaceAll("..(?!$)", "$0:");	// 
%>
		<tr>
			<td><%= num %></td>
			<td><%= depTime %></td>
			<td><%= arrTime %></td>
			<td><%= item.getAirlineNm() %></td>
			<td><%= formatter.format(item.getEconomyCharge()) %></td>
			<td><%= formatter.format(item.getPrestigeCharge()) %></td>
		</tr>
<%
		num++;
	}
%>

		<tfoot>
			<tr>
				<th colspan="4">총 검색 결과</th>
				<th colspan="2"><%= allFlights.size()%> 건</th>
			</tr>
		</tfoot>
</table>

</body>
</html>