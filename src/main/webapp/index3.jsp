<%--
  Created by IntelliJ IDEA.
  User: srini
  Date: 30-07-2024
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        form{
            width: 35%;
            margin: 0px auto;

        }
        input[type=text]{
            width: 100%;
            box-sizing: border-box;
            border: 2px solid blue;
            border-radius: 10px;
            font-size: 16px;
            background-color: white;
            padding: 15px 25px 12px 55px;



        }
        input[type=password]{
            width: 100%;
            box-sizing: border-box;
            border: 2px solid blue;
            border-radius: 10px;
            font-size: 16px;
            background-color: white;
            padding: 15px 25px 12px 55px;


        }
        input[type=submit]{
            width: 100%;
            box-sizing: border-box;
            border: 2px solid blue;
            border-radius: 10px;
            font-size: 16px;
            background-color: black;
            color:white;
            padding: 15px 25px 12px 25px;
            margin: 5px;
            cursor: pointer;
            text-align: center;

        }
    </style>
</head>
<body>
<form action="LoginServlet" method="get">
    <h1><b>Login Page</b></h1>
    <%--<label><h1>Roll Number :</h1></label>--%>
    <input type="text" name="rollno" placeholder="Enter the RollNo">
    <%--
        <label><h1>Password    :</h1></label>
    --%>
    <input type="password" name="password" placeholder="Enter the Password">
    <input type="submit" name="LoginIn" value="LoginIn">

</form>


</body>
</html>
