<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.GymMember"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<GymMember> listaGymMember = (ArrayList<GymMember>) request.getAttribute("listaGM");
GymMember gymMember = (GymMember) request.getAttribute("gymMember");
%>
<!DOCTYPE html>
<html>
<head>
<!-- add css e js -->

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

				<td><%=listaGymMember.get(i).getName()%></td>
				<td><%=listaGymMember.get(i).getSex()%></td>
				<td><%=listaGymMember.get(i).getWeight()%></td>

				<td><a href="goToUpdate?id=<%=id%>">Editar</a></td>
				<td><a href="delete?id=<%=id%>">Deletar</a></td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>