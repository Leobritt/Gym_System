<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="model.GymMember"%>
<%@ page import="java.util.ArrayList"%>

<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
<link rel="stylesheet" href="createupdate.css">

</head>
<body>
<!-- add css e js -->

	<h1>CREATE</h1>
	<form action="createGM" method="get">
    <h2>Data about Gym Members</h2>
		<label for="name">Name:</label> 
		<br>
		<input type="text" 
			name="name"> 
			<br> 
			
			<h4>Please select your sex</h4>
<input type="radio" id="male" name="sexOption" value="male">
<label for="male">Male</label><br>
<input type="radio" id="female" name="sexOption" value="female">
<label for="female">Female</label><br>
<input type="radio" id="Other" name="sexOption" value="Other">
<label for="other">Other</label> 

    
<br> 
<br>
        <label for="weight">Weight:</label> 
        <br>
		<input type="text" 
			name="weight"> 
			<br>
			<br>
		<input type="submit">
		
	</form>
</body>
</html>