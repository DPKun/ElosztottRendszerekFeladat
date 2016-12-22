<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<body>


<c:if test="${empty courses}">
No course. Please add.


</c:if>

<form method="get" action="addCourse">
    <button type="submit">Add course</button>
</form>

<c:if test="${not empty courses}">
The courses: 
<table rules="all" frame="border" width="200">
<c:forEach items="${courses}" var="element"> 
  <tr>
    <td>${element.courseName}</td>
    <td>${element.courseCredit}</td>
      <td>${element.preferedSemester}</td>
  </tr>
</c:forEach>
</table>
</c:if>
</body>
</html>