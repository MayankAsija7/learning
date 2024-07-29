package com.RequestMaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RequestedBookDaoImpl{
	public ArrayList<Requests> returnBook(int stid)
	{
		
		String url="jdbc:postgresql://10.1.1.53:5432/TRAINING";
	String name="postgres";
	String password="MOb1cule!";
		
		System.out.println("Inside returnrequest : Value Passed : "+stid);
		ArrayList<Requests> RqAl=new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Class Loaded");
	Connection con=DriverManager.getConnection(url,name,password);
String query="SELECT requests.request_id,requests.student_id,requests.request_status,requests.request_date,requests.request_remark,requests.isbn,students.stnm,books.name FROM \"I1291\".requests INNER JOIN \"I1291\".students ON students.stid = requests.student_id INNER JOIN \"I1291\".books ON requests.isbn = books.isbn WHERE student_id = ? AND request_status = 'Request Approved,Book Pending To Return'";		
PreparedStatement pts=con.prepareStatement(query);
		pts.setInt(1,stid);
		System.out.println("Value For PreparedStatement : "+pts);
		ResultSet resultset=pts.executeQuery();
System.out.println("Here Controll After Executing Query");
		while(resultset.next())
		{
			Requests requestObj=new Requests();
	requestObj.setRequestId(resultset.getInt(1));
	requestObj.setBookName(resultset.getString(8));
	RqAl.add(requestObj);
		}
		System.out.println("Requests Fetched in ArrayList From Database"+RqAl);
		return RqAl;
		}
		catch(Exception ex)
		{

		return RqAl;
		}

		
		
		
		
	}
	
	
	
	
	
	
	

}
