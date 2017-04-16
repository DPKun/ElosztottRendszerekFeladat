<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="mdl-layout__header">
<span>
    <a href="?lang=en">en</a> 
    | 
    <a href="?lang=hu">hu</a>
</span>
<span>
    <a href="?theme=light"><spring:message code="label.light"/></a> 
    | 
    <a href="?theme=dark"><spring:message code="label.dark"/></a>
</span>
<span>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="principal.username"/>
<a href="/springfeladat/logout"><spring:message code="label.logout"/></a>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
<a href="/springfeladat/login"><spring:message code="label.signInButton"/></a>
</sec:authorize>
</span>
</div>