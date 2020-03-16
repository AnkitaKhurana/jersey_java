<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<h3 id="form_header" class="text-warning" align="center">Add
			Employee Details</h3>
		<br> <br> <br>
		<form:form action="update" method="POST" modelAttribute="employee">
  Employee Code:<br>
			<form:label path="emp_code">${employee.emp_code}</form:label>
			<form:input type="hidden" name="emp_code" path="emp_code"
				class="form-control" />
			<br>
  Employee Name:<br>
			<form:input type="text" name="emp_name" path="emp_name"
				class="form-control" />
			<form:errors path="emp_name" cssClass="error" />
			<br>
  Employee Location:<br>
			<form:input type="text" name="location" path="location"
				class="form-control" />
			<form:errors path="location" cssClass="error" />
			<br>
  Employee Email:<br>
			<form:input type="text" name="email" path="email"
				class="form-control" />
			<form:errors path="email" cssClass="error" />

			<br>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>