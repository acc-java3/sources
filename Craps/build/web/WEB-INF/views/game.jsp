<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Craps-o-rama&trade;</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
        <link rel="stylesheet" href="styles/main.css"/>
    </head>
    <body>
        <div id="ui" class="w3-display-container w3-display-topmiddle
             w3-round-xlarge w3-card-4 w3-palegreen w3-margin w3-padding">
            <h1>Welcome to Craps-o-rama&trade;!<br/>You have $${player.bank}
                to spend.</h1>
            <c:if test="${player.sum ne 0}">
                <h2>
                    You rolled
                    <img src="images/die${player.die1}.png"/> +
                    <img src="images/die${player.die2}.png"/> =
                    ${player.sum}
                </h2>    
            </c:if>
            <c:if test="${player.point ne 0}">
                <h3>Your point is ${player.point}</h3>
            </c:if>
            <c:choose>
                <c:when test="${status eq 'win'}">
                    <h1 class="win">You WIN!</h1>
                    <%@include file="/WEB-INF/views/summary.jspf"%>
                </c:when>
                <c:when test="${status eq 'lose'}">
                    <h1 class="lose">You LOSE!</h1>
                    <%@include file="/WEB-INF/views/summary.jspf"%>
                </c:when>
                <c:otherwise>
                    <h2>
                        Place a bet and/or click the button to roll the dice!
                        (Current bet: $${player.runningBet})
                    </h2>
                    <form method="POST" action="main">
                        <input type="hidden" name="action" value="play"/>
                        <h3 class="flash">${flash}</h3>
                        <label>Place your bet:</label>
                        $<input id="bet" type="text" name="bet" placeholder="0"/>
                        <input type="submit" value="Roll 'em!"/>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <script>
            document.getElementById("bet").focus();
        </script>
    </body>
</html>
