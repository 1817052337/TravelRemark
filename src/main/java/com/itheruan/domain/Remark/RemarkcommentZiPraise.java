package com.itheruan.domain.Remark;
import java.io.Serializable;
import java.util.Date;


public class RemarkcommentZiPraise implements Serializable {
	private Integer remarkcommentZiPraiseId;
	private Date remarkcommentZiPraiseTime;
	private String remarkcommentZiPraiseUserId;
	private Integer remarkcommentZiPraiseRcId;
	public Integer getRemarkcommentZiPraiseId() {
		return remarkcommentZiPraiseId;
	}
	public void setRemarkcommentZiPraiseId(Integer remarkcommentZiPraiseId) {
		this.remarkcommentZiPraiseId = remarkcommentZiPraiseId;
	}
	public Date getRemarkcommentZiPraiseTime() {
		return remarkcommentZiPraiseTime;
	}
	public void setRemarkcommentZiPraiseTime(Date remarkcommentZiPraiseTime) {
		this.remarkcommentZiPraiseTime = remarkcommentZiPraiseTime;
	}
	public String getRemarkcommentZiPraiseUserId() {
		return remarkcommentZiPraiseUserId;
	}
	public void setRemarkcommentZiPraiseUserId(String remarkcommentZiPraiseUserId) {
		this.remarkcommentZiPraiseUserId = remarkcommentZiPraiseUserId;
	}
	public Integer getRemarkcommentZiPraiseRcId() {
		return remarkcommentZiPraiseRcId;
	}
	public void setRemarkcommentZiPraiseRcId(Integer remarkcommentZiPraiseRcId) {
		this.remarkcommentZiPraiseRcId = remarkcommentZiPraiseRcId;
	}
	@Override
	public String toString() {
		return "RemarkcommentZiPraise [remarkcommentZiPraiseId=" + remarkcommentZiPraiseId
				+ ", remarkcommentZiPraiseTime=" + remarkcommentZiPraiseTime + ", remarkcommentZiPraiseUserId="
				+ remarkcommentZiPraiseUserId + ", remarkcommentZiPraiseRcId=" + remarkcommentZiPraiseRcId + "]";
	}
	
	
}

