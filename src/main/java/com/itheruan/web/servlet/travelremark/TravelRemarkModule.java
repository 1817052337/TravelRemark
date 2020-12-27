package com.itheruan.web.servlet.travelremark;

import com.itheruan.domain.Travelremarklabel;
import com.itheruan.domain.Travelremarkmodule;
import com.itheruan.domain.regon.Area;
import com.itheruan.domain.regon.City;
import com.itheruan.domain.regon.Province;
import com.itheruan.service.mysqlservice.Impl.ModuleServiceImpl;
import com.itheruan.service.mysqlservice.Impl.ProvinceServiceImpl;
import com.itheruan.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ElasticSearch
 * @description: 景点和点评所属模块和标签的表现层实现类
 * @author: YAN.YUE.SHUANG
 * @create: 2020-12-26 17:52
 **/
@WebServlet("/travelremark/travelRemarkModule.do")
public class TravelRemarkModule extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menthod = request.getParameter("method");
        if ("findByModuleIdLabel".equals(menthod)) {
            //查询所有模块
            findByModuleIdLabel(request,response);
        }else if ("provinceId".equals(menthod)) {

        }
    }

    /**
     * 查询所有模块
     * @param request
     * @param response
     */
    private void findByModuleIdLabel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String travelremarkmoduleId = request.getParameter("travelremarkmoduleId");
       // System.out.println("获取的参数"+travelremarkmoduleId);

        //查询所有标签
        List<Travelremarklabel> allLabel = new ModuleServiceImpl().findAllLabel();
        List<Travelremarklabel> labelList = new ArrayList<>();
        for (Travelremarklabel travelremarklabel : allLabel) {
            if ((travelremarklabel.getTravelremarklabelModuleId()+"").equals(travelremarkmoduleId+"")) {
                //存入集合
                labelList.add(travelremarklabel);
            }
        }
        //System.out.println(labelList);
        //序列或json
        JsonUtil.writeValue(labelList, response);

        //跳转页面
        request.getRequestDispatcher("/travelremark/remark/remark_write.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
