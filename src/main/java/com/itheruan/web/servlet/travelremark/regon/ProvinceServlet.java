package com.itheruan.web.servlet.travelremark.regon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheruan.domain.Travelremarklabel;
import com.itheruan.domain.Travelremarkmodule;
import com.itheruan.domain.regon.Area;
import com.itheruan.domain.regon.City;
import com.itheruan.domain.regon.Province;
import com.itheruan.service.mysqlservice.Impl.ModuleServiceImpl;
import com.itheruan.service.mysqlservice.Impl.ProvinceServiceImpl;
import com.itheruan.utils.JsonUtil;

@WebServlet("/travelremark/regon/province.do")
public class ProvinceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String menthod = request.getParameter("method");
		if ("provinceAll".equals(menthod)) {
			//查询所有省份
			provinceAll(request,response);
		}else if ("provinceId".equals(menthod)) {
			//获取省份id
			findProvinceId(request,response);
			
		}else if ("cityId".equals(menthod)) {
			//获取城市id
			findcityId(request,response);
		}
	}
	
	/**
	 * 根据城市id获取地区
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void findcityId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String cityId = request.getParameter("cityId");
		
		ProvinceServiceImpl serviceImpl = new ProvinceServiceImpl();
		List<Area> findAllArea = serviceImpl.findAllArea();
		System.out.println(findAllArea);
		List<Area> areaList = new ArrayList<>();
		
		for (Area area : findAllArea) {
			if ((area.getAreaCityId()+"").equals(cityId+"")) {
				//System.out.println(area);
				areaList.add(area);
			}
		}
		System.out.println(areaList);
		JsonUtil.writeValue(areaList, response);	
	}

	/**
	 * 根据省份id获取城市和地区
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void findProvinceId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String provinceId = request.getParameter("provinceId");
		System.out.println("省份id"+provinceId);
		List<City> cityList = new ArrayList<>();
		ProvinceServiceImpl serviceImpl = new ProvinceServiceImpl();
		List<City> allCity = serviceImpl.findAllCity();
		for (City city : allCity) {
			if ((city.getCityProvinceId()).equals(provinceId)) {
				cityList.add(city);
			}
		}
		
		//获取第一个城市id
		City city = cityList.get(0);
		List<Area> areaList = new ArrayList<>();
		List<Area> findAllArea = serviceImpl.findAllArea();
		for (Area area : findAllArea) {
			if ((area.getAreaCityId()+"").equals(city.getCityId()+"")) {
				//System.out.println(area);
				areaList.add(area);
			}
		}
		//System.out.println(areaList);
		List<Object> list = new ArrayList<Object>();
		list.add(cityList);
		list.add(areaList);
		
		JsonUtil.writeValue(list, response);
	}

	/**
	 * 查询所有省份
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void provinceAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProvinceServiceImpl serviceImpl = new ProvinceServiceImpl();
		//查询所有省份
		List<Province> findAllProvince = serviceImpl.findAllProvince();
		//根据省份id，查询
		List<City> findAllCity = serviceImpl.findAllCity();
		City city = null;
		for (City city1 : findAllCity) {
			if ((city1.getCityProvinceId()).equals("1")) {
				city = city1;
			}
		}
		String cityId = city.getCityId();
		System.out.println(cityId);
		//获取城市id
		List<Area> findAllArea = serviceImpl.findAllArea();
		List<Area> areaList = new ArrayList<>();
		for (Area area : findAllArea) {
			if ((area.getAreaCityId()+"").equals(cityId)) {
				areaList.add(area);
			}
		}
		ModuleServiceImpl moduleService = new ModuleServiceImpl();
		//查询所有模块
		List<Travelremarkmodule> moduleList = moduleService.findAllModule();

		//默认获取第一个模块
		Travelremarkmodule travelremarkmodule = moduleList.get(0);
		System.out.println("单个模块"+travelremarkmodule);

		List<Travelremarklabel> labelList = new ArrayList<>();
		//根据模块获取标签
		List<Travelremarklabel> allLabel = moduleService.findAllLabel();
		System.out.println(allLabel);
		for (Travelremarklabel travelremarklabel : allLabel) {
			if ((travelremarkmodule.getTravelremarkmoduleId()+"").equals(travelremarklabel.getTravelremarklabelModuleId()+"")) {
				labelList.add(travelremarklabel);
			}
		}
		System.out.println("所有标签"+labelList);

		//存储值
		request.setAttribute("findAllProvince", findAllProvince);
		request.setAttribute("city", city);
		request.setAttribute("areaList", areaList);


		//存储模块和标签
		request.setAttribute("moduleList", moduleList);
		request.setAttribute("labelList", labelList);

		//跳转页面
		request.getRequestDispatcher("/travelremark/remark/remark_write.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
