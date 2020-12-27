package com.itheruan.domain.travel;

import java.io.Serializable;

public class Travelscenicimage implements Serializable{
	private Integer travelscenicimageId;
	private String travelscenicimageName;
	private String travelscenicimageTsId;
	public Integer getTravelscenicimageId() {
		return travelscenicimageId;
	}
	public void setTravelscenicimageId(Integer travelscenicimageId) {
		this.travelscenicimageId = travelscenicimageId;
	}
	public String getTravelscenicimageName() {
		return travelscenicimageName;
	}
	public void setTravelscenicimageName(String travelscenicimageName) {
		this.travelscenicimageName = travelscenicimageName;
	}
	public String getTravelscenicimageTsId() {
		return travelscenicimageTsId;
	}
	public void setTravelscenicimageTsId(String travelscenicimageTsId) {
		this.travelscenicimageTsId = travelscenicimageTsId;
	}
	@Override
	public String toString() {
		return "Travelscenicimage [travelscenicimageId=" + travelscenicimageId + ", travelscenicimageName="
				+ travelscenicimageName + ", travelscenicimageTsId=" + travelscenicimageTsId + "]";
	}
	
	
	
}

