package com.itheruan.domain.travel;
import java.io.Serializable;
import java.sql.*;


public class Travelsceniccollect  implements Serializable{
	private Integer travelsceniccollectId;
	private Date travelsceniccollectTime;
	private String travelsceniccollectUserId;
	private String travelsceniccollectTsId;
	public Integer getTravelsceniccollectId() {
		return travelsceniccollectId;
	}
	public void setTravelsceniccollectId(Integer travelsceniccollectId) {
		this.travelsceniccollectId = travelsceniccollectId;
	}
	public Date getTravelsceniccollectTime() {
		return travelsceniccollectTime;
	}
	public void setTravelsceniccollectTime(Date travelsceniccollectTime) {
		this.travelsceniccollectTime = travelsceniccollectTime;
	}
	public String getTravelsceniccollectUserId() {
		return travelsceniccollectUserId;
	}
	public void setTravelsceniccollectUserId(String travelsceniccollectUserId) {
		this.travelsceniccollectUserId = travelsceniccollectUserId;
	}
	public String getTravelsceniccollectTsId() {
		return travelsceniccollectTsId;
	}
	public void setTravelsceniccollectTsId(String travelsceniccollectTsId) {
		this.travelsceniccollectTsId = travelsceniccollectTsId;
	}
	@Override
	public String toString() {
		return "Travelsceniccollect [travelsceniccollectId=" + travelsceniccollectId + ", travelsceniccollectTime="
				+ travelsceniccollectTime + ", travelsceniccollectUserId=" + travelsceniccollectUserId
				+ ", travelsceniccollectTsId=" + travelsceniccollectTsId + "]";
	}
	
	
	
}

