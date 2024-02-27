package com.portfolio.mvc.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upassword = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		RequestDispatcher dispatcher = null;
		try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true", "root", "root123"); // creating a connection with mysql database
            PreparedStatement pst = con.prepareStatement("INSERT INTO users (uname,upwd,uemail,umobile) values(?,?,?,?) ");
            pst.setString(1, uname);
            pst.setString(2, upassword);
            pst.setString(3, uemail);
            pst.setString(4, umobile); 
            
            dispatcher = request.getRequestDispatcher("registration.jsp");
            int rowCount = pst.executeUpdate();
            if(rowCount > 0 ) {
            	 request.setAttribute("status", "success");
            	 
            }
            else {
            	request.setAttribute("status", "failed");
            }
            dispatcher.forward(request, response);
            

        } catch (Exception e) {
            System.out.println(e);
        }
		


		
	}

}
