<html>
<head>
    <style>
        form{
            width: 35%;

        }
        input[type=text]{
            width: 100%;
            box-sizing: border-box;
            border: 2px solid blue;
            border-radius: 15px;
            font-size: 10px;
            background-color: white;
            padding: 15px 25px 12px 55px;
            margin: 5px;

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

<form action="InsertServlet" method="get" name="form1" >
    <h1>Insert Report: </h1>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    <%--input type="text" name="fname"><br>
    <input type="text" name="email"><br>
    <input type="text" name="num1"><br>
    <input type="text" name="num2"><br>
    <input type="text" name="eid"><br>
    <%--<input type="text" name="ename"><br>--%>

    <input type="text" name="RollNo" placeholder="Enter  Rollno" style="border-color: sandybrown"> &emsp;
    <input type="text" name="CName" placeholder="Enter Name" style="border-color: chartreuse"> &emsp;
    <input type="text" name="Telugu" placeholder="Telugu Marks"> &emsp;
    <input type="text" name="Hindi" placeholder="Hindi Marks"> &emsp;
    <input type="text" name="English" placeholder="English Marks"> &emsp;
    <input type="text" name="Maths" placeholder="Maths Marks"> &emsp;
    <input type="text" name="Science" placeholder="Science Marks"> &emsp;
    <input type="text" name="Social" placeholder="Social Marks"> &emsp;
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    <input type="submit" name="Submit">
</form>

<form action="ViewServlet" method="post" name="form2" style="margin-left: 45%; margin-top: -714px" >
    <h1>View Reports: </h1>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

    <input type="text" name="rollno2" placeholder="Enter the Rollno" style="border-color: brown; margin-top: -1px">&emsp;
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    <input type="submit" value="View Result" style="width: 170px;margin-top: -1px">
</form>
</body>
</html>
