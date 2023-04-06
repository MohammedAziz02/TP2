<%@ page import="com.tp2.Models.Person" %><%--
  Created by IntelliJ IDEA.
  User: Mohammed Aziz02
  Date: 4/4/2023
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
  <title>Test</title>

</head>
<body>
<div class="container">
  <h1>Test view</h1>
  <%--<p>${text}${city}</p>
  <p>${Person.firstName} ${Person.lastName}</p>--%>
  <%
    Person p1 = (Person) session.getAttribute("p1");
    System.out.println("from testJSP le person dans la sessions est ; " + p1);
  %>
</div>
</body>
</html>
