package com.LibrarianMaster;

public class Librarian {
	@Override
	public String toString() {
		return "Librarian [libId=" + libId + ", libName=" + libName + ", libContNum=" + libContNum + ", libJoinDate="
				+ libJoinDate + ", libAddress=" + libAddress + ", libEmail=" + libEmail + ", libPassword=" + libPassword
				+ "]";
	}
	int libId;
	String libName;
	String libContNum;
	String libJoinDate;
	String libAddress;
	String libEmail;
	String libPassword;
	public int getLibId() {
		return libId;
	}
	public void setLibId(int libId) {
		this.libId = libId;
	}
	public String getLibName() {
		return libName;
	}
	public void setLibName(String libName) {
		this.libName = libName;
	}
	public String getLibContNum() {
		return libContNum;
	}
	public void setLibContNum(String libContNum) {
		this.libContNum = libContNum;
	}
	public String getLibJoinDate() {
		return libJoinDate;
	}
	public void setLibJoinDate(String libJoinDate) {
		this.libJoinDate = libJoinDate;
	}
	public String getLibAddress() {
		return libAddress;
	}
	public void setLibAddress(String libAddress) {
		this.libAddress = libAddress;
	}
	public String getLibEmail() {
		return libEmail;
	}
	public void setLibEmail(String libEmail) {
		this.libEmail = libEmail;
	}
	public String getLibPassword() {
		return libPassword;
	}
	public void setLibPassword(String libPassword) {
		this.libPassword = libPassword;
	}


}
