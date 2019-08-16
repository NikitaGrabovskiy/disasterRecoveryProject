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

<title>Update Job</title>

</head>
<body>
<div class="sidenav">
  <a href="JobCodeManagement.htm">>>>  Job Code Management</a>
  <a href="MachineManagement.html">>>>  Machine Management</a>
  <a href="timesheetApproval.html">>>>  Time-card Approval</a>
  <a href=".html">>>>  Log out</a>
</div>
<div class="main">
	<h1>Update Jobs</h1>

	<form:form method="POST" action="updateJobMethod.html" id="myForm" enctype="multipart/form-data">
<table>
			<form:input path="id" value="${job.id}" type="hidden"/>
			<tr>
				<td><form:label path="job_code">Job Code:</form:label></td>
				<td><form:input path="job_code" value="${job.job_code}" /></td>
			</tr>
			<tr>
				<td><form:label path="j_desc">Job Description:</form:label></td>
				<td><form:input path="j_desc" value="${job.j_desc}" /></td>
			</tr>
			<tr>
				<td><form:label path="hourly_rate">Hourly rate:</form:label></td>
				<td><form:input path="hourly_rate" value="${job.hourly_rate}" /></td>
			</tr>
			<tr>
				<td><form:label path="max_hours">Max Hour per day:</form:label></td>
				<td><form:input path="max_hours" value="${job.max_hours}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" class="button"/></td>
				<td><a href="JobCodeManagement.html" class="button">Back</a></td>
			</tr>
		</table>
	</form:form>
	<br>
	
	<br>
	</div>
</body>

</html>