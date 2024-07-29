package com.LibrarianMaster;

import java.util.ArrayList;

public interface LibrarianMasterDao {
public int insertLibrarian(int id,String name,String contact,String joiningDate,String address,String email,String password);
public ArrayList<Librarian> findLibrarian(int id);
public int UpdateLibrarian(int id,String name,String contact,String joiningDate,String address,String email,String password);
public void DeleteLibrarian(int id);
public int DelLibrarian(int id);
public int fetchMax();
public ArrayList<Librarian> DeletedLibrarian();
}
