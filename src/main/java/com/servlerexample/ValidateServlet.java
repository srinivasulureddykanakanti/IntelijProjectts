package com.servlerexample;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        int cRollno=Integer.parseInt(req.getParameter("rollno"));
        String cPassword=req.getParameter("password");
        try {
            Class.forName("org.postgresql.Driver");
            String dbUrl="jdbc:postgresql://localhost:5432/postgres";
            String dbUsername="postgres";
            String dbPassword="2003";

            Connection con=null;

            con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            Statement statement=con.createStatement();
            String query1="select * from child2 where rollno="+cRollno+ " and cname='"+cPassword+"';";
            ResultSet execute=statement.executeQuery(query1);
            if(execute.next()){
                req.setAttribute("output",execute);
                RequestDispatcher rd=req.getRequestDispatcher("/WelcomeServlet");
                rd.forward(req,res);
            }else {
                res.setContentType("text/html");
                PrintWriter out=res.getWriter();
                out.println("<span class='Error' > Invalid Username or password</span>");
                ServletContext ctxt=getServletContext();
                RequestDispatcher rd=ctxt.getRequestDispatcher("/index4.jsp");
                rd.include(req,res);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
