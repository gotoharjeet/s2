package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestFor=request.getParameter("task");
		//System.out.println(requestFor);
		
		
		
		RequestDispatcher rd=null;
		
		
		
		
		if(requestFor.equals("Login"))
		{
		    rd=request.getRequestDispatcher("LoginServlet");
		   rd.forward(request, response);
		}else {
			response.sendRedirect("./registeruser.html");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
