package com.portfolio.mvc.model;

public class User {

	String uname ;
	String uemail;
	String upwd;
	String umobile;
	
	
	public User(String uname, String uemail, String upwd, String umobile) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upwd = upwd;
		this.umobile = umobile;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUmobile() {
		return umobile;
	}
	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}
	
	
}
