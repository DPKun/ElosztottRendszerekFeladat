<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Permission Denied</title>
</head>
<body>
<%@include file="menu.jsp" %>
<p></p>
<h3><spring:message code="label.permissionDenied"/></h3>
<a href="/springfeladat/welcome">  <button type="submit"><spring:message code="label.back"/></button></a>
  
</body>
</html>