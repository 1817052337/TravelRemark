package com.itheruan.domain.travel;

import java.io.Serializable;
import java.util.List;

public class Travelscenic implements Serializable{
	private String travelscenicId;
	private String travelscenicName;
	private String travelscenicIntroduce;
	private String travelscenicLocation;
	private String travelscenicPrice;
	private String travelscenicPhone;
	private String travelscenicBusinesshours;
	private String travelscenicType;
	private String travelscenicModule;
	private Integer travelscenicAreaId;
	//	private	List<Travelsceniccollect> travelsceniccollectList;//景点的收藏
	//	private	List<Travelsceniccollect> travelsceniccollectList;//景点的评论
	//	private	List<Travelsceniccollect> travelsceniccollectList;
	//	private	List<Travelsceniccollect> travelsceniccollectList;
	//	private	List<Travelsceniccollect> travelsceniccollectList;
	public String getTravelscenicId() {
		return travelscenicId;
	}
	public void setTravelscenicId(String travelscenicId) {
		this.travelscenicId = travelscenicId;
	}
	public String getTravelscenicName() {
		return travelscenicName;
	}
	public void setTravelscenicName(String travelscenicName) {
		this.travelscenicName = travelscenicName;
	}
	public String getTravelscenicIntroduce() {
		return travelscenicIntroduce;
	}
	public void setTravelscenicIntroduce(String travelscenicIntroduce) {
		this.travelscenicIntroduce = travelscenicIntroduce;
	}
	public String getTravelscenicLocation() {
		return travelscenicLocation;
	}
	public void setTravelscenicLocation(String travelscenicLocation) {
		this.travelscenicLocation = travelscenicLocation;
	}
	public String getTravelscenicPrice() {
		return travelscenicPrice;
	}
	public void setTravelscenicPrice(String travelscenicPrice) {
		this.travelscenicPrice = travelscenicPrice;
	}
	public String getTravelscenicPhone() {
		return travelscenicPhone;
	}
	public void setTravelscenicPhone(String travelscenicPhone) {
		this.travelscenicPhone = travelscenicPhone;
	}
	public String getTravelscenicBusinesshours() {
		return travelscenicBusinesshours;
	}
	public void setTravelscenicBusinesshours(String travelscenicBusinesshours) {
		this.travelscenicBusinesshours = travelscenicBusinesshours;
	}
	public String getTravelscenicType() {
		return travelscenicType;
	}
	public void setTravelscenicType(String travelscenicType) {
		this.travelscenicType = travelscenicType;
	}
	public String getTravelscenicModule() {
		return travelscenicModule;
	}
	public void setTravelscenicModule(String travelscenicModule) {
		this.travelscenicModule = travelscenicModule;
	}
	public Integer getTravelscenicAreaId() {
		return travelscenicAreaId;
	}
	public void setTravelscenicAreaId(Integer travelscenicAreaId) {
		this.travelscenicAreaId = travelscenicAreaId;
	}
	@Override
	public String toString() {
		return "Travelscenic [travelscenicId=" + travelscenicId + ", travelscenicName=" + travelscenicName
				+ ", travelscenicIntroduce=" + travelscenicIntroduce + ", travelscenicLocation=" + travelscenicLocation
				+ ", travelscenicPrice=" + travelscenicPrice + ", travelscenicPhone=" + travelscenicPhone
				+ ", travelscenicBusinesshours=" + travelscenicBusinesshours + ", travelscenicType=" + travelscenicType
				+ ", travelscenicModule=" + travelscenicModule + ", travelscenicAreaId=" + travelscenicAreaId + "]";
	}
	
	
	
}

