<%@page import="java.util.*"%><%-- required for the DoubleSummaryStatistics object --%>
<!DOCTYPE html>
<html>
	<head>
		<title>Mr. Miyagi's Class' Grades</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
	</head>
	<body>
		<!-- GRADES AREA HERE -->
		<h1>The Grades</h1>
		<%
			// remember to cast attributes back to their original type
			double[] grades = (double[])request.getAttribute("grades");
			for (double grade : grades)
				out.println("<span class=\"w3-badge w3-green\">" + grade + "</span>");
		%>
		
		<!-- SUMMARY AREA HERE -->
		<h1>The Stats</h1>
		<%
			// not from java.lang so make sure there's an import directive above
			DoubleSummaryStatistics stats = (DoubleSummaryStatistics)request.getAttribute("stats");
		%>
		<table class="w3-table w3-striped w3-border">
			<tr><th>Stat</th><th>Value</th></tr>
			<tr><td>Minimum</td><td><%= stats.getMin() %></td></tr>
			<tr><td>Maximum</td><td><%= stats.getMax() %></td></tr>
			<tr><td>Average</td><td><%= String.format("%.2f", stats.getAverage()) %></td></tr>
		</table>
	</body>
</html>