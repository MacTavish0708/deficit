<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 08.09.2023
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/css/styleGeneral.css"/>" rel="stylesheet" type="text/css"/>
    <c:if test="${empty van.railwayTankNumber}">
        <title>Add Van</title>
    </c:if>
    <c:if test="${!empty van.railwayTankNumber}">
        <title>Edit Van</title>
    </c:if>
</head>

<body>

<h3>
    <c:url value="/vanTable?page=${page}" var="vanTablePage"/>
    <a href="${vanTablePage}">Back</a>
</h3>
<hr>

<c:if test="${empty van.railwayTankNumber}">
    <h1>Add Van Page</h1>
</c:if>
<c:if test="${!empty van.railwayTankNumber}">
    <h1>Edit Van Page</h1>
</c:if>

<c:if test="${empty van.railwayTankNumber}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty van.railwayTankNumber}">
    <c:url value="/edit" var="var"/>
</c:if>


<form action="${var}" method="POST">
    <c:if test="${!empty van.railwayTankNumber}">
        <input type="hidden" name="id" value="${van.id}">
    </c:if>

    <table>
        <tr>
            <td>
                <label for="Substance">Substance</label>
            </td>
            <td>

                <select name="Substance" id="Substance">
                    <c:forEach var="substance" items="${substanceList}">
                        <option id="${substance.id}" value="${substance.substance}">${substance.substance}</option>
                    </c:forEach>
                </select>

<%--                <c:if test="${!empty van.railwayTankNumber}">--%>
<%--                    <input type="text" name="Substance" id="Substance" value="${van.substance}">--%>
<%--                </c:if>--%>
<%--                <c:if test="${empty van.railwayTankNumber}">--%>
<%--                    <input type="text" name="Substance" id="Substance" value="${"null"}">--%>
<%--                </c:if>--%>

            </td>

        </tr>
        <tr>
            <td>
                <label for="DateOfArrival">DateOfArrival</label>
            </td>
            <td>
                <c:if test="${!empty van.railwayTankNumber}">
                    <input type="date" name="DateOfArrival" id="DateOfArrival" value="${van.dateOfArrival}">
                </c:if>
                <c:if test="${empty van.railwayTankNumber}">
                    <input type="date" name="DateOfArrival" id="DateOfArrival" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>">
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
                <label for="RailwayTankNumber">RailwayTankNumber</label>
            </td>
            <td>
                <c:if test="${!empty van.railwayTankNumber}">
                    <input type="text" name="RailwayTankNumber" id="RailwayTankNumber" value="${van.railwayTankNumber}" maxlength="8">
                </c:if>
                <c:if test="${empty van.railwayTankNumber}">
                    <input type="text" name="RailwayTankNumber" id="RailwayTankNumber" value="00000000" maxlength="8">
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
                <label for="DateOfDrain">DateOfDrain</label>
            </td>
            <td>
                <c:if test="${!empty van.railwayTankNumber}">
                    <input type="date" name="DateOfDrain" id="DateOfDrain" value="${van.dateOfDrain}" >
                </c:if>
                <c:if test="${empty van.railwayTankNumber}">
                    <input type="date" name="DateOfDrain" id="DateOfDrain" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>">
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
                <label for="TypeOfRailwayTank">TypeOfRailwayTank</label>
            </td>
            <td>

                <select name="TypeOfRailwayTank" id="TypeOfRailwayTank">
                    <c:forEach var="substance" items="${typeList}">
                        <option value="${substance}" >${substance}</option>
                    </c:forEach>
                </select>

<%--                <c:if test="${!empty van.railwayTankNumber}">--%>
<%--                    <input type="text" name="TypeOfRailwayTank" id="TypeOfRailwayTank" value="${van.typeOfRailwayTank}">--%>
<%--                </c:if>--%>
<%--                <c:if test="${empty van.railwayTankNumber}">--%>
<%--                    <input type="text" name="TypeOfRailwayTank" id="TypeOfRailwayTank" value="${"66"}">--%>
<%--                </c:if>--%>

            </td>
        </tr>
        <tr>
            <td>
                <label for="Overflow">Overflow</label>
            </td>
            <td>
                <select name="Overflow" id="Overflow">
                    <c:forEach var="overflow" items="${overflowList}">
                        <option value="${overflow}" >${overflow}</option>
                    </c:forEach>
                </select>

<%--                <c:if test="${!empty van.railwayTankNumber}">--%>
<%--                    <input type="text" name="Overflow" id="Overflow" value="${van.overflow}">--%>
<%--                </c:if>--%>
<%--                <c:if test="${empty van.railwayTankNumber}">--%>
<%--                    <input type="text" name="Overflow" id="Overflow" value="${"0"}">--%>
<%--                </c:if>--%>
            </td>
        </tr>
        <tr>
            <td>
                <label for="Density">Density</label>
            </td>
            <td>
                <c:if test="${!empty van.railwayTankNumber}">
                    <input type="number" name="Density" id="Density" value="${van.density}">
                </c:if>
                <c:if test="${empty van.railwayTankNumber}">
                    <input type="number" name="Density" id="Density" value=0>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
                <label for="Temperature">Temperature</label>
            </td>
            <td>
                <c:if test="${!empty van.railwayTankNumber}">
                    <input type="number" name="Temperature" id="Temperature" value="${van.temperature}">
                </c:if>
                <c:if test="${empty van.railwayTankNumber}">
                    <input type="number" name="Temperature" id="Temperature" value=0>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
                <label for="WeightInvoice">WeightInvoice</label>
            </td>
            <td>
                <c:if test="${!empty van.railwayTankNumber}">
                    <input type="number" name="WeightInvoice" id="WeightInvoice" value="${van.weightInvoice}">
                </c:if>
                <c:if test="${empty van.railwayTankNumber}">
                    <input type="number" name="WeightInvoice" id="WeightInvoice" value=0>
                </c:if>
            </td>
        </tr>

    </table>

    <c:if test="${empty van.railwayTankNumber}">
        <input type="submit" value="Add new VanDeficit">
    </c:if>
    <c:if test="${!empty van.railwayTankNumber}">
        <input type="submit" value="Edit VanDeficit">
    </c:if>
</form>


</body>
</html>
