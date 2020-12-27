package com.itheruan.domain;


import java.io.Serializable;

/**
 * 景点和点评所属模块
 */
public class Travelremarkmodule implements Serializable {
	private Integer travelremarkmoduleId;
	private String travelremarkmoduleName;

	public Integer getTravelremarkmoduleId() {
		return travelremarkmoduleId;
	}

	public void setTravelremarkmoduleId(Integer travelremarkmoduleId) {
		this.travelremarkmoduleId = travelremarkmoduleId;
	}

	public String getTravelremarkmoduleName() {
		return travelremarkmoduleName;
	}

	public void setTravelremarkmoduleName(String travelremarkmoduleName) {
		this.travelremarkmoduleName = travelremarkmoduleName;
	}

	@Override
	public String toString() {
		return "Travelremarkmodule{" +
				"travelremarkmoduleId=" + travelremarkmoduleId +
				", travelremarkmoduleName='" + travelremarkmoduleName + '\'' +
				'}';
	}
}

