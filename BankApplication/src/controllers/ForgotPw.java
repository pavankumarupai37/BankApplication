package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Model;

public class ForgotPw extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		String newpassword=x.getParameter("newpasswd");
		HttpSession hs=x.getSession();
		String email=(String)hs.getAttribute("EMAIL");
		Model m=new Model();
		boolean temp=m.forgotPw(newpassword,email);
		if(temp==true) 
		{
			try
			{
				y.sendRedirect("/BankApplication/PwChngSuc.jsp");
			}
			catch(Exception e)
			{
				System.out.println("unable to redirect");
			}
		}
		else
		{
			try
			{
				y.sendRedirect("/BankApplication/PwChngFail.jsp");
			}
			catch(Exception e)
			{
				System.out.println("unable to redirect");
			}
		}
		
	}
}