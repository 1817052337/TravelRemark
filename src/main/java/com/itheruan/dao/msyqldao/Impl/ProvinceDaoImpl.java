package com.itheruan.dao.msyqldao.Impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itheruan.dao.msyqldao.IProvinceDao;
import com.itheruan.dao.msyqldao.IRemarkDao;
import com.itheruan.domain.regon.Area;
import com.itheruan.domain.regon.City;
import com.itheruan.domain.regon.Province;
import com.itheruan.utils.JDBCUtils;

/**
 * 省份 城市 地区 持久层实现类
 * @author 11137
 *
 */
public class ProvinceDaoImpl implements IProvinceDao{
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
	/**
	 * 查询所有省份
	 * @return
	 */
	@Override
	public List<Province> findAllProvince() {
		 String sql = "select * from province ";
	        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Province>(Province.class));
	}
	/**
	 * 查询所有城市
	 * @return
	 */
	@Override  
	public List<City> findAllCity() {
		 String sql = "select * from city ";
	        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<City>(City.class));
	}

	
	/**
	 * 查询所有地区
	 * @return
	 */
	@Override
	public List<Area> findAllArea() {
		 String sql = "select * from area";
	        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Area>(Area.class));
	}
	/**
	 * 根据城市id查询城市
	 * @param cityName
	 * @return
	 */
	@Override
	public City findByCityIdCity(String cityName) {
		String sql = "select * from city where  city_name = ?";
		return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<City>(City.class),cityName);
	}


	/**
	 * 根据城市名称查询城市
	 * @param cityId
	 * @return
	 */
	@Override
	public List<Area> findByCity(int cityId) {
		String sql = "select * from area where area_city_id = ?";
		return jdbcTemplate.query(sql , new BeanPropertyRowMapper<Area>(Area.class),cityId);
	}

	/**
	 * 根据地区名称获取地区信息
	 * @param areaName
	 * @return
	 */
	@Override
	public Area findByNameArea(String areaName) {
		String sql = "select * from area where area_name = ?";
		return jdbcTemplate.queryForObject(sql , new BeanPropertyRowMapper<Area>(Area.class),areaName);
	}
}
