package com.itheruan.dao.msyqldao.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.itheruan.domain.Remark.*;
import com.itheruan.domain.travel.TravelsceniccommentZiReport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itheruan.dao.msyqldao.IRemarkDao;
import com.itheruan.domain.regon.Area;
import com.itheruan.domain.regon.City;
import com.itheruan.domain.regon.Province;
import com.itheruan.utils.JDBCUtils;

public class RemarkDaoImpl implements IRemarkDao {
	/*public static void main(String[] args) {
		List<Remark> allRemark = new RemarkDaoImpl().findAllRemark(1);
		System.out.println(allRemark);
	}*/
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
	

	/**
	 * 1.查询所有点评
	 * @return
	 */
	
	public List<Remark> findAllRemark(int cityId) {
		List<Area> areas = new ProvinceDaoImpl().findByCity(cityId);
		String sql = "select * from remark where remark_area_id = ?";
		List<Remark> remarkList = new ArrayList<>();
		for (Area area : areas) {
			List<Remark> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Remark>(Remark.class),area.getAreaId());
			//query.forEach(n ->);
			for (Remark remark : query) {
				remarkList.add(remark);
			}
		}
		return remarkList;
	}

	/**
	 * 2.根据id查询点评收藏数量
	 * @return
	 */
	public List<Long> findAllRemarkcollect(List<String> remarkIdList) {
		String sql = "select count(*) from remarkcollect where remarkcollect_remark_id = ?";
		List<Long> list = new ArrayList<Long>();
		for (String remarkId : remarkIdList) {
			System.out.println(remarkId);
			Long l=  jdbcTemplate.queryForObject(sql, Long.class,remarkId);
			list.add(l);
		}
		return list;
	}

	/**
	 * 3.根据id查询点评点赞的数量
	 * @param remarkIdList
	 * @return
	 */
	public List<Long> findAllRemarkpraise(List<String> remarkIdList) {
		String sql ="select count(*) from remarkpraise where remarkpraise_remark_id=?";
		List<Long> list = new ArrayList<Long>();
		for (String remarkId : remarkIdList) {
			Long l=  jdbcTemplate.queryForObject(sql, Long.class,remarkId);
			list.add(l);
			//System.out.println(l);
		}
		return list;
	}

	/**
	 * 4.根据id查询点评图片
	 * @return
	 */
	public List<List<Remarkimage>> findAllRemarkimag(List<String> remarkIdList) {
		String sql = "select * from remarkimage where remarkimage_remark_id=?";
		List<List<Remarkimage>> list = new ArrayList<List<Remarkimage>>();
		
		for (String remarkId : remarkIdList) {
			System.out.println(remarkId);
			List<Remarkimage> query =jdbcTemplate.query(sql,new BeanPropertyRowMapper<Remarkimage>(Remarkimage.class),remarkId);
			list.add(query);
		}
		
		return list;
	}
	
	/**
	 * 5.根据id查询点评分享数量
	 * @return
	 */
	public List<Long> findAllRemarkshare(List<String> remarkIdList) {
		String sql ="select count(*) from remarkshare where remarkshare_remark_id=?";
		List<Long> list = new ArrayList<Long>();
		for (String remarkId : remarkIdList) {
			Long l=  jdbcTemplate.queryForObject(sql, Long.class,remarkId);
			//System.out.println(l);
			list.add(l);
		}
		
		return list;
	}
	
	/**
	 * 6.根据id查询点评评论
	 * @return
	 */
	public List<List<Remarkcomment>> findAllRemarkcomment(List<String> remarkIdList) {
		String sql = "select * from remarkcomment where remarkcomment_remark_id=?";
		List<List<Remarkcomment>> list = new ArrayList<List<Remarkcomment>>();
		
		for (String remarkId : remarkIdList) {
			List<Remarkcomment> query =jdbcTemplate.query(sql,new BeanPropertyRowMapper<Remarkcomment>(Remarkcomment.class),remarkId);
			list.add(query);
		}
		
		return list;
	}
	
	/**
	 * 7.根据id查询点评评论的点赞数量
	 * @return
	 */
	public List<Long> findAllRemarkcommentZiPraise(List<Integer> RemarkcommentIdList) {
		String sql ="select count(*) from remarkcomment_zi_praise where remarkcomment_zi_praise_rc_id=?";
		List<Long> list = new ArrayList<Long>();
		for (Integer commentId : RemarkcommentIdList) {
			Long l=  jdbcTemplate.queryForObject(sql, Long.class,commentId);
			//System.out.println(l);
			list.add(l);
		}
		
		return list;
	}
	

	/**
	 * 8.根据id查询点评评论的评论
	 * @return
	 */
	public List<RemarkcommentZiComment> findAllRemarkcommentZiComment(int RemarkcommentId) {
		String sql = "select * from remarkcomment_zi_comment where remarkcomment_zi_comment_rc_id=?";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<RemarkcommentZiComment>(RemarkcommentZiComment.class),RemarkcommentId);
		
	}
	
	/**
	 * 9.根据id查询点评评论的点赞数量
	 * @param RemarkcommentZiCommentIdList
	 * @return
	 */

	public List<Long> findAllTravelScenicCommentZiComment(List<Integer> RemarkcommentZiCommentIdList) {
		try {
			String sql ="select count(*) from remarkcomment_zi_comment_praise where rc_zi_praise_c_id=?";
			List<Long> list = new ArrayList<Long>();
			for (Integer commentId : RemarkcommentZiCommentIdList) {
				Long l=  jdbcTemplate.queryForObject(sql, Long.class,commentId);
				//System.out.println(l);
				list.add(l);
			}
			return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据用户id和点评id查询该用户对这条点评是否进行收藏
	 * @param userId
	 * @param remarkId
	 * @return
	 */
	@Override
	public Remarkcollect findByRemarkIdAndUserIdRemarkCollect(String userId, String remarkId) {
		try {
			String sql = "select * from remarkcollect where remarkcollect_user_id =  ? and remarkcollect_remark_id  = ?";
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Remarkcollect.class), userId, remarkId);
		} catch (DataAccessException e) {
			return null;
		}
	}

	/**
	 * 根据用户id和点评id查询该用户对这条点评是否进行点赞
	 * @param userId
	 * @param remarkId
	 * @return
	 */
	@Override
	public Remarkpraise findByRemarkIdAndUserIdRemarkPraise(String userId, String remarkId) {
		try {
			String sql = "select * from remarkpraise where remarkpraise_user_id =  ? and remarkpraise_remark_id  = ?";
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Remarkpraise.class), userId, remarkId);
		} catch (DataAccessException e) {
			return null;
		}
	}

	/**
	 * 根据用户id和点评id查询该用户对这条点评是否进行举报
	 * @param userId
	 * @param remarkId
	 * @return
	 */
	@Override
	public Remarkreport findByRemarkIdAndUserIdRemarkReport(String userId, String remarkId) {
		try {
			String sql = "select * from remarkreport where remarkreport_user_id =  ? and remarkreport_remark_id  = ?";
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Remarkreport.class), userId, remarkId);
		} catch (DataAccessException e) {
			return null;
		}
	}


	/**
	 * 10.保存点评
	 * @param remark
	 */

	public void saveremark(Remark remark) {

		String sql="insert into remark(remark_id,remark_text,remark_title,remark_environmentgrade,remark_servegrade,remark_allgrade,remark_time,remark_num,remark_travel_module,remark_travel_label,remark_user_id,remark_area_id) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql, remark.getRemarkId(),remark.getRemarkText(),remark.getRemarkTitle(),remark.getRemarkEnvironmentgrade(),remark.getRemarkServegrade(),remark.getRemarkAllgrade()
							,remark.getRemarkTime(),remark.getRemarkNum(),remark.getRemarkTravelModule(),remark.getRemarkTravelLabel(),remark.getRemarkUserId(),remark.getRemarkAreaId());
		
	}

	/**
	 * 11.保存点评收藏
	 * @param remarkcollect
	 */
	public void saveremarkcollect(Remarkcollect remarkcollect) {
		String sql ="insert into remarkcollect(remarkcollect_time,remarkcollect_user_id,remarkcollect_remark_id)values(?,?,?)";
		jdbcTemplate.update(sql,remarkcollect.getRemarkcollectTime(),remarkcollect.getRemarkcollectUserId(),remarkcollect.getRemarkcollectRemarkId());
		
	}
	
	/**
	 * 12.保存点评图片
	 * @param RemarkimageList
	 */
	public void saveRemarkimageList(List<Remarkimage> RemarkimageList) {
		String sql ="insert into remarkimage(remarkimage_name,remarkimage_user_id,remarkimage_remark_id) values (?,?,?)";
		for (Remarkimage remarkimage : RemarkimageList) {
			jdbcTemplate.update(sql,remarkimage.getRemarkimageName(),remarkimage.getRemarkimageUserId(),remarkimage.getRemarkimageRemarkId());
		}
	}


	/**
	 * 13.保存点评分享
	 * @param remarkshare
	 */
	public void saveRemarkShare(Remarkshare remarkshare) {
		String sql ="insert into remarkshare(remarkshare_time,remarkshare_user_id,remarkshare_remark_id) values(?,?,?)";
		jdbcTemplate.update(sql, remarkshare.getRemarkshareTime(),remarkshare.getRemarkshareUserId(),remarkshare.getRemarkshareRemarkId());
	}

	/**
	 * 14.保存点评举报
	 * @param Remarkreport
	 */
	public void saveRemarkreport(Remarkreport Remarkreport) {

		String sql = "insert into remarkreport(remarkreport_text,remarkreport_time,remarkreport_user_id,remarkreport_remark_id) values(?,?,?,?)";
		jdbcTemplate.update(sql,Remarkreport.getRemarkreportText(),Remarkreport.getRemarkreportTime(),Remarkreport.getRemarkreportUserId(),Remarkreport.getRemarkreportRemarkId());
		
	}

	/**
	 * 保存点赞
	 * @param remarkpraise
	 */
	@Override
	public void saveRemarkPraise(Remarkpraise remarkpraise) {
		String sql = "insert into remarkpraise(remarkpraise_time,remarkpraise_user_id,remarkpraise_remark_id) values(?,?,?)";
		jdbcTemplate.update(sql,remarkpraise.getRemarkpraiseTime(),remarkpraise.getRemarkpraiseUserId(),remarkpraise.getRemarkpraiseRemarkId());

	}

	/**
	 * 15.保存点评评论
	 * @param remarkcomment
	 */
	public void saveRemarkcomment(Remarkcomment remarkcomment) {
		String sql ="insert into remarkcomment(remarkcomment_text,remarkcomment_time,remarkcomment_user_id,remarkcomment_remark_id) values(?,?,?,?)";
		jdbcTemplate.update(sql, remarkcomment.getRemarkcommentText(),remarkcomment.getRemarkcommentTime(),remarkcomment.getRemarkcommentUserId(),remarkcomment.getRemarkcommentRemarkId());
		
	}

	/**
	 * 16.保存点评评论的点赞
	 * @param travelsceniccommentZiPraise
	 */
	public void saveTRemarkcommentZiPraise(RemarkcommentZiPraise travelsceniccommentZiPraise) {

		String sql ="insert into remarkcomment_zi_praise(remarkcomment_zi_praise_time,remarkcomment_zi_praise_user_id,remarkcomment_zi_praise_rc_id) values (?,?,?)";
		jdbcTemplate.update(sql, travelsceniccommentZiPraise.getRemarkcommentZiPraiseTime(),travelsceniccommentZiPraise.getRemarkcommentZiPraiseUserId(),travelsceniccommentZiPraise.getRemarkcommentZiPraiseRcId());
	}

	
	/**
	 * 17.保存点评评论的举报
	 * @param remarkcommentZiCommentReport
	 */
	public void saveRemarkcommentZiCommentReport(RemarkcommentZiCommentReport remarkcommentZiCommentReport) {

		String sql ="insert into remarkcomment_zi_report(remarkcomment_zi_report_text,remarkcomment_zi_report_time,remarkcomment_zi_report_user_id,remarkcomment_zi_report_rc_id)values(?,?,?,?)";
		jdbcTemplate.update(sql, remarkcommentZiCommentReport.getRcZiCReportText(),remarkcommentZiCommentReport.getRcZiCReportTime(),remarkcommentZiCommentReport.getRcZiCReportUserId(),remarkcommentZiCommentReport.getRcZiCReportCId());
		
	}

	public void deleteTravelScenic(List<String> RemarkList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRemarkcollect(List<Integer> RemarkcollectIdList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRemarkimage(List<Integer> RemarkimageIdList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRemarkpraise(List<Integer> RemarkpraiseIdList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRemarkreport(List<Integer> RemarkreportIdList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRemarkshare(List<Integer> RemarkshareIdList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRemarkcomment(List<Integer> RemarkcommentIdList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRemarkcommentZiPraise(List<Integer> RemarkcommentZiPraiseIdList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRemarkcommentZiComment(List<Integer> RemarkcommentZiCommentIdList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTravelsceniccommentZiComment(List<Integer> TravelsceniccommentZiCommentIdList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRemarkcommentZiCommentPraise(List<Integer> RemarkcommentZiCommentPraiseIdList) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRemarkcommentZiCommentReport(List<Integer> RemarkcommentZiCommentReportIdList) {
		// TODO Auto-generated method stub
		
	}


}
