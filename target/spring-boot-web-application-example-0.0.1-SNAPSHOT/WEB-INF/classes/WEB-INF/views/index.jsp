<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Spring Boot</title>



</head>
<body>
  <h1>Welcome to online store</h1>
  <hr>

  <div class="form">
    <form action="hello" method="post" onsubmit="return validate()">
      <table>
        <tr>
          <td>Enter Your name</td>
          <td><input id="name" name="name"></td>
          <td><input type="submit" value="Submit"></td>
        </tr>
      </table>
    </form>
  </div>
  
  	
			<form:form method="POST" action="save.html" commandName="command">
	   		<table>
			    <tr>
			        <td><form:label path="id">Product ID:</form:label></td>
			        <td><form:input path="id" value="${product.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Product Name:</form:label></td>
			        <td><form:input path="name" value="${product.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="price">Product Price:</form:label></td>
			        <td><form:input path="price" value="${product.price}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="quantity">Product Quantity:</form:label></td>
			        <td><form:input path="quantity" value="${product.quantity}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
  
 
	<table align="left" border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			
		</tr>

  	<c:forEach items="${allProducts}" var="product">
    	<tr>
       		<td><c:out value="${product.id}"/></td>
        	<td><c:out value="${product.name}"/></td>  
        	<td><c:out value="${product.price}"/></td>
        	<td><c:out value="${product.quantity}"/></td> 
        
    	</tr>
	</c:forEach>
	
	
	</table>

</body>
</html>