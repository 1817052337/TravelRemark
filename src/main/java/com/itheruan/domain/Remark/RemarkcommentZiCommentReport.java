package com.itheruan.domain.Remark;
import java.io.Serializable;
import java.util.Date;


public class RemarkcommentZiCommentReport implements Serializable {
	private Integer rcZiCReportId;
	private String rcZiCReportText;
	private Date rcZiCReportTime;
	private String rcZiCReportUserId;
	private Integer rcZiCReportCId;
	public Integer getRcZiCReportId() {
		return rcZiCReportId;
	}
	public void setRcZiCReportId(Integer rcZiCReportId) {
		this.rcZiCReportId = rcZiCReportId;
	}
	public String getRcZiCReportText() {
		return rcZiCReportText;
	}
	public void setRcZiCReportText(String rcZiCReportText) {
		this.rcZiCReportText = rcZiCReportText;
	}
	public Date getRcZiCReportTime() {
		return rcZiCReportTime;
	}
	public void setRcZiCReportTime(Date rcZiCReportTime) {
		this.rcZiCReportTime = rcZiCReportTime;
	}
	public String getRcZiCReportUserId() {
		return rcZiCReportUserId;
	}
	public void setRcZiCReportUserId(String rcZiCReportUserId) {
		this.rcZiCReportUserId = rcZiCReportUserId;
	}
	public Integer getRcZiCReportCId() {
		return rcZiCReportCId;
	}
	public void setRcZiCReportCId(Integer rcZiCReportCId) {
		this.rcZiCReportCId = rcZiCReportCId;
	}
	@Override
	public String toString() {
		return "RemarkcommentZiCommentReport [rcZiCReportId=" + rcZiCReportId + ", rcZiCReportText=" + rcZiCReportText
				+ ", rcZiCReportTime=" + rcZiCReportTime + ", rcZiCReportUserId=" + rcZiCReportUserId
				+ ", rcZiCReportCId=" + rcZiCReportCId + "]";
	}
	
	
}

