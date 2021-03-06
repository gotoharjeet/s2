package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.User;
import com.service.UserServiceImp;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		out=response.getWriter();
		RequestDispatcher rd=null;
		
		
		
		
		
		
		if(isVerification(uname,password,rd,request,response)==false)
		{
			rd=request.getRequestDispatcher("home.html");
			try {
				rd.include(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print("empty username/password");
		}
		else
		{
			User user=new User(uname,password);
			boolean isValidUser=new UserServiceImp().validateUser(user);
			
			if(isValidUser == true)
			{
				System.out.println("User needs to redirect DAO");
			}
			else
			{
				rd=request.getRequestDispatcher("home.html");
				rd.include(request, response);
				out.print("username/password does not exist");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	private boolean isVerification(String uname,String password,RequestDispatcher rd,HttpServletRequest request,HttpServletResponse response)
	{
		if(uname.isEmpty() && password.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
