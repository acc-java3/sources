<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
		<title>Widgets, Inc.&trade; Staff</title>
	</head>
	<body>
		<h1>Staff of Widgets, Inc&trade;</h1>
		<table class="w3-table w3-striped w3-border w3-hoverable">
			<tr><th>Employee Name</th></tr>
		<c:forEach var="emp" items="${staff}">
			<tr>
				<td>
					<a href="main?action=details&id=${emp.id}">
						${emp.lastName}, ${emp.firstName}
					</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</body>
</html>