package com.itheruan.service.mysqlservice.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.itheruan.dao.msyqldao.IProvinceDao;
import com.itheruan.dao.msyqldao.Impl.ProvinceDaoImpl;
import com.itheruan.domain.regon.Area;
import com.itheruan.domain.regon.City;
import com.itheruan.domain.regon.Province;
import com.itheruan.service.mysqlservice.IProvinceService;
import com.itheruan.utils.JedisUtil;
import com.itheruan.utils.SerializeUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

/**
 * 省份 城市 地区 业务层接口
 * 
 * @author 11137
 *
 */
public class ProvinceServiceImpl implements IProvinceService {
	public static void main(String[] args) {
		List<City> allCity = new ProvinceServiceImpl().findAllCity();
		for (City city : allCity) {
			System.out.println(city);
		}
	}

	/**
	 * 查询所有省份
	 * 
	 * @return
	 */
	@Override
	public List<Province> findAllProvince() {
		IProvinceDao provinceDao = new ProvinceDaoImpl();
		// 获取redis客户端
		Jedis jedis = JedisUtil.getJedis();

		Set<Tuple> provinceListJ = jedis.zrangeWithScores("provinceList", 0, -1);

		List<Province> provinceList = null;
		// 2.判断查询的集合是否为空
		if (provinceListJ == null || provinceListJ.size() == 0) {

			System.out.println("从数据库查询....");
			// 3.如果为空,需要从数据库查询,在将数据存入redis
			// 3.1 从数据库查询
			provinceList = provinceDao.findAllProvince();

			// 3.2 将集合数据存储到redis中的 category的key
			for (int i = 0; i < provinceList.size(); i++) {
				Province province = provinceList.get(i);

				// 将省份信息存储到redis缓冲之中
				jedis.zadd("provinceList", province.getProvinceId(), province.getProvinceName());
			}
		} else {
			System.out.println("从redis中查询.....");

			// 4.如果不为空,将set的数据存入list
			provinceList = new ArrayList<Province>();
			for (Tuple tuple : provinceListJ) {
				// 获取redis缓冲中的信息
				Province province = new Province();
				province.setProvinceId((int) (tuple.getScore()));
				province.setProvinceName(tuple.getElement());
				provinceList.add(province);
			}
		}

		return provinceList;
	}

	/**
	 * 查询所有城市
	 * 
	 * @return
	 */
	@Override
	public List<City> findAllCity() {
		IProvinceDao provinceDao = new ProvinceDaoImpl();
		Jedis jedis = JedisUtil.getJedis();
		// 获取缓存中城市集合
		List<byte[]> cityListJ = jedis.lrange("cityList".getBytes(), 0, -1);
		List<City> cityList = null;
		// 2.判断查询的集合是否为空
		if (cityListJ == null || cityListJ.size() == 0) {

			System.out.println("从数据库查询....");
			// 3.如果为空,需要从数据库查询,在将数据存入redis
			// 3.1 从数据库查询
			cityList = provinceDao.findAllCity();

			// 3.2 将集合数据存储到redis中的 category的key
			for (int i = 0; i < cityList.size(); i++) {
				City city = cityList.get(i);

				// 将城市信息存储到redis缓冲之中
				jedis.lpush("cityList".getBytes(), SerializeUtil.serialize(city));
			}
		} else {
			System.out.println("从redis中查询.....");

			// 4.如果不为空,将set的数据存入list
			cityList = new ArrayList<City>();
			for (byte[] bs : cityListJ) {
				City city2 = (City) SerializeUtil.unserialize(bs);
				cityList.add(city2);
			}

		}
		return cityList;
	}

	/**
	 * 查询所有地区
	 * 
	 * @return
	 */
	@Override
	public List<Area> findAllArea() {
		IProvinceDao provinceDao = new ProvinceDaoImpl();
		Jedis jedis = JedisUtil.getJedis();

		// 获取缓存中城市集合
		List<byte[]> areaListJ = jedis.lrange("areaList".getBytes(), 0, -1);
		List<Area> areaList = null;
		// 2.判断查询的集合是否为空
		if (areaListJ == null || areaListJ.size() == 0) {

			System.out.println("从数据库查询....");
			// 3.如果为空,需要从数据库查询,在将数据存入redis
			// 3.1 从数据库查询
			areaList = provinceDao.findAllArea();
			//System.out.println(areaList);
			// System.out.println(areaList);
			// 3.2 将集合数据存储到redis中的 category的key
			for (int i = 0; i < areaList.size(); i++) {
				Area area = areaList.get(i);
				// System.out.println(area);
				// 将城市信息存储到redis缓冲之中
				jedis.lpush("areaList".getBytes(), SerializeUtil.serialize(area));
			}
		} else {
			System.out.println("从redis中查询.....");
			// 4.如果不为空,将set的数据存入list
			areaList = new ArrayList<Area>();
			//areaList.add()
			//areaListJ.add(SerializeUtil.serialize(new Area()));
			//jedis.lpush("areaList".getBytes(), SerializeUtil.serialize(new Area()));
			for (byte[] bs : areaListJ) {
				Area city2 = (Area) SerializeUtil.unserialize(bs);
				areaList.add(city2);
			}

		}
		//System.out.println(areaList);
		return areaList;

	}
	/**
	 * 根据城市id查询城市
	 * @param cityName
	 * @return
	 */
	@Override
	public City findByCityIdCity(String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据地区名称获取地区信息
	 * @param areaName
	 * @return
	 */
	@Override
	public Area findByNameArea(String areaName) {
		return new ProvinceDaoImpl().findByNameArea(areaName);
	}


}
