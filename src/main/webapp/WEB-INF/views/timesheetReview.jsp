<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/css/style.css">
<title>Timesheet review</title>

</head>
<body>

<div class="sidenav">
  <a href="JobCodeManagement.htm">>>>  Job Code Management</a>
  <a href="MachineManagement.html">>>>  Machine Management</a>
  <a href="timesheetApproval.html">>>>  Time-card Approval</a>
  <a href=".html">>>>  Log out</a>
</div>
<div class="main">


<h1>Timesheet Review</h1>
		<table>
			<tr>
				<th>Site Code </th>
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
		
		<div class="bottom">
		<a href="approveTimesheet?id=${timesheet.id}" class="button">Approve Timesheet</a>
	    <a href="timesheetApproval.html" class="button">Back</a>
		</div>		
	</div>	
</body>
</html>