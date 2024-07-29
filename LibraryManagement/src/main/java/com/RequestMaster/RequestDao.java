package com.RequestMaster;

import java.util.ArrayList;
public interface RequestDao {
	public int createRequest(int reqId,int studentId,String rqStatus,String rqDate,String rqRemark,String bookReturnDate);
	public ArrayList<Requests>AllRequestsHistory();
	public ArrayList<Requests> findRequest(int requestId);
	public int updateRequest(int reqId,int studentId,String rqStatus,String rqDate,String rqRemark,String bookReturnDate);
	public void deleteRequest(int reqId);
	public int getMaxId();
public void accept(int reqId);
public void deny(int reqId);
public void acceptBookReturn(int reqId);
}
