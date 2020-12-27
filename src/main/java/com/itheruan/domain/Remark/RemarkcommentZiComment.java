package com.itheruan.domain.Remark;
import java.io.Serializable;
import java.util.Date;


public class RemarkcommentZiComment implements Serializable {
	private Integer remarkcommentZiCommentId;
	private String remarkcommentZiCommentText;
	private Date remarkcommentZiCommentTime;
	private String remarkcommentZiCommentUserId;
	private Integer remarkcommentZiCommentRcId;
	public Integer getRemarkcommentZiCommentId() {
		return remarkcommentZiCommentId;
	}
	public void setRemarkcommentZiCommentId(Integer remarkcommentZiCommentId) {
		this.remarkcommentZiCommentId = remarkcommentZiCommentId;
	}
	public String getRemarkcommentZiCommentText() {
		return remarkcommentZiCommentText;
	}
	public void setRemarkcommentZiCommentText(String remarkcommentZiCommentText) {
		this.remarkcommentZiCommentText = remarkcommentZiCommentText;
	}
	public Date getRemarkcommentZiCommentTime() {
		return remarkcommentZiCommentTime;
	}
	public void setRemarkcommentZiCommentTime(Date remarkcommentZiCommentTime) {
		this.remarkcommentZiCommentTime = remarkcommentZiCommentTime;
	}
	public String getRemarkcommentZiCommentUserId() {
		return remarkcommentZiCommentUserId;
	}
	public void setRemarkcommentZiCommentUserId(String remarkcommentZiCommentUserId) {
		this.remarkcommentZiCommentUserId = remarkcommentZiCommentUserId;
	}
	public Integer getRemarkcommentZiCommentRcId() {
		return remarkcommentZiCommentRcId;
	}
	public void setRemarkcommentZiCommentRcId(Integer remarkcommentZiCommentRcId) {
		this.remarkcommentZiCommentRcId = remarkcommentZiCommentRcId;
	}
	@Override
	public String toString() {
		return "RemarkcommentZiComment [remarkcommentZiCommentId=" + remarkcommentZiCommentId
				+ ", remarkcommentZiCommentText=" + remarkcommentZiCommentText + ", remarkcommentZiCommentTime="
				+ remarkcommentZiCommentTime + ", remarkcommentZiCommentUserId=" + remarkcommentZiCommentUserId
				+ ", remarkcommentZiCommentRcId=" + remarkcommentZiCommentRcId + "]";
	}
	
	
}

