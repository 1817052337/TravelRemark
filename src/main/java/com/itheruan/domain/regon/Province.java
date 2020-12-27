package com.itheruan.domain.regon;

import java.io.Serializable;

/**
    * @文件名称：Province.java
    * @创建时间：2020-12-22 15:27:05
    * @创  建  人： 
    * @文件描述：province 实体类
    * @文件版本：V0.01 
    */ 

/**
 *省份实体类
 * @author 11137
 *
 */
public class Province  implements Serializable{
	private Integer provinceId;
	private String provinceName;
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", provinceName=" + provinceName + "]";
	}
	
	
}

