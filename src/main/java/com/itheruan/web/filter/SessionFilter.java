package com.itheruan.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheruan.utils.Error;
import com.itheruan.utils.JedisUtil;

import redis.clients.jedis.Jedis;

/**
 * url过滤器
 * 
 * @author 11137
 *
 */
@WebFilter("/travelremark/*")
public class SessionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// System.out.println("SessionFilter-->初始化");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		// System.out.println("SessionFilter开始工作...");
		//System.out.println("过滤器开始工作");
		// 1.获取request对象和response对象
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		/*
		 * // 获取用户ip String userIp = request.getRemoteAddr(); Jedis jedis =
		 * JedisUtil.getJedis();
		 * 
		 * // 从redis获取ip String user = jedis.get(userIp); String userIpho = userIp +
		 * "ho"; if (user == null) { //System.out.println("第一次访问"); // 后缀 // String sql
		 * = request.getContextPath();
		 * 
		 * // 获取计数 String index = jedis.get(userIpho); if (index == null ||
		 * index.length() == 0) { System.out.println("不存在计数"); // 不存在计数
		 * jedis.set(userIpho, "1"); } else { // 存在之前访问的计数 // 删除在写 jedis.del(userIpho);
		 * jedis.set(userIpho, "1"); } //设置时间 jedis.setex(userIp, 10, "1");
		 * 
		 * 
		 * } else if (Integer.parseInt(jedis.get(userIpho)) > 10) {
		 * System.out.println("限制访问次数"); // 限制访问 跳转错误页面 Error.getError(request,
		 * response, "你访问的次数太多，请稍等片刻重试"); return;
		 * 
		 * } else { // 计数加1 int count = (Integer.parseInt(jedis.get(userIpho))) + 1;
		 * jedis.set(userIpho, count + ""); //System.out.println("当前访问次数" + count);
		 * 
		 * }
		 */
   
		// 2.针对特权页面放行
		String path = request.getServletPath();
		//System.out.println("path--->" + path);
		if (("/user/login.jsp".equals(path)) || ("/user/userservlet.do".equals(path)) || ("/homeServlet".equals(path)) ) {
			// System.out.println("当前是特权页面，请放行");
			chain.doFilter(request, response);
			return;
		}
		// 3.过滤session
		HttpSession session = request.getSession();
		if (session.getAttribute("userMap") == null) {
			// System.out.println("您还没有登录");
//		  String errorMsg="您还没有登录，请输入您的账号和密码";
//		  request.setAttribute("error", errorMsg);
//		  request.getRequestDispatcher("/manage/error.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/user/login.jsp");
			return;
		} else {
			// System.out.println("过滤通过了");
			// 放行
			chain.doFilter(request, response);
			return;
		}

	}

	@Override
	public void destroy() {
		// System.out.println("SessionFilter销毁...");
	}

}
