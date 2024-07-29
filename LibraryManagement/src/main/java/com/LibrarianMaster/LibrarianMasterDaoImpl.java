package com.LibrarianMaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibrarianMasterDaoImpl implements LibrarianMasterDao {

	String url="jdbc:postgresql://10.1.1.53:5432/TRAINING";
	String name="postgres";
	String password="123";
	String cname="postgres";
	String cpassword="123";
	
	@Override
	public int insertLibrarian(int id,String name,String contact,String joiningDate,String address,String email,String password)
	{
	try
	{
		System.out.println("Controll"+name+joiningDate);
	Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url,cname,cpassword);
			String query="insert into \"I1291\".librarian values(?,?,?,?,?,?,?)";
			String Query2="insert into \"I1291\".users values(?,?)";
			PreparedStatement pts=con.prepareStatement(query);
			pts.setInt(1,id);
			pts.setString(2,name);
			pts.setString(3, contact);
			System.out.print("on 3");
			pts.setString(4, joiningDate);
			pts.setString(5, address);
			System.out.println("On 4");
			pts.setString(6, email);
			pts.setString(7, password);
			System.out.println("Control in insert"+id);
			pts.execute();
			
			/////////
			PreparedStatement pts2=con.prepareStatement(Query2);
			pts2.setString(1,email);
			pts2.setString(2,"librarian");
			pts2.executeQuery();
System.out.println("Insert Into user table done");
			
			}
    catch(SQLException e)
	{
    	if(e.getSQLState().equals("23505"))
    	{
    		System.out.println("User Already Exist With Same Mail ID");
    		return -1;  		
    	}
    	
	}
	catch(Exception ex)
			{
				System.out.println("Exception::::"+ex);
				ex.getStackTrace();
			return 0;
			}
					return 1;
	}

	/*
	 * public ArrayList<Librarian> findLibrarian(int id) { ArrayList<Librarian>
	 * LbAl=new ArrayList<Librarian>(); Librarian librarianobj=new Librarian(); try
	 * { Class.forName("org.postgresql.Driver"); Connection
	 * con=DriverManager.getConnection(url,cname,cpassword); String
	 * query="select * from \"I1291\".Librarian where libid = " +id;
	 * PreparedStatement pts=con.prepareStatement(query); //pts.setInt(1, id);
	 * System.out.println("Hello Mayank"); ResultSet resultset=pts.executeQuery();
	 * System.out.println("Im Here "+resultset); if(resultset != null) {
	 * while(resultset.next()) { librarianobj.setLibId(resultset.getInt(1));
	 * librarianobj.setLibName(resultset.getString(2));
	 * librarianobj.setLibContNum(resultset.getString(3));
	 * librarianobj.setLibJoinDate(resultset.getString(4));
	 * librarianobj.setLibAddress(resultset.getString(5));
	 * librarianobj.setLibEmail(resultset.getString(6));
	 * librarianobj.setLibPassword(resultset.getString(7)); LbAl.add(librarianobj);
	 * } } return LbAl; } catch(Exception ex) { ex.getStackTrace(); return LbAl; }
	 *
	 * }
	 */
	@Override
	public ArrayList<Librarian> findLibrarian(int id)
	{
		System.out.println("LibrarianMasterDaoImpl :: Inside findLibrarian method");

		System.out.println("parameter id " + id);

		  ArrayList<Librarian> librarianList = new ArrayList<>();
		    try {
		        Class.forName("org.postgresql.Driver");
		        Connection con = DriverManager.getConnection(url, cname, cpassword);
		        String query = "select * from \"I1291\".librarian where libid = ?";

		        System.out.println("query ---> " + query);

		        PreparedStatement pts = con.prepareStatement(query);
		        pts.setInt(1, id);
		        ResultSet resultSet = pts.executeQuery();

		        System.out.println("resultSet " + resultSet);

		        while (resultSet.next()) {
		            Librarian librarian = new Librarian();
		            librarian.setLibId(resultSet.getInt(1));
		            librarian.setLibName(resultSet.getString(2));
		            librarian.setLibContNum(resultSet.getString(3));
		            librarian.setLibJoinDate(resultSet.getString(4));
		            librarian.setLibAddress(resultSet.getString(5));
		            librarian.setLibEmail(resultSet.getString(6));
		            librarian.setLibPassword(resultSet.getString(7));
		            librarianList.add(librarian);
		        }
		        con.close(); // Close connection
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		    System.out.println("librarianList ---> " + librarianList);
		    return librarianList;
	}
	@Override
	public int UpdateLibrarian(int id,String name,String contact,String joiningDate,String address,String email,String password)
	{
		ArrayList<Librarian>LbAl=findLibrarian(id);
		LbAl.forEach((ele)->System.out.println(ele));
		if(LbAl != null&& !LbAl.isEmpty())
		{

		try
		{
			Class.forName("org.postgresql.Driver");

		String query="update \"I1291\".Librarian set libId=?,libName=?,contNum=?,jDate=?,address=?,email=?,pass=? where libId="+id;
		Connection con=DriverManager.getConnection(url,cname,cpassword);
		PreparedStatement pts=con.prepareStatement(query);
		pts.setInt(1, id);
		pts.setString(2,name);
		pts.setString(3,contact);
		pts.setString(4,joiningDate);
		pts.setString(5,address);
		pts.setString(6,email);
		pts.setString(7,password);
		int op=pts.executeUpdate();
		return op;
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			return 0;
		}
		}
		else
		{
			return -1;
		}

	}
	@Override
	public void DeleteLibrarian(int id)
	{
		try {
			Class.forName("org.postgresql.Driver");
	        String query = "delete from \"I1291\".Librarian where libid=?";
	        Connection con = DriverManager.getConnection(url, cname, cpassword);
	        PreparedStatement pts = con.prepareStatement(query);
	        pts.setInt(1, id);
	        pts.executeUpdate();
	        //con.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	public int fetchMax()
	{
		
try {
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection(url,name,password);
	String Query="select Max(libid) from \"I1291\".librarian";
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
	
	
	
	
	public ArrayList<Librarian> AllLibrarian()
	{
		System.out.println("LibrarianMasterDaoImpl :: Inside findLibrarian method");

			  ArrayList<Librarian> librarianList = new ArrayList<>();
		    try {
		        Class.forName("org.postgresql.Driver");
		        Connection con = DriverManager.getConnection(url, cname, cpassword);
		        String query = "select * from \"I1291\".librarian where Deleted = 'false'";

		        System.out.println("query ---> " + query);

		        PreparedStatement pts = con.prepareStatement(query);
		        ResultSet resultSet = pts.executeQuery();

		        System.out.println("resultSet " + resultSet);

		        while (resultSet.next()) {
		            Librarian librarian = new Librarian();
		            librarian.setLibId(resultSet.getInt(1));
		            librarian.setLibName(resultSet.getString(2));
		            librarian.setLibContNum(resultSet.getString(3));
		            librarian.setLibJoinDate(resultSet.getString(4));
		            librarian.setLibAddress(resultSet.getString(5));
		            librarian.setLibEmail(resultSet.getString(6));
		            librarian.setLibPassword(resultSet.getString(7));
		            librarianList.add(librarian);
		        }
		        con.close(); // Close connection
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		    System.out.println("librarianList ---> " + librarianList);
		    return librarianList;
	}
	
	
	public int DelLibrarian(int id)
	{
		try {
			Class.forName("org.postgresql.Driver");
	        String query = "update \"I1291\".Librarian set Deleted ='true' where libid=?;";
	        String query2="update \"I1291\".users set deleted='true' where user_email= (select email from \"I1291\".librarian where libid =?)";
	        Connection con = DriverManager.getConnection(url, cname, cpassword);
	        PreparedStatement pts = con.prepareStatement(query);
	        PreparedStatement pts2=con.prepareStatement(query2);
	        pts.setInt(1, id);
	        pts2.setInt(1, id);
	       int st= pts.executeUpdate();
	       int Deleted=pts2.executeUpdate(); 
	       con.close();
	        return st;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	   return 0;
	    }
	}
	
	
	
	public ArrayList<Librarian> DeletedLibrarian()
	{
		
		System.out.println("LibrarianMasterDaoImpl :: Inside All Deleted Librarian method");

		  ArrayList<Librarian> librarianList = new ArrayList<>();
	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection(url, cname, cpassword);
	        String query = "select * from \"I1291\".librarian where Deleted = 'true'";

	        System.out.println("query ---> " + query);

	        PreparedStatement pts = con.prepareStatement(query);
	        ResultSet resultSet = pts.executeQuery();

	        System.out.println("resultSet " + resultSet);

	        while (resultSet.next()) {
	            Librarian librarian = new Librarian();
	            librarian.setLibId(resultSet.getInt(1));
	            librarian.setLibName(resultSet.getString(2));
	            librarian.setLibContNum(resultSet.getString(3));
	            librarian.setLibJoinDate(resultSet.getString(4));
	            librarian.setLibAddress(resultSet.getString(5));
	            librarian.setLibEmail(resultSet.getString(6));
	            librarian.setLibPassword(resultSet.getString(7));
	            librarianList.add(librarian);
	        }
	        con.close(); // Close connection
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    System.out.println("librarianList ---> " + librarianList);
	    return librarianList;		
	
		
	}
	
	
	
	
	
	
	
	
	

}
