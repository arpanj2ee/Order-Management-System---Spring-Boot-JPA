<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Create A New Order</title>
</head>
<body>
<h1>New Order</h1>
<form:form method="POST" commandName="order" action="${pageContext.request.contextPath}/order/create" >
<table>
<tbody>
<tr>
<td>Order name:</td>
<td><form:input path="orderName" /></td>
<td><form:errors path="orderName" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Order Description:</td>
<td><form:input path="orderDescription" /></td>
<td><form:errors path="orderDescription" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Order Price:</td>
<td><form:input path="orderPrice" /></td>
<td><form:errors path="orderPrice" cssStyle="color: red;"/></td>
</tr>
<tr>
<td><input type="submit" value="Create" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>