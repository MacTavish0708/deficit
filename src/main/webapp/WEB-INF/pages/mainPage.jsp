<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 06.10.2023
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/css/styleGeneral.css"/>" rel="stylesheet" type="text/css"/>
    <title>Main Page</title>
</head>
<body>
<h1>Main Page</h1>

<c:url value="/vanTable" var="vanTablePage"/>
<h2>
    <a href="${vanTablePage}">Table Data</a>
</h2>

<c:url value="/calculation" var="calculationPage"/>
<h2>
    <a href="${calculationPage}">Calculation</a>
</h2>

</body>
</html>
