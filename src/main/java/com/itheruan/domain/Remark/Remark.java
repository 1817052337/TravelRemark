package com.itheruan.domain.Remark;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.itheruan.utils.DateUtils;
import com.itheruan.utils.Dates;

/**
 * 点评实体类
 */
public class Remark implements Serializable{
	private String remarkId;
	private String remarkText;
	private String remarkTitle;
	private String remarkEnvironmentgrade;
	private String remarkServegrade;
	private String remarkAllgrade;
	private Date remarkTime;
	private String remarkTimeStr;
	private Integer remarkNum;
	private String remarkTravelModule;
	private String remarkTravelLabel;
	private String remarkUserId;
	private Integer remarkAreaId;
	private String remarkImage;
	private boolean flagCollect;//景点是否被该用户收藏
	private boolean flagPraise;//景点是否被该用户点赞
	private boolean flagReport;//景点是否被该用户举报
	private Map<String,Object> userMap;//用户


	public String getRemarkId() {
		return remarkId;
	}



	public void setRemarkId(String remarkId) {
		this.remarkId = remarkId;
	}



	public String getRemarkText() {
		return remarkText;
	}



	public void setRemarkText(String remarkText) {
		this.remarkText = remarkText;
	}



	public String getRemarkTitle() {
		return remarkTitle;
	}



	public void setRemarkTitle(String remarkTitle) {
		this.remarkTitle = remarkTitle;
	}



	public String getRemarkEnvironmentgrade() {
		return remarkEnvironmentgrade;
	}



	public void setRemarkEnvironmentgrade(String remarkEnvironmentgrade) {
		this.remarkEnvironmentgrade = remarkEnvironmentgrade;
	}



	public String getRemarkServegrade() {
		return remarkServegrade;
	}



	public void setRemarkServegrade(String remarkServegrade) {
		this.remarkServegrade = remarkServegrade;
	}



	public String getRemarkAllgrade() {
		return remarkAllgrade;
	}



	public void setRemarkAllgrade(String remarkAllgrade) {
		this.remarkAllgrade = remarkAllgrade;
	}



	public Date getRemarkTime() {
		return remarkTime;
	}



	public void setRemarkTime(Date remarkTime) {
		this.remarkTime = remarkTime;
	}



	public Integer getRemarkNum() {
		return remarkNum;
	}



	public void setRemarkNum(Integer remarkNum) {
		this.remarkNum = remarkNum;
	}



	public String getRemarkTravelModule() {
		return remarkTravelModule;
	}



	public void setRemarkTravelModule(String remarkTravelModule) {
		this.remarkTravelModule = remarkTravelModule;
	}



	public String getRemarkTravelLabel() {
		return remarkTravelLabel;
	}



	public void setRemarkTravelLabel(String remarkTravelLabel) {
		this.remarkTravelLabel = remarkTravelLabel;
	}



	public String getRemarkUserId() {
		return remarkUserId;
	}



	public void setRemarkUserId(String remarkUserId) {
		this.remarkUserId = remarkUserId;
	}



	public Integer getRemarkAreaId() {
		return remarkAreaId;
	}



	public void setRemarkAreaId(Integer remarkAreaId) {
		this.remarkAreaId = remarkAreaId;
	}
	

	public String getRemarkImage() {
		return remarkImage;
	}




	public void setRemarkImage(String remarkImage) {
		this.remarkImage = remarkImage;
	}
	public String getRemarkTimeStr() {
		 if(remarkTime!=null) {
			 remarkTimeStr = DateUtils.date2String(remarkTime, "yyyy-MM-dd HH:mm:ss");
		 }
		return remarkTimeStr;
	}

	public void setRemarkTimeStr(String remarkTimeStr) {
		this.remarkTimeStr = remarkTimeStr;
	}

	public boolean isFlagCollect() {
		return flagCollect;
	}

	public void setFlagCollect(boolean flagCollect) {
		this.flagCollect = flagCollect;
	}

	public boolean isFlagPraise() {
		return flagPraise;
	}

	public void setFlagPraise(boolean flagPraise) {
		this.flagPraise = flagPraise;
	}

	public boolean isFlagReport() {
		return flagReport;
	}

	public void setFlagReport(boolean flagReport) {
		this.flagReport = flagReport;
	}


	public Map<String, Object> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, Object> userMap) {
		this.userMap = userMap;
	}

	@Override
	public String toString() {
		return "Remark{" +
				"remarkId='" + remarkId + '\'' +
				", remarkText='" + remarkText + '\'' +
				", remarkTitle='" + remarkTitle + '\'' +
				", remarkEnvironmentgrade='" + remarkEnvironmentgrade + '\'' +
				", remarkServegrade='" + remarkServegrade + '\'' +
				", remarkAllgrade='" + remarkAllgrade + '\'' +
				", remarkTime=" + remarkTime +
				", remarkTimeStr='" + remarkTimeStr + '\'' +
				", remarkNum=" + remarkNum +
				", remarkTravelModule='" + remarkTravelModule + '\'' +
				", remarkTravelLabel='" + remarkTravelLabel + '\'' +
				", remarkUserId='" + remarkUserId + '\'' +
				", remarkAreaId=" + remarkAreaId +
				", remarkImage='" + remarkImage + '\'' +
				", flagCollect=" + flagCollect +
				", flagPraise=" + flagPraise +
				", flagReport=" + flagReport +
				", userMap=" + userMap +
				'}';
	}

}

