package com.ayu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private Connection con;
	private PreparedStatement ps;
	//while loading
	public void init(){
		//driver load
		//connection est
		//ps-object-create
		String sql = "insert into userinfo values(?,?,?,?,?,?,?)";
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","lqs@5");
		 ps  = con.prepareStatement(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//while unloading
	public void destroy(){
		//con close
		try{
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String mobile=request.getParameter("mobile");
			
			//to read the hobby, we can not use request.getParameter("hobby");
			//because there are may be multiple parameters with the same name hobby and we wish to reaad all the values
		     
		
			StringJoiner sj = new StringJoiner(","); //joins the string with the element passed in bracket
			
			
		
		
		//process the request
		
				
				
				out.println("<html>");
				out.println("<body>");
				out.println("<hr>");
				try{
					
					ps.setString(1, email);
					ps.setString(2, password);		
					ps.setString(3, name);
					ps.setString(4, address);
					ps.setString(5, city);
					ps.setString(6, state);
					ps.setString(7, mobile);
					ps.executeUpdate();
					
					out.println("<h3>Registered successfully</h3>");
					out.println("<h4><a href=index.jsp>Login</a></h4>");
					
				}catch(Exception e){
					
					e.printStackTrace();
					out.println(e);
					out.println("<h3>Registration failed</h3>");
					out.println("<h4><a href=registration.jsp>Re-try</a></h4>");
					out.println("<h4><a href=index.jsp>Login</a></h4>");
				}
				out.println("<hr>");
				out.println("</body>");
				out.println("</html>");
				out.close();
		}
	

	

}
