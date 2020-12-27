package com.itheruan.dao.msyqldao.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itheruan.dao.msyqldao.IUserDao;
import com.itheruan.utils.JDBCUtils;
import com.itheruan.utils.UuidUtil;


/**
 * 用户dao实现类
 * @author 11137
 *
 */
public class UserDaoImpl implements IUserDao{
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

	/**
	 * 根据用户id查询用户
	 * @param userId
	 * @return
	 */
	@Override
	public Map<String, Object> findByIdUser(String userId) {
		try {
			String sql = "select * from user where user_id =  ?";
			return jdbcTemplate.queryForMap(sql, userId);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 注册用户
	 * 
	 * @param user_name
	 * @param user_password
	 * @param user_email
	 */
	@Override
	public void saveUser(String user_id,String user_name, String user_password, String user_email,String user_state,Date user_time) {
		// TODO Auto-generated method stub
		String sql = "insert into user(user_id,user_name,user_password,user_email,user_state,user_time) values (?,?,?,?,?,?)";
		//设置激活状态为0（未激活）
		 jdbcTemplate.update(sql, user_id,user_name,user_password,user_email,user_state,user_time);
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
		
		try {
			String sql = "select * from user where user_name = ? and user_password = ?";		
			return	jdbcTemplate.queryForMap(sql,user_name,user_password);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	
	/**
	 * 根据用户名查询用户
	 * @param user_name
	 * @return
	 */
	@Override
	public Map<String, Object> findByNameUser(String user_name) {
		try {
			String sql = "select * from user where user_name = ?";		
			return	jdbcTemplate.queryForMap(sql,user_name);
		} catch (DataAccessException e) {
			return null;
		}
		
	}
	
	

	
	/**
	 * 根据用户id查询关注的用户
	 * 
	 * @param attention_noticer_user_id
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findAllAttention(String attention_noticer_user_id) {
		try {
			String sql = "select a.attention_id,a.attention_time,c.* from userattention a \r\n" + 
					" left join user c on a.attention_passive_user_id =c.user_id  WHERE attention_noticer_user_id = ?";
			return jdbcTemplate.queryForList(sql,attention_noticer_user_id);
		} catch (DataAccessException e) {
			return null;
		}
	}


	/**
	 * 根据用户id查询黑名单的用户
	 * 
	 * @param userblacklist_fa_user_id
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findAllBlacklist(String userblacklist_fa_user_id) {
		try {
			String sql = "select a.userblacklist_id,c.* from userblacklist a \r\n" + 
					" left join user c on a.userblacklist_bei_user_id =c.user_id  WHERE userblacklist_fa_user_id = ?";
			return jdbcTemplate.queryForList(sql,userblacklist_fa_user_id);
		} catch (DataAccessException e) {
			return null;
		}
	}

	
	/**
	 * 根据用户id查询收藏的点评
	 * 
	 * @param userremarkcollect_user_id
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findAllRemarkCollect(String userremarkcollect_user_id) {
		try {
			String sql = "SELECT * FROM user WHERE user_id in (SELECT userremarkcollect_remark_id from userremarkcollect WHERE userremarkcollect_user_id = ?) "; 
			return jdbcTemplate.queryForList(sql,userremarkcollect_user_id);
		} catch (DataAccessException e) {
			return null;
		}
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
		String sql = "update user set user_image = ? , user_city = ? , user_sex = ? , user_introduce = ? where user_name = ?";
		jdbcTemplate.update(sql, user_image, user_city, user_sex, user_introduce, user_name);
	}


}
