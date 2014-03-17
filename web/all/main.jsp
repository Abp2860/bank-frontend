<%-- 
    Document   : main
    Created on : 28-02-2014, 11:05:44
    Author     : Anders
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Demo Bank</title>
  </head>
  <body>
    <h1>Bank Project</h1>
    <p>This page can be seen by all</p>
    <br/>
    <ul>
      <c:if test="${pageContext.request.isUserInRole('Customer')==true}">
        <li><a href="Controller?command=customer-main">Customer main page</a></li>
      </c:if >


      <c:choose >
        <c:when test="${pageContext.request.remoteUser== null}">
          <li><a href="Controller?command=showlogin">Login</a>
        </c:when>
        <c:otherwise>
          <li><a href="Controller?command=logout">Log out</a></li>
        </c:otherwise>
      </c:choose>
    </ul>
  </body>
</html>
