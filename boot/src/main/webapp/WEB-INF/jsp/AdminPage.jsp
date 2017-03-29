<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page isELIgnored="false" %>
<html>
<body>
<%@include file="menu.jsp" %>
<p></p>
<h2><spring:message code="label.admin"/></h2>
<p> <spring:message code="label.signInButton"/></p>

<form method="get" action="admin/status">
    <button type="submit"><spring:message code="label.status"/></button>
</form>
</body>
</html>