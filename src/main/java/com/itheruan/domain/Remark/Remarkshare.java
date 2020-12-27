package com.itheruan.domain.Remark;
import java.io.Serializable;
import java.util.Date;


   /**
    * @文件名称：Remarkshare.java
    * @创建时间：2020-12-22 15:20:07
    * @创  建  人： 
    * @文件描述：remarkshare 实体类
    * @文件版本：V0.01 
    */ 



public class Remarkshare implements Serializable {
	private Integer remarkshareId;
	private Date remarkshareTime;
	private String remarkshareUserId;
	private String remarkshareRemarkId;
	public Integer getRemarkshareId() {
		return remarkshareId;
	}
	public void setRemarkshareId(Integer remarkshareId) {
		this.remarkshareId = remarkshareId;
	}
	public Date getRemarkshareTime() {
		return remarkshareTime;
	}
	public void setRemarkshareTime(Date remarkshareTime) {
		this.remarkshareTime = remarkshareTime;
	}
	public String getRemarkshareUserId() {
		return remarkshareUserId;
	}
	public void setRemarkshareUserId(String remarkshareUserId) {
		this.remarkshareUserId = remarkshareUserId;
	}
	public String getRemarkshareRemarkId() {
		return remarkshareRemarkId;
	}
	public void setRemarkshareRemarkId(String remarkshareRemarkId) {
		this.remarkshareRemarkId = remarkshareRemarkId;
	}
	@Override
	public String toString() {
		return "Remarkshare [remarkshareId=" + remarkshareId + ", remarkshareTime=" + remarkshareTime
				+ ", remarkshareUserId=" + remarkshareUserId + ", remarkshareRemarkId=" + remarkshareRemarkId + "]";
	}
	
	
	
}

