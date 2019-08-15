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

<title>Job Code Management</title>
</head>
<body>


<div class="sidenav">
  <a href="JobCodeManagement.htm">Job code management</a>
  <a href="MachineManagement.html">Machine management</a>
  <a href="timesheetApproval.html">Timecard approval</a>
  <a href=".html">Log out</a>
</div>

	<h1>Job Code Management</h1>

	<c:if test="${!empty allJobs}">
		<table align="left" id="productsTable">
			<tr>
				<th>Job Code</th>
				<th>Description</th>
				<th>Hourly rate</th>
				<th>Max hours per day</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${allJobs}" var="job">
				<tr>
					<td><c:out value="${job.job_code}" /></td>
					<td><c:out value="${job.j_desc}" /></td>
					<td><c:out value="$${job.hourly_rate}" /></td>
					<td><c:out value="${job.max_hours}" /></td> 
					<td align="center"><a href="updateJob.html?id=${job.id}">Edit</a>
						<a href="deleteJob.html?id=${job.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
		<br>
		<br>

	<div align="center" class = "bottom">
	   	<a href="addJob.html" class="button">Add</a>
	    <a href=".html" class="button">Back</a>
    </div>

</body>
</html>