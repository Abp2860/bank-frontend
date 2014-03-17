<%-- 
    Document   : customer-detail
    Created on : 07-03-2014, 11:41:53
    Author     : Anders
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details for ${pageContext.request.remoteUser}</title>
    </head>
    <body>
        <h1>Customer Details!</h1>
        <p>${customer.firstName}</p>
        <p>${customer.lastName}</p>
        <p>${customer.email}</p>
        <ul>
          <li><a href='Controller?command=main'>Back to main page</a></li>
          <li><a href="Controller?command=customer-main">Customer main page</a></li>
        </ul>
    </body>
</html>

