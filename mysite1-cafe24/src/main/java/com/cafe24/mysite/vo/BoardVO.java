package com.cafe24.mysite.vo;

public class BoardVO {
	private Long no;
	private String title;
	private String writer;
	private String contents;
	private Integer count;
	private String regDate;
	private Long writerNo;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", contents=" + contents + ", count="
				+ count + ", regDate=" + regDate + ", writerNo=" + writerNo + "]";
	}
	
}
