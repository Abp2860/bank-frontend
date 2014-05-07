<%-- 
    Document   : customer-edit
    Created on : 10-04-2014, 10:03:38
    Author     : Anders
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer</title>
        <script src="jq/jquery-1.9.1.js"></script>
        <script src="jq/jqueryValidation.js"></script>
        
        <script>
        $(document).ready(function() {
               
                $("#myform").validate({
                    rules: {
                        cpr: {required: true, minlength: 11, maxlength: 11},
                        firstname: {required: true, minlength: 2},
                        lastname: {required: true, minlength: 2},
                        mail: {required: true, remote:"EmailValidation", email: true},
                        address: {required: true, minlength: 5},
                        postcode: {required: true, minlength: 4, maxlength: 4,number: true},
                        city: {required: true, minlength: 4},
                        phone: {required: true, minlength: 8, maxlength: 8, number: true}
                    },
                    messages: {
                        cpr: {
                            required: "please enter your cpr",
                            minlength: "not a valid cpr number",
                            maxlength: "not a valid cpr number"
                        },
                        firstname: {
                            required: "Please enter you first name",
                            minlength: jQuery.format("At least {0} characters required!")
                        },
                        lastname: {
                            required: "Please enter your lastname",
                            minlength: jQuery.format("At least {0} characters required!")
                        },
                        mail: {
                            required: "Please enter a email address",
                            remote: "Email is already registred",
                            email: "not a valid email address"
                        },
                        address: {
                            required: "Please enter a address",
                            minlength: "not a valid address"
                        },
                        postcode: {
                            required: "Please enter zipcode",
                            minlength: "not a valid zipcode",
                            maxlength: "not a valid zipcode",
                            number: "not a valid zipcode"
                            
                        },
                        city: {
                            required: "Please enter city",
                            minlength: "city does not exist"
                        },
                        phone: {
                            required: "please enter phone number",
                            minlength: "not a valid phone number",
                            maxlength: "not a valid phone number",
                            number: "not a valid phone number"
                            
                            
                        }
                    }

                });
            });
            
        </script>
        
    </head>
    <body>
        <h1>Add Customer</h1>
    </body>
</html>
