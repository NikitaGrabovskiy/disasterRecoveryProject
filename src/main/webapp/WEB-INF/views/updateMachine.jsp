<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Update Machine</title>

</head>
<body>
<div class="sidenav">
  <a href="JobCodeManagement.htm">>>>  Job Code Management</a>
  <a href="MachineManagement.html">>>>  Machine Management</a>
  <a href="timesheetApproval.html">>>>  Time-card Approval</a>
  <a href=".html">>>>  Log out</a>
</div>
<div class="main">
	<h1>Update Machine</h1>
	<form:form method="POST" action="updateMachineMethod.html" id="myForm" enctype="multipart/form-data">
<table>
			<form:input path="id" value="${machine.id}" type="hidden"/>
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
				<td><input type="submit" value="Update" class="button"/></td>
				<td><a href="MachineManagement.html" class = "button">Back</a></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>

</html>