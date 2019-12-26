<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<input type="button" value="Add Customer" onClick="window.location.href='showFormAdd'; return false;" class="add-button"/>
		<!-- add out html table here -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			
			<!-- Loop over and print out customers -->
			<c:forEach var="tempCustomer" items="${Customer}">
				
				<!-- Link for update Customer -->
				<c:url var="updateLink" value="/customer/showFormUpdate">
					<c:param name="customerID" value="${tempCustomer.id}"/>
				</c:url>
				
				<!-- Link for Delete Customer -->
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerID" value="${tempCustomer.id}"/>
				</c:url>
				
				<tr>
					<td> ${tempCustomer.first_name} </td>
					<td> ${tempCustomer.last_name} </td>
					<td> ${tempCustomer.email} </td>
					<td><a href="${updateLink}">Update</a>
								|
						<a href="${deleteLink}" onClick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
					</td>
				</tr>
			
			</c:forEach>
		</table>
		
		</div>
	</div>

</body>
</html>