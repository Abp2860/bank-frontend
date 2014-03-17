<%-- 
    Document   : customer-list
    Created on : 28-02-2014, 11:45:20
    Author     : Anders
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer list Page</title>
    </head>
    <body>
        <h1>Customer List</h1>

        <hr>
        <table border="1">
             <c:forEach var="customer" items="${customers}">
            <tr>
               
                <td><a href='Controller?command=list-customer-accounts&customerID=${customer.cpr}'> ${customer.name}</a></td>
                <td>${customer.cpr}</td>
                <td>${customer.address}</td>
                <td>${customer.phone}</td>
                <td>${customer.email}</td>
                     
            </tr>
            </c:forEach> 
        </table>
<ul>
	<li>
	    <a href="Controller?command=main">Main page</a>
	    
	</li>
	</ul>

    </body>
