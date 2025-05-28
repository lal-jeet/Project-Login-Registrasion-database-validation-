package com.test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/reg")
public class RegisterServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String uname=req.getParameter("user");
		String password=req.getParameter("pass");
		String mail=req.getParameter("mail");
		
		Student st=new Student(uname, mail, password);
		
				int k = new DAO().register(st);	
				if(k>0)
				{
					res.getWriter().println("Register Success");
				}
				else
				{
					res.getWriter().println("fail");
				}
	}

		
}
