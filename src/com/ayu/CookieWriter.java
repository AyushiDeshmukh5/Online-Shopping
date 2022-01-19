package com.ayu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet("/CookieWriter")
public class CookieWriter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//here we wish to send the cookie along with response.
		PrintWriter out = response.getWriter();
		
		//three steps to write cookie:
		
		//step-1:Create a cookie object.
		Cookie ck1 = new Cookie ("author","BookBazar");
		Cookie ck2 = new Cookie("company","ayu");
	    //step-2:Set the maximum age of the cookie.
		ck1.setMaxAge(5000); //in seconds
		ck2.setMaxAge(5000);
//		ck.setMaxAge(60*60*24*7); for a week
		
		//step-3:Write it to response object.
		response.addCookie(ck1);
		response.addCookie(ck2);
		
		out.println("Hello user:)");  //we are sending response to client
		
		out.close();
	}

}
