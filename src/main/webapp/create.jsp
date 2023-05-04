<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="model.GymMember"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<GymMember> listaGymMember = (ArrayList<GymMember>) request.getAttribute("listaGM");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>CREATE</h1>
	<form action="createGM" method="get"></form>
</body>
</html>