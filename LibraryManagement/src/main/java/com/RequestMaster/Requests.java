package com.RequestMaster;

public class Requests {
int requestId;
int studentId;
String studentName;
String bookName;
String bookStatus;
String requestStatus;
String requestDate;
String remark;
String bookReturnDate;
@Override
public String toString() {
	return "Requests [requestId=" + requestId + ", studentId=" + studentId + ", studentName=" + studentName
			+ ", bookName=" + bookName + ", bookStatus=" + bookStatus + ", requestStatus=" + requestStatus
			+ ", requestDate=" + requestDate + ", remark=" + remark + ", bookReturnDate=" + bookReturnDate + "]";
}

public int getRequestId() {
	return requestId;
}
public void setRequestId(int requestId) {
	this.requestId = requestId;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getBookStatus() {
	return bookStatus;
}
public void setBookStatus(String bookStatus) {
	this.bookStatus = bookStatus;
}
public String getRequestStatus() {
	return requestStatus;
}
public void setRequestStatus(String requestStatus) {
	this.requestStatus = requestStatus;
}
public String getRequestDate() {
	return requestDate;
}
public void setRequestDate(String requestDate) {
	this.requestDate = requestDate;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public String getBookReturnDate() {
	return bookReturnDate;
}
public void setBookReturnDate(String bookReturnDate) {
	this.bookReturnDate = bookReturnDate;
}

}
