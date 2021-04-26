<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="getall.meg">
<table >
<thead>
<tr>
<td>TeamId</td>
<td>TeamName</td>
<td>HomeGround</td>
<td>Captain</td>
<td>update</td>
<td>delete</td>
</tr>
</thead>
<tbody>
	<c:forEach var="team" items="${teamList}" >
	<tr>
		<td>${team.getTeamId()}</td>
		<td>${team.getTeamName()}</td>
		<td>${team.getHomeGround()}</td>
		<td>${team.getCaptain()}</td>
		<td><a href="update.jsp" >Edit</a></td>
		<td><a href="delete.jsp" >Delete</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</form>
</body>
</html>