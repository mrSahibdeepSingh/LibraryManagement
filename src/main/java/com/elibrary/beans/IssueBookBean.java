package com.elibrary.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="issued_books")
public class IssueBookBean {
	
	@Id
	private String callno;
	private String studentid,studentname;
	private long studentmobile;
	private Date issuedDate;
	private String returnStatus;

public IssueBookBean() {}
public IssueBookBean(String callno, String studentid, String studentname, long studentmobile) {
	super();
	this.callno = callno;
	this.studentid = studentid;
	this.studentname = studentname;
	this.studentmobile = studentmobile;
}

public String getReturnstatus() {
	return returnStatus;
}
public void setReturnstatus(String returnStatus) {
	this.returnStatus = returnStatus;
}
public Date getIssuedDate() {
	return issuedDate;
}
public void setIssuedDate(Date issuedDate) {
	this.issuedDate = issuedDate;
}
public String getCallno() {
	return callno;
}
public void setCallno(String callno) {
	this.callno = callno;
}
public String getStudentid() {
	return studentid;
}
public void setStudentid(String studentid) {
	this.studentid = studentid;
}
public String getStudentname() {
	return studentname;
}
public void setStudentname(String studentname) {
	this.studentname = studentname;
}
public long getStudentmobile() {
	return studentmobile;
}
public void setStudentmobile(long studentmobile) {
	this.studentmobile = studentmobile;
}

}
