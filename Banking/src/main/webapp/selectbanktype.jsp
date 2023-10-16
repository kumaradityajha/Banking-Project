<%@page import="dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Opening Page</title>
</head>
<body>

<h1>Welcome to Account Opening Page</h1>

<!-- <h1>Hello </h1> -->



<% Customer customer =(Customer) request.getSession().getAttribute("customer"); %>

<%= customer.getName() %>



<h1>Select Bank Type </h1>
<form action="createbankaccount" method="post">

<input type="radio" name="acctype" value="saving" required="required">Saving
<input type="radio" name="acctype" value="current">Current<br><br>


<button>Submit</button> <button type="reset">Cancel</button>








</form>

</body>
</html>