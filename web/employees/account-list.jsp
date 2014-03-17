<%-- 
    Document   : account-list
    Created on : 28-02-2014, 11:06:00
    Author     : Anders
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account list</title>
    </head>
    <body>
        <h1>Account list</h1>
    
        <table border="1">
           <c:forEach var="account" items="${accounts}">
            <tr>
        <td><a href='Controller?command=show-account-detail&number=${account.number}'>
            ${account.number}</a></td>
        <td>${account.balance} kr.</td>
        <td>${account.type} <a href="Controller?command=prepare-transfer&number=${account.number}">
           </tr>
            
            </c:forEach> 
            
        </table>
        <br>
            <a href="Controller?command=prepare-transfer&number=${number}">Transfer</a>
            <br>
        <a href="Controller?command=list-customers"> Back</a>
        </br>
	    <a href="Controller?command=main">Main page</a>
	    
            
	
	
    </body>
</html>
