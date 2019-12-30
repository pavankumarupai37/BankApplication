package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Model 
{
	String name=null;
	String customer_id=null;
	String password=null;
	String account_number=null;
	String balance=null;
	String a=null;
	String url="jdbc:oracle:thin:@//localhost:1522/XE";
	String uname="system";
	String pwd="system";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
	public Model()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, uname, pwd);
			System.out.println("driver loaded and connection established");
		}
		catch(Exception e)
		{
			System.out.println("driver not loaded and connection failed");
		}
	}
	
	public boolean MkeLogin()
	{
		try
		{
			pstmt=con.prepareStatement("select * from bank where customer_id=? and password=?");
			pstmt.setString(1, customer_id);
			pstmt.setString(2, password);
			res=pstmt.executeQuery();
			System.out.println(res);
			if(res.next()==false)
			{
				return false;
			}
			else
			{
				account_number=res.getString(2);
				return true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("query not executed");
		}
		return false;
	}

	public boolean ChkBal()
	{
		try
		{
			pstmt=con.prepareStatement("select * from bank where account_number=?");
			pstmt.setString(1, account_number);
			res=pstmt.executeQuery();
			if(res.next()==false)
			{
				return false;
			}
			else
			{
				balance=res.getString(3);
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("query not executed");
		}
		return false;
	}
	
	public boolean ChngPw()
	{
		try
		{
			pstmt=con.prepareStatement("update bank set password=? where account_number=?");
			pstmt.setString(1, password);
			pstmt.setString(2, account_number);
			int temp=pstmt.executeUpdate();
			{
				if(temp==0)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("query not executed");
		}
		return false;
	}
	
	public boolean transferAmt(String amount)
	{
		try
		{
			pstmt=con.prepareStatement("update bank set balance=balance-? where account_number=?");
			pstmt.setString(1,amount);
			pstmt.setString(2, account_number);
			int res=pstmt.executeUpdate();
			pstmt=con.prepareStatement("insert into bankstatement values(?,?)");
			pstmt.setString(1, account_number);
			pstmt.setString(2, amount);
			pstmt.executeQuery();
			if(res==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("query not executed");
		}
		return false;
	}
	
	public void transferToAcc(String amount,String account_number1)
	{
		try
		{
			pstmt=con.prepareStatement("update bank set balance=balance+? where account_number=?");
			pstmt.setString(1,amount);
			pstmt.setString(2,account_number1);
			int res=pstmt.executeUpdate();
			System.out.println(res);
		}
		catch(Exception e)
		{
			System.out.println("query not executed");
		}
		
	}
	
	public ArrayList getMini()
	{
		ArrayList al=new ArrayList();
		try
		{
			pstmt=con.prepareStatement("select * from bankstatement where account_number=?");
			pstmt.setString(1, account_number);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				String temp=res.getString(2);
				al.add(temp);
			}
			return al;
		}
		catch(Exception e)
		{
			System.out.println("query not executed");
		}
		return al;
	}
	
	public boolean applyLoan()
	{
		try
		{
			pstmt=con.prepareStatement("select * from bank where account_number=?");
			System.out.println(account_number);
			pstmt.setString(1, account_number);
			res=pstmt.executeQuery();
			System.out.println(res);
			if(res.next()==false)
			{
				return false;
			}
			else
			{
				a=res.getString("NAME");
				System.out.println(a);
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Query not executed");
		}
		return false;
	}
	
	public boolean forgotPw(String newpassword,String email)
	{
		try
		{
			pstmt=con.prepareStatement("update bank set password=? where e_mail=?");
			pstmt.setString(1, newpassword);
			pstmt.setString(2, email);
			int row=pstmt.executeUpdate();
			if(row==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("query not executed");
		}
		return false;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	
}
