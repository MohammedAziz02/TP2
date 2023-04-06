<%--
  Created by IntelliJ IDEA.
  User: Mohammed Aziz02
  Date: 4/4/2023
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> foooooooooooooooooorm</h1>

<form:form action="submitForm" modelAttribute="person" >
    First name: <form:input path="id" />
    <br><br>
    First name: <form:input path="firstName" />
    <br><br>
    Last name: <form:input path="lastName" />
    <br><br>
    date de naissance: <form:input path="date_naiss" />
    <br><br>
    cne: <form:input path="cne" />
    <br><br>
    <input type="submit" value="Submit" />
</form:form>

</body>
</html>
