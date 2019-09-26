<%@taglib prefix="l4j" uri="http://logging.apache.org/log4j/tld/log"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <l4j:trace message="entering view.jsp body tag"/>
        <h1>Hello ${target}!</h1>
        <l4j:dump scope="request"/>
        <l4j:trace message="leaving view.jsp body tag"/>
    </body>
</html>
