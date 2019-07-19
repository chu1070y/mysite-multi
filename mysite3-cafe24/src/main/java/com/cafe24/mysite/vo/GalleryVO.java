package com.cafe24.mysite.vo;

import org.springframework.web.multipart.MultipartFile;

public class GalleryVO {

	private Long no;
	private String description;
	private String img;
	
	private MultipartFile multipartFile;

	@Override
	public String toString() {
		return "GalleryVO [no=" + no + ", description=" + description + ", img=" + img + ", multipartFile="
				+ multipartFile + "]";
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	
	
	
}
