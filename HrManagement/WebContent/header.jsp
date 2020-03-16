
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ankitakhurana.hrManagement.models.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left: 80%;">
		<%
			HttpSession sessionsa = request.getSession(false);
			User user = (User) sessionsa.getAttribute("user");
			if (user != null)
				out.println("Hi " + user.getUsername());
		%>
		<c:if test="${!(user eq null)}">
			<form action="logout" method="GET" style="text-align: center;">
				<input type="submit" class="btn btn-danger" value="X">
			</form>
		</c:if>
	</div>
	<div class="container">
		<div class="jumbotron">Hr Management</div>
	</div>
</body>
</html>