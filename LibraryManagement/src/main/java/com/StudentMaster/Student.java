package com.StudentMaster;

public class Student {
		int id;
	String studentName;
	String phoneNo;
	String address;
	String email;
	String pass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", phoneNo=" + phoneNo + ", address=" + address
				+ ", email=" + email + ", pass=" + pass + "]";
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


}
