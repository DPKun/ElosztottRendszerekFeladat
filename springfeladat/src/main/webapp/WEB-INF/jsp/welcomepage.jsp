<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page isELIgnored="false" %>
<html>
<link rel="stylesheet" href="<spring:theme code="css"></spring:theme>">

<body>
<%@include file="menu.jsp" %>
<p></p>

<c:if test="${empty courses}">
<spring:message code="label.noCourse"/>


</c:if>

<form method="get" action="addCourse">
    <button type="submit"><spring:message code="label.newCourse"/></button>
</form>

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
<c:forEach items="${courses}" var="element"> 
  <tr>
    <td>${element.courseName}</td>
    <td>${element.courseCredit}</td>
      <td>${element.preferredSemester}</td>
  </tr>
</c:forEach>
</table>
</c:if>
</body>
</html>