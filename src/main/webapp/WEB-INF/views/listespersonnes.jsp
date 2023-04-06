<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="com.tp2.config.AppConfig" %>
<%@ page import="com.tp2.utils.tpClasses.CalculAgeImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: Mohammed Aziz02
  Date: 4/4/2023
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste de Personnes</title>
</head>
<body>
  <h1> Listes de Personnes</h1>
  <table border="1">
      <tr>
          <th>ID</th>
          <th>FIRStname</th>
          <th>Last Name</th>
          <th>date of birth</th>
          <th>cne</th>
          <th>age</th>
          <!-- Add more table column headers here -->
      </tr>
      <%--version de question n4--%>
     <%-- <c:forEach items="${sessionScope.personnes}" var="person">
          <tr>
              <!-- Access the properties of each person using JSTL expression language -->
              <td>${person.id}</td>
              <td>${person.firstName}</td>
              <td>${person.lastName}</td>
              <td>${person.date_naiss}</td>
              <td>${person.cne}</td>
              <td>${calculate.calculer(person.date_naiss)}</td>
              <!-- Display more properties of the person here -->
          </tr>
      </c:forEach>--%>

      <%--version de question n6--%>
      <c:forEach items="${sessionScope.personnes}" var="person">
          <tr>
              <!-- Access the properties of each person using JSTL expression language -->
              <td>${person.id}</td>
              <td>${person.firstName}</td>
              <td>${person.lastName}</td>
              <td>${person.date_naiss}</td>
              <td>${person.cne}</td>
              <td>${calculate.calculer(person.date_naiss)}</td>
              <!-- Display more properties of the person here -->
          </tr>
      </c:forEach>

 <%--     <h1>${calculate}</h1>--%>
  </table>
</body>
</html>
