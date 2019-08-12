<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Timesheet review</title>

</head>
<body>
		<table align="left" border="1">
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
		
				
		<a href="approveTimesheet?id=${timesheet.id}" class="button">Approve timesheet</a>
		<br>
		<br>

	<a href="timesheetApproval.html">Back</a>
</body>
</html>