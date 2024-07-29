package com.RequestMaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.http.HttpSession;

public class fetchOne {
String url="jdbc:postgresql://10.1.1.53:5432/TRAINING";
	String name="postgres";
	String password="MOb1cule!";
	
	public ArrayList<Requests> disp(int studentId)
{
	ArrayList<Requests> requestsArrayList=new ArrayList<>();

	try
	{
	Class.forName("org.postgresql.Driver");
	System.out.println("Data Driver Loaded");
	Connection con=DriverManager.getConnection(url,name,password);
	//String query="select * from \"I1291\".requests where student_id=?";
	String query="select requests.request_id,requests.request_status,request_date,books.name from \"I1291\".requests inner join \"I1291\".books on requests.isbn=books.isbn where student_id= ? order by requests.request_id";
	System.out.println("Query Value : "+query);
	PreparedStatement pts=con.prepareStatement(query);
	pts.setInt(1,studentId);
	System.out.println("Prepared Statement Value"+pts);
	ResultSet rst1=pts.executeQuery();
	System.out.println(rst1);
	System.out.println("ExecuteQuery Executed");
	System.out.println("inside authentication printing resultSet : "+rst1);

	if(!rst1.equals(null))
{
	while(rst1.next())
	{
	Requests requestObj=new Requests();
	requestObj.requestId=rst1.getInt(1);
	requestObj.requestStatus=rst1.getString(2);
	requestObj.requestDate=rst1.getString(3);
	requestObj.bookReturnDate=rst1.getString(4);
	
	requestsArrayList.add(requestObj);
	}
	
return requestsArrayList;
}
	else
	{
		System.out.println("No Value In Resultset");
		return requestsArrayList;
	}
}
	
catch(Exception ex)
	{
	
	ex.getStackTrace();
	System.out.println(ex);
		
	}
	return requestsArrayList;
}

public ArrayList<Requests> dispAll()
{
	ArrayList<Requests> requestsArrayList=new ArrayList<>();

	try
	{

	
	Class.forName("org.postgresql.Driver");
	System.out.println("Data Driver Loaded");
	Connection con=DriverManager.getConnection(url,name,password);
	//String query="SELECT requests.request_id,requests.request_date,books.name,students.stnm FROM \"I1291\".requests	inner join \"I1291\".books ON requests.isbn = books.isbn INNER JOIN \"I1291\".students ON requests.student_id  = students.stid WHERE requests.request_status = 'Pending For Approval'";
	String query="SELECT requests.request_id,requests.request_date,books.name,students.stnm,books.status,requests.request_status FROM \"I1291\".requests inner join \"I1291\".books ON requests.isbn = books.isbn INNER JOIN \"I1291\".students ON requests.student_id  = students.stid WHERE requests.request_status = 'Pending For Approval'";
	System.out.println("Query Value : "+query);
	PreparedStatement pts=con.prepareStatement(query);
	System.out.println("Prepared Statement Value"+pts);
	ResultSet rst=pts.executeQuery();
	System.out.println(rst);
	System.out.println("ExecuteQuery Executed");
	System.out.println("inside authentication printing resultSet : "+rst);

	if(!rst.equals(null))
{
	while(rst.next())
	{
	Requests requestObj=new Requests();
	requestObj.requestId=rst.getInt(1);
	requestObj.requestDate=rst.getString(2);
	requestObj.bookName=rst.getString(3);
	requestObj.studentName=rst.getString(4);
	requestObj.bookStatus=rst.getString(5);
	requestObj.requestStatus=rst.getString(6);
	requestsArrayList.add(requestObj);
	}
	System.out.println("Before Printing Resultset");
return requestsArrayList;
}
	else
	{
		System.out.println("No Value In Resultset");
		return requestsArrayList;
	}
}
	
catch(Exception ex)
	{
	
	ex.getStackTrace();
	System.out.println(ex);
		
	}
	return requestsArrayList;
}


public ArrayList<Requests> dispAllReturnRequest()
{
	//for all return request
	ArrayList<Requests> requestsArrayList=new ArrayList<>();

	try
	{

	
	Class.forName("org.postgresql.Driver");
	System.out.println("Data Driver Loaded");
	Connection con=DriverManager.getConnection(url,name,password);
	
	
	String query="SELECT requests.request_id,requests.request_date,books.name,students.stnm,books.status FROM \"I1291\".requests inner join \"I1291\".books ON requests.isbn = books.isbn INNER JOIN \"I1291\".students ON requests.student_id  = students.stid WHERE requests.request_status = 'request pending to approve return book'";
	//String query="SELECT requests.request_id,requests.request_date,books.name,students.stnm,books.status FROM \"I1291\".requests inner join \"I1291\".books ON requests.isbn = books.isbn INNER JOIN \"I1291\".students ON requests.student_id  = students.stid";
	System.out.println("Query Value : "+query);
	PreparedStatement pts=con.prepareStatement(query);
	System.out.println("Prepared Statement Value"+pts);
	ResultSet rst=pts.executeQuery();
	System.out.println(rst);
	System.out.println("ExecuteQuery Executed");
	System.out.println("inside authentication printing resultSet : "+rst);

	if(!rst.equals(null))
{
	while(rst.next())
	{
	Requests requestObj=new Requests();
	requestObj.requestId=rst.getInt(1);
	requestObj.requestDate=rst.getString(2);
	requestObj.bookName=rst.getString(3);
	requestObj.studentName=rst.getString(4);
	requestObj.bookStatus=rst.getString(5);
	requestsArrayList.add(requestObj);
	}
	System.out.println("Before Printing Resultset");
return requestsArrayList;
}
	else
	{
		System.out.println("No Value In Resultset");
		return requestsArrayList;
	}
}
	
catch(Exception ex)
	{
	
	ex.getStackTrace();
	System.out.println(ex);
		
	}
	return requestsArrayList;


}












public ArrayList<Requests> dispAllRequest()
{
	//for all return request
	ArrayList<Requests> requestsArrayList=new ArrayList<>();

	try
	{

	
	Class.forName("org.postgresql.Driver");
	System.out.println("Data Driver Loaded");
	Connection con=DriverManager.getConnection(url,name,password);
	
	
	
	String query="SELECT requests.request_id,requests.request_date,books.name,students.stnm,books.status,requests.request_status  FROM \"I1291\".requests inner join \"I1291\".books ON requests.isbn = books.isbn INNER JOIN \"I1291\".students ON requests.student_id  = students.stid order by requests.request_id";
	System.out.println("Query Value : "+query);
	PreparedStatement pts=con.prepareStatement(query);
	System.out.println("Prepared Statement Value"+pts);
	ResultSet rst=pts.executeQuery();
	System.out.println(rst);
	System.out.println("ExecuteQuery Executed");
	System.out.println("inside authentication printing resultSet : "+rst);

	if(!rst.equals(null))
{
	while(rst.next())
	{
	Requests requestObj=new Requests();
	requestObj.requestId=rst.getInt(1);
	requestObj.requestDate=rst.getString(2);
	requestObj.bookName=rst.getString(3);
	requestObj.studentName=rst.getString(4);
	requestObj.bookStatus=rst.getString(5);
	requestObj.requestStatus=rst.getString(6);
	requestsArrayList.add(requestObj);
	}
	System.out.println("Before Printing Resultset");
return requestsArrayList;
}
	else
	{
		System.out.println("No Value In Resultset");
		return requestsArrayList;
	}
}
	
catch(Exception ex)
	{
	
	ex.getStackTrace();
	System.out.println(ex);
		
	}
	return requestsArrayList;


}

/////////////////////////////////////////////////////////////////////////////

public ArrayList<Requests> dispRequestByDate(String start,String end)
{
	//for all return request
	ArrayList<Requests> requestsArrayList=new ArrayList<>();

	try
	{

	
	Class.forName("org.postgresql.Driver");
	System.out.println("Data Driver Loaded");
	Connection con=DriverManager.getConnection(url,name,password);
	
	
	
	String query="SELECT requests.request_id,requests.request_date,books.name,students.stnm,books.status,requests.request_status  FROM \"I1291\".requests inner join \"I1291\".books ON requests.isbn = books.isbn INNER JOIN \"I1291\".students ON requests.student_id  = students.stid where requests.request_date between ? and ? order by requests.request_id ";
	System.out.println("Query Value : "+query);
	PreparedStatement pts=con.prepareStatement(query);
	pts.setString(1,start);
	pts.setString(2, end);
	System.out.println("Prepared Statement Value"+pts);
	ResultSet rst=pts.executeQuery();
	System.out.println(rst);
	System.out.println("ExecuteQuery Executed");
	System.out.println("inside authentication printing resultSet : "+rst);

	if(!rst.equals(null))
{
	while(rst.next())
	{
	Requests requestObj=new Requests();
	requestObj.requestId=rst.getInt(1);
	requestObj.requestDate=rst.getString(2);
	requestObj.bookName=rst.getString(3);
	requestObj.studentName=rst.getString(4);
	requestObj.bookStatus=rst.getString(5);
	requestObj.requestStatus=rst.getString(6);
	requestsArrayList.add(requestObj);
	}
	System.out.println("Before Printing Resultset");
return requestsArrayList;
}
	else
	{
		System.out.println("No Value In Resultset");
		return requestsArrayList;
	}
}
	
catch(Exception ex)
	{
	
	ex.getStackTrace();
	System.out.println(ex);
		
	}
	return requestsArrayList;


}



public ArrayList<Requests> dispInHandBooks(int id)
{
	//for all return request
	ArrayList<Requests> requestsArrayList=new ArrayList<>();

	try
	{

	
	Class.forName("org.postgresql.Driver");
	System.out.println("Data Driver Loaded");
	Connection con=DriverManager.getConnection(url,name,password);
	
	
	
	String query="SELECT requests.request_id,requests.request_date,books.name,students.stnm,books.status,requests.request_status  FROM \"I1291\".requests inner join \"I1291\".books ON requests.isbn = books.isbn INNER JOIN \"I1291\".students ON requests.student_id  = students.stid where requests.student_id=? and request_status='Request Approved,Book Pending To Return'  order by requests.request_id";
	System.out.println("Query Value : "+query);
	PreparedStatement pts=con.prepareStatement(query);
	System.out.println("Prepared Statement Value"+pts);
	
	pts.setInt(1, id);
	
	ResultSet rst=pts.executeQuery();
	System.out.println(rst);
	System.out.println("ExecuteQuery Executed");
	System.out.println("inside authentication printing resultSet : "+rst);

	if(!rst.equals(null))
{
	while(rst.next())
	{
	Requests requestObj=new Requests();
	requestObj.requestId=rst.getInt(1);
	requestObj.requestDate=rst.getString(2);
	requestObj.bookName=rst.getString(3);
	requestObj.studentName=rst.getString(4);
	requestObj.bookStatus=rst.getString(5);
	requestObj.requestStatus=rst.getString(6);
	requestsArrayList.add(requestObj);
	}
	System.out.println("Before Printing Resultset");
return requestsArrayList;
}
	else
	{
		System.out.println("No Value In Resultset");
		return requestsArrayList;
	}
}
	
catch(Exception ex)
	{
	
	ex.getStackTrace();
	System.out.println(ex);
		
	}
	return requestsArrayList;


}


















}
