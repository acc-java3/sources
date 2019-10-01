<!DOCTYPE html>
<html>
	<head>
		<title>Guess-o-Rama 3000&trade;</title>
	</head>
	<body>
		<h1>You're Playing Guess-o-Rama 3000&trade;!</h1>
		<h3>You've made ${game.guesses} guess${game.guesses eq 1 ? "" : "es"} so far.</h3>
		<h3><font color="red">${flash}</font></h3>
		<h2><font color="blue">${message}</font></h2>
		<form method="POST" action="main">
			<input type="hidden" name="action" value="guess"/>
			<input type="text" name="guess" min="1" max="${range}"/>
			<input type="submit" value="Submit my Guess"/>
		</form>
	</body>
</html>