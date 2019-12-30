package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Model;

public class GetStatement extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		HttpSession hs=x.getSession();
		String account_number=(String)hs.getAttribute("ACCOUNT_NUMBER");
		Model m=new Model();
		m.setAccount_number(account_number);
		ArrayList temp=m.getMini();
		if(temp.isEmpty())
		{
			try
			{
				y.sendRedirect("/BankApplication/HistoryErr.jsp");
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
				HttpSession hs1=x.getSession(true);
				hs.setAttribute("HISTORY",temp);
				y.sendRedirect("/BankApplication/HistorySuccess.jsp");
			}
			catch(Exception e)
			{
				System.out.println("unable to redirect");
			}
		}
			
		
	}
}