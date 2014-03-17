<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Customer</title>
    <style>
      label {display: inline; width: 8em; text-align: left; float: left;}
      fieldset {width: 20em;padding: 1em;}
    </style>
  </head>
  <body>
    <h1>Add customer</h1>
    <p>This page should be visible for SuperEmployees only</p>
    <fieldset>
      <legend>Customer Details</legend>
      <Form>
        <div>
          <div><label for="fname">First Name</label><input type="text" name="fname" id="fname" required/></div>
          <div><label for="lname">Last Name</label><input type="text" name="lname" id="lname" required/></div>
          <div><label for="email">Email</label><input type="email" name="email" id="email"/></div>
        </div>
        <input type="hidden" name="command" value="save-customer">
        <br/>
        <input type="submit" value="save"/>
      </Form>
    </fieldset>
    <br/>
    <ul >
      <li><a href="Controller?command=main">Back to main</a></li>
      <li><a href="Controller?command=listcustomers">See all customers</a></li>
    </ul>
  </body>
</html>
