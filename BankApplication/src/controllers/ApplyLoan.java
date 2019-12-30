package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Model;

public class ApplyLoan extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		HttpSession hs=x.getSession();
		String account_number=(String)hs.getAttribute("ACCOUNT_NUMBER");
		System.out.println(account_number);
		Model m=new Model();
		m.setAccount_number(account_number);
		boolean temp=m.applyLoan();
		if(temp==true)
		{
			String b=m.getA();
			HttpSession hs1=x.getSession(true);
			System.out.println(b);
			hs1.setAttribute("NAME",b);
			try
			{
				y.sendRedirect("/BankApplication/HmeSuc.jsp");
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
				y.sendRedirect("/BankApplication/HmeFail.jsp");
			}
			catch(Exception e) 
			{
				System.out.println("unable to redirect");
			}
		}
	}
}