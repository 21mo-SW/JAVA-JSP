<!--<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>-->
<%@ page import="java.sql.*" contentType="text/html; charset=EUC-KR" %>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:XE";
Connection dbconn=DriverManager.getConnection(url,"c##madang","c##madang");
Statement stmt = dbconn.createStatement();
String bookid=request.getParameter("bookid");
ResultSet myResultSet=stmt.executeQuery("SELECT * FROM Book WHERE bookid='"+bookid+"'");
if(myResultSet!=null){
	myResultSet.next();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>***Book VIEW **</title>
</head>
<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red">
<table border="1" cellspacing="0" width="400" bordercolor="gray"
		bordercolordark="white" bordercolorlight="blue">
	<tr>
	 <td width="150" height="23">
	 	<p align="center">
	 	<span style="font-size:9pt;">å �� ��</span></p>
	 </td>
	 <td width="513">
	 	<p><span style="font-size:9pt;">
	 	<%=myResultSet.getString("BOOKNAME")%></span></p>
	 </td>
	</tr>
	<tr>
	 <td width="150" height="23">
	 	<p align="center">
	 	<span style="font-size:9pt;">�� �� ��</span></p>
	 <td width="513">
	 	<p><span style="font-size:9pt;">
	 	<%=myResultSet.getString("PUBLISHER")%></span></p>
	 </td>
	</tr>
	<tr>
	 <td width="150" height="23">
	 	<p align="center">
	 	<span style="font-size:9pt;">�� ��</span></p>
	 </td>
	 <td width="513">
	 	<p><span style="font-size:9pt;">
	 	<%=myResultSet.getString("PRICE")%></span></p>
	 </td>
	</tr>
</table>
<table cellpadding="0" cellspacing="0" width="400" height="23">
	<tr>
	 <td width="150">
	 	<p align="right"><span style="font-size:9pt;">
	 	<a href="booklist.jsp?">
	 	<font color="black">���</font></a></span></p>
	 </td>
	</tr>
</table>
<%
	}stmt.close();
	dbconn.close();
%>
</body>
</html>