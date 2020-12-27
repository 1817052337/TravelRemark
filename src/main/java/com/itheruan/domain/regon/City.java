package com.itheruan.domain.regon;

import java.io.Serializable;
import java.util.List;

import com.itheruan.domain.Remark.Remark;

/**
 * 城市实体类
 * @author 11137
 *
 */
public class City implements Serializable{
	private String cityId;
	private String cityName;
	private String cityInitial;
	private String cityProvinceId;
	private List<Area> remarkList;//地区集合
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;    
	}
	public String getCityInitial() {
		return cityInitial;
	}
	public void setCityInitial(String cityInitial) {
		this.cityInitial = cityInitial;
	}
	public String getCityProvinceId() {
		return cityProvinceId;
	}
	public void setCityProvinceId(String cityProvinceId) {
		this.cityProvinceId = cityProvinceId;
	}
	public List<Area> getRemarkList() {
		return remarkList;
	}
	public void setRemarkList(List<Area> remarkList) {
		this.remarkList = remarkList;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", cityInitial=" + cityInitial
				+ ", cityProvinceId=" + cityProvinceId + ", remarkList=" + remarkList + "]";
	}
	
	
	
	
	
	
}
