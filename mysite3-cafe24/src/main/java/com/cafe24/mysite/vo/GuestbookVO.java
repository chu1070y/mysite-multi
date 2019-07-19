package com.cafe24.mysite.vo;

public class GuestbookVO {
	private Long no;
	private String name;
	private String password;
	private String content;
	private String regDate;

	public GuestbookVO(Long no, String name, String password, String content, String regDate) {
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.regDate = regDate;
	}
	
	public GuestbookVO() {
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContents() {
		return content;
	}
	public void setContents(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "GuestbookVO [no=" + no + ", name=" + name + ", password=" + password + ", contents=" + content
				+ ", regDate=" + regDate + "]";
	}

	public Object getNo2() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
