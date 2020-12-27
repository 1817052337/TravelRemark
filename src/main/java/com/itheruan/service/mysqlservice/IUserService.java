package com.itheruan.service.mysqlservice;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户业务层接口
 * @author 11137
 *
 */
public interface IUserService {

	/**
	 * 根据用户id查询用户
	 * @param userId
	 * @return
	 */
	Map<String, Object> findByIdUser(String userId);

	/**
	 * 注册用户
	 * 
	 * @param user_name
	 * @param user_password
	 * @param user_email
	 */
	void saveUser(String user_id,String user_name, String user_password, String user_email,String user_state);
	
	
	/**
	 * 将注册用户存入redis缓冲
	 * 
	 * @param user_name
	 * @param user_password
	 * @param user_email
	 */
	void saveRedisUser(String user_name, String user_password, String user_email,HttpServletRequest request);

	/**
	 * 用户登录
	 * 
	 * @param user_name
	 * @param user_password
	 * @return
	 */
	Map<String, Object> findByNameAndPasswordUser(String user_name, String user_password);
	
	
	/**
	 * 根据用户名查询用户
	 * @param user_name
	 * @return
	 */
	Map<String,Object> findByNameUser(String user_name);


	/**
	 * 根据用户id查询关注的用户
	 * 
	 * @param attention_passive_user_id
	 * @return
	 */
	List<Map<String, Object>> findAllAttention(String attention_passive_user_id);

	/**
	 * 根据用户id查询黑名单的用户
	 * 
	 * @param userblacklist_bei_user_id
	 * @return
	 */
	List<Map<String, Object>> findAllBlacklist(String userblacklist_bei_user_id);

	/**
	 * 根据用户id查询收藏的点评
	 * 
	 * @param userremarkcollect_user_id
	 * @return
	 */
	List<Map<String, Object>> findAllRemarkCollect(String userremarkcollect_user_id);
	
	
	/**
	 * 根据用户id查询收藏的景点
	 * 
	 * @param usertravelcollect_user_id
	 * @return
	 */
	List<Map<String, Object>> findAllTravelCollect(String usertravelcollect_user_id);


	/**
	 * 根据用户名修改个人信息
	 * @param user_name
	 * @param user_image
	 * @param user_city
	 * @param user_sex
	 * @param user_introduce
	 */
	void updateUser(String user_name, String user_image, String user_city, String user_sex, String user_introduce);
}
