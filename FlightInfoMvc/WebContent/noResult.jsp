<%@page import="airplane.mvc.model.FlightInfoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String depart = request.getParameter("depart");
	String arrival = request.getParameter("arrival");
	String departTime = request.getParameter("departTime");
%>
	<h3>출발지 : <%= FlightInfoService.airPortId.get(depart) %> / 도착지: <%= FlightInfoService.airPortId.get(arrival) %> / 출발일자: <%= departTime %> 에 대한 검색결과가 0건입니다.</h3>


</body>
</html>