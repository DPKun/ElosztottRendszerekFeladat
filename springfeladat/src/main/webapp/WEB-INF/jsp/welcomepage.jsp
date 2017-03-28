<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@page isELIgnored="false" %>
<html>
<link rel="stylesheet" href="<spring:theme code="css"></spring:theme>">
<body>
<%@include file="menu.jsp" %>
<p></p>

<c:if test="${empty courses}">
<spring:message code="label.noCourse"/>


</c:if>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<form method="get" action="/springfeladat/admin/addCourse">
    <button type="submit"><spring:message code="label.newCourse"/></button>
</form>
</sec:authorize>
<c:if test="${not empty courses}">
<spring:message code="label.courses"/>
<table rules="all" frame="border" width="200">
<tr>
<td>
<spring:message code="label.courseName"/></td>
<td>
<spring:message code="label.courseCredit"/>
</td>
<td>
<spring:message code="label.semester"/></td></tr>
<c:forEach items="${courses}" var="element" varStatus="status" > 
  <tr>
    <td>${element.courseName}</td>
    <td>${element.courseCredit}</td>
    <td>${element.preferredSemester}</td>
    <sec:authorize access="hasRole('ROLE_USER')">
    <td>
    <form method="get" action="subscribe">
    <input type="hidden" name="course" id="course" value="${status.index}">
    <button type="submit"><spring:message code="label.subscribeCourse"/></button>
</form></td>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    <td>
    <form method="get" action="delete">
    <input type="hidden" name="course" id="course" value="${status.index}">
    <button type="submit"><spring:message code="label.deleteCourse"/></button>
</form></td>
    </sec:authorize>
  </tr>
</c:forEach>
</table>
</c:if>
<a href="/springfeladat/display">  <button type="submit"><spring:message code="label.subs"/></button></a>
</body>
</html>