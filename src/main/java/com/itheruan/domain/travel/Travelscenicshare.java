package com.itheruan.domain.travel;
import java.io.Serializable;
import java.sql.*;


public class Travelscenicshare implements Serializable{
	private Integer travelscenicshareId;
	private Date travelscenicshareTime;
	private String travelscenicshareUserId;
	private String travelscenicshareTsId;
	public Integer getTravelscenicshareId() {
		return travelscenicshareId;
	}
	public void setTravelscenicshareId(Integer travelscenicshareId) {
		this.travelscenicshareId = travelscenicshareId;
	}
	public Date getTravelscenicshareTime() {
		return travelscenicshareTime;
	}
	public void setTravelscenicshareTime(Date travelscenicshareTime) {
		this.travelscenicshareTime = travelscenicshareTime;
	}
	public String getTravelscenicshareUserId() {
		return travelscenicshareUserId;
	}
	public void setTravelscenicshareUserId(String travelscenicshareUserId) {
		this.travelscenicshareUserId = travelscenicshareUserId;
	}
	public String getTravelscenicshareTsId() {
		return travelscenicshareTsId;
	}
	public void setTravelscenicshareTsId(String travelscenicshareTsId) {
		this.travelscenicshareTsId = travelscenicshareTsId;
	}
	@Override
	public String toString() {
		return "Travelscenicshare [travelscenicshareId=" + travelscenicshareId + ", travelscenicshareTime="
				+ travelscenicshareTime + ", travelscenicshareUserId=" + travelscenicshareUserId
				+ ", travelscenicshareTsId=" + travelscenicshareTsId + "]";
	}
	
	
}

