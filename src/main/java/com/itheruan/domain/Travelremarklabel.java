package com.itheruan.domain;


import java.io.Serializable;

public class Travelremarklabel implements Serializable {
	private Integer travelremarklabelId;
	private String travelremarklabelName;
	private Integer travelremarklabelModuleId;


	public Integer getTravelremarklabelId() {
		return travelremarklabelId;
	}

	public void setTravelremarklabelId(Integer travelremarklabelId) {
		this.travelremarklabelId = travelremarklabelId;
	}

	public String getTravelremarklabelName() {
		return travelremarklabelName;
	}

	public void setTravelremarklabelName(String travelremarklabelName) {
		this.travelremarklabelName = travelremarklabelName;
	}

	public Integer getTravelremarklabelModuleId() {
		return travelremarklabelModuleId;
	}

	public void setTravelremarklabelModuleId(Integer travelremarklabelModuleId) {
		this.travelremarklabelModuleId = travelremarklabelModuleId;
	}

	@Override
	public String toString() {
		return "Travelremarklabel{" +
				"travelremarklabelId=" + travelremarklabelId +
				", travelremarklabelName='" + travelremarklabelName + '\'' +
				", travelremarklabelModuleId=" + travelremarklabelModuleId +
				'}';
	}
}

