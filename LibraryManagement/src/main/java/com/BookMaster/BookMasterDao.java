package com.BookMaster;

import java.util.ArrayList;

public interface BookMasterDao {
	public int insertBook(int isbn,String bkname,String author,String description,String genre);
	public ArrayList findBook(int isbn);
	public int updateBook(int isbn,String bkname,String author,String description,String genre);
	public void DeleteBook(int isbn);
	public ArrayList<LibBook>findAllBook();
	public int fetchMax();
	public void DelBook(int isbn);
	public ArrayList<LibBook>DeletedBooks();
}
