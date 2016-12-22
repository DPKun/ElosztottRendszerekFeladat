<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>New Course</h2>

<c:if test="${not empty message}">
${message}
</c:if>
<p></p>

<form name="courseData" method="post" action="addCourse" onsubmit="check()">
<label for="courseName" >Course name: </label>

	<input type="text" id="courseName" name="courseName" required="true" ><br>
	<p></p>
	<label for="courseCredit" >Credit: </label>
	<input type="number" name="courseCredit" id="courseCredit"  ><br>
	<label for="preferedSemester" >Semester: </label>
	<input type="number" name="preferedSemester" id="preferedSemester"  ><br>
	<p></p>
   <button type="submit">Add new course</button>
</form>
 <script Language="JavaScript">
function check() {
    if(document.forms["courseData"]["courseCredit"].value == "")
        document.forms["courseData"]["courseCredit"].value = "0";
    if(document.forms["courseData"]["preferedSemester"].value == "")
        document.forms["courseData"]["preferedSemester"].value = "0";
}
</script>
</body>
</html>