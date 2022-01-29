package com.ayu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DisplayCart")
public class DisplayCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//this servlet will show the cart to user
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		HashSet<Integer> set = (HashSet<Integer>) session.getAttribute("cart");
		
		out.println("<html>");
		out.println("<body>");
		if(set==null){
			out.println("<h3>Cart is empty</h3>");
		out.println("<h3><a href=CategoryServlet>Start buying</h3>");
		}else{
			out.println("<h3>Your Cart :</h3>");
			out.println("<h3><a href=CategoryServlet>Start buying</h3>");
			out.print("<hr>");
			
			StringJoiner sj = new StringJoiner(",","(",")");
			//StringJoiner sj = new StringJoiner("seperate","prefix","suffix");
			//Example: StringJoiner sj = new StringJoiner(",","(",")");
			
			
			for(Integer item:set ){
		sj.add(" "+item);
		}
			String sql = "select * from products where code in "+sj;
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","lqs@5");
		   Statement stmt  = con.createStatement();
		   ResultSet rs = stmt.executeQuery(sql);
		   out.println("<table border=1>");
		   int sum=0;
			while(rs.next()){
				
				String code = rs.getString("code");
				String name = rs.getString("name");
				String price = rs.getString("price");
				String description= rs.getString("description");
				String category = rs.getString("category");
				sum = sum+Integer.parseInt(price);
				out.println("<tr>");
				out.println("<td>"+code+"</td>");
				out.println("<td>"+name+"</td>");
				out.println("<td align=right>"+price+"</td>");
				out.println("<td>"+description+"</td>");
				out.println("<td>"+category+"</td>");
				out.println("</tr>");
			}
			out.println("<tr>");
			out.println("<td></td>");
			out.println("<td>Total Rs.</td>");
			out.println("<td>"+sum+"</td>");
			out.println("</tr>");
				
			
		out.println("/table");
		con.close();
		
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			//out.println(sql);
			out.println("<hr>");
			out.println("<a href = buyer-dashboard.jsp>Dashboard");
		}
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		}
		
	}



