package com.ayu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//fetching userid from session
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("uid");
		if(email==null){
			//there is not memeber uid in session(authentication not done)
			response.sendRedirect("index.jsp");
		}
		
		
		// for keeping count of items in cart
				HashSet<Integer> set = (HashSet<Integer>) session.getAttribute("cart");
				
				int n=0;
				if(set!=null){
					n=set.size(); //we can find out number of items in collection by using size method
				}
				
		
		
		String ch = "";
	String time ="";
	//here we are reading a cookie whose name is choice
	
//	step-1 :Fetch all the cookies
	Cookie ck[] = request.getCookies();
	
	
//	step-2:Search for desired ones
		if(ck!=null) //alwys check if cookie object is null or not
		for(Cookie c:ck){
			String name = c.getName();
			if(name.equals("choice")){
				ch= c.getValue();
				
			}else if(name.equals("lastvisit")){
				time = c.getValue();
			}
		}
		
		
		
		PrintWriter out = response.getWriter();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","lqs@5");
			String sql = "select distinct category from products order by category";
					
					
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			out.println("<html>");
			out.println("<body>");
			out.println("Welcome "+email);
			out.println("<h5>Total Products:" +n+"</h5>");
			//out.println("<h4>Your last visit time:"+time+"</h4>");
			//out.println("<h4><marquee>Attractive offers on "+ ch+"</marquee></h4>");
			out.println("<h3>Books-Categories</h3>");
			out.println("<hr>");
			while(rs.next()){
				String  s =rs.getString(1);
				out.println("<a href=ProductListServlet?cat="+s+">");
				out.println(s);
				out.println("</a>");
				out.println("<br>");
			}
			out.println("<hr>");
			out.println("<a href=buyer-dashboard.jsp>Buyer-Dashboard</a>");
			out.println("<a href=CategoryServlet>Category page</a>");
			out.println("</body>");
			out.println("</html>");
			
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}
