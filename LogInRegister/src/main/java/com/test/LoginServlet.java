package com.test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/login")
public class LoginServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			String uname=req.getParameter("user");
			String password=req.getParameter("pass");
			
			Student std=new DAO().login(uname, password);
			req.setAttribute("stObj", std);
			System.out.println(std);
			if(std==null)
			{
				req.setAttribute("status", "user not found");
			}
			else
			{
				req.setAttribute("status", "succuss");
			}
			req.getRequestDispatcher("result.jsp").forward(req, res);
		
	}

}
