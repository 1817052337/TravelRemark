package com.itheruan.service.mysqlservice.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.itheruan.dao.msyqldao.Impl.UserDaoImpl;
import com.itheruan.domain.User;
import com.itheruan.service.mysqlservice.IUserService;
import com.itheruan.utils.JedisUtil;
import com.itheruan.utils.MailUtils;
import com.itheruan.utils.Md5Utils;
import com.itheruan.utils.UuidUtil;

/**
 * 用户业务层实现类
 * 
 * @author 11137
 *
 */
public class UserServiceImpl implements IUserService {


	/**
	 * 根据用户id查询用户
	 * @param userId
	 * @return
	 */
	@Override
	public Map<String, Object> findByIdUser(String userId) {
		return new UserDaoImpl().findByIdUser(userId);
	}

	/**
	 * 注册用户
	 * 
	 * @param user_name
	 * @param user_password
	 * @param user_email
	 */
	@Override
	public void saveUser(String user_id,String user_name, String user_password, String user_email,String user_state) {
		//加密码进行加密
		user_password = Md5Utils.getMd5(user_password);
		
		new UserDaoImpl().saveUser(user_id, user_name, user_password, user_email, user_state,new Date());
		
	}

	/**
	 * 将注册用户存入redis缓冲
	 * 
	 * @param user_name
	 * @param user_password
	 * @param user_email
	 */
	@Override
	public void saveRedisUser(String user_name, String user_password, String user_email, HttpServletRequest request) {
	
		// 生成唯一id
		String user_id = UuidUtil.getUuid();

		// 生成激活码 设置存活时间为5分钟 存入到redis缓冲中
		String user_code = UuidUtil.getUuid();
		JedisUtil.getJedis().setex(user_id + "code", 60 * 5, user_code);
		//将用户注册信息存入到缓存
		JedisUtil.getJedis().setex(user_id + "user_name", 60 * 5, user_name);
		JedisUtil.getJedis().setex(user_id + "user_password", 60 * 5, user_password);
		JedisUtil.getJedis().setex(user_id + "user_email", 60 * 5, user_email);
		// 3.激活邮件发送，邮件正文？

		String content = "<a href='http://localhost:10000/TravelRemark/user/userservlet.do?method=verifycode&user_code="
				+ user_code + "&user_id=" + user_id + "'>点击激活【旅途点评】</a>";

		MailUtils.sendMail(user_email, content, "激活邮件");
	}

	/**
	 * 用户登录
	 * 
	 * @param user_name
	 * @param user_password
	 * @return
	 */
	@Override
	public Map<String, Object> findByNameAndPasswordUser(String user_name, String user_password) {
		// TODO Auto-generated method stub
		//进行加密
		user_password = Md5Utils.getMd5(user_password);
		return new UserDaoImpl().findByNameAndPasswordUser(user_name, user_password);
	}

	/**
	 * 根据用户名查询用户
	 * 
	 * @param user_name
	 * @return
	 */
	@Override
	public Map<String, Object> findByNameUser(String user_name) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().findByNameUser(user_name);
	}


	/**
	 * 根据用户id查询关注的用户
	 * 
	 * @param attention_passive_user_id
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findAllAttention(String attention_passive_user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据用户id查询黑名单的用户
	 * 
	 * @param userlacklist_bei_user_id
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findAllBlacklist(String userlacklist_bei_user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据用户id查询收藏的点评
	 * 
	 * @param userremarkcollect_user_id
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findAllRemarkCollect(String userremarkcollect_user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据用户id查询收藏的景点
	 * 
	 * @param usertravelcollect_user_id
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findAllTravelCollect(String usertravelcollect_user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据用户名修改个人信息
	 * @param user_name
	 * @param user_image
	 * @param user_city
	 * @param user_sex
	 * @param user_introduce
	 */
	@Override
	public void updateUser(String user_name, String user_image, String user_city, String user_sex, String user_introduce) {
		new UserDaoImpl().updateUser(user_name, user_image, user_city, user_sex, user_introduce);
	}

}
