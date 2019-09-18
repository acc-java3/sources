<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Summary Of Spam-o-Tron 3000&trade;</title>
	</head>
	<body>
		<%
			Set<String> subscribers = (Set<String>)application.getAttribute("subscribed");
			Set<String> unsubscribers = (Set<String>)application.getAttribute("unsubscribed");
		%>
		<h1>Subscribers</h1>
		<ul>
		<%
			for (String email : subscribers)
				out.println("\t\t\t<li>" + email + "</li>");
		%>
		</ul>
		<h1>Unsubscribers</h1>
		<ul>
		<%
			for (String email : unsubscribers)
				out.println("\t\t\t<li>" + email + "</li>");
		%>
		</ul>
	</body>
</html>