package com.itheruan.domain.Remark;


import java.io.Serializable;

/**
    * @文件名称：Remarkimage.java
    * @创建时间：2020-12-22 15:20:41
    * @创  建  人： 
    * @文件描述：remarkimage 实体类
    * @文件版本：V0.01 
    */ 



public class Remarkimage implements Serializable {
	private Integer remarkimageId;
	private String remarkimageName;
	private String remarkimageUserId;
	private String remarkimageRemarkId;
	public Integer getRemarkimageId() {
		return remarkimageId;
	}
	public void setRemarkimageId(Integer remarkimageId) {
		this.remarkimageId = remarkimageId;
	}
	public String getRemarkimageName() {
		return remarkimageName;
	}
	public void setRemarkimageName(String remarkimageName) {
		this.remarkimageName = remarkimageName;
	}
	public String getRemarkimageUserId() {
		return remarkimageUserId;
	}
	public void setRemarkimageUserId(String remarkimageUserId) {
		this.remarkimageUserId = remarkimageUserId;
	}
	public String getRemarkimageRemarkId() {
		return remarkimageRemarkId;
	}
	public void setRemarkimageRemarkId(String remarkimageRemarkId) {
		this.remarkimageRemarkId = remarkimageRemarkId;
	}
	@Override
	public String toString() {
		return "Remarkimage [remarkimageId=" + remarkimageId + ", remarkimageName=" + remarkimageName
				+ ", remarkimageUserId=" + remarkimageUserId + ", remarkimageRemarkId=" + remarkimageRemarkId + "]";
	}

	
}

