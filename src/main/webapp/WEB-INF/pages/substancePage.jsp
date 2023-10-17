<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 09.10.2023
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/css/styleGeneral.css"/>" rel="stylesheet" type="text/css"/>
    <title>Title</title>
</head>
<body>

<h3>
    <c:url value="/vanTable?page=${page}" var="vanTablePage"/>
    <a href="${vanTablePage}">Back</a>
</h3>
<hr>

<h1>CRUD substance Page</h1>

<c:url value="/substancePost" var="var"/>
<form action="${var}" method="POST">

    <div>
        <label>
            <input type="radio" name="typeAction" value="0" checked/>
            Add
        </label>
        <label>
            <input type="radio" name="typeAction" value="1" />
            Edit
        </label>
        <label>
            <input type="radio" name="typeAction" value="2" />
            Delete
        </label>
    </div>
    <br><br>

    Input new substance for add:
    <label>
        <input type="text" name="inputSubstance" value="${"null"}">
    </label>
    <br><br>

    Select substance which edit or delete:
    <label>
        <select name="selectSubstance">
            <c:forEach var="substance" items="${substanceList}">
                <option value="${substance.id}" >${substance.substance}</option>
            </c:forEach>
        </select>
    </label>
    <br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
