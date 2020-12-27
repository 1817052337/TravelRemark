package com.itheruan.web.servlet.travelremark;

import com.itheruan.domain.Remark.Remark;
import com.itheruan.domain.Travelremarklabel;
import com.itheruan.domain.Travelremarkmodule;
import com.itheruan.domain.regon.Area;
import com.itheruan.domain.regon.City;
import com.itheruan.service.mysqlservice.Impl.ModuleServiceImpl;
import com.itheruan.service.mysqlservice.Impl.ProvinceServiceImpl;
import com.itheruan.service.mysqlservice.Impl.RemarkServiceImpl;
import com.itheruan.service.mysqlservice.Impl.UserServiceImpl;
import com.itheruan.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/travelremark/travelRemarkShow.do")
public class TravelRemarkShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menthod = request.getParameter("method");
        if ("findByLikeTravelRemark".equals(menthod)) {
            //查询所有模块
            findByLikeTravelRemark(request,response);
        } else if ("findByLikeLabelAndModule".equals(menthod)) {
            findByLikeLableAndModuleAndArea(request, response);
        }
    }


    /**
     * 模块，标签异步条件查询
     * @param request
     * @param response
     */
    private void findByLikeLableAndModuleAndArea(HttpServletRequest request, HttpServletResponse response) {
        RemarkServiceImpl remarkService = new RemarkServiceImpl();

        //获取参数
        //模块内容
        String travelremarkmoduleName = request.getParameter("travelremarkmoduleName");
        //标签内容
        String travelremarklabelName = request.getParameter("travelremarklabelName");
        //地区内容
        String areaName = request.getParameter("areaName");
        System.out.println("模块内容"+travelremarkmoduleName);
        System.out.println(travelremarklabelName);
        System.out.println("地区名称"+areaName);


        //从session中获取地区信息
        City city = (City) request.getSession().getAttribute("city");
        //city.setCityId("1");
        int cityId = Integer.parseInt(city.getCityId());
        //获取该省份的所有点评
        List<Remark> allRemark = remarkService.findAllRemark(cityId);
        //定义最终点评集合
        List<Remark> remarkList = null;

        Integer areaId = 0;

        //当地区不为空是
        if (areaName != null && areaName.length() != 0) {
            //获取地区实体类
            Area area = new ProvinceServiceImpl().findByNameArea(areaName);
            //获取id
            areaId = area.getAreaId();
            ////循环遍历进行判断
            for (Remark remark : allRemark) {
                //获取标签
                String remarkTravelModule = remark.getRemarkTravelModule();
                //获取模块
                String remarkTravelLabel = remark.getRemarkTravelLabel();
                //获取地区id
                Integer remarkAreaId = (remark.getRemarkAreaId());

                //先判断地区是否为空

                if (remarkTravelModule.contains(travelremarkmoduleName) && remarkTravelLabel.contains(travelremarklabelName) && remarkAreaId == areaId) {
                    remarkList.add(remark);
                }
            }

        }else {
            //当地区为空时
            for (Remark remark : allRemark) {
                //获取标签
                String remarkTravelModule = remark.getRemarkTravelModule();
                //获取模块
                String remarkTravelLabel = remark.getRemarkTravelLabel();
                if (remarkTravelModule.contains(travelremarkmoduleName) && remarkTravelLabel.contains(travelremarklabelName)) {
                    remarkList.add(remark);
                }
            }
        }


        System.out.println("最终集合"+remarkList);



    }

    /**
     * 模块，标签，进行模糊搜索
     * @param request
     * @param response
     */
    private void findByLikeTravelRemark(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RemarkServiceImpl remarkService = new RemarkServiceImpl();
        ModuleServiceImpl moduleService = new ModuleServiceImpl();
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        //获取参数
        String travelremark_search = (request.getParameter("travelremark_search")).replace("\u00A0", "").trim();

        //获取当前所在的地区
        //从session中获取地区信息
        City city = (City) request.getSession().getAttribute("city");
        //city.setCityId("1");
        int cityId = Integer.parseInt(city.getCityId());
        //获取当前点评所属的城市id
        //创建最终点评的集合
        List<Remark> allRemark = remarkService.findAllRemark(cityId);

        //查询所有模块
        List<Travelremarkmodule> moduleList = moduleService.findAllModule();

        Travelremarkmodule travelremarkmoduleZ = null;
        List<Remark> remarkList = null;

        //判断当前模块是否被选中(true为选中，false为未选中)
        boolean flag  = false;

        if (travelremark_search == null || travelremark_search.length() == 0) {
            //获取点评关联的用户集合
            for (Remark remark : allRemark) {
                remark.setUserMap(userService.findByIdUser(remark.getRemarkUserId()));
                //下载点评内容
                subStrByStrAndLen(FileUtils.download(remark.getRemarkText()), 50);
            }
            remarkList = allRemark;
            travelremarkmoduleZ = moduleList.get(0);
            flag  = false;
        }else {
            remarkList = new ArrayList<>();
            for (Remark remark : allRemark) {
                //获取模块
                String remarkTravelModule = remark.getRemarkTravelModule();
                //获取标签
                String remarkTravelLabel = remark.getRemarkTravelLabel();
                if ((remarkTravelModule.contains(travelremark_search) )|| remarkTravelLabel.contains(travelremark_search)) {
                    Map<String, Object> byIdUser = userService.findByIdUser(remark.getRemarkUserId());
                    remark.setUserMap(byIdUser);
                    //下载点评内容

                    remark.setRemarkText(subStrByStrAndLen(FileUtils.download(remark.getRemarkText()), 50));
                    remarkList.add(remark);
                }
            }
            //判断所有模块中是否包含搜索的内容
            for (Travelremarkmodule travelremarkmodule : moduleList) {
                if (travelremarkmodule.getTravelremarkmoduleName().contains(travelremark_search) ||travelremarkmodule.getTravelremarkmoduleName().equals(travelremark_search)) {
                    //包含
                    travelremarkmoduleZ = travelremarkmodule;
                    flag  = true;
                    break;
                }else {
                    //不包含 默认获取第一个
                    travelremarkmoduleZ = moduleList.get(0);
                    flag  = false;
                }
            }
        }


        //System.out.println("最终集合" + remarkList);
        ////remarkList.forEach(n-> System.out.println(n));
       // System.out.println("-----------------------");



        List<Travelremarklabel> labelList = new ArrayList<>();
        //根据模块获取标签
        List<Travelremarklabel> allLabel = moduleService.findAllLabel();
       // System.out.println(allLabel);
        for (Travelremarklabel travelremarklabel : allLabel) {
            if ((travelremarkmoduleZ.getTravelremarkmoduleId()+"").equals(travelremarklabel.getTravelremarklabelModuleId()+"")) {
                labelList.add(travelremarklabel);
            }
        }

        //根据城市id获取所有地区
        List<Area> areaList = new ArrayList<>();
        List<Area> allArea = provinceService.findAllArea();
        for (Area area : allArea) {
            if ((area.getAreaCityId() + "").equals((cityId + ""))) {
                areaList.add(area);
            }
        }


        //存值
        //单个模块
        request.setAttribute("flag", flag);
        //点评集合
        request.setAttribute("remarkList",remarkList);
        //模块集合
        request.setAttribute("moduleList",moduleList);
        //标签集合
        request.setAttribute("labelList",labelList);
        //地区集合
        request.setAttribute("areaList", areaList);

        //转向概展示页面
        request.getRequestDispatcher("/travelremark/travelremark_show.jsp").forward(request, response);

    }


    /**
     * 截取指定长度的字符串
     *
     * @param str 原字符串
     * @param len 长度
     * @return 如果str为null，则返回null；如果str长度小于len，则返回str；如果str的长度大于len，则返回截取后的字符串
     */
    public static String subStrByStrAndLen(String str, int len) {
        return null != str ? str.substring(0, str.length() > len ? len : str.length()) : null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
