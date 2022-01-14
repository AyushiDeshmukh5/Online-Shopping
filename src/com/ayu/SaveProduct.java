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

@WebServlet("/SaveProduct")
public class SaveProduct extends HttpServlet {
	
	
	
	private Connection con;
	private PreparedStatement ps;
	//while loading
	public void init(){
		//driver load
		//connection est
		//ps-object-create
		String sql = "insert into products values(?,?,?,?,?)";
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
			
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String description=request.getParameter("description");
			String price=request.getParameter("price");
			String category=request.getParameter("category");
			
			
			//to read the hobby, we can not use request.getParameter("hobby");
			//because there are may be multiple parameters with the same name hobby and we wish to reaad all the values
		     
		
			StringJoiner sj = new StringJoiner(","); //joins the string with the element passed in bracket
			
			
		
		
		//process the request
		
				
				
				out.println("<html>");
				out.println("<body>");
				out.println("<hr>");
				try{
					
					ps.setInt(1, Integer.parseInt(code));
					ps.setString(2, name);		
					ps.setString(3, description);
					ps.setInt(4, Integer.parseInt(price));
					ps.setString(5, category);
					
					ps.executeUpdate();
					
					out.println("<h3>Stored successfully</h3>");
					
				}catch(Exception e){
					
					e.printStackTrace();
					out.println(e);
					out.println("<h3>Operation failed</h3>");
					
				}
				out.println("<h4><a href=pentry.jsp>Add more</a></h4>");
				out.println("<h4><a href=owner-dashboard.jsp>Owner-dashboard</a></h4>");
				
				out.println("<hr>");
				out.println("</body>");
				out.println("</html>");
				out.close();
		}
	

	

}
