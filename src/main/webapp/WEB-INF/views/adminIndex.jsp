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
<style>
body {
  color: blue;
}

h1 {
  color: green;
}
#productsTable {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#productsTable td, #productsTable th {
  border: 1px solid #ddd;
  padding: 8px;
}

#productsTable tr:nth-child(even){background-color: #f2f2f2;}

#productsTable tr:hover {background-color: #ddd;}

#productsTable th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<title>Spring Boot</title>



</head>
<body>

	<a href="JobCodeManagement.html" class="button">Job Code Management</a>
	<br>
	<br>
	<a href="MachineManagement.html" class="button">Machine Management</a>
	<br>
	<br>
	<a href="timesheetApproval.html" class="button">Time card approval</a>


</body>
</html>