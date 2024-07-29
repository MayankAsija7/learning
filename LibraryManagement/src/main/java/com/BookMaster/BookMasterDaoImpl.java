package com.BookMaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookMasterDaoImpl implements BookMasterDao{
	String url="jdbc:postgresql://10.1.1.53:5432/TRAINING";
	String name="postgres";
	String password="123";
	@Override
	public int insertBook(int isbn,String bkname,String author,String description,String genre)
	{
try
{
Class.forName("org.postgresql.Driver");
Connection con=DriverManager.getConnection(url,name,password);
String query="insert into \"I1291\".books values(?,?,?,?,?)";
PreparedStatement pts=con.prepareStatement(query);
pts.setInt(1,isbn);
pts.setString(2, bkname);
pts.setString(3, author);
pts.setString(4, description);
pts.setString(5, genre);
pts.execute();
}
catch(Exception ex)
{
	ex.getStackTrace();
return 0;
}
		return 1;
	}
	@Override
	public ArrayList<LibBook>findBook(int isbn)
	{
		ArrayList<LibBook> BkAl=new ArrayList<>();
		LibBook bookobj=new LibBook();
		try {
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection(url,name,password);
String query="select * from \"I1291\".books where ?="+"isbn";
		PreparedStatement pts=con.prepareStatement(query);
		pts.setInt(1, isbn);
		ResultSet resultset=pts.executeQuery();

		while(resultset.next())
		{
			bookobj.setIsbn(resultset.getInt(1));
			bookobj.setName(resultset.getString(2));
			bookobj.setAuthor(resultset.getString(3));
			bookobj.setDescription(resultset.getString(4));
			bookobj.setGenre(resultset.getString(5));
			BkAl.add(bookobj);
		}
		return BkAl;
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			return BkAl;
		}
	}
	@Override
	public int updateBook(int isbn,String bkname,String author,String description,String genre)
	{
		try
		{
			Class.forName("org.postgresql.Driver");

		String query="update \"I1291\".books set name=?,author=?,description=?,genre=? where isbn="+isbn;
		Connection con=DriverManager.getConnection(url,name,password);
		PreparedStatement pts=con.prepareStatement(query);
		pts.setString(1, bkname);
		pts.setString(2, author);
		pts.setString(3, description);
		pts.setString(4,genre);
		int op=pts.executeUpdate();
		return op;
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
		return 0;
		}
	@Override
	public void DeleteBook(int isbn)
	{
		try {
	        Class.forName("org.postgresql.Driver");
	        String query = "delete from \"I1291\".books where isbn=?";
	        Connection con = DriverManager.getConnection(url, name, password);
	        PreparedStatement pts = con.prepareStatement(query);
	        pts.setInt(1, isbn);
	        pts.executeUpdate();
	        con.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        
	    }
	}


	@Override
	public ArrayList<LibBook>findAllBook()
	{
//	?????????????????????
		ArrayList<LibBook> BkAl=new ArrayList<>();

		try {
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection(url,name,password);
String query="SELECT * FROM \"I1291\".books where deleted='false'";
		PreparedStatement pts=con.prepareStatement(query);
		System.out.println("Prepared Statement Value : "+pts);
		ResultSet resultset=pts.executeQuery();
		System.out.println("Value in result set"+resultset);

		while(resultset.next())
		{
			LibBook bookobj=new LibBook();

			bookobj.setIsbn(resultset.getInt(1));
			bookobj.setName(resultset.getString(2));
			bookobj.setAuthor(resultset.getString(3));
			bookobj.setDescription(resultset.getString(4));
			bookobj.setGenre(resultset.getString(5));
			bookobj.setStatus(resultset.getString(6));
			System.out.println(bookobj.getName());
			BkAl.add(bookobj);

			System.out.println("Book Name: List : "+BkAl);

		}
		//BkAl.forEach((obj)->System.out.println(obj.getName()));
		return BkAl;
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			return BkAl;
		}
	}
	public int fetchMax()
	{
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url,name,password);
			String Query="select Max(stid) from \"I1291\".students";
			PreparedStatement pts2=con.prepareStatement(Query);
			ResultSet resultset=pts2.executeQuery();
			System.out.println("Maximum Id Generated : "+resultset);
			if(resultset.next())
			{
				int id=resultset.getInt(1);
				id++;
				System.out.println("Max Id Returning");
				return id;	
				
			}
			else
			{
				System.out.println("Data Not Found");
			return 0;
			}

			}
			catch(Exception ex)
			{
			System.out.println("Here Exception Occoured");
			return 0;
			}
			}	
	public void DelBook(int isbn)
	{
		try
		{
			Class.forName("org.postgresql.Driver");

		String query="update \"I1291\".books set deleted='true' where isbn="+isbn;
		Connection con=DriverManager.getConnection(url,name,password);
		PreparedStatement pts=con.prepareStatement(query);
				int op=pts.executeUpdate();
	
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
			
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<LibBook>DeletedBooks()
	{
//	?????????????????????
		ArrayList<LibBook> BkAl=new ArrayList<>();

		try {
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection(url,name,password);
String query="SELECT * FROM \"I1291\".books where deleted='true'";
		PreparedStatement pts=con.prepareStatement(query);
		System.out.println("Prepared Statement Value : "+pts);
		ResultSet resultset=pts.executeQuery();
		System.out.println("Value in result set"+resultset);

		while(resultset.next())
		{
			LibBook bookobj=new LibBook();

			bookobj.setIsbn(resultset.getInt(1));
			bookobj.setName(resultset.getString(2));
			bookobj.setAuthor(resultset.getString(3));
			bookobj.setDescription(resultset.getString(4));
			bookobj.setGenre(resultset.getString(5));
			bookobj.setStatus(resultset.getString(6));
			System.out.println(bookobj.getName());
			BkAl.add(bookobj);

			System.out.println("Book Name: List : "+BkAl);

		}
		//BkAl.forEach((obj)->System.out.println(obj.getName()));
		return BkAl;
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			return BkAl;
		}
	}
	
	
	
	
	}

