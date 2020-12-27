package com.itheruan.domain.regon;

import java.io.Serializable;
import java.util.List;

import com.itheruan.domain.Remark.Remark;

/**
    * @文件名称：Area.java
    * @创建时间：2020-12-22 15:59:46
    * @创  建  人： 
    * @文件描述：area 实体类
    * @文件版本：V0.01 
    */ 

/**
 * 地区实体类
 * @author 11137
 *
 */
public class Area  implements Serializable{
	private Integer areaId;
	private String areaName;
	private String areaCode;
	private Integer areaCityId;
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public Integer getAreaCityId() {
		return areaCityId;
	}
	public void setAreaCityId(Integer areaCityId) {
		this.areaCityId = areaCityId;
	}

	@Override
	public String toString() {
		return "Area{" +
				"areaId=" + areaId +
				", areaName='" + areaName + '\'' +
				", areaCode='" + areaCode + '\'' +
				", areaCityId=" + areaCityId +
				'}';
	}
}

