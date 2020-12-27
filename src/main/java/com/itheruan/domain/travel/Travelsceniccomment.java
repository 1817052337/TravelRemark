package com.itheruan.domain.travel;
import java.io.Serializable;
import java.sql.*;


public class Travelsceniccomment implements Serializable{
	private Integer travelsceniccommentId;
	private String travelsceniccommentText;
	private Date travelsceniccommentTime;
	private String travelsceniccommentEnvironmentgrade;
	private String travelsceniccommentServegrade;
	private String travelsceniccommentAllgrade;
	private String travelsceniccommentUserId;
	private String travelsceniccommentTsId;
	public Integer getTravelsceniccommentId() {
		return travelsceniccommentId;
	}
	public void setTravelsceniccommentId(Integer travelsceniccommentId) {
		this.travelsceniccommentId = travelsceniccommentId;
	}
	public String getTravelsceniccommentText() {
		return travelsceniccommentText;
	}
	public void setTravelsceniccommentText(String travelsceniccommentText) {
		this.travelsceniccommentText = travelsceniccommentText;
	}
	public Date getTravelsceniccommentTime() {
		return travelsceniccommentTime;
	}
	public void setTravelsceniccommentTime(Date travelsceniccommentTime) {
		this.travelsceniccommentTime = travelsceniccommentTime;
	}
	public String getTravelsceniccommentEnvironmentgrade() {
		return travelsceniccommentEnvironmentgrade;
	}
	public void setTravelsceniccommentEnvironmentgrade(String travelsceniccommentEnvironmentgrade) {
		this.travelsceniccommentEnvironmentgrade = travelsceniccommentEnvironmentgrade;
	}
	public String getTravelsceniccommentServegrade() {
		return travelsceniccommentServegrade;
	}
	public void setTravelsceniccommentServegrade(String travelsceniccommentServegrade) {
		this.travelsceniccommentServegrade = travelsceniccommentServegrade;
	}
	public String getTravelsceniccommentAllgrade() {
		return travelsceniccommentAllgrade;
	}
	public void setTravelsceniccommentAllgrade(String travelsceniccommentAllgrade) {
		this.travelsceniccommentAllgrade = travelsceniccommentAllgrade;
	}
	public String getTravelsceniccommentUserId() {
		return travelsceniccommentUserId;
	}
	public void setTravelsceniccommentUserId(String travelsceniccommentUserId) {
		this.travelsceniccommentUserId = travelsceniccommentUserId;
	}
	public String getTravelsceniccommentTsId() {
		return travelsceniccommentTsId;
	}
	public void setTravelsceniccommentTsId(String travelsceniccommentTsId) {
		this.travelsceniccommentTsId = travelsceniccommentTsId;
	}
	@Override
	public String toString() {
		return "Travelsceniccomment [travelsceniccommentId=" + travelsceniccommentId + ", travelsceniccommentText="
				+ travelsceniccommentText + ", travelsceniccommentTime=" + travelsceniccommentTime
				+ ", travelsceniccommentEnvironmentgrade=" + travelsceniccommentEnvironmentgrade
				+ ", travelsceniccommentServegrade=" + travelsceniccommentServegrade + ", travelsceniccommentAllgrade="
				+ travelsceniccommentAllgrade + ", travelsceniccommentUserId=" + travelsceniccommentUserId
				+ ", travelsceniccommentTsId=" + travelsceniccommentTsId + "]";
	}
	
	
	
	
}

