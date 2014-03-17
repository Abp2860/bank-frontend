<%-- 
    Document   : account-detail
    Created on : 03-03-2014, 01:59:45
    Author     : Anders
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account history</title>
    </head>
    <body>
        <h1>Account Details</h1>
        ${number}
        <hr/>
        <table border="1">
            <c:forEach var="history" items="${history}">
                <tr> 
                    <td>${history.date}</td>
                    <td> ${history.amount} kr.</td>
                    <td> ${history.accountNumber}</td>
                </tr>
                
            </c:forEach>  
        </table>
           <br>
           <a href="Controller?command=prepare-transfer&number=${number}">Transfer</a>
      
           </br>
        
	    <a href="Controller?command=main">Main page</a>
         
       
    </body>
</html>

