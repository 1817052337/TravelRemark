package com.itheruan.dao.msyqldao;

import com.mysql.jdbc.log.Log;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户dao接口
 * @author 11137
 *
 */
public interface IUserDao {

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
	void saveUser(String user_id,String user_name, String user_password, String user_email,String user_state,Date user_date);

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
	 * @param attention_noticer_user_id
	 * @return
	 */
	List<Map<String, Object>> findAllAttention(String attention_noticer_user_id);

	/**
	 * 根据用户id查询黑名单的用户
	 * 
	 * @param userblacklist_fa_user_id
	 * @return
	 */
	List<Map<String, Object>> findAllBlacklist(String userblacklist_fa_user_id);

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
