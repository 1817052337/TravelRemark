package com.itheruan.domain.Remark;
import java.io.Serializable;
import java.util.Date;


/**
    * @文件名称：Remarkcollect.java
    * @创建时间：2020-12-22 15:20:16
    * @创  建  人： 
    * @文件描述：remarkcollect 实体类
    * @文件版本：V0.01 
    */ 

public class Remarkcollect implements Serializable{
	private Integer remarkcollectId;
	private Date remarkcollectTime;
	private String remarkcollectUserId;
	private String remarkcollectRemarkId;
	public Integer getRemarkcollectId() {
		return remarkcollectId;
	}
	public void setRemarkcollectId(Integer remarkcollectId) {
		this.remarkcollectId = remarkcollectId;
	}
	public Date getRemarkcollectTime() {
		return remarkcollectTime;
	}
	public void setRemarkcollectTime(Date remarkcollectTime) {
		this.remarkcollectTime = remarkcollectTime;
	}
	public String getRemarkcollectUserId() {
		return remarkcollectUserId;
	}
	public void setRemarkcollectUserId(String remarkcollectUserId) {
		this.remarkcollectUserId = remarkcollectUserId;
	}
	public String getRemarkcollectRemarkId() {
		return remarkcollectRemarkId;
	}
	public void setRemarkcollectRemarkId(String remarkcollectRemarkId) {
		this.remarkcollectRemarkId = remarkcollectRemarkId;
	}
	@Override
	public String toString() {
		return "Remarkcollect [remarkcollectId=" + remarkcollectId + ", remarkcollectTime=" + remarkcollectTime
				+ ", remarkcollectUserId=" + remarkcollectUserId + ", remarkcollectRemarkId=" + remarkcollectRemarkId
				+ ", getRemarkcollectId()=" + getRemarkcollectId() + ", getRemarkcollectTime()="
				+ getRemarkcollectTime() + ", getRemarkcollectUserId()=" + getRemarkcollectUserId()
				+ ", getRemarkcollectRemarkId()=" + getRemarkcollectRemarkId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}

