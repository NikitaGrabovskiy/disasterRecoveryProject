<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/css/style.css">
<title>Add TimeSheet</title>
</head>
<body>
<div class="sidenav">
  <a href="addTimesheet.htm">>>>  Add New Timesheet</a>
  <a href="timecardSubmission.htm">>>>  Timecards</a>
  <a href=".html">>>>  Log out</a>
</div>
<div class="main">
 <h1>Add New Timesheet</h1>
    <div>
	<form:form method="POST" action="submitTimesheet.html"
		commandName="commandTimesheet" id="form-id">
		<table style="width:100%; margin-top:10px;">
		
			<tr>
				<td><form:label path="site_code">Site Code:</form:label></td>
				<td><form:input path="site_code" value="${timesheet.site_code}" /></td>
				<td><form:label path="contractor_name">Constructor Name:</form:label></td>
				<td><form:input path="contractor_name" value="${timesheet.contractor_name}" /></td>
			</tr>
			
			<form:input path="total_hours" value="${totalNuberOfHours}" type="hidden"/>
			<form:input path="total_amount" value="${totalAmount}" type="hidden" />
			<form:input path="finalized" value="false" type="hidden" />
			
			<!-- tr style="visibility: hidden;">
				<td><form:input path="total_hours" value="${totalNuberOfHours}" type="hidden"/></td>
			</tr>
			<tr style="visibility: hidden;">
				<td><form:input path="total_amount" value="${totalAmount}" type="hidden" /></td>
			</tr>
			<tr style="visibility: hidden;">
				<td><form:input path="finalized" value="false" type="hidden" /></td>
			</tr -->
		</table>
	</form:form>



	<h2>Labor entry</h2>
	
	
	<form:form method="POST" action="addLaborEntry.html" id="myForm"
		commandName="commandLaborEntry">
		<table style="width: 100%;">
			<tr>
				<td><form:label path="code">Labor code:</form:label></td>
								<td><form:select path="code">
						<form:options items="${allCodesForJobs}" />
					</form:select></td>
				<td><form:label path="hoursWorked">Total Hrs:</form:label></td>
				<td><form:input path="hoursWorked" value="${laborEntry.code}" /></td>
				<td colspan="1" align="center"><input type="submit" value="Add" onclick="document.getElementById('form-id').submit();" class="button" align="center"/></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty listOfLaborEntries}">
		<table style="width: 100%; margin-top:10px;">
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
					<td><c:out value="$${laborEntry.totalAmount}" /></td>
					<td><a href="deleteLaborEntry.html?code=${laborEntry.code}" onclick="document.getElementById('form-id').submit();">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</c:if>

	
	
    <h2>Machine entry</h2>

    <form:form method="POST" action="addMachineEntry.html" id="myForm"
		commandName="commandMachineEntry">
		<table style="width: 100%;">
			<tr>
				<td><form:label path="code">Machine code:</form:label></td>
								<td><form:select path="code">
						<form:options items="${allCodesForMachines}" />
					</form:select></td>
				<td><form:label path="hoursUsed">Total Hrs:</form:label></td>
				<td><form:input path="hoursUsed" value="${Machine.code}" /></td>
				<td colspan="1" align="center"><input type="submit" value="Add" onclick="document.getElementById('form-id').submit();" class="button"/></td>
			</tr>
		</table>
	</form:form>


	<c:if test="${!empty listOfMachineEntries}">
		<table style="width: 100%; margin-top:10px;">
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
					<td><c:out value="$${machineEntry.totalAmount}" /></td>
					<td><a href="deleteMachineEntry.html?code=${machineEntry.code}" onclick="document.getElementById('form-id').submit();" >Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</c:if>

	
	
	
		<form:form method="POST" action="submitHiddenForm.html"
		commandName="commandTimesheet" id="hiddenForm" style="visibility: hidden;">
		<table style="visibility: hidden;">
				<td><form:input path="site_code" value="${timesheet.site_code}" type="hidden"/></td>
				<td><form:input path="contractor_name" value="${timesheet.contractor_name}" type="hidden"/></td>
				<td><form:input path="total_hours" value="${totalNuberOfHours}" type="hidden"/></td>
				<td><form:input path="total_amount" value="${totalAmount}" type="hidden" /></td>
				<td><form:input path="finalized" value="false" type="hidden" /></td>
		</table>
	</form:form>
	</div>
	<div class="bottom">
	<a href="timecardSuccessfulSubmition.html" onclick="document.getElementById('hiddenForm').submit();" class="button">Submit</a>
	<a href="timecardSubmission.html" class="button">Back</a>
    </div>

</div>
</body>
</html>