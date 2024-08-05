package com.servlerexample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cRollno=Integer.parseInt(request.getParameter("rollno2"));
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String dbUrl="jdbc:postgresql://localhost:5432/postgres";
        String dbUsername="postgres";
        String dbPassword="2003";

        Connection con=null;
        try {
            con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            Statement statement=con.createStatement();
            String querySelect="select * from child2 where rollno="+cRollno;
            ResultSet execute=statement.executeQuery(querySelect);
            PrintWriter out=response.getWriter();
            out.println("<b>Data is Extracted successfully<b>");
            while (execute.next()){
                out.println("<table border=1>");
                out.println("<tr>");
                out.println("<th>Childern_ID</th>");
                out.println("<th>Children_Name</th>");
                out.println("<th>Telugu_Marks</th>");
                out.println("<th>Hindi_Marks</th>");
                out.println("<th>English_Marks</th>");
                out.println("<th>Maths_Marks</th>");
                out.println("<th>Science_Marks</th>");
                out.println("<th>Social_Marks</th>");
                out.println("<th>Total_Marks</th>");
                out.println("<tr>");
                out.println("<td>"+execute.getInt(1)+"</td>");
                out.println("<td>"+execute.getString(2)+"</td>");
                out.println("<td> "+execute.getInt(3)+"</td>");
                out.println("<td>"+execute.getInt(4)+"</td>");
                out.println("<td> "+execute.getInt(5)+"</td>");
                out.println("<td> "+execute.getInt(6)+"</td>");
                out.println("<td> "+execute.getInt(7)+"</td>");
                out.println("<td> "+execute.getInt(8)+"</td>");
                int total=execute.getInt(3)+execute.getInt(4)+execute.getInt(5)+execute.getInt(6)+execute.getInt(7)+execute.getInt(8);
                out.println("<td> "+total+"</td>");
                out.println("</tr>");
            }
            execute.close();
            statement.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
