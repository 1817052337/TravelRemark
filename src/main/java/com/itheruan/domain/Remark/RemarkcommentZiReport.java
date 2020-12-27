package com.itheruan.domain.Remark;
import java.io.Serializable;
import java.util.Date;


public class RemarkcommentZiReport implements Serializable {
	private Integer remarkcommentZiReportId;
	private String remarkcommentZiReportText;
	private Date remarkcommentZiReportTime;
	private String remarkcommentZiReportUserId;
	private Integer remarkcommentZiReportRcId;
	public Integer getRemarkcommentZiReportId() {
		return remarkcommentZiReportId;
	}
	public void setRemarkcommentZiReportId(Integer remarkcommentZiReportId) {
		this.remarkcommentZiReportId = remarkcommentZiReportId;
	}
	public String getRemarkcommentZiReportText() {
		return remarkcommentZiReportText;
	}
	public void setRemarkcommentZiReportText(String remarkcommentZiReportText) {
		this.remarkcommentZiReportText = remarkcommentZiReportText;
	}
	public Date getRemarkcommentZiReportTime() {
		return remarkcommentZiReportTime;
	}
	public void setRemarkcommentZiReportTime(Date remarkcommentZiReportTime) {
		this.remarkcommentZiReportTime = remarkcommentZiReportTime;
	}
	public String getRemarkcommentZiReportUserId() {
		return remarkcommentZiReportUserId;
	}
	public void setRemarkcommentZiReportUserId(String remarkcommentZiReportUserId) {
		this.remarkcommentZiReportUserId = remarkcommentZiReportUserId;
	}
	public Integer getRemarkcommentZiReportRcId() {
		return remarkcommentZiReportRcId;
	}
	public void setRemarkcommentZiReportRcId(Integer remarkcommentZiReportRcId) {
		this.remarkcommentZiReportRcId = remarkcommentZiReportRcId;
	}
	@Override
	public String toString() {
		return "RemarkcommentZiReport [remarkcommentZiReportId=" + remarkcommentZiReportId
				+ ", remarkcommentZiReportText=" + remarkcommentZiReportText + ", remarkcommentZiReportTime="
				+ remarkcommentZiReportTime + ", remarkcommentZiReportUserId=" + remarkcommentZiReportUserId
				+ ", remarkcommentZiReportRcId=" + remarkcommentZiReportRcId + "]";
	}
	
	
}

