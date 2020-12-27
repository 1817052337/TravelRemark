package com.itheruan.web.servlet.travelremark.remark;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheruan.domain.Remark.*;
import com.itheruan.domain.Travelremarklabel;
import com.itheruan.domain.Travelremarkmodule;
import com.itheruan.domain.regon.City;
import com.itheruan.service.mysqlservice.Impl.ModuleServiceImpl;
import com.itheruan.service.mysqlservice.Impl.ProvinceServiceImpl;
import com.itheruan.service.mysqlservice.Impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.itheruan.service.mysqlservice.Impl.RemarkServiceImpl;
import com.itheruan.utils.FileUtils;
import com.itheruan.utils.JsonUtil;
import com.itheruan.utils.UuidUtil;

@WebServlet("/travelremark/remark/remarkServlet.do")
public class RemarkServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menthod = request.getParameter("method");
        System.out.println(menthod);
        if ("saveRemark".equals(menthod)) {
            // 保存点评
            saveRemark(request, response);
        } else if ("findByIdRemark".equals(menthod)) {
            //根据id查询景点详情
            findByIdRemark(request, response);
        } else if ("saveRemarkComment".equals(menthod)) {
            //保存评论
            saveRemarkComment(request, response);
        } else if ("saveRemarkPraise".equals(menthod)) {
            //保存点赞
            saveRemarkPraise(request, response);
        }else if ("saveRemarkReport".equals(menthod)){
            //保存举报
            saveRemarkReport(request, response);
        }else if ("saveRemarkCollect".equals(menthod)){
            //保存收藏
            saveRemarkCollect(request, response);
        }else if ("saveRemarkShare".equals(menthod)){
            //保存分享
            saveRemarkShare(request, response);
        }
    }

    /**
     * 保存分享
     * @param request
     * @param response
     */
    private void saveRemarkShare(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取点评id
        String remarkId = request.getParameter("remarkId");
        Map<String, Object> userMap = (Map<String, Object>) request.getSession().getAttribute("userMap");
        //获取用户id
        String userId = (String) userMap.get("user_id");

        Remarkshare remarkshare = new Remarkshare();
        remarkshare.setRemarkshareTime(new Date());
        remarkshare.setRemarkshareRemarkId(remarkId);
        remarkshare.setRemarkshareUserId(userId);
        //调用service方法进行保存
        new RemarkServiceImpl().saveRemarkShare(remarkshare);

        JsonUtil.writeValue(true, response);
    }

    /**
     * 保存收藏
     * @param request
     * @param response
     */
    private void saveRemarkCollect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取点评id
        String remarkId = request.getParameter("remarkId");
        Map<String, Object> userMap = (Map<String, Object>) request.getSession().getAttribute("userMap");
        //获取用户id
        String userId = (String) userMap.get("user_id");

        Remarkcollect remarkcollect = new Remarkcollect();
        remarkcollect.setRemarkcollectRemarkId(remarkId);
        remarkcollect.setRemarkcollectTime(new Date());
        remarkcollect.setRemarkcollectUserId(userId);

        //调用service方法进行保存
        new RemarkServiceImpl().saveremarkcollect(remarkcollect);

        JsonUtil.writeValue(true, response);
    }

    /**
     * 保存举报
     * @param request
     * @param response
     */
    private void saveRemarkReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取点评id
        String remarkId = request.getParameter("remarkId");
        Map<String, Object> userMap = (Map<String, Object>) request.getSession().getAttribute("userMap");
        //获取用户id
        String userId = (String) userMap.get("user_id");
        //获取举报原因
        String remarkreport_text = request.getParameter("remarkreport_text");

        Remarkreport remarkreport = new Remarkreport();
        remarkreport.setRemarkreportText(remarkreport_text);
        remarkreport.setRemarkreportTime(new Date());
        remarkreport.setRemarkreportUserId(userId);
        remarkreport.setRemarkreportRemarkId(remarkId);

        //调用service方法进行保存
        new RemarkServiceImpl().saveRemarkreport(remarkreport);

        JsonUtil.writeValue(true, response);
    }

    /**
     * 保存点赞
     * @param request
     * @param response
     */
    private void saveRemarkPraise(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取点评id
        String remarkId = request.getParameter("remarkId");
        Map<String, Object> userMap = (Map<String, Object>) request.getSession().getAttribute("userMap");
        //获取用户id
        String userId = (String) userMap.get("user_id");

        Remarkpraise remarkpraise = new Remarkpraise();
        remarkpraise.setRemarkpraiseRemarkId(remarkId);
        remarkpraise.setRemarkpraiseUserId(userId);
        remarkpraise.setRemarkpraiseTime(new Date());

        //调用service方法进行保存
        new RemarkServiceImpl().saveRemarkPraise(remarkpraise);

        JsonUtil.writeValue(true, response);
    }

    /**
     * 保存评论
     *
     * @param request
     * @param response
     */
    private void saveRemarkComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String remarkCommentText = request.getParameter("remarkComment");
        System.out.println("评论" + remarkCommentText);
        String remarkId = request.getParameter("remarkId");
        System.out.println("id" + remarkId);
        Map<String, Object> userMap = (Map<String, Object>) request.getSession().getAttribute("userMap");
        //获取用户id
        String userId = (String) userMap.get("user_id");

        //从session中获取地区信息
        City city = (City) request.getSession().getAttribute("city");
        int cityId = Integer.parseInt(city.getCityId());

        //将数据保存到实体类中
        Remarkcomment remarkcomment = new Remarkcomment();
        remarkcomment.setRemarkcommentText(remarkCommentText);
        remarkcomment.setRemarkcommentTime(new Date());
        remarkcomment.setRemarkcommentUserId(userId);
        remarkcomment.setRemarkcommentRemarkId(remarkId);
        new RemarkServiceImpl().saveRemarkcomment(remarkcomment, cityId);

        JsonUtil.writeValue(true, response);
    }

    /**
     * 保存点评
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws Exception
     */
    private void saveRemark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 标题
        String remark_title = request.getParameter("remark_title");
        // 点评的内容 存储的是文件名称（点评中的字数不得小于100字）
        String remark_text = uploadImage(request, request.getParameter("remark_text"));
        // 关联的地区id
        String areaId = request.getParameter("areaId");
        //System.out.println("地区id" + areaId);
        // 景点名称
        String remark_travel = request.getParameter("remark_travel");
        // 总评分
        String remark_allgrade = request.getParameter("remark_allgrade");
        // 环境评分
        String remark_environmentgrade = request.getParameter("remark_environmentgrade");
        // 服务评分
        String remark_servegrade = request.getParameter("remark_servegrade");
        // 点评发布时间
        Date remark_time = new Date();
        // 点评所属的模块
        String remark_travel_module_id = request.getParameter("remark_travel_module");
        ModuleServiceImpl moduleService = new ModuleServiceImpl();
        List<Travelremarkmodule> module = moduleService.findAllModule();
        String remark_travel_module = "";
        for (Travelremarkmodule travelremarkmodule : module) {
            if (travelremarkmodule.getTravelremarkmoduleId() == Integer.parseInt(remark_travel_module_id)) {
                remark_travel_module = travelremarkmodule.getTravelremarkmoduleName();
                break;
            }
        }
        // 点评所属的标签
        String remark_travel_label_id = request.getParameter("remark_travel_label");
       String remark_travel_label = "";
        for (Travelremarklabel travelremarklabel : moduleService.findAllLabel()) {
            if (travelremarklabel.getTravelremarklabelId() == Integer.parseInt(remark_travel_label_id)) {
                remark_travel_label = travelremarklabel.getTravelremarklabelName();
                break;
            }
        }

        // 发布点评的用户
        Map<String, Object> userMap = (Map<String, Object>) request.getSession().getAttribute("userMap");
        String user_id = (String) userMap.get("user_id");

        RemarkServiceImpl remarkServiceImpl = new RemarkServiceImpl();
        // 保存景点信息数据
        Remark remark = new Remark();
        String remarkId = UuidUtil.getUuid();
        remark.setRemarkId(remarkId);
        remark.setRemarkText(remark_text);
        remark.setRemarkTitle(remark_title);
        remark.setRemarkEnvironmentgrade(remark_environmentgrade);
        remark.setRemarkServegrade(remark_servegrade);
        // 保存时间
        remark.setRemarkTime(remark_time);
        remark.setRemarkAllgrade(remark_allgrade);
        remark.setRemarkNum(0);
        remark.setRemarkEnvironmentgrade(remark_environmentgrade);
        remark.setRemarkServegrade(remark_servegrade);
        remark.setRemarkTravelModule(remark_travel_module);
        remark.setRemarkTravelLabel(remark_travel_label);
        remark.setRemarkAreaId(Integer.parseInt(areaId));
        remark.setRemarkUserId(user_id);
        System.out.println(remark);

        //获取点评所关联的城市id
        int cityId = Integer.parseInt(request.getParameter("cityId"));
        remarkServiceImpl.saveremark(remark, cityId);


        String saveImage = request.getParameter("image");

        String[] split = saveImage.split(",");
        List<Remarkimage> remarkimages = new ArrayList<Remarkimage>();
        for (String imagepath : split) {
            //System.out.println(imagepath);
            Remarkimage remarkimage = new Remarkimage();
            String imageName = FileUtils.upload(imagepath.trim(), "remarkImage/" + UuidUtil.getUuid());
            remarkimage.setRemarkimageName(imageName);
            remarkimages.add(remarkimage);
            remarkimage.setRemarkimageUserId(user_id);
            remarkimage.setRemarkimageRemarkId(remarkId);
            System.out.println(imageName);
        }

        // 获取图片集合
        // 保存图片
        // List<Remarkimage> remarkimageList = new ArrayList<Remarkimage>();
        /*
         * List<String> list = new ArrayList<String>(); String[] saveImage =
         * request.getParameterValues("image"); for (String imagepath : saveImage) {
         * System.out.println(imagepath); Remarkimage remarkimage = new Remarkimage();
         * String imageName = FileUtils.upload(imagepath, "remarkImage/" +
         * UuidUtil.getUuid() + ".png"); list.add(imageName);
         *
         * }
         */

        remarkServiceImpl.saveRemarkimageList(remarkimages, cityId);

        boolean flag = true;
        Object[] data = {flag, remarkId};
        JsonUtil.writeValue(data, response);
        //重定向
        //request.getRequestDispatcher("/travelremark/remark/remark_write_ok.jsp").forward(request, response);
        //response.sendRedirect(request.getContextPath()+"/travelremark/remark/remark_write_ok.jsp");
    }

    /**
     * 根据id查询点评详情
     *
     * @param request
     * @param response
     */
    private void findByIdRemark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取点评id
        //获取传递的点评id
        String remarkId = request.getParameter("remarkId");

        RemarkServiceImpl remarkService = new RemarkServiceImpl();

        //从session中获取地区信息
        City city = (City) request.getSession().getAttribute("city");
        //city.setCityId("1");
        int cityId = Integer.parseInt(city.getCityId());

        //获取当前点评所属的城市id
        //Integer.parseInt(city.getCityId())
        List<Remark> allRemark = remarkService.findAllRemark(cityId);
        Remark remarkZ = null;
        for (Remark remark : allRemark) {
            if (remark.getRemarkId().equals(remarkId)) {
                remarkZ = remark;
                break;
            }
        }
        //   System.out.println("最终的城市" + remarkZ);
        List<String> list = new ArrayList<>();
        list.add(remarkZ.getRemarkId());
        //查询点评图片
        List<Remarkimage> remarkImageList = remarkService.findAllRemarkimag(list, cityId).get(0);
        //  System.out.println("图片的集合" + remarkImageList);
        //查询点评的评论
        List<Remarkcomment> remarkCommentList = remarkService.findAllRemarkcomment(list, cityId).get(0);
//        System.out.println(remarkCommentList);

        for (Remarkcomment remarkcomment : remarkCommentList) {
            //根据用户id查询用户信息
            Map<String, Object> byIdUser = new UserServiceImpl().findByIdUser(remarkcomment.getRemarkcommentUserId());
            //存入到评论集合中
            //System.out.println("用户"+byIdUser);
            remarkcomment.setUserMap(byIdUser);
        }

        //查询用户信息
        Map<String, Object> user = new UserServiceImpl().findByIdUser(remarkZ.getRemarkUserId());

        //根据路径，从阿里云oos中下载点评内容
        String download = FileUtils.download(remarkZ.getRemarkText());
        remarkZ.setRemarkText(download);

        String user_id = (String) user.get("user_id");
        //点评是否被该用户收藏
        Remarkcollect flagRemarkcollect = remarkService.findByRemarkIdAndUserIdRemarkCollect(user_id, remarkId);
        if (flagRemarkcollect == null) {
            //没有收藏
            remarkZ.setFlagCollect(false);
        }else {
            //收藏了
            remarkZ.setFlagCollect(true);
        }

        //点评是否被该用户点赞
        Remarkpraise flagRemarkPraise = remarkService.findByRemarkIdAndUserIdRemarkPraise(user_id, remarkId);
        if (flagRemarkcollect == null) {
            //没有收藏
            remarkZ.setFlagCollect(false);
        }else {
            //收藏了
            remarkZ.setFlagCollect(true);
        }

        //存储数据
        //点评
        request.setAttribute("remark", remarkZ);
        //图片
        request.setAttribute("remarkImageList", remarkImageList);
        //评论
        request.setAttribute("remarkCommentList", remarkCommentList);
        //用户
        request.setAttribute("user", user);

        //跳转到详情页
        request.getRequestDispatcher("/travelremark/remark/remark_particulars.jsp").forward(request, response);

    }


    /**
     * 上传文件
     *
     * @param request
     * @param remark_text
     * @return
     * @throws ServletException
     * @throws IOException
     */
    private String uploadImage(HttpServletRequest request, String remark_text) throws ServletException, IOException {

        // 设置文件上传的位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploadImages");
        // System.out.println(realPath);
        // 判断是否有该文件夹
        File file = new File(realPath);
        if (!file.exists()) {
            // 文件夹为空，创建该文件夹
            file.mkdir();
        }

        // 创建ServletFileUpload解析器
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());

        // 处理中文乱码
        servletFileUpload.setHeaderEncoding("utf-8");
        String fileName = UuidUtil.getUuid() + ".txt";
        String filePath = realPath + "/" + fileName;
        FileWriter fw = new FileWriter(filePath);
        //FileOutputStream fos = new FileOutputStream();
        fw.write(remark_text);
        fw.close();
        // 阿里云进行存储
        String fileTextName = "remarktext/" + fileName;
        FileUtils.Fileupload(filePath, fileTextName);
        return fileTextName;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
