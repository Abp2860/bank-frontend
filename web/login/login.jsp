<%-- 
    Document   : login
    Created on : 07-03-2014, 09:56:30
    Author     : Anders
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
      label {display: block;width: 8em;text-align: left;float: left;}
      #login {margin-left: auto;margin-right:auto ;margin-top :2em;width:20em;}
    </style>
    <title>Login Page</title>
  </head>
  <body>
    <fieldset id='login'>
      <legend>Login</legend>
      <form method="POST" action="Controller">
        <div><label for="username">User name</label> <input type="text" name="username" id="username"></div>
        <div><label for="password"> Password</label> <input type="password" name="password" id="password"></div>
        <input type='submit' value='login'/>
        <input type='hidden' name="command" value='showlogin'/>
      </form>
      <p style='color:red'>${loginerror}</p>
    </fieldset>
  </body>
</html>