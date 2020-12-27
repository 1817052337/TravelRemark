package com.itheruan.Remark_Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.itheruan.domain.Remark.Remarkimage;
import org.junit.Test;

import com.itheruan.dao.msyqldao.Impl.RemarkDaoImpl;
import com.itheruan.domain.Remark.Remark;
import com.itheruan.domain.regon.Area;
import com.itheruan.domain.regon.City;
import com.itheruan.domain.regon.Province;
import com.itheruan.service.mysqlservice.Impl.ProvinceServiceImpl;
import com.itheruan.service.mysqlservice.Impl.RemarkServiceImpl;
import com.itheruan.utils.FileUtils;
import com.itheruan.utils.JedisUtil;
import com.itheruan.utils.SerializeUtil;
import com.itheruan.utils.UuidUtil;

import redis.clients.jedis.Jedis;

public class Test_01 {

	
	
	@Test
	public void test_03() {
		/*
		 * ProvinceServiceImpl serviceImpl = new ProvinceServiceImpl(); List<Province>
		 * list = serviceImpl.finAllProvince(); System.out.println(list);
		 */
		
		/*
		 * Jedis jedis = JedisUtil.getJedis(); City city = new City();
		 * city.setCityName("长江"); byte[] serialize = SerializeUtil.serialize(city);
		 * 
		 * jedis.lpush("list".getBytes(),serialize);
		 * 
		 * List<byte[]> lrange2 = jedis.lrange("list".getBytes(), 0, -1); for (byte[] bs
		 * : lrange2) { City city2 = (City) SerializeUtil.unserialize(bs);
		 * System.out.println(city2); }
		 */
		/*
		 * ProvinceServiceImpl serviceImpl = new ProvinceServiceImpl(); List<City>
		 * finAllCity = serviceImpl.finAllCity(); System.out.println(finAllCity);
		 */
		 
		 
		/*
		 * ProvinceServiceImpl serviceImpl = new ProvinceServiceImpl(); List<Area>
		 * findAllCity = serviceImpl.findAllArea(); System.out.println(findAllCity);
		 * System.out.println(findAllCity.size());
		 */
		
//		InputStream tInputStringStream = new ByteArrayInputStream("这是说撒了考试卷阿拉蕾".getBytes());
//		System.out.println(tInputStringStream);
//		System.out.println(tInputStringStream.toString());
//		System.out.println(tInputStringStream.);
		
		//FileUtils.upload(tInputStringStream.toString(), "remarktext/"+UuidUtil.getUuid()+".text");

		/*RemarkServiceImpl remarkServiceImpl = new RemarkServiceImpl();
		List<Remark> remarks = remarkServiceImpl.findAllRemark();
		//System.out.println(remarks);
		//List<Remark> remarkList = new ArrayList<>();
		List<String> remarkIdList = new ArrayList<>();
		for (Remark remark : remarks) {
			System.out.println(remarks);
			remarkIdList.add(remark.getRemarkId());
		}

		List<List<Remarkimage>> allRemarkimag = remarkServiceImpl.findAllRemarkimag(remarkIdList);

		System.out.println(remarks);
		System.out.println(allRemarkimag);
		List<Object> list = new ArrayList<>();

		list.add(remarks);
		list.add(allRemarkimag);*/

		/*List<Remark> allRemark = new RemarkDaoImpl().findAllRemark(1);
		for (Remark remark : allRemark) {
			System.out.println(remark.getRemarkTimeStr());
		}
*/

		System.out.println("123".equals(""));
	}
	
}
