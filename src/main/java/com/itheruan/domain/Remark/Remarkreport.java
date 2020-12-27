package com.itheruan.domain.Remark;
import java.io.Serializable;
import java.util.Date;


   /**
    * @文件名称：Remarkreport.java
    * @创建时间：2020-12-22 15:21:01
    * @创  建  人： 
    * @文件描述：remarkreport 实体类
    * @文件版本：V0.01 
    */ 



public class Remarkreport implements Serializable {
	private Integer remarkreportId;
	private String remarkreportText;
	private Date remarkreportTime;
	private String remarkreportUserId;
	private String remarkreportRemarkId;
	public Integer getRemarkreportId() {
		return remarkreportId;
	}
	public void setRemarkreportId(Integer remarkreportId) {
		this.remarkreportId = remarkreportId;
	}
	public String getRemarkreportText() {
		return remarkreportText;
	}
	public void setRemarkreportText(String remarkreportText) {
		this.remarkreportText = remarkreportText;
	}
	public Date getRemarkreportTime() {
		return remarkreportTime;
	}
	public void setRemarkreportTime(Date remarkreportTime) {
		this.remarkreportTime = remarkreportTime;
	}
	public String getRemarkreportUserId() {
		return remarkreportUserId;
	}
	public void setRemarkreportUserId(String remarkreportUserId) {
		this.remarkreportUserId = remarkreportUserId;
	}
	public String getRemarkreportRemarkId() {
		return remarkreportRemarkId;
	}
	public void setRemarkreportRemarkId(String remarkreportRemarkId) {
		this.remarkreportRemarkId = remarkreportRemarkId;
	}
	@Override
	public String toString() {
		return "Remarkreport [remarkreportId=" + remarkreportId + ", remarkreportText=" + remarkreportText
				+ ", remarkreportTime=" + remarkreportTime + ", remarkreportUserId=" + remarkreportUserId
				+ ", remarkreportRemarkId=" + remarkreportRemarkId + "]";
	}
	
	
	
}

