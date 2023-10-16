<%@page import="dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>accounts</title>
</head>
<body>

<h1>Welcome to Accounts Page </h1>

<% List<BankAccount> list = (List<BankAccount>) request.getSession().getAttribute("list"); %>

<% if(list.isEmpty())
{%>
<h1> No Active Account Found </h1>

<%} else{ %>

<% for(BankAccount bankAccount : list) { %>

<a href="setactiveaccount?acno=<%=bankAccount.getAccountNo()%>"><button><%= bankAccount.getAccountNo() %></button></a>
 

<% }%>

<% }%>





</body>
</html>