package com.itheruan.domain.Remark;
import com.itheruan.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


/**
 * 点评评论实体类
 * @author 11137
 *
 */
public class Remarkcomment implements Serializable {
	private Integer remarkcommentId;
	private String remarkcommentText;
	private Date remarkcommentTime;
	private String remarkcommentTimeStr;
	private String remarkcommentUserId;
	private String remarkcommentRemarkId;
	private Map<String,Object> userMap;//用户



	public Integer getRemarkcommentId() {
		return remarkcommentId;
	}

	public void setRemarkcommentId(Integer remarkcommentId) {
		this.remarkcommentId = remarkcommentId;
	}

	public String getRemarkcommentText() {
		return remarkcommentText;
	}

	public void setRemarkcommentText(String remarkcommentText) {
		this.remarkcommentText = remarkcommentText;
	}

	public Date getRemarkcommentTime() {
		return remarkcommentTime;
	}

	public void setRemarkcommentTime(Date remarkcommentTime) {
		this.remarkcommentTime = remarkcommentTime;
	}

	public String getRemarkcommentTimeStr() {
		if(remarkcommentTime!=null) {
			remarkcommentTimeStr = DateUtils.date2String(remarkcommentTime, "yyyy-MM-dd HH:mm:ss");
		}
		return remarkcommentTimeStr;
	}

	public void setRemarkcommentTimeStr(String remarkcommentTimeStr) {

		this.remarkcommentTimeStr = remarkcommentTimeStr;
	}

	public String getRemarkcommentUserId() {
		return remarkcommentUserId;
	}

	public void setRemarkcommentUserId(String remarkcommentUserId) {
		this.remarkcommentUserId = remarkcommentUserId;
	}

	public String getRemarkcommentRemarkId() {
		return remarkcommentRemarkId;
	}

	public void setRemarkcommentRemarkId(String remarkcommentRemarkId) {

		this.remarkcommentRemarkId = remarkcommentRemarkId;
	}

	public Map<String, Object> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, Object> userMap) {
		this.userMap = userMap;
	}

	@Override
	public String toString() {
		return "Remarkcomment{" +
				"remarkcommentId=" + remarkcommentId +
				", remarkcommentText='" + remarkcommentText + '\'' +
				", remarkcommentTime=" + remarkcommentTime +
				", remarkcommentTimeStr='" + remarkcommentTimeStr + '\'' +
				", remarkcommentUserId='" + remarkcommentUserId + '\'' +
				", remarkcommentRemarkId='" + remarkcommentRemarkId + '\'' +
				", userMap=" + userMap +
				'}';
	}
}

