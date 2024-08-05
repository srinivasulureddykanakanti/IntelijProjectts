package com.servlerexample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
            PrintWriter out=res.getWriter();
            out.println("<b>Data is Extracted successfully<b>");
            if(execute.next()){
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
            }else {
                out.println("Not a Valid User");
            }
            execute.close();
            statement.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
