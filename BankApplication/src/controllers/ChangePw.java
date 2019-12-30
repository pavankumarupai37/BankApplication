package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Model;

public class ChangePw extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		HttpSession hs=x.getSession();
		String account_number=(String)hs.getAttribute("ACCOUNT_NUMBER");
		String password=x.getParameter("newpassword");
		Model m=new Model();
		m.setPassword(password);
		m.setAccount_number(account_number);
		boolean temp=m.ChngPw();
		if(temp==true)
		{
			try
			{
				y.sendRedirect("/BankApplication/PwChangeSuccess.jsp");
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
				y.sendRedirect("/BankApplication/PwChangeFailure.jsp");
			}
			catch(Exception e)
			{
				System.out.println("unable to redirect");
			}
		}
		
	}
}