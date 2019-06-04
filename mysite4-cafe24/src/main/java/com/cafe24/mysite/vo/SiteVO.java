package com.cafe24.mysite.vo;

import org.springframework.web.multipart.MultipartFile;

public class SiteVO {
	private Long no;
	private String title;
	private String welcom_mes;
	private String profile;
	private String description;
	
	private MultipartFile multipartFile;

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

	public String getWelcom_mes() {
		return welcom_mes;
	}

	public void setWelcom_mes(String welcom_mes) {
		this.welcom_mes = welcom_mes;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	@Override
	public String toString() {
		return "SiteVO [no=" + no + ", title=" + title + ", welcom_mes=" + welcom_mes + ", profile=" + profile
				+ ", description=" + description + ", multipartFile=" + multipartFile + "]";
	}
	
	
	
}
