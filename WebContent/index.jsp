<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="com.omantel.database.ConnectionFactory"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo Page</title>
</head>
<body>

<li>Greetings</li><br>
<%
out.println("Hello "+ConnectionFactory.displayUser());
%><br><br>

<font color="green">
<%
out.println("POS TEST database information "+ConnectionFactory.getPosDbConnection_TEST()+"\n");
%></font><br><br>

<font color="blue">
<%
out.println("POS Production database information "+ConnectionFactory.getPosDbConnection_Prod());
%></font>
</body>
</html>