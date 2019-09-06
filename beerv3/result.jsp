<!DOCTYPE html>
<html>
    <head>
        <title>BeerV3 Suggestion</title>
    </head>
    <body>
        Based on your color choice, we recommend the following brands:
        <ul>
<%
    java.util.List<String> brands = (java.util.List<String>)request.getAttribute("styles");
    for (String brand : brands)
        out.println("\t\t\t<li>" + brand + "</li>");
%>
        </ul>
    </body>
</html>

