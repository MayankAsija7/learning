package com.myserP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpSession;

public class authenticationDaoImpl implements authenticationDao {




	String url="jdbc:postgresql://10.1.1.53:5432/TRAINING";
	String name="postgres";
	String password="123";


	@Override
	public String validateUser(String mail)
	{

		try
		{
			System.out.println("Email Received inside Validate User"+mail);
			Class.forName("org.postgresql.Driver");
			System.out.println("Data Driver Loaded");
		Connection con=DriverManager.getConnection(url,name,password);
		String query="select * from \"I1291\".users where user_email=?";
		System.out.println("Query Value : "+query);
		PreparedStatement pts=con.prepareStatement(query);
		pts.setString(1, mail);
		System.out.println("Prepared Statement Value"+pts);
		ResultSet rst=pts.executeQuery();
		System.out.println("ExecuteQuery Executed");
		System.out.println("inside authentication printing resultSet : "+rst);
		if(rst != null)
		{
			rst.next();
			System.out.println("Type of User "+rst.getString(2));
			String userType=rst.getString(2);
			boolean accoutStatus=rst.getBoolean(3);
			
			System.out.println("Account Deleted status ***************||||***********"+accoutStatus);
			
			String DeletedAc=String.valueOf(rst.getBoolean(3));
			System.out.println(DeletedAc);
			if(rst.getBoolean(3)==true)
			{
		return DeletedAc;
				
			}
			
			return rst.getString(2);

		}
		else
		{
			return "Empty";
		}


		}
		catch(Exception ex)
		{
		ex.getStackTrace();
		return "Exception";
		}
		}
	@Override
	public ArrayList login(String userEmail,String userPass,String userType)
	{
		ArrayList UserInfoArrayList=new ArrayList();
		System.out.println("Controll in Login");
		System.out.println("User Email = "+userEmail+": User Pass = "+userPass+" : User Type"+userType);
		if(userType.equals("admin"))
		{
			String query="select * from \"I1291\".admin_table where admin_mail=? AND admin_password = ?";
			System.out.println("In login : Query for admin : "+query);
			try
			{
				Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url,name,password);
			PreparedStatement pts=con.prepareStatement(query);

			pts.setString(1,userEmail);
			pts.setString(2,userPass);
			System.out.println("PreparedSatatement object value : "+pts);
			ResultSet rst=pts.executeQuery();
System.out.println("Query Executed"+rst);
//String userName=rst.getString(2);
			rst.next();
			System.out.println("Values in ResultSet : "+rst);
			System.out.println("login Query Executed");
			String userName=rst.getString(2);
			System.out.println("User Name : "+userName);
			if(!rst.equals(null))
			{
				UserInfoArrayList.add(userName);

				return UserInfoArrayList;
			}
			else
			{
				return UserInfoArrayList;
			}

			}






			catch(Exception ex)
			{

				System.out.println("Exception Occoured in login");
				return UserInfoArrayList;
			}

		}
		else
			if(userType.equals("student"))
			{
				System.out.println("In Student type");
				String query="select steml, stpas,stnm,stid FROM \"I1291\".students where steml=? and stpas=?";
				try
				{
					Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection(url,name,password);
				PreparedStatement pts=con.prepareStatement(query);
				pts.setString(1,userEmail);
				pts.setString(2,userPass);
				System.out.println("Going to Execute Query in Resultset");
				ResultSet rst=pts.executeQuery();
				System.out.println("Resultset Query Executed");
				rst.next();
				String userName=rst.getString(3);
				String userId=rst.getString(4);
				
				
				
				
				
				System.out.println("Value Of Resultset : "+rst);
				System.out.println("Here User name is : "+userName);
				
				if(!rst.equals(null))
				{
				
					UserInfoArrayList.add(userName);
					UserInfoArrayList.add(userId);
					
				 return UserInfoArrayList;
				}
				else
				{
					return UserInfoArrayList;
				}

				}
				catch(Exception ex)
				{
					System.out.println("Exception Occoured");
					return UserInfoArrayList;
				}
			}else if(userType.equals("librarian"))
			{
				System.out.println("Here User Identified User Is Librarian");
				
				String query= "select email,pass,libname from \"I1291\".librarian where email=? and pass=?";
				try
				{
					Class.forName("org.postgresql.Driver");
				System.out.println("Login Data Drivers Loaded");
				
						
						
				
				
				Connection con=DriverManager.getConnection(url,name,password);
				PreparedStatement pts=con.prepareStatement(query);
				pts.setString(1,userEmail);
				pts.setString(2,userPass);
				System.out.println("Value of Preparedstatement : "+pts);
				
				System.out.println("Control Loading data for Librianian");
				
				ResultSet rst=pts.executeQuery();
				
				System.out.println("Resultset After ExecuteQuery For Librarian  : "+rst);
				rst.next();
				System.out.println("Resultset After ExecuteQuery For Librarian  : "+rst);
				
				if(!rst.equals(null))
				{
					String userEmailId=rst.getString(1);
					String userPassword=rst.getString(2);
					String userName=rst.getString(3);		
					
					System.out.println("Here Adding Values in ArrayList Before Returning"+userName+" : "+userEmailId+" : "+userPassword);
					UserInfoArrayList.add(userEmailId);
					UserInfoArrayList.add(userName);
					UserInfoArrayList.add(userPassword);
					
					System.out.println("Here ArrayList Printing : "+UserInfoArrayList);
					return UserInfoArrayList;
				}
				else
				{
					return UserInfoArrayList;
				}

				}
				catch(Exception ex)
				{
					System.out.println("Exception Occoured");
					return UserInfoArrayList;
				}
			}

		return UserInfoArrayList;
			}
}
