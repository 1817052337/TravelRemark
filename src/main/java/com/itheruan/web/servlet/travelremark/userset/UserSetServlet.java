package com.itheruan.web.servlet.travelremark.userset;

import com.itheruan.domain.regon.Province;
import com.itheruan.service.mysqlservice.Impl.ProvinceServiceImpl;
import com.itheruan.service.mysqlservice.Impl.UserServiceImpl;
import com.itheruan.utils.FileUtils;
import com.itheruan.utils.UuidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/travelremark/userSetServlet.do")
public class UserSetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menthod = request.getParameter("method");
        System.out.println(menthod);
        if ("findByIdUser".equals(menthod)) {
            //根据用户id 获取用户信息
            findByIdUser(request, response);
        } else if("updateUser".equals(menthod)){
            updateUser(request, response);

        } else if ("findByUser".equals(menthod)) {
            //查看个人详情信息
            findByUser(request, response);
        }
    }

    /**
     * 查看个人详细信息
     * @param request
     * @param response
     */
    private void findByUser(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> userMapS = (Map<String, Object>) request.getSession().getAttribute("userMap");
        String user_id  = (String) userMapS.get("user_id");
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, Object> user = userService.findByIdUser(user_id);

        //根据id查询获取的所有点赞
    }

    /**
     * 修改个人信息
     * @param request
     * @param response
     */
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // <img id="preview" src="<%=request.getContextPath()%>/assets/images/blog/profile.png" alt="">
        Map<String, Object> userMapS = (Map<String, Object>) request.getSession().getAttribute("userMap");
        String user_name  = (String) userMapS.get("user_name");
        String user_imageB = request.getParameter("user_image");
        String user_image = FileUtils.upload(user_imageB, "remarkImage/" + UuidUtil.getUuid());
        System.out.println(user_image);
        String user_city_id = request.getParameter("user_city");
        System.out.println(user_city_id);
        String user_sex = "";
        String woman = request.getParameter("woman");
        if (woman == null || woman.length() == 0) {
            user_sex = "男";
        }else {
            user_sex = "女";
        }
        System.out.println(user_sex);
        //自我介绍
        String user_introduce = request.getParameter("user_introduce");
        //查询所有省份
        String user_city = "";
        List<Province> allProvince = new ProvinceServiceImpl().findAllProvince();
        for (Province province : allProvince) {
            if (user_city_id.equals(province.getProvinceId()+"")) {
                user_city = province.getProvinceName();
                break;
            }
        }
        System.out.println("城市"+user_city);
        System.out.println("自我介绍"+user_introduce);

        new UserServiceImpl().updateUser(user_name, user_image, user_city, user_sex, user_introduce);

        //重定向用户信息详情展示页
        response.sendRedirect(request.getContextPath()+"/user/userparticulars.jsp");

    }

    /**
     * 根据用户id 获取用户信息
     * @param request
     * @param response
     */
    private void findByIdUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // String user_id = request.getParameter("user_id");
        Map<String, Object> userMapS = (Map<String, Object>) request.getSession().getAttribute("userMap");
        String user_id = (String) userMapS.get("user_id");
        System.out.println(user_id);
        Map<String, Object> userMap = new UserServiceImpl().findByIdUser(user_id);

        String user_image = (String) userMap.get("user_image");
        //System.out.println(user_image);
        if (user_image == null || user_image.length() == 0) {
            System.out.println("为空");
            userMap.put("user_image", "https://travelremark.oss-cn-beijing.aliyuncs.com/remarkImage/5f7dd1625c21457bb1c19b938b7c6faa.png");
        }
        //https://travelremark.oss-cn-beijing.aliyuncs.com/remarkImage/5f7dd1625c21457bb1c19b938b7c6faa.png

        System.out.println("用户信息" + userMap);
        //获取所有省份
        List<Province> provinceList = new ProvinceServiceImpl().findAllProvince();

        //存值
        request.setAttribute("userMap",userMap);
        request.setAttribute("provinceList", provinceList);

        //转向到编辑个人信息页面
        request.getRequestDispatcher("/user/userset.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
