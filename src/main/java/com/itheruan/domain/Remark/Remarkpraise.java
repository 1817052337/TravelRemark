package com.itheruan.domain.Remark;
import java.io.Serializable;
import java.util.Date;


   /**
    * @文件名称：Remarkpraise.java
    * @创建时间：2020-12-22 15:20:50
    * @创  建  人： 
    * @文件描述：remarkpraise 实体类
    * @文件版本：V0.01 
    */ 


public class Remarkpraise implements Serializable {
	private Integer remarkpraiseId;
	private Date remarkpraiseTime;
	private String remarkpraiseUserId;
	private String remarkpraiseRemarkId;
	public Integer getRemarkpraiseId() {
		return remarkpraiseId;
	}
	public void setRemarkpraiseId(Integer remarkpraiseId) {
		this.remarkpraiseId = remarkpraiseId;
	}
	public Date getRemarkpraiseTime() {
		return remarkpraiseTime;
	}
	public void setRemarkpraiseTime(Date remarkpraiseTime) {
		this.remarkpraiseTime = remarkpraiseTime;
	}
	public String getRemarkpraiseUserId() {
		return remarkpraiseUserId;
	}
	public void setRemarkpraiseUserId(String remarkpraiseUserId) {
		this.remarkpraiseUserId = remarkpraiseUserId;
	}
	public String getRemarkpraiseRemarkId() {
		return remarkpraiseRemarkId;
	}
	public void setRemarkpraiseRemarkId(String remarkpraiseRemarkId) {
		this.remarkpraiseRemarkId = remarkpraiseRemarkId;
	}
	@Override
	public String toString() {
		return "Remarkpraise [remarkpraiseId=" + remarkpraiseId + ", remarkpraiseTime=" + remarkpraiseTime
				+ ", remarkpraiseUserId=" + remarkpraiseUserId + ", remarkpraiseRemarkId=" + remarkpraiseRemarkId + "]";
	}
	
	
	
}

