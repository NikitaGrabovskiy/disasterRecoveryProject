<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add Job</title>



</head>
<body>
	<h2>Add Job</h2>
	<form:form method="POST" action="saveJob.html" id="myForm" enctype="multipart/form-data">
		<table>
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
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
		<br>
		<br>
	<a href="JobCodeManagement.html">Back</a>
</body>
</html>