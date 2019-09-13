<%@page import="edu.acc.java3.ctxlisten.Dog"%>
<!DOCTYPE html>
<html>
	<body>
		<h1>
		<% 
			Dog dog = (Dog)getServletContext().getAttribute("dog");
			out.print(dog);
		%>
		</h1>
	</body>
</html>