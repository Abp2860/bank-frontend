<%-- 
    Document   : account-edit
    Created on : 10-04-2014, 10:03:06
    Author     : Anders
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add account</title>
    </head>
    <body>
        <h1>Add account</h1>
        <form>
            <div>
                <input type="hidden" name="cpr" value="${customer.cpr}">
                <div><label for="interest">interest</label>
                <input type="text" name="interest" id="interest" required/>%</div>
                <div>
                <input type="hidden" name="command" value="save-account">
                <br/>
                <input type="submit" value="add" style="margin-left:240px;">
                <a id="cancel" href="Controller?cpr=${customer.cpr}&command=cancel-transaction"> Cancel </a>
                </form>
                </br>
            </div>
    </body>
</html>
