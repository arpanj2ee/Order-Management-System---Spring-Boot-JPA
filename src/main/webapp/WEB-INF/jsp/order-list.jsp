<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order List</title>
</head>
<body>
	<h1>Order List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="25px">Id</th><th width="50px">Name</th><th width="100px">Description</th><th width="25px">Price</th><th width="50px">Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="order" items="${orderList}">
<tr>
<td>${order.orderId}</td>
<td>${order.orderName}</td>
<td>${order.orderDescription}</td>
<td>${order.orderPrice}</td>

<td>
<a href="${pageContext.request.contextPath}/order/edit/${order.orderId}">Edit</a><br/>
<a href="${pageContext.request.contextPath}/order/delete/${order.orderId}">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
	
</body>
</html>