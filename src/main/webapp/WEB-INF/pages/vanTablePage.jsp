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
    <title>Table Van</title>
</head>
<body>

<h3>
    <c:url value="/" var="mainPage"/>
    <a href="${mainPage}">Back</a>
</h3>
<hr>

<h1>CRUD and view with filter Van table Page</h1>

<b>Number of entries per page :</b>

<c:url value="/vanTablePost" var="var"/>
<form action="${var}" method="POST">
    <label>
        <input type="number" name="maxRowInPage" value="${vanTablePost.maxRowInPage}" />
    </label>
    <h2>Filters output</h2>

    <b>Type out: </b>
    <label>
        <input type="radio" name="typeList" value="0" checked/>
        All
    </label>
    <label>
        <input type="radio" name="typeList" value="1" />
        For a year
    </label>
    <label>
        <input type="radio" name="typeList" value="2" />
        For a year and month
    </label>
    <label>
        <input type="radio" name="typeList" value="3" />
        Date from/Date to
    </label>


    <table class="tableFilterClass">
        <tr>
            <th>
                Substance:
            </th>
            <th>
                Write year:
            </th>
            <th>
                Write month:
            </th>
            <th>
                Select from date and to date:
            </th>
        </tr>
        <tr>
            <td>
                <label>
                    <select name="substance">
                        <c:forEach var="substance" items="${substanceList}">
                            <option value="${substance.substance}" >${substance.substance}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
            <td>
                <label>
                    <input name="year" value="${vanTablePost.year}"/>
                </label>
            </td>
            <td>
                <label>
                    <select name="month">
                        <c:forEach var="month" items="${months}">
                            <option value="${month.value}" >${month}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
            <td>
                From:
                <label for="dateFrom">
                    <input type="date" name="dateFrom" id="dateFrom" value="${vanTablePost.dateFrom}">
                </label>
                <br><br>
                To:
                <label for="dateTo">
                    <input type="date" name="dateTo" id="dateTo" value="${vanTablePost.dateTo}">
                </label>
            </td>
        </tr>
    </table>

    <input type="submit" value="Apply filters" />
</form>

<table class="tableVanClass">
    <caption class="heading"> VanDeficit </caption>
    <thead>
    <tr class="tableVanClass">
        <th class="tableVanClass">№</th>
        <%--        <th>Id</th>--%>
        <th class="tableVanClass">Substance</th>
        <th class="tableVanClass">DateOfArrival</th>
        <th class="tableVanClass">RailwayTankNumber</th>
        <th class="tableVanClass">DateOfDrain</th>
        <th class="tableVanClass">TypeOfRailwayTank</th>
        <th class="tableVanClass">Overflow</th>
        <th class="tableVanClass">Density</th>
        <th class="tableVanClass">Temperature</th>
        <th class="tableVanClass">WeightInvoice</th>
        <th class="tableVanClass">VolumeOfTheRailwayTank</th>
        <th class="tableVanClass">ActualWeight</th>
        <th class="tableVanClass">DifferenceActInv</th>
        <th class="tableVanClass">edit/delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="van" items="${vanList}" varStatus="i">
        <tr class="tableVanClass">

            <td class="tableVanClass">${i.index + 1 + (page - 1) * maxRowInPage}</td>
<%--        <td>${type.id}</td>--%>
            <td class="tableVanClass">${van.substance}</td>
            <td class="tableVanClass">${van.dateOfArrival1}</td>
            <td class="tableVanClass">${van.railwayTankNumber}</td>
            <td class="tableVanClass">${van.dateOfDrain1}</td>
            <td class="tableVanClass">${van.typeOfRailwayTank}</td>
            <td class="tableVanClass">${van.overflow}</td>
            <td class="tableVanClass">${van.density}</td>
            <td class="tableVanClass">${van.temperature}</td>
            <td class="tableVanClass">${van.weightInvoice}</td>
            <td class="tableVanClass">${van.volumeOfTheRailwayTank}</td>
            <td class="tableVanClass">${van.actualWeight}</td>
            <td class="tableVanClass">${van.differenceActInv}</td>
            <td class="tableVanClass">
                <a href="/edit/${van.id}">
<%--                    edit--%>
                    <span class="icon icon-edit"></span>
                </a>
                <a href="/delete/${van.id}">
<%--                    delete--%>
                    <span class="icon icon-delete"></span>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

    <c:if test="${vanList.size() == 0}">
        <tr>
            <td colspan="1" style="font-size: 150%" class="left-side right-side">
                The list is empty, but you can add a new van.
            </td>
        </tr>
    </c:if>
    <tr>
        <td colspan="1" class="left-side link right-side">
            <a style="margin-right: 70px; font-size: 100%" href="<c:url value="/add"/>">
                <%--                <c:url value="/add" var="add"/>--%>
                <%--                <a href="${add}">Add new Van</a>--%>
                <span class="icon icon-add"></span>Add new Van
            </a>
        </td>
    </tr>

</table>

page:
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/vanTable" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<h2>
    <c:url value="/substanceCRUD" var="addSubstance"/>
    <a href="${addSubstance}">CRUD Substance</a>
</h2>

</body>
</html>
