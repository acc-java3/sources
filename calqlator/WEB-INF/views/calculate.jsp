<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>CalQlator&trade;</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
		<style type="text/css">.flash {color:#B22222;}</style>
	</head>
	<body>
		<div class="w3-container w3-margin">
			<h1>Welcome to the CalQlator&trade;!</h1>

			<!-- flash here if there's an error message -->
			<c:if test="${not empty flash}"><h2 class="flash">${flash}</h2></c:if>
			
			<!-- result of the last expression if there was one -->
			<c:if test="${not empty lastCalc}"><h2><tt>${lastCalc}</tt></h2></c:if>
			
			<!-- form for defining a calculation here -->
			<%@include file="/WEB-INF/views/calcForm.jspf"%>
			
			<!-- previous calculations here if there are any -->
			<c:if test="${not empty calcList}">
			<%@include file="/WEB-INF/views/calcList.jspf"%>
			</c:if>
		</div>
	</body>
</html>