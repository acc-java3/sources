<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Application &raquo; Login</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
    </head>
    <body>
        <div class="w3-display-container w3-display-topmiddle">
            <h1>Log In To Access the Honeypot</h1>
            <c:if test="${not empty flash}">
            <h2 style="color:red;">${flash}</h2>
            </c:if>
            <c:if test="${not empty errors}">
            <ul class="w3-ul">
            <c:forEach var="error" items="${errors}">
                <li style="color:red;">${error}</li>
            </c:forEach>
            </ul>
            </c:if>
            <form class="w3-container" method="POST" action="main">
                <input type="hidden" name="action" value="login"/>
                <label><strong>Username</strong></label>
                <input class="w3-input w3-border w3-light-grey" type="text" name="username"/>
                <label><strong>Password</strong></label>
                <input class="w3-input w3-border w3-light-grey" type="password" name="password"/>
                <button class="w3-btn w3-blue-grey">Log Me In</button>
            </form>
        </div>
    </body>
</html>