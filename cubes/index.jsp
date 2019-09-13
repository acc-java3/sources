<!DOCTYPE html>
<html>
	<head>
		<title>Cubes App</title>
		<link rel="stylesheet"
			href="https://www.w3schools.com/w3css/4/w3.css"/>
	</head>
	<body>
		<h1>Cubes</h1>
		<table class="w3-table w3-striped w3-border">
			<tr><th>Number</th><th>Square</th><th>Cube</th></tr>
			<!-- dynamic rows begin here-->
			<%
				int number = 5;
				String num = request.getParameter("num");
				if (num != null && num.length() > 0) {
					try {
						int parsed = Integer.parseInt(num);
						if (parsed > 0 && parsed < 1291)
							number = parsed;
					} catch (NumberFormatException nfe) {}
				}
				
				for (int n = 1; n <= number; n++) {
					int square = n * n;
					int cube = square * n;
					StringBuilder sb = new StringBuilder();
					sb.append("\t\t\t<tr>")
						.append("<td>" + n + "</td>")
						.append("<td>" + square + "</td>")
						.append("<td>" + cube + "</td>")
						.append("</tr>");
					out.println(sb);
				} 
			%>
			<!-- dynamic rows end here -->
		</table>
	</body>
</html>