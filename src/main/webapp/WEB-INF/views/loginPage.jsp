<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/css/style.css">
<!-- Static content -->

<title>Login page</title>

</head>
<body>
<h1>Authentication</h1>
	<form:form method="POST" action="register.html" id="myForm" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="name">Username :</form:label></td>
				<td><form:input path="name" value="${user.name}" /></td>
			</tr>
			<tr>
				<td><form:label path="pass">Password:</form:label></td>
				<td><form:input path="pass" value="${user.pass}" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center"><input type="submit" value="Log In" class="button" /></td>

			</tr>
		</table>
	</form:form>
	
		<h1>${message}</h1>
</body>
</html>