package com.StudentMaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImp implements StudentDao{
		String url="jdbc:postgresql://10.1.1.53:5432/TRAINING";
	String name="postgres";
	String password="MOb1cule!";
		@Override
public int insertUser(int id,String uname,String cno,String Adrs,String email,String pass)
	{
		try {
				Class.forName("org.postgresql.Driver");

			Connection con=DriverManager.getConnection(url,name,password);
			String query="insert into \"I1291\".students values(?,?,?,?,?,?)";
		String Query2="insert into \"I1291\".users values(?,?)";
			PreparedStatement pts=con.prepareStatement(query);
				pts.setInt(1, id);
				pts.setString(2, uname);
				pts.setString(3, cno);
				pts.setString(4, Adrs);
				pts.setString(5, email);
				pts.setString(6, pass);
			boolean qr=pts.execute();
		
			System.out.println(qr);
			
			PreparedStatement pts2=con.prepareStatement(Query2);
			pts2.setString(1, email);
			pts2.setString(2,"student");
			pts2.executeQuery();
			con.close();		
return 1;

}
		
catch(SQLException e)
		{
	if(e.getSQLState().equals("23505"))
	{
		System.out.println("Value Alreday Exsist Addition Not PerFormed");
		e.printStackTrace();
		return -1;//email id already exist
	}
	
	return 0;
		}
catch(Exception ex)
{
	ex.printStackTrace();
return 0;
}
	}
@Override
public ArrayList findUser(int id)
{
	int id1=id;
	try
	{
		Class.forName("org.postgresql.Driver");
	 String query="select * from \"I1291\".students where StId="+id1;
	Connection cn=DriverManager.getConnection(url,name,password);
	PreparedStatement pts=cn.prepareStatement(query);
	ResultSet rs=pts.executeQuery();
	Student StudentObj=new Student();
	ArrayList<Student> StudentAl=new ArrayList<>();
	while(rs.next())
	{
		StudentObj.setId(rs.getInt(1));
		StudentObj.setStudentName(rs.getString(2));
		StudentObj.setPhoneNo(rs.getString(3));
		StudentObj.setAddress(rs.getString(4));
		StudentObj.setEmail(rs.getString(5));
		StudentObj.setPass(rs.getString(6));
		StudentAl.add(StudentObj);
	}
	return StudentAl;
	}
	catch(Exception ex)
	{
		ex.getStackTrace();

	}
	return null;


}


@Override
public int updateUser(int id, String uname, String cno, String Adrs, String email, String pass) {
    ArrayList<Student> StAl = findUser(id);
System.out.println("Inside Update");
    if (!StAl.isEmpty()) {
        try {
        	Class.forName("org.postgresql.Driver");
            String query = "update \"I1291\".students set StNm=?, StCno=?, StAd=?, StEml=?, StPas=? where StId=?";
            Connection con = DriverManager.getConnection(url, name, password);
            PreparedStatement pts = con.prepareStatement(query);
            pts.setString(1, uname);
            pts.setString(2, cno);
            pts.setString(3, Adrs);
            pts.setString(4, email);
            pts.setString(5, pass);
            pts.setInt(6, id);
            int i = pts.executeUpdate();
            con.close();
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    } else {
        return -1; // No record found
    }
}
@Override
public void DeleteUser(int id) {
    try {
    	Class.forName("org.postgresql.Driver");
        String query = "delete from \"I1291\".students where StId=?";
        Connection con = DriverManager.getConnection(url, name, password);
        PreparedStatement pts = con.prepareStatement(query);
        pts.setInt(1, id);
        pts.executeUpdate();
        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
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

public ArrayList showAllUsers()
{
	
	try
	{
		Class.forName("org.postgresql.Driver");
	 String query="select * from \"I1291\".students where deleted='false'";
	
	Connection cn=DriverManager.getConnection(url,name,password);
	PreparedStatement pts=cn.prepareStatement(query);
	ResultSet rs=pts.executeQuery();
	ArrayList<Student> StudentAl=new ArrayList<>();
	while(rs.next())
	{
		Student StudentObj=new Student();
		StudentObj.setId(rs.getInt(1));
		StudentObj.setStudentName(rs.getString(2));
		StudentObj.setPhoneNo(rs.getString(3));
		StudentObj.setAddress(rs.getString(4));
		StudentObj.setEmail(rs.getString(5));
		StudentObj.setPass(rs.getString(6));
		StudentAl.add(StudentObj);
	}
	return StudentAl;
	}
	catch(Exception ex)
	{
		ex.getStackTrace();
		return null;
	}
	
}


public int DeleteStudent(int id) {
    ArrayList<Student> StAl = findUser(id);
System.out.println("Inside Update");
    if (!StAl.isEmpty()) {
        try {
        	
        	
        	Class.forName("org.postgresql.Driver");
            
    //////////
        	
        	
        	//String query3="select COUNT(request_id) from REQUESTS where request_status ='Book Returned' and where request_status ='Request Rejected' and student_id ='2'";
        	
        	
        	
        	
        	
        	
        	
        	
        	////////
        	
        	String query = "update \"I1291\".students set deleted='true' where StId=?";
            String query2="update \"I1291\".users set deleted='true' where user_email= (select steml from \"I1291\".students where stid =?)";
            System.out.println("users query "+query2);
            Connection con = DriverManager.getConnection(url, name, password);
            PreparedStatement pts = con.prepareStatement(query);
            PreparedStatement pts2=con.prepareStatement(query2);
            pts.setInt(1, id);
           pts2.setInt(1, id);
           System.out.println("Prepared Statement 2 : "+pts2);
            int i = pts.executeUpdate();
            int u=pts2.executeUpdate();
            con.close();
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    } else {
        return -1; // No record found
    }
}
public ArrayList DeletedUser()
{
	

	try
	{
		Class.forName("org.postgresql.Driver");
	 String query="select * from \"I1291\".students where deleted='true'";
	Connection cn=DriverManager.getConnection(url,name,password);
	PreparedStatement pts=cn.prepareStatement(query);
	ResultSet rs=pts.executeQuery();
	
	ArrayList<Student> StudentAl=new ArrayList<>();
	while(rs.next())
	{
		Student StudentObj=new Student();
		StudentObj.setId(rs.getInt(1));
		StudentObj.setStudentName(rs.getString(2));
		StudentObj.setPhoneNo(rs.getString(3));
		StudentObj.setAddress(rs.getString(4));
		StudentObj.setEmail(rs.getString(5));
		StudentObj.setPass(rs.getString(6));
		StudentAl.add(StudentObj);
	}
	return StudentAl;
	}
	catch(Exception ex)
	{
		ex.getStackTrace();
		return null;
	}
	




}



}