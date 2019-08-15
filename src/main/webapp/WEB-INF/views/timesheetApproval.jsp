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

<title>Timesheet Approval</title>
</head>
<body>
	<h1>Timesheet Approval</h1>


	<c:if test="${!empty allTimesheets}">
		<table align="left" border="1">
			<tr>
				<th>Site Code</th>
				<th>Constructor Name</th>
				<th>Total Hrs</th>
				<th>Total Amount</th>
				<th></th>
			</tr>

			<c:forEach items="${allTimesheets}" var="timesheet">
				<tr>
					<td><c:out value="${timesheet.site_code}" /></td>
					<td><c:out value="${timesheet.contractor_name}" /></td>
					<td><c:out value="${timesheet.total_hours}" /></td>
					<td><c:out value="${timesheet.total_amount}" /></td> 
					<td align="center"><c:choose>
    <c:when test="${timesheet.finalized=='true'}">
        finalized
        <br />
    </c:when>    
    <c:otherwise>
        <a href="timesheetReview.html?id=${timesheet.id}">review</a>
        <br />
    </c:otherwise>
</c:choose></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
		<br>
		<br>
	<a href="adminIndex.html" class="button">Back</a>
</body>
</html>