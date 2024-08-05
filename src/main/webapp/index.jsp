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
    <title>Main Page</title>
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
<form action="index3.jsp" method="get">
    <h1><b>Main Page</b></h1>
    <input type="submit" name="LoginIn Page" value="LoginIn page">
</form>
<form action="index2.jsp" method="get">
    <input type="submit" name="DataE&V Page" value="DataE&V page">
</form>
<form action="index4.jsp" method="get">
    <input type="submit" name="DataE&V_rd Page" value="DataE&V_rd page">
</form>


</body>
</html>
