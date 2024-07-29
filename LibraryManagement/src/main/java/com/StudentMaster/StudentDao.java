package com.StudentMaster;

import java.util.ArrayList;

public interface StudentDao {
	public int insertUser(int id,String uname,String cno,String Adrs,String email,String pass);
	public ArrayList findUser(int id);
	public int updateUser(int id,String uname,String cno,String Adrs,String email,String pass);
	public void DeleteUser(int id);
	public int fetchMax();
	public ArrayList showAllUsers();
	public ArrayList DeletedUser();

}
