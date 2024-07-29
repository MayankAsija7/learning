package com.BookMaster;

public class LibBook {
	int Isbn;
	String name;
	String author;
	String description;
	String genre;
	String status;
	
	
	
	@Override
	public String toString() {
		return "LibBook [Isbn=" + Isbn + ", name=" + name + ", author=" + author + ", description=" + description
				+ ", genre=" + genre + ", status=" + status + "]";
	}
	
	public int getIsbn() {
		return Isbn;
	}
	public void setIsbn(int isbn) {
		Isbn = isbn;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
