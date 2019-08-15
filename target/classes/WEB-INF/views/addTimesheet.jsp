<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add TimeSheet</title>

	<form:form method="POST" action="submitTimesheet.html"
		commandName="commandTimesheet" id="form-id">
		<table>
		
			<tr>
				<td><form:label path="site_code">Site Code:</form:label></td>
				<td><form:input path="site_code" value="${timesheet.site_code}" /></td>
			</tr>
			
			<tr>
				<td><form:label path="contractor_name">Constructor Name:</form:label></td>
				<td><form:input path="contractor_name" value="${timesheet.contractor_name}" /></td>
			</tr>
			
			<tr>
				<td><form:input path="total_hours" value="${totalNuberOfHours}" type="hidden"/></td>
			</tr>
						<tr>
				<td><form:input path="total_amount" value="${totalAmount}" type="hidden" /></td>
			</tr>
						<tr>
				<td><form:input path="finalized" value="false" type="hidden" /></td>
			</tr>
		</table>
	</form:form>


</head>
<body>
	<h2>Labor entry</h2>
	
	
	

	<c:if test="${!empty listOfLaborEntries}">
		<table align="left" border="1">
			<tr>
				<th>Job Code</th>
				<th>Total Hrs</th>
				<th>Amount</th>
				<th></th>
			</tr>

			<c:forEach items="${listOfLaborEntries}" var="laborEntry">
				<tr>
					<td><c:out value="${laborEntry.code}" /></td>
					<td><c:out value="${laborEntry.hoursWorked}" /></td>
					<td><c:out value="${laborEntry.totalAmount}" /></td>
					<td><a href="deleteLaborEntry.html?code=${laborEntry.code}" onclick="document.getElementById('form-id').submit();">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</c:if>

	<form:form method="POST" action="addLaborEntry.html" id="myForm"
		commandName="commandLaborEntry">
		<table>
			<tr>
				<td><form:label path="code">Labor code:</form:label></td>
								<td><form:select path="code">
						<form:options items="${allCodesForJobs}" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="hoursWorked">Total Hrs:</form:label></td>
				<td><form:input path="hoursWorked" value="${laborEntry.code}" /></td>

			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" onclick="document.getElementById('form-id').submit();"/></td>
			</tr>
		</table>
	</form:form>
	<br>
	<br>
	
	
		<h2>Machine entry</h2>

	<c:if test="${!empty listOfMachineEntries}">
		<table align="left" border="1">
			<tr>
				<th>Machine Code</th>
				<th>Total Hrs</th>
				<th>Amount</th>
				<th></th>
			</tr>

			<c:forEach items="${listOfMachineEntries}" var="machineEntry">
				<tr>
					<td><c:out value="${machineEntry.code}" /></td>
					<td><c:out value="${machineEntry.hoursUsed}" /></td>
					<td><c:out value="${machineEntry.totalAmount}" /></td>
					<td><a href="deleteMachineEntry.html?code=${machineEntry.code}" onclick="document.getElementById('form-id').submit();">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</c:if>

	<form:form method="POST" action="addMachineEntry.html" id="myForm"
		commandName="commandMachineEntry">
		<table>
			<tr>
				<td><form:label path="code">Machine code:</form:label></td>
								<td><form:select path="code">
						<form:options items="${allCodesForMachines}" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="hoursUsed">Total Hrs:</form:label></td>
				<td><form:input path="hoursUsed" value="${Machine.code}" /></td>

			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" onclick="document.getElementById('form-id').submit();"/></td>
			</tr>
		</table>
	</form:form>
	<br>
	<br>
	
	
	
		<form:form method="POST" action="submitHiddenForm.html"
		commandName="commandTimesheet" id="hiddenForm">
		<table>
				<td><form:input path="site_code" value="${timesheet.site_code}" type="hidden"/></td>
				<td><form:input path="contractor_name" value="${timesheet.contractor_name}" type="hidden"/></td>
				<td><form:input path="total_hours" value="${totalNuberOfHours}" type="hidden"/></td>
				<td><form:input path="total_amount" value="${totalAmount}" type="hidden" /></td>
				<td><form:input path="finalized" value="false" type="hidden" /></td>
		</table>
	</form:form>
	
	
	<a href="timecardSuccessfulSubmition.html" onclick="document.getElementById('hiddenForm').submit();" >Submit</button>
	<br>
	<br>

	<a href="timecardSubmission.html">Back</a>



</body>
</html>