<!DOCTYPE html>
<html>
	<head>
		<title>Guess-o-Rama 3000&trade;</title>
	</head>
	<body>
		<h1>You Win! My Number Was ${game.answer}</h1>
		<h2>You guessed my number in ${game.guesses}
			guess${game.guesses eq 1 ? "" : "es"}.<h2>
		<a href="main?action=start">Play Again!</a>
	</body>
</html>