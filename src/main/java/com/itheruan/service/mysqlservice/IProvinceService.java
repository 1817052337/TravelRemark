package com.itheruan.service.mysqlservice;

import java.util.List;

import com.itheruan.domain.regon.Area;
import com.itheruan.domain.regon.City;
import com.itheruan.domain.regon.Province;

/**
 * 省份 城市 地区 业务层接口
 * @author 11137
 *
 */
public interface IProvinceService {
	/**
	 * 查询所有省份
	 * @return
	 */
	List<Province>  findAllProvince();
	
	
	/**
	 * 查询所有城市
	 * @return
	 */
	List<City>  findAllCity();
	
	
	/**
	 * 根据城市id查询城市
	 * @param cityName
	 * @return
	 */
	City findByCityIdCity(String cityName);

	
	/**
	 * 查询所有地区
	 * @return
	 */
	List<Area>  findAllArea();


	/**
	 * 根据地区名称获取地区信息
	 * @param areaName
	 * @return
	 */
	Area findByNameArea(String areaName);

}
