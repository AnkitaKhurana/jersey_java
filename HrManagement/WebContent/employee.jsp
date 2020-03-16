<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<table border=1px; width="100%">
		<tr>
			<td>Employee Code</td>
			<td>Employee Name</td>
			<td>Location</td>
			<td>Email</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${employees}" var="emp" varStatus="status">
			<td>${emp.emp_code}</td>
			<td>${emp.emp_name}</td>
			<td>${emp.location}</td>
			<td>${emp.email}</td>
			<td>
				<form action="edit" method="get">
					<input type="submit" value="Edit" class="edit"> <input
						type="hidden" name="action" value="get" /> <input type="hidden"
						name="empCode" value="${emp.emp_code}" />

				</form>

			</td>


		</c:forEach>
	</table>
	<jsp:include page="footer.jsp" />

</body>
</html>