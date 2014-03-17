<%-- 
    Document   : startCustomerPage
    Created on : 07-03-2014, 11:43:10
    Author     : Anders
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Page</title>
  </head>
  <body>
    <h1>Welcome to Demo-Banks Customer Pages</h1>
    <p>This page should show details about the current customer</p>
    You are logged on as : ${pageContext.request.remoteUser}
    <br/>
    <p><a href='Controller?command=showcustdetails'>Show details</a></p>
    <p><a href='Controller?command=main'>Back to main page</a></p>
    
  </body>
</html>
