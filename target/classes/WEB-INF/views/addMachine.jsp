<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/css/style.css">
<title>Add Machine</title>



</head>
<body>
	<h2>Add Machine</h2>
	<form:form method="POST" action="saveMachine.html" id="myForm" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="mach_code">Machine Code:</form:label></td>
				<td><form:input path="mach_code" value="${machine.mach_code}" /></td>
			</tr>
			<tr>
				<td><form:label path="mach_desc">Description:</form:label></td>
				<td><form:input path="mach_desc" value="${machine.mach_desc}" /></td>
			</tr>
			<tr>
				<td><form:label path="hourly_rent">Hourly rent:</form:label></td>
				<td><form:input path="hourly_rent" value="${machine.hourly_rent}" /></td>
			</tr>
			<tr>
				<td><form:label path="max_hours">Max Hour per day:</form:label></td>
				<td><form:input path="max_hours" value="${machine.max_hours}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
		<br>
		<br>
	<a href="MachineManagement.html">Back</a>
</body>
</html>