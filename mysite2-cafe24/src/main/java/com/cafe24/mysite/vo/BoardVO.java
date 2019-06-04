package com.cafe24.mysite.vo;

public class BoardVO {
	private Long no;
	private String title;
	private String writer;
	private String content;
	private Integer count;
	private String regDate;
	
	private Long writerNo;
	private Long groupNo;
	private Long orderNo;
	private Long dept;
	private Long del;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(Long writerNo) {
		this.writerNo = writerNo;
	}
	public Long getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getDept() {
		return dept;
	}
	public void setDept(Long dept) {
		this.dept = dept;
	}
	public Long getDel() {
		return del;
	}
	public void setDel(Long del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", count="
				+ count + ", regDate=" + regDate + ", writerNo=" + writerNo + ", groupNo=" + groupNo + ", orderNo="
				+ orderNo + ", dept=" + dept + ", del=" + del + "]";
	}
	
}
