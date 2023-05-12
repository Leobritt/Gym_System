<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.GymMember"%>
<%@ page import="java.util.ArrayList"%>
<%
GymMember gymMember = (GymMember) request.getAttribute("gymMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- add css e js -->
<title>Update Page</title>
<link rel="stylesheet" href="createupdate.css">
</head>
<body>
	<h1>UPDATE</h1>
	<form action="updateGM" method="post">
		<h2>Data about Gym Members</h2>
		<input type="hidden" name="id" value="<%=gymMember.getId()%>">
		<label for="name">Name:</label> <br> <input type="text"
			name="name">

		<h4>Please select your sex</h4>
<input type="radio" id="male" name="sexOption" value="male">
<label for="male">Male</label><br>
<input type="radio" id="female" name="sexOption" value="female">
<label for="female">Female</label><br>
<input type="radio" id="other" name="sexOption" value="Other">
<label for="other">Other</label><br><br>

		
		<label
			for="weight">Weight:</label> <br> <input type="text"
			name="weight"> <br> <input type="submit">

	</form>
</body>
</html>