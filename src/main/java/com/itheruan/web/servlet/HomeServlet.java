package com.itheruan.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheruan.domain.Remark.Remark;
import com.itheruan.domain.Remark.Remarkimage;
import com.itheruan.domain.regon.City;
import com.itheruan.service.mysqlservice.Impl.ProvinceServiceImpl;
import com.itheruan.service.mysqlservice.Impl.RemarkServiceImpl;
import com.itheruan.utils.JedisUtil;
import com.itheruan.utils.SerializeUtil;
import com.itheruan.web.servlet.travelremark.regon.ProvinceServlet;
import redis.clients.jedis.Jedis;

import static javax.swing.text.html.CSS.getAttribute;

/**
 * 首页的展示
 */
@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取当前所在的城市
        String cityName = request.getParameter("city");
        System.out.println("城市名称"+cityName);
        HttpSession session = request.getSession();

        City cityZ = null;
        if (cityName == null) {
            City city = (City) session.getAttribute("city");
            cityName = city.getCityName();
            System.out.println("session中的城市名称"+cityName);
        }

        if (cityName != null || cityName.length() > 0) {
            //根据城市名称获取当前城市的实体类
            List<City> allCity = new ProvinceServiceImpl().findAllCity();
            City city = null;
            for (City city1 : allCity) {
                if (city1.getCityName().equals(cityName)) {
                    city = city1;
                    break;
                }
            }
            //获取缓存中的城市
            Jedis jedis = JedisUtil.getJedis();
            City cityJ = (City) SerializeUtil.unserialize(jedis.get("city".getBytes()));

            //从session中获取城市实体类

            City sessionCity = (City) session.getAttribute("city");

            //System.out.println(sessionCityName);
            //先判断session中是否为空
            if (sessionCity == null) {
                System.out.println("开始存储值");
                //先删除jedis可能存在的城市实体类
                jedis.del("city");
                //将城市存入到redis缓冲，并设置失效时间为十分钟
                jedis.setex("city".getBytes(), 10 * 60, SerializeUtil.serialize(city));
                //存入session域中
                session.setAttribute("city", city);
            } else if (sessionCity != null && cityJ == null ) {
                //删除session域中的数值，将当前城市改为用户所在的城市
                session.removeAttribute("city");
                session.setAttribute("city", city);
                jedis.del("city");
                //将城市存入到redis缓冲，并设置失效时间为十分钟
                jedis.setex("city".getBytes(), 10 * 60, SerializeUtil.serialize(city));
            }

        }
        cityZ = (City) session.getAttribute("city");


       System.out.println("城市最终实体类" + cityZ);


        //根据城市id查询点评集合
        RemarkServiceImpl remarkServiceImpl = new RemarkServiceImpl();

        List<Remark> remarks = remarkServiceImpl.findAllRemark(Integer.parseInt(cityZ.getCityId()));
        System.out.println(remarks);

        List<Remark> remarkList = new ArrayList<>();
        List<String> remarkIdList = new ArrayList<>();
        for (Remark remark : remarks) {
            //System.out.println(remarks);
            remarkIdList.add(remark.getRemarkId());
        }

        //获取图片集合
        List<List<Remarkimage>> allRemarkimag = remarkServiceImpl.findAllRemarkimag(remarkIdList,Integer.parseInt(cityZ.getCityId()));
        //System.out.println("图片集合"+allRemarkimag);

        for (int i = 0; i < remarks.size(); i++) {
            if (allRemarkimag.get(i) == null || allRemarkimag.get(i).size() == 0) {
                continue;
            }
            Remark remark = remarks.get(i);
            String remarkimageName = allRemarkimag.get(i).get(0).getRemarkimageName();
            remark.setRemarkImage(remarkimageName);
        }

        //System.out.println("展示信息：" + remarks);

        request.setAttribute("remarks", remarks);

        request.getRequestDispatcher("/index_02.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

}
