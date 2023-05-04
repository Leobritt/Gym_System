<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.GymMember"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<GymMember> listaGymMember = (ArrayList<GymMember>) request.getAttribute("listaGM");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Gym Members</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Sex</th>
				<th>Weight</th>
			</tr>

		</thead>

		<tbody>
			<%
			for (int i = 0; i < listaGymMember.size(); i++) {
				String id = String.valueOf(listaGymMember.get(i).getId());
			%>
			<tr>
			
				<td><%=listaGymMember.get(i).getNome()%></td>
				<td><%=listaGymMember.get(i).getSexo()%></td>
				<td><%=listaGymMember.get(i).getPeso()%></td>
				
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>