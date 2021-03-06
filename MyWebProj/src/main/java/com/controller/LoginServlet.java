package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		if(request.getParameter("uname").isEmpty() && !request.getParameter("password").isEmpty())
		{
			System.out.println("Sorry username is required");
			rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			out.print("<p1>Username is required</p>");
		}
		else
		{
			rd=request.getRequestDispatcher("SuccessServlet");
			rd.forward(request, response);
		}
	}

}
