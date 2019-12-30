package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Model;

public class TransferAmt extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		String amount=x.getParameter("amount");
		String account_number1=x.getParameter("accountnumber");
		HttpSession hs=x.getSession(true);
		String account_number=(String)hs.getAttribute("ACCOUNT_NUMBER");
		Model m=new Model();
		m.setAccount_number(account_number);
		boolean temp=m.transferAmt(amount);
		if(temp==true)
		{
			try
			{
				m.transferToAcc(amount, account_number1);
				y.sendRedirect("/BankApplication/BalUpdated.jsp");
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
				y.sendRedirect("/BankApplication/BalNotUpdated.jsp");
			}
			catch(Exception e)
			{
				System.out.println("unable to redirect");
			}
		}
	}
}