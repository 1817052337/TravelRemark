package com.itheruan.web.servlet.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.elasticsearch.common.metrics.EWMA;

import com.itheruan.domain.ResultInfo;
import com.itheruan.service.mysqlservice.Impl.UserServiceImpl;
import com.itheruan.utils.JedisUtil;
import com.itheruan.utils.JsonUtil;

/**
 * 用户表现层实现类
 * @author 11137
 *
 */
@WebServlet("/user/userservlet.do")
public class UserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String menthod = request.getParameter("method");

		if (menthod.equals("regist")) {
			// 注册
			register(request, response);
		} else if (menthod.equals("regist_user_name")) {
			// 判断用户名是否存在
			regist_user_name(request, response);
		}

		else if (menthod.equals("verifycode")) {
			// 判断激活码是否存在
			verifyCode(request, response);
		} else if (menthod.equals("login")) {
			// 登录
			login(request, response);
		}else if (menthod.equals("judgeuser")) {
			// 判断用户是否登录
			judgeuser(request, response);
		}
	}
	
	/**
	 * 判断用户是否登录
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void judgeuser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> userMap = (Map<String, Object>) request.getSession().getAttribute("userMap");
		
		if (userMap==null) {
			//没有登录
			//跳转到登录页面
			response.sendRedirect(request.getContextPath()+"/user/login.jsp");
		}else {
			//跳转到详情页
			response.sendRedirect(request.getContextPath()+"/user/userparticulars.jsp");
		}
	}

	/**
	 * 登录模块
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		//System.out.println(user_name);
		
		// 调用service方法
		Map<String, Object> userMap = new UserServiceImpl().findByNameAndPasswordUser(user_name, user_password);
		System.out.println(userMap);
		if (userMap == null) {
			ResultInfo info = new ResultInfo();
			// 注册失败
			info.setFlag(false);
			info.setErrorMsg("用户名或密码错误");
			JsonUtil.writeValue(info, response);
		} else {
			// 正确
			//将用户存入到session域中
			request.getSession().setAttribute("userMap", userMap);


			//重定向首页
			//response.sendRedirect(request.getContextPath()+"/homeServlet?city="+sessionCityName);
			request.getRequestDispatcher("/index.jsp").forward(request,response);
			/*
			 * ResultInfo info = new ResultInfo(); // 注册失败 info.setFlag(true);
			 * JsonUtil.writeValue(info, response);
			 */
		}


	}

	/**
	 * 判断激活码是否存在
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void verifyCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String code = request.getParameter("user_code");
		String user_id = request.getParameter("user_id");
		System.out.println(code);
		System.out.println(user_id);
		// 获取redis缓冲中的
		String user_code = JedisUtil.getJedis().get(user_id + "code");
		System.out.println(user_code);

		if (user_code != null) {
			if (user_code.equals(code)) {

				// 激活成功
				// 删除redis缓冲中的激活码
				JedisUtil.getJedis().del(user_id + "code");   
				
				//获取redis缓冲中用户注册信息
				String user_name = JedisUtil.getJedis().get(user_id + "user_name");
				String user_password = JedisUtil.getJedis().get(user_id + "user_password");
				String user_email = JedisUtil.getJedis().get(user_id + "user_email");
				// 保存用户注册信息到数据库中
				new UserServiceImpl().saveUser(user_id, user_name, user_password, user_email, "1");
				System.out.println("跳转");
				// 跳转到登录页面
				request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			} else {
				// 激活失败 跳转到一个失败页面
				
			}

		}

	}

	/**
	 * 校验用户名是否重复
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void regist_user_name(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		// ajax异步判断用户名是否存在
		String user_name = request.getParameter("user_name");
		System.out.println(user_name);
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		Map<String, Object> userMap = userServiceImpl.findByNameUser(user_name);
		if (userMap != null) {
			// 用户名存在

			ResultInfo info = new ResultInfo();
			// 注册失败
			info.setFlag(false);
			info.setErrorMsg("用户名存在,请换一个");
			JsonUtil.writeValue(info, response);

		}
	}

	/**
	 * 注册模块
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 当用户名为空时，判断验证码是否正确
		String user_code = request.getParameter("user_code");
		// 从sesion中获取验证码
		HttpSession session = request.getSession();
		String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
		session.removeAttribute("CHECKCODE_SERVER");// 为了保证验证码只能使用一次
		// 比较
		if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(user_code)) {
			// 验证码错误
			ResultInfo info = new ResultInfo();
			// 注册失败
			info.setFlag(false);
			info.setErrorMsg("验证码错误");
			JsonUtil.writeValue(info, response);
			return;
		}

		UserServiceImpl userServiceImpl = new UserServiceImpl();
		System.out.println("往下输入");
		// 当用户名和密码都正确时，调用service方法发送激活邮件，同时保存注册信息
		// 获取参数
		String user_password = request.getParameter("user_password");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		System.out.println(user_email);
		userServiceImpl.saveRedisUser(user_name, user_password, user_email, request);
		// 注册成功
		ResultInfo info = new ResultInfo();
		// 注册失败
		info.setFlag(true);
		JsonUtil.writeValue(info, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
