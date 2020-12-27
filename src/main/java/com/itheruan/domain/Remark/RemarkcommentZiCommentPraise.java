package com.itheruan.domain.Remark;
import java.io.Serializable;
import java.util.Date;


public class RemarkcommentZiCommentPraise implements Serializable {
	private Integer rcZiCPraiseId;
	private Date rcZiCPraiseTime;
	private String rcZiCPraiseUserId;
	private Integer rcZiPraiseCId;
	public Integer getRcZiCPraiseId() {
		return rcZiCPraiseId;
	}
	public void setRcZiCPraiseId(Integer rcZiCPraiseId) {
		this.rcZiCPraiseId = rcZiCPraiseId;
	}
	public Date getRcZiCPraiseTime() {
		return rcZiCPraiseTime;
	}
	public void setRcZiCPraiseTime(Date rcZiCPraiseTime) {
		this.rcZiCPraiseTime = rcZiCPraiseTime;
	}
	public String getRcZiCPraiseUserId() {
		return rcZiCPraiseUserId;
	}
	public void setRcZiCPraiseUserId(String rcZiCPraiseUserId) {
		this.rcZiCPraiseUserId = rcZiCPraiseUserId;
	}
	public Integer getRcZiPraiseCId() {
		return rcZiPraiseCId;
	}
	public void setRcZiPraiseCId(Integer rcZiPraiseCId) {
		this.rcZiPraiseCId = rcZiPraiseCId;
	}
	@Override
	public String toString() {
		return "RemarkcommentZiCommentPraise [rcZiCPraiseId=" + rcZiCPraiseId + ", rcZiCPraiseTime=" + rcZiCPraiseTime
				+ ", rcZiCPraiseUserId=" + rcZiCPraiseUserId + ", rcZiPraiseCId=" + rcZiPraiseCId + "]";
	}
	
	
}

