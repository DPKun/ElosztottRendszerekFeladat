<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@page isELIgnored="false" %>
<html>
<body>
<%@include file="menu.jsp" %>
<p></p>

<c:if test="${empty courses}">
<spring:message code="label.noCourse"/>
</c:if>
<c:if test="${not empty courses}">
<spring:message code="label.courses"/>
<table rules="all" frame="border" width="200">
<tr>
<td>
<spring:message code="label.courseName"/></td>
<td>
<spring:message code="label.courseCredit"/>
</td>
</tr>
<c:forEach items="${courses}" var="element" varStatus="status" > 
  <tr>
    <td>${element.courseName}</td>
    <td>${element.courseCredit}</td>
  </tr>
</c:forEach>
</table>
</c:if>
<a href="/springfeladat/welcome">  <button type="submit"><spring:message code="label.back"/></button></a>
</body>
</html>