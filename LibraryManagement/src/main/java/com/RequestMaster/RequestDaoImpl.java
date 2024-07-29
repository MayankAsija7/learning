package com.RequestMaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RequestDaoImpl implements RequestDao{
String url="jdbc:postgresql://10.1.1.53:5432/TRAINING";
	String name="postgres";
	String password="MOb1cule!";
	@Override
	public int getMaxId()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url,name,password);
			String Query2="select Max(request_id) from \"I1291\".requests";
			PreparedStatement pts2=con.prepareStatement(Query2);
			ResultSet rst2=pts2.executeQuery();
			System.out.println("Maximum Id Generated : "+rst2);


		}
		catch(Exception ex)
		{
	ex.printStackTrace();
	System.out.println("Exception occourd");
		}


		return 0;

	}


	@Override
	public int createRequest(int reqId,int studentId,String rqStatus,String rqDate,String rqRemark,String bookReturnDate)
	{
try
{
	System.out.println("Values Received From RequestMaster.jsp"+reqId+" "+studentId+" "+rqStatus+" "+rqDate+" "+rqRemark+" "+bookReturnDate);

	Class.forName("org.postgresql.Driver");
Connection con=DriverManager.getConnection(url,name,password);
System.out.println("Connection String : "+con);
String query="insert into \"I1291\".requests values(?,?,?,?,?,?)";
System.out.println("Query Executed : "+query);
PreparedStatement pts=con.prepareStatement(query);
System.out.println("Preparedstatement : "+pts);
pts.setInt(1, reqId);
pts.setInt(2,studentId);
pts.setString(3,rqStatus);
pts.setString(4, rqDate);
pts.setString(5, rqRemark);
pts.setString(6, bookReturnDate);
System.out.println("Preparedstatement's Object : "+pts);
pts.executeUpdate();
System.out.println();
return 1;
}
catch(Exception ex)
{
	ex.getStackTrace();
return 0;
}

	}


	@Override
	public ArrayList<Requests> findRequest(int requestId) {
System.out.println("Inside findrequest : Value Passed : "+requestId);
		ArrayList<Requests> RqAl=new ArrayList<>();
		Requests requestObj=new Requests();
		try {
			Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection(url,name,password);
String query="select * from \"I1291\".requests where request_id=?";
		PreparedStatement pts=con.prepareStatement(query);
		pts.setInt(1,requestId);
		ResultSet resultset=pts.executeQuery();

		while(resultset.next())
		{
	requestObj.setRequestId(resultset.getInt(1));
	requestObj.setStudentId(resultset.getInt(2));
	requestObj.setRequestStatus(resultset.getString(3));
	requestObj.setRequestDate(resultset.getString(4));
	requestObj.setRemark(resultset.getString(5));
	requestObj.setBookReturnDate(resultset.getString(6));
	RqAl.add(requestObj);
		}
		return RqAl;
		}
		catch(Exception ex)
		{

		return RqAl;
		}

	}

	@Override
	public int updateRequest(int reqId,int studentId,String rqStatus,String rqDate,String rqRemark,String bookReturnDate)
	{
		try
		{
			Class.forName("org.postgresql.Driver");

		System.out.println("Inside UpdateRequest : With Parameters :  "+reqId+" "+studentId+" "+rqStatus+" "+rqDate+" "+rqRemark+" "+bookReturnDate);
		String query="update \"I1291\".requests set student_id=?,r 	equest_status=?,request_date=?,request_remark=?,book_return_date=? where request_id="+reqId;
		System.out.println("Query Received : "+query);
		Connection con=DriverManager.getConnection(url,name,password);
		System.out.println("Connection String : "+con);
	    PreparedStatement pts=con.prepareStatement(query);
		pts.setInt(1,studentId);
		pts.setString(2,rqStatus);
		pts.setString(3,rqDate);
		pts.setString(4,rqRemark);
		pts.setString(5,bookReturnDate);
		System.out.println("Printing Preparedstatement object"+pts);
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
	public void deleteRequest(int reqId) {
		try {
			System.out.println("Inside Delete Request : RequestId Received To Delete : "+reqId);
			Class.forName("org.postgresql.Driver");
	        String query = "delete from \"I1291\".requests where request_id=?";
	        System.out.println("Query : "+query);
	        Connection con = DriverManager.getConnection(url, name, password);
	        PreparedStatement pts = con.prepareStatement(query);
	        pts.setInt(1,reqId);
	        pts.executeUpdate();
	        con.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	}
	
	
	
public void accept(int reqId)	
{
System.out.println("in accept");
try
{
	Class.forName("org.postgresql.Driver");

System.out.println("Inside Update Request Status : Accept Request");


System.out.println("Request Id Is Received By Accept"+reqId);

String query="UPDATE \"I1291\".requests SET request_status = ? FROM \"I1291\".books WHERE \"I1291\".requests.isbn = \"I1291\".books.isbn AND \"I1291\".requests.request_id ="+reqId;
String query2="UPDATE \"I1291\".books SET status = ? FROM \"I1291\".requests WHERE \"I1291\".requests.isbn = \"I1291\".books.isbn AND \"I1291\".requests.request_id="+reqId;
System.out.println("Query Received1 : "+query);
Connection con=DriverManager.getConnection(url,name,password);
System.out.println("Connection String : "+con);
PreparedStatement pts=con.prepareStatement(query);
pts.setString(1,"Request Approved,Book Pending To Return");

System.out.println("Printing Preparedstatement object1"+pts);
int op=pts.executeUpdate();
System.out.println(op);


PreparedStatement pts2=con.prepareStatement(query2);
pts2.setString(1,"Unavailable");

System.out.println("Printing Preparedstatement object2"+pts2);
int op2=pts2.executeUpdate();
System.out.println(op2);





}
catch(Exception ex)
{
	ex.getStackTrace();
}
	
}




public void deny(int reqId)	
{
System.out.println("in Deny");
try
{
	Class.forName("org.postgresql.Driver");

System.out.println("Inside Update Request Status : Deny Request");


System.out.println("Request Id Is Received By Deny : "+reqId);

String query="UPDATE \"I1291\".requests SET request_status = ? WHERE request_id ="+reqId;

System.out.println("Query Received1 : "+query);
Connection con=DriverManager.getConnection(url,name,password);
System.out.println("Connection String : "+con);
PreparedStatement pts=con.prepareStatement(query);
pts.setString(1,"Request Rejected");

System.out.println("Printing Preparedstatement object1"+pts);
int op=pts.executeUpdate();
System.out.println(op);


}
catch(Exception ex)
{
	ex.getStackTrace();
}
	
}




public void acceptBookReturn(int reqId)
{
	
	System.out.println("in accept Return");
	try
	{
		Class.forName("org.postgresql.Driver");

	System.out.println("Inside Update Request Status : Accept Request");


	System.out.println("Request Id Is Received By Accept"+reqId);

	String query="UPDATE \"I1291\".requests SET request_status = ? FROM \"I1291\".books WHERE \"I1291\".requests.isbn = \"I1291\".books.isbn AND \"I1291\".requests.request_id ="+reqId;
	String query2="UPDATE \"I1291\".books SET status = ? FROM \"I1291\".requests WHERE \"I1291\".requests.isbn = \"I1291\".books.isbn AND \"I1291\".requests.request_id="+reqId;
	System.out.println("Query Received1 : "+query);
	Connection con=DriverManager.getConnection(url,name,password);
	System.out.println("Connection String : "+con);
	PreparedStatement pts=con.prepareStatement(query);
	pts.setString(1,"Book Returned");

	System.out.println("Printing Preparedstatement object1"+pts);
	int op=pts.executeUpdate();
	System.out.println(op);


	PreparedStatement pts2=con.prepareStatement(query2);
	pts2.setString(1,"Available");

	System.out.println("Printing Preparedstatement object2"+pts2);
	int op2=pts2.executeUpdate();
	System.out.println(op2);





	}
	catch(Exception ex)
	{
		ex.getStackTrace();
	}
}

public ArrayList<Requests>AllRequestsHistory()
{
	
	System.out.println("Inside find all request");
	ArrayList<Requests> RqAl=new ArrayList<>();
	Requests requestObj=new Requests();
	try {
		Class.forName("org.postgresql.Driver");
Connection con=DriverManager.getConnection(url,name,password);
String query="select * from \"I1291\".requests";
	PreparedStatement pts=con.prepareStatement(query);
	ResultSet rst=pts.executeQuery();

	while(rst.next())
	{
		Requests allRequestObj=new Requests();
		allRequestObj.requestId=rst.getInt(1);
		allRequestObj.requestDate=rst.getString(2);
		allRequestObj.bookName=rst.getString(3);
		allRequestObj.studentName=rst.getString(4);
		allRequestObj.bookStatus=rst.getString(5);
RqAl.add(allRequestObj);
	}
	return RqAl;
	}
	catch(Exception ex)
	{

	return RqAl;
	}



}


}
