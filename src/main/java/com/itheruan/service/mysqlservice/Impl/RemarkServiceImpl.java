package com.itheruan.service.mysqlservice.Impl;

import java.util.*;

import com.itheruan.domain.Remark.*;
import com.itheruan.utils.FileUtils;
import com.itheruan.utils.SerializeUtil;
import com.itheruan.utils.SerializeUtilList;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.itheruan.dao.msyqldao.IRemarkDao;
import com.itheruan.dao.msyqldao.Impl.RemarkDaoImpl;
import com.itheruan.domain.regon.Area;
import com.itheruan.domain.regon.City;
import com.itheruan.domain.regon.Province;
import com.itheruan.service.mysqlservice.IRemarkService;
import com.itheruan.utils.JedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;


public class RemarkServiceImpl implements IRemarkService {
/*	public static void main(String[] args) {
		RemarkServiceImpl remarkService = new RemarkServiceImpl();
		List<Remark> allRemark = remarkService.findAllRemark(1);
		System.out.println(allRemark.get(0).getRemarkText());
		String remarkText = FileUtils.download(allRemark.get(0).getRemarkText());
		System.out.println(remarkText);
	}*/

	public static void main(String[] args) {
		List<Remark> allRemark = new RemarkServiceImpl().findAllRemark(8);
		System.out.println(allRemark);
	}
	/**
	 * 1.根据城市id 查询所有点评
	 * @return
	 */	
	public List<Remark> findAllRemark(int cityId) {

		// 获取redis客户端
				Jedis jedis = JedisUtil.getJedis();

		// 获取缓存中城市集合
		List<byte[]> allRemarkJ = jedis.lrange(("RemarkList"+cityId).getBytes(), 0, -1);
		List<Remark> allRemark = null;
		// 2.判断查询的集合是否为空
		if (allRemarkJ == null || allRemarkJ.size() == 0) {

			System.out.println("从数据库查询....");
			// 3.如果为空,需要从数据库查询,在将数据存入redis
			// 3.1 从数据库查询
			allRemark = new RemarkDaoImpl().findAllRemark(cityId);
			//System.out.println(allRemark);
			//System.out.println("分隔新");

			// 3.2 将集合数据存储到redis中的 category的key
			for (int i = 0; i < allRemark.size(); i++) {
				Remark remark = allRemark.get(i);
				//System.out.println(remark);
				// 将城市信息存储到redis缓冲之中
				jedis.lpush(("RemarkList"+cityId).getBytes(), SerializeUtil.serialize(remark));
			}

		} else {
			System.out.println("从redis中查询.....");

			// 4.如果不为空,将set的数据存入list
			allRemark = new ArrayList<Remark>();
			for (byte[] bs : allRemarkJ) {
				Remark remark = (Remark) SerializeUtil.unserialize(bs);
				allRemark.add(remark);
			}

			//System.out.println(allRemark);
		}
		return allRemark;
	}

	/**
	 * 2.根据id查询点评收藏数量
	 * @return
	 */
	public List<Long> findAllRemarkcollect(List<String> remarkIdList) {

		return new RemarkDaoImpl().findAllRemarkcollect(remarkIdList);
	}

	/**
	 * 3.根据id查询点评点赞的数量
	 * @param remarkIdList
	 * @return
	 */
	public List<Long> findAllRemarkpraise(List<String> remarkIdList) {
		return new RemarkDaoImpl().findAllRemarkpraise(remarkIdList);
	}

	/**
	 * 4.根据id查询点评图片
	 * @return
	 */
	public List<List<Remarkimage>> findAllRemarkimag(List<String> remarkIdList,int cityId) {
		RemarkDaoImpl remarkDao = new RemarkDaoImpl();
		// 获取redis客户端
		Jedis jedis = JedisUtil.getJedis();

		// 获取缓存中城市集合
		List<byte[]> RemarkImageListJ = jedis.lrange(("RemarkImageList"+cityId).getBytes(), 0, -1);
		List<List<Remarkimage>> allRemarkimageZui = null;

		// 2.判断查询的集合是否为空
		if (RemarkImageListJ == null || RemarkImageListJ.size() == 0) {
			System.out.println("从数据库查询....");
			// 3.如果为空,需要从数据库查询,在将数据存入redis
			// 3.1 从数据库查询

			//3.2获取当前城市所有的点评 存入到一个集合之中
			List<Remark> allRemark = this.findAllRemark(cityId);
			List<String> remarkIdZong = new ArrayList<>();
			for (Remark remark : allRemark) {
				remarkIdZong.add(remark.getRemarkId());
			}
			//根据点评id查询该城市所有点评的图片
			List<List<Remarkimage>> allRemarkimageDao = remarkDao.findAllRemarkimag(remarkIdZong);
			//遍历传递的点评集合id
			allRemarkimageZui = new ArrayList<>();
			System.out.println(remarkIdList.size());
			for (int i = 0; i < remarkIdList.size(); i++) {
				//传递的点评集合id
				String remarkId = remarkIdList.get(i);
				//System.out.println("参数点评id"+remarkId);
				//遍历存储该城市所有点评的图片的集合
				for (int a = 0; i < allRemarkimageDao.size(); a++) {

					//获取每一个点评的图片的集合
					List<Remarkimage> remarkimages = allRemarkimageDao.get(a);
					//判断remarkimages中点评的id是否和传递的点评id相等
					if (remarkId.equals((remarkimages.get(0).getRemarkimageRemarkId()))) {
						System.out.println("相等");
						allRemarkimageZui.add(remarkimages);
						break;
					}

				}
			}

			//System.out.println("最终的集合"+allRemarkimageZui);

			// 4 将集合数据存储到redis中的
			for (List<Remarkimage> remarkimages : allRemarkimageDao) {
				jedis.lpush(("RemarkImageList" + cityId).getBytes(), SerializeUtilList.serializeList(remarkimages));
			}

		} else {
			System.out.println("从redis中查询.....");
			allRemarkimageZui = new ArrayList<>();
			//遍历传递的点评集合id
			for (int i = 0; i < remarkIdList.size(); i++) {
				//传递的点评集合id
				String remarkId = remarkIdList.get(i);
				//遍历存储该城市所有点评的图片的集合
				for (int a = 0; i < RemarkImageListJ.size(); a++) {
					//获取每一个点评的图片的集合
					List<Remarkimage> remarkimages = (List<Remarkimage>) SerializeUtilList.unserializeList(RemarkImageListJ.get(a));
					//判断remarkimages中点评的id是否和传递的点评id相等
					if (remarkId.equals((remarkimages.get(0).getRemarkimageRemarkId()))) {
						allRemarkimageZui.add(remarkimages);
						break;
					}

				}
			}
		}


		return allRemarkimageZui;
	}

	
	/**
	 * 5.根据id查询点评分享数量
	 * @return
	 */
	public List<Long> findAllRemarkshare(List<String> remarkIdList) {
		return new RemarkDaoImpl().findAllRemarkshare(remarkIdList);
	}
	
	/**
	 * 6.根据id查询点评评论
	 * @return
	 */
	public List<List<Remarkcomment>> findAllRemarkcomment(List<String> remarkIdList,int cityId) {
		//findAllRemark(ci)
		return new RemarkDaoImpl().findAllRemarkcomment(remarkIdList);
	}
	
	/**
	 * 7.根据id查询点评评论的点赞数量
	 * @return
	 */
	public List<Long> findAllRemarkcommentZiPraise(List<Integer> RemarkcommentIdList) {


		//按照地区查询评论

		return new RemarkDaoImpl().findAllRemarkcommentZiPraise(RemarkcommentIdList);
	}

	/**
	 * 8.根据id查询点评评论的评论
	 * @return
	 */

	public List<RemarkcommentZiComment> findAllRemarkcommentZiComment(int RemarkcommentId) {
		return new RemarkDaoImpl().findAllRemarkcommentZiComment(RemarkcommentId);
		
	}
	
	/**
	 * 9.根据id查询点评评论的点赞数量
	 * @param RemarkcommentZiCommentIdList
	 * @return
	 */

	public List<Long> findAllTravelScenicCommentZiComment(List<Integer> RemarkcommentZiCommentIdList) {
		return new RemarkDaoImpl().findAllTravelScenicCommentZiComment(RemarkcommentZiCommentIdList);
	}

	/**
	 * 根据用户id和点评id查询该用户对这条点评是否进行收藏
	 * @param userId
	 * @param remarkId
	 * @return
	 */
	@Override
	public Remarkcollect findByRemarkIdAndUserIdRemarkCollect(String userId, String remarkId) {
		return new RemarkDaoImpl().findByRemarkIdAndUserIdRemarkCollect(userId, remarkId);
	}

	/**
	 * 根据用户id和点评id查询该用户对这条点评是否进行点赞
	 * @param userId
	 * @param remarkId
	 * @return
	 */
	@Override
	public Remarkpraise findByRemarkIdAndUserIdRemarkPraise(String userId, String remarkId) {
		return new RemarkDaoImpl().findByRemarkIdAndUserIdRemarkPraise(userId, remarkId);
	}

	/**
	 * 根据用户id和点评id查询该用户对这条点评是否进行举报
	 * @param userId
	 * @param remarkId
	 * @return
	 */
	@Override
	public Remarkreport findByRemarkIdAndUserIdRemarkReport(String userId, String remarkId) {
		return new RemarkDaoImpl().findByRemarkIdAndUserIdRemarkReport(userId, remarkId);
	}


	/**
	 * 10.保存点评
	 * @param remark
	 */

	public void saveremark(Remark remark,int cityId) {
		new RemarkDaoImpl().saveremark(remark);
		//同时保存点评道redis缓冲之中
		Jedis jedis = JedisUtil.getJedis();
		// 获取缓存中城市集合
		List<byte[]> allRemarkJ = jedis.lrange(("RemarkList"+cityId).getBytes(), 0, -1);
		jedis.lpush(("RemarkList"+cityId).getBytes(), SerializeUtil.serialize(remark));

		//allRemarkJ.get(remark)
	}



	/**
	 * 11.保存点评收藏
	 * @param remarkcollect
	 */
	public void saveremarkcollect(Remarkcollect remarkcollect) {
		new RemarkDaoImpl().saveremarkcollect(remarkcollect);
	}

	/**
	 * 保存点赞
	 * @param remarkpraise
	 */
	@Override
	public void saveRemarkPraise(Remarkpraise remarkpraise) {
		new RemarkDaoImpl().saveRemarkPraise(remarkpraise);
	}

	/**
	 * 12.保存点评图片
	 * @param RemarkimageList
	 */

	public void saveRemarkimageList(List<Remarkimage> RemarkimageList,int cityId) {
		
		new RemarkDaoImpl().saveRemarkimageList(RemarkimageList);
		//同时保存点评图片到redis缓冲之中
		Jedis jedis = JedisUtil.getJedis();
		jedis.lpush(("RemarkImageList" + cityId).getBytes(), SerializeUtilList.serializeList(RemarkimageList));
	}

	
	/**
	 * 13.保存点评分享
	 * @param remarkshare
	 */
	public void saveRemarkShare(Remarkshare remarkshare) {

		new RemarkDaoImpl().saveRemarkShare(remarkshare);
	}

	/**
	 * 14.保存点评举报
	 * @param Remarkreport
	 */
	public void saveRemarkreport(Remarkreport Remarkreport) {

		new RemarkDaoImpl().saveRemarkreport(Remarkreport);
	}

	/**
	 * 15.保存点评评论
	 * @param remarkcomment
	 */
	public void saveRemarkcomment(Remarkcomment remarkcomment,int cityId) {
		new RemarkDaoImpl().saveRemarkcomment(remarkcomment);
	}

	/**
	 * 16.保存点评评论的点赞
	 * @param travelsceniccommentZiPraise
	 */
	public void saveTRemarkcommentZiPraise(RemarkcommentZiPraise travelsceniccommentZiPraise) {
		new RemarkDaoImpl().saveTRemarkcommentZiPraise(travelsceniccommentZiPraise);
	}

	
	/**
	 * 17.保存点评评论的举报
	 * @param remarkcommentZiCommentReport
	 */
	public void saveRemarkcommentZiCommentReport(RemarkcommentZiCommentReport remarkcommentZiCommentReport) {

		new RemarkDaoImpl().saveRemarkcommentZiCommentReport(remarkcommentZiCommentReport);
	}

	@Override
	public void deleteTravelScenic(List<String> RemarkList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRemarkcollect(List<Integer> RemarkcollectIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRemarkimage(List<Integer> RemarkimageIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRemarkpraise(List<Integer> RemarkpraiseIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRemarkreport(List<Integer> RemarkreportIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRemarkshare(List<Integer> RemarkshareIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRemarkcomment(List<Integer> RemarkcommentIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRemarkcommentZiPraise(List<Integer> RemarkcommentZiPraiseIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRemarkcommentZiComment(List<Integer> RemarkcommentZiCommentIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelsceniccommentZiComment(List<Integer> TravelsceniccommentZiCommentIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRemarkcommentZiCommentPraise(List<Integer> RemarkcommentZiCommentPraiseIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRemarkcommentZiCommentReport(List<Integer> RemarkcommentZiCommentReportIdList) {
		// TODO Auto-generated method stub
		
	}


}
