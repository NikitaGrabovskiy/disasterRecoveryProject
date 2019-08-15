<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Static content -->

<title>Machine Management</title>
</head>
<body>
	<h1>Machine Management</h1>
	
		<a href="addMachine.html">Add</a>
	<br>
	<br>
	<br>

	<c:if test="${!empty allMachines}">
		<table align="left" border="1">
			<tr>
				<th>Machine Code</th>
				<th>Description</th>
				<th>Hourly rent</th>
				<th>Max hours per day</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${allMachines}" var="machine">
				<tr>
					<td><c:out value="${machine.mach_code}" /></td>
					<td><c:out value="${machine.mach_desc}" /></td>
					<td><c:out value="${machine.hourly_rent}" /></td>
					<td><c:out value="${machine.max_hours}" /></td> 
					<td align="center"><a href="updateMachine.html?id=${machine.id}">Edit</a>
						<a href="deleteMachine.html?id=${machine.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
		<br>
		<br>
	<a href="adminIndex.html">Back</a>
</body>
</html>