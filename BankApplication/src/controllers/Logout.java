package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		HttpSession hs=x.getSession();
		hs.invalidate();
		try
		{
			y.sendRedirect("/BankApplication/Login.jsp");
		}
		catch(Exception e)
		{
			System.out.println("unable to redirect");
		}
	}
}