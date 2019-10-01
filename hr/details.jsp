<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
		<title>Details for Employee ${emp.id}</title>
	</head>
	<body>
		<h1>Employee Details for ${emp.id}</h1>
		<h2><font color="red">${flash}</font></h2>
		<table class="w3-table w3-striped w3-border">
			<tr><th>Last Name</th><th>First Name</th><th>Id</th><th>Title</th></tr>
			<tr>
				<td>${emp.lastName}</td>
				<td>${emp.firstName}</td>
				<td>${emp.id}</td>
				<td>${emp.title}</td>
			</tr>
		</table>
		<hr/>
		<c:choose>
			<c:when test="${type eq 'S'}">
				<%@include file="salaried.jspf"%>
			</c:when>
			<c:when test="${type eq 'H'}">
				<%@include file="hourly.jspf"%>
			</c:when>
			<c:when test="${type eq 'P'}">
				<%@include file="pieceworker.jspf"%>
			</c:when>
		</c:choose>
		<hr/>
		<h3>Gross Pay This Week: ${emp.pay}</h3>		
	</body>
</html>