<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Headers App</title>
		<link rel="stylesheet"
			href="https://www.w3schools.com/w3css/4/w3.css"/>
	</head>
	<body>
		<h1>Request Headers</h1>
		<table class="w3-table w3-striped w3-border">
			<tr><th>Name</th><th>Value</th></tr>
			<%
				Enumeration<String> headerNames = request.getHeaderNames();
				while (headerNames.hasMoreElements()) {
					String headerName = headerNames.nextElement();
					out.print("<tr>");
					out.print("<td>" + headerName + "</td>");
					out.print("<td>" + request.getHeader(headerName) + "</td>");
					out.println("</tr>");
				}
			%>
		</table>
		<h1>Response Headers</h1>
		<table class="w3-table w3-striped w3-border">
			<tr><th>Name</th><th>Value</th></tr>
			<%
				response.addHeader("Foo", "Bar!");
				for (String headerName : response.getHeaderNames()) {
					out.print("<tr>");
					out.print("<td>" + headerName + "</td>");
					out.print("<td>" + response.getHeader(headerName) + "</td>");
					out.println("</tr>");
				}
			%>
		</table>

	</body>
</html>








