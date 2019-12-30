package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Model;

public class CheckBal extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		HttpSession hs=x.getSession();
		String account_number=(String)hs.getAttribute("ACCOUNT_NUMBER");
		Model m=new Model();
		m.setAccount_number(account_number);
		boolean temp=m.ChkBal();
		if(temp==true)
		{
			try
			{
				String balance=m.getBalance();
				HttpSession hs1=x.getSession(true);
				hs1.setAttribute("BALANCE", balance);
				y.sendRedirect("/BankApplication/ChkBalSuccess.jsp");
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
				y.sendRedirect("/BankApplication/ChkBalFailure.jsp");
			}
			catch(Exception e)
			{
				System.out.println("unable to redirect");
			}
		}
		
	}
}