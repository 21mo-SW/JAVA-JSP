<!--<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<<<<<<< HEAD:.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/booklist_web/bookview.jsp
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection dbconn=DriverManager.getConnection(url,"c##madang","c##madang");
	Statement stmt = dbconn.createStatement();
	String bookid=request.getParameter("bookid");
	ResultSet myResultSet=stmt.executeQuery("SELECT * FROM Book WHERE bookid='"+bookid+"'");
	if(myResultSet != null){
		myResultSet.next();
=======
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
>>>>>>> 22a8a26df6a60d74416eefecfbbe9f245d61659a:web_booklist/WebContent/bookview.jsp
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>***Book VIEW **</title>
</head>
<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red">
<table border="1" cellspacing="0" width="400" bordercolor="gray"
		bordercolordark="white" bordercolorlight="blue">
	<tr>
	 <td width="150" height="23">
	 	<p align="center">
	 	<span style="font-size:9pt;">책 제 목</span></p>
	 </td>
	 <td width="513">
	 	<p><span style="font-size:9pt;">
	 	<%=myResultSet.getString("BOOKNAME")%></span></p>
	 </td>
	</tr>
	<tr>
	 <td width="150" height="23">
	 	<p align="center">
	 	<span style="font-size:9pt;">출 판 사</span></p>
	 <td width="513">
	 	<p><span style="font-size:9pt;">
	 	<%=myResultSet.getString("PUBLISHER")%></span></p>
	 </td>
	</tr>
	<tr>
	 <td width="150" height="23">
	 	<p align="center">
	 	<span style="font-size:9pt;">가 격</span></p>
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
	 	<font color="black">목록</font></a></span></p>
	 </td>
	</tr>
</table>
<%
	}stmt.close();
	dbconn.close();
%>
</body>
</html>