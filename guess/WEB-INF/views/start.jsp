<!DOCTYPE html>
<html>
	<head>
		<title>Guess-o-Rama 3000&trade;</title>
	</head>
	<body>
		<h1>Welcome to the Guess-o-Rama 3000&trade;!</h1>
		<p>
			I've selected a whole number between 1 and ${range}.
			Guess my number!
		</p>
		<form method="POST" action="main">
			<input type="hidden" name="action" value="guess"/>
			<input type="text" name="guess" min="1" max="${range}"/>
			<input type="submit" value="Submit my Guess"/>
		</form>
	</body>
</html>