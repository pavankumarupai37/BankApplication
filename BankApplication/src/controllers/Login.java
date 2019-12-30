package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Model;

public class Login extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		String customer_id=x.getParameter("id");
		String password=x.getParameter("password");
		Model m=new Model();
		m.setCustomer_id(customer_id);
		m.setPassword(password);
		boolean temp=m.MkeLogin();
		
		if(temp==true)
		{
			try
			{
				String account_number=m.getAccount_number();
				System.out.println(account_number);
				HttpSession hs=x.getSession(true);
				hs.setAttribute("ACCOUNT_NUMBER", account_number);
				try 
				{
					x.getServletContext().getRequestDispatcher("/CheckBal").include(x,y);
				}
				catch(Exception e)
				{
					System.out.println("unable to redirect");
				}
				
				y.sendRedirect("/BankApplication/Success.jsp");
				
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
				y.sendRedirect("/BankApplication/Failure.html");
			}
			catch(Exception e)
			{
				System.out.println("unable to redirect");
			}
		}
	}
}