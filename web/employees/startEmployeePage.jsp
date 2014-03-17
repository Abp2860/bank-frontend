<%-- 
    Document   : startEmployeePage
    Created on : 07-03-2014, 12:26:33
    Author     : Anders
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Page</title>
  </head>
  <body>
    <h1>Welcome to Demo-Banks Employee Pages</h1>
    <p>This page should be visible for employees only</p>
    <ul>
      <li><a href="Controller?command=list-customers">List customers</a></li>
      <li><a href="Controller?command=main">Back to main</a></li>
    </ul>
  </body>
</html>