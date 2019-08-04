<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table >
	<tr>
		<th>id</th>
		<th>lastName</th>
		<th>email</th>
		<th>gender</th>
	</tr>
	<c:forEach var="emp" items="${emps}">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.lastName}</td>
			<td>${emp.email}</td>
			<td>${emp.gender}</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>