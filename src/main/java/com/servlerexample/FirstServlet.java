package com.servlerexample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.Class.forName;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String uname=req.getParameter("fname");
//        String uemail=req.getParameter("email");
//        int unum1=Integer.parseInt(req.getParameter("num1"));
//        int unum2=Integer.parseInt(req.getParameter("num2"));

        int ueid=Integer.parseInt(req.getParameter("eid"));
        String uename=req.getParameter("ename");

//        double sum=unum1+unum2;
//        PrintWriter out=res.getWriter();
//        out.println("Hi, This is First Servlet");
//        out.println("Hi "+uname);
//        out.println("Your email is:"+uemail);
//        out.println("Sum of  numbers"+unum1+"and"+unum2+" is: "+sum);


        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.out.println("Driver not found");
        }
        String dbUrl="jdbc:postgresql://localhost:5432/postgres";
        String dbUsername="postgres";
        String dbPassword="2003";

        Connection con=null;


        try {
            con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            Statement statement=con.createStatement();
            if (con!=null){
                System.out.println("Connection Established");
            }else {
                System.out.println("Connection Not Established");
            }
            String queryInsert="insert into emp values("+ueid+",'"+uename+"');";
            String querySelect="select * from emp where eid="+ueid;
            ResultSet execute=statement.executeQuery(querySelect);
            PrintWriter out=res.getWriter();
            out.println("Data is Extracted successfully");
            while (execute.next()){
                out.println("Employee_ID: "+execute.getInt(1));
                out.println("Employee_Name : "+execute.getString(2));
                out.println("_____________________");
            }
            execute.close();
            statement.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Exception occured");
            e.printStackTrace();
        }


    }

}
