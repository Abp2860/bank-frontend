<%-- 
    Document   : transfer-edit
    Created on : 03-03-2014, 02:08:53
    Author     : Anders
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer</title>
    </head>
    <body>
        <h1>Transfer Page</h1>
        <form action="Controller">
         

Enter account number:
<br>
<INPUT  TYPE="TEXT" NAME="text1">
<BR>
Enter amount:
<br>
<INPUT width="55%" TYPE="TEXT" NAME="text1">
<BR>
<p><input type="hidden" name='source' value="${number}"</p>
<p><input type="submit" name="command" value="transfer-command"></p>


        </form>
        <br>
            <a href="Controller?command=back">Back</a>
    </body>
</html>
