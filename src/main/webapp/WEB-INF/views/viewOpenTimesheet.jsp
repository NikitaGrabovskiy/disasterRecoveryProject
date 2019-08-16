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

<title>View open timesheet</title>
</head>
<body>
        <h1>Open Timesheet</h1>
        <div>
		<table>
			<tr>
				<th>Site Code</th>
				<th>Constructor Name</th>
				<th>Total Hrs</th>
				<th>Total Amount</th>
			</tr>
				<tr>
					<td><c:out value="${timesheet.site_code}" /></td>
					<td><c:out value="${timesheet.contractor_name}" /></td>
					<td><c:out value="${timesheet.total_hours}" /></td>
					<td><c:out value="${timesheet.total_amount}" /></td> 
				</tr>
		</table>
        </div>
		<div class="bottom">
			<a href="deleteSubmitedTimesheet.html?id=${timesheet.id}" class="button">Delete Timesheet</a>
			<a href="timecardSubmission.html" class="button" >Back</a>
		</div>
			
	
	
	
</body>
</html>