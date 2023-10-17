<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 06.10.2023
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/css/styleGeneral.css"/>" rel="stylesheet" type="text/css"/>
    <title>Calculation</title>
</head>
<body>

<h3>
    <c:url value="/" var="mainPage"/>
    <a href="${mainPage}">Back</a>
</h3>
<hr>
<h1>Calculation Page</h1>

<c:url value="/calculationPost" var="var"/>
<form action="${var}" method="POST">
    <table>
        <caption>
            <h2>Input data:</h2>
        </caption>
        <tr>
            <th>
                Type:
            </th>
            <th>
                Input:
            </th>
            <th>
                Previous Input:
            </th>
        </tr>
        <tr>
            <td>
                Type RW:
            </td>
            <td>
                <label>
                    <select name="typerw">
                        <c:forEach var="substance" items="${typeList}">
                            <option value="${substance}">${substance}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
            <td>
                ${calculationPost.typerw}
            </td>
        </tr>
        <tr>
            <td>
                Density:
            </td>
            <td>
                <label>
                    <input name="density" value="0"/>
                </label>
            </td>
            <td>
                ${calculationPost.density}
            </td>
        </tr>
        <tr>
            <td>
                Weight:
            </td>
            <td>
                <label>
                    <input name="weight"value="0"/>
                </label>
            </td>
            <td>
                ${calculationPost.weight}
            </td>
        </tr>
    </table>

    <input type="submit" value="Submit" />
</form>

<c:if test="${calculationPost.weight*1000/calculationPost.density>maxVolume}">
A lot of ${(calculationPost.weight*1000/calculationPost.density-maxVolume)*calculationPost.density/1000}
</c:if>
<c:if test="${calculationPost.weight*1000/calculationPost.density<=maxVolume}">
    Сalculated!
</c:if>

<hr>
<h2>Output data:</h2>
<p>Overflow: ${tov.overflow}</p>
<p>Weight: ${tov.volumeOfTheRailwayTank * calculationPost.density/1000}</p>

</body>
</html>
