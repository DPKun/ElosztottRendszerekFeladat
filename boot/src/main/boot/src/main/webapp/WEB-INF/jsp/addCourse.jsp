<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<%@include file="menu.jsp"%>
	<p></p>
	<h2>
		<i><spring:message code="label.newCourse" /></i>
	</h2>

	<c:forEach var="err" items="${errors}">
		<p>${err}</p>
	</c:forEach>

	<c:if test="${not empty CourseModel}">
		<form:form name="errorcoursedata" method="post" action="addCourse"
			modelAttribute="CourseModel">
			<label for="courseName"><spring:message
					code="label.courseName" />: </label>
			<form:input path="courseName" type="text" id="courseName"
				name="courseName" required="true" />
			<br>
			<p></p>
			<label for="courseCredit"><spring:message
					code="label.courseCredit" /> </label>
			<form:input path="courseCredit" type="number" name="courseCredit"
				id="courseCredit" />
			<br>
			<p></p>
			<label for="preferredSemester"><spring:message
					code="label.semester" /></label>
			<form:input path="preferredSemester" type="number"
				name="preferredSemester" id="preferredSemester" />
			<br>
			<p></p>
			<button type="submit">
				<spring:message code="label.newCourse" />
			</button>
		</form:form>
	</c:if>
</body>
</html>