 package com.spring.vo;

public class MemberVO {
	
	private String uid;
	private String pwd;
	private String username;
	private String email;
	private String regdate;
	private String updateDate;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "MemerVO [uid=" + uid + ", pwd=" + pwd + ", username=" + username + ", email=" + email + ", regdate="
				+ regdate + ", updateDate=" + updateDate + "]";
	}
	
	
}
