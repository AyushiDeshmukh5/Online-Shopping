package com.ayu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserVerification")
public class UserVerification extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//writing visit time using cookies to client's disk
		java.util.Date dt = new java.util.Date();
		String visit = dt.toString();
	visit = 	visit.replace(' ', '-');
		
		
		Cookie ck = new Cookie("lastvisit",visit);
		ck.setMaxAge(60*60*24*30);
		response.addCookie(ck);
		
		
	PrintWriter out=response.getWriter(); 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		
		
		if(usertype.equals("Buyer")){
			//here we need to check the details from database
			String sql = "select * from userinfo where email=? and password = ?";
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","lqs@5");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			boolean b = rs.next();
			if(b){
				response.sendRedirect("buyer-dashboard.jsp");
			}
			else{
				out.println("Invalid details");
			}
			con.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else if(usertype.equals("Owner")){
			if(email.equals("admin@gmail.com") && password.equals("admin@123")){
				response.sendRedirect("owner-dashboard.jsp");
			}
			else{
				out.println("Invalid details");
			}
		}
		
	
	
	
	
	}

}
