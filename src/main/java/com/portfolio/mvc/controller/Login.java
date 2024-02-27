package com.portfolio.mvc.controller;



import java.io.IOException;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String upassword = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null ; 
		try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true", "root", "root123"); // creating a connection with mysql database
            PreparedStatement pst = con.prepareStatement("Select * from users where uname = ? and upwd = ?");
            pst.setString(1, uname);
            pst.setString(2, upassword);
           
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()) {
            	session.setAttribute("name", rs.getString("uname"));
            	dispatcher = request.getRequestDispatcher("index.jsp");
            }else
            {
            	request.setAttribute("status", "failed");
            	dispatcher = request.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(request, response);
            
           
            
           
            

        } catch (Exception e) {
            System.out.println(e);
        }
	}

}
