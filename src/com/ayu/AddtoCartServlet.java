package com.ayu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddtoCartServlet")
public class AddtoCartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		//reading the code
		int code = Integer.parseInt(request.getParameter("code"));
  
		//here we try to fetch a collection from session.
		
		HttpSession session = request.getSession();
		HashSet<Integer> set = (HashSet<Integer>) session.getAttribute("cart");

	//either you will get set or null
		
		if(set==null){
			set = new HashSet<Integer>(); //when user purchase first item
			
		}
		set.add(code);
		session.setAttribute("cart",set );
		response.sendRedirect("CategoryServlet");
	}
}
