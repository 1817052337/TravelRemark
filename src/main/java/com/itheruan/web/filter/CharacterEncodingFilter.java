package com.itheruan.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheruan.utils.Error;
import com.itheruan.utils.JedisUtil;

import redis.clients.jedis.Jedis;

/**
 * 编码过滤器 
 * 
 * @author 11137
 *
 */
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		// 1.获取request和response对象
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		// 2.设定编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
	
	

		
		// 3.放行
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// System.out.println("CharacterEncodingFilter--->销毁");
	}
}
