package com.servlerexample;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
         int cRollno=Integer.parseInt(request.getParameter("RollNo"));
         String cName=request.getParameter("CName");
         int cTel=Integer.parseInt(request.getParameter("Telugu"));
         int cHin=Integer.parseInt(request.getParameter("Hindi"));
         int cEng=Integer.parseInt(request.getParameter("English"));
         int cMat=Integer.parseInt(request.getParameter("Maths"));
         int cSci=Integer.parseInt(request.getParameter("Science"));
         int cSoc=Integer.parseInt(request.getParameter("Social"));

        try {
            Class.forName("org.postgresql.Driver");
            String dbUrl="jdbc:postgresql://localhost:5432/postgres";
            String dbUsername="postgres";
            String dbPassword="2003";

            Connection con=null;

            con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            Statement statement=con.createStatement();
            String queryInsert="insert into child2 values("+cRollno+",'"+cName+"',"+cTel+","+cHin+","+cEng+","+cMat+","+cSci+","+cSoc+");";
            statement.executeUpdate(queryInsert);
            PrintWriter out=response.getWriter();
            out.println("<b>Data Inserted Successfully<b>");
            statement.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Hello InsertServlet World

    }
}
