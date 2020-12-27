package com.itheruan.dao.msyqldao;

import java.util.List;
import java.util.Map;

import com.itheruan.domain.Remark.*;
import com.itheruan.domain.travel.Travelscenic;
import com.itheruan.domain.travel.TravelsceniccommentZiReport;


/**
 * 点评的持久层接口
 * @author 11137
 *
 */
public interface IRemarkDao {

	/**
	 * 查询所有点评
	 * @return
	 */
	List<Remark> findAllRemark(int cityId);

	/**
	 * 根据id查询点评收藏数量
	 * @return
	 */
	List<Long> findAllRemarkcollect(List<String> remarkIdList);

	/**
	 * 根据id查询点评点赞的数量
	 * @param remarkIdList
	 * @return
	 */
	List<Long> findAllRemarkpraise(List<String> remarkIdList);

	/**
	 * 根据id查询点评图片
	 * @return
	 */
	List<List<Remarkimage>> findAllRemarkimag(List<String> remarkIdList);

	/**
	 * 根据id查询点评分享数量
	 * @return
	 */
	List<Long> findAllRemarkshare(List<String> remarkIdList);

	/**
	 * 根据id查询点评评论
	 * @return
	 */
	List<List<Remarkcomment>> findAllRemarkcomment(List<String> remarkIdList);

	/**
	 * 根据id查询点评评论的点赞数量
	 * @return
	 */
	List<Long> findAllRemarkcommentZiPraise(List<Integer> RemarkcommentIdList);

	/**
	 * 根据id查询点评评论的评论
	 * @return
	 */
	List<RemarkcommentZiComment> findAllRemarkcommentZiComment(int RemarkcommentId);

	/**
	 * 根据id查询点评评论的点赞数量
	 * @param RemarkcommentZiCommentIdList
	 * @return
	 */
	List<Long> findAllTravelScenicCommentZiComment(List<Integer> RemarkcommentZiCommentIdList);

	/**
	 * 根据用户id和点评id查询该用户对这条点评是否进行收藏
	 * @param userId
	 * @param remarkId
	 * @return
	 */
	Remarkcollect findByRemarkIdAndUserIdRemarkCollect(String userId, String remarkId);

	/**
	 * 根据用户id和点评id查询该用户对这条点评是否进行点赞
	 * @param userId
	 * @param remarkId
	 * @return
	 */
	Remarkpraise  findByRemarkIdAndUserIdRemarkPraise(String userId, String remarkId);

	/**
	 * 根据用户id和点评id查询该用户对这条点评是否进行举报
	 * @param userId
	 * @param remarkId
	 * @return
	 */
	Remarkreport findByRemarkIdAndUserIdRemarkReport(String userId, String remarkId);



	/**
	 * 保存点评
	 * @param remark
	 */
	void saveremark(Remark remark);

	/**
	 * 保存点评收藏
	 * @param remarkcollect
	 */
	void saveremarkcollect(Remarkcollect remarkcollect);

	/**
	 * 保存点评图片
	 * @param RemarkimageList
	 */
	void saveRemarkimageList(List<Remarkimage> RemarkimageList);

	/**
	 * 保存点评分享
	 * @param remarkshare
	 */
	void saveRemarkShare(Remarkshare remarkshare);

	/**
	 * 保存点评举报
	 * @param Remarkreport
	 */
	void saveRemarkreport(Remarkreport Remarkreport);

	/**
	 * 保存点赞
	 * @param remarkpraise
	 */
	void saveRemarkPraise(Remarkpraise remarkpraise);


	/**
	 * 保存点评评论
	 * @param remarkcomment
	 */
	void saveRemarkcomment(Remarkcomment remarkcomment);

	/**
	 * 保存点评评论的点赞
	 * @param travelsceniccommentZiPraise
	 */
	void saveTRemarkcommentZiPraise(RemarkcommentZiPraise travelsceniccommentZiPraise);

	/**
	 * 保存点评评论的举报
	 * @param remarkcommentZiCommentReport
	 */
	void saveRemarkcommentZiCommentReport(RemarkcommentZiCommentReport remarkcommentZiCommentReport);
	//void saveTravelScenicComment(Travelsceniccomment travelsceniccomment);


	/**
	 * 批量删除点评
	 * @param RemarkList
	 */
	void deleteTravelScenic(List<String> RemarkList);

	/**
	 * 批量删除点评收藏
	 * @param RemarkcollectIdList
	 */
	void deleteRemarkcollect(List<Integer> RemarkcollectIdList);

	/**
	 * 批量删除点评图片
	 * @param RemarkimageIdList
	 */
	void deleteRemarkimage(List<Integer> RemarkimageIdList);

	/**
	 * 批量删除点评点赞
	 * @param RemarkpraiseIdList
	 */
	void deleteRemarkpraise(List<Integer> RemarkpraiseIdList);

	/**
	 * 批量删除点评举报
	 * @param RemarkreportIdList
	 */
	void deleteRemarkreport(List<Integer> RemarkreportIdList);

	/**
	 * 批量删除点评分享
	 * @param RemarkshareIdList
	 */
	void deleteRemarkshare(List<Integer> RemarkshareIdList);

	/**
	 * 批量删除点评评论
	 * @param RemarkcommentIdList
	 */
	void deleteRemarkcomment(List<Integer> RemarkcommentIdList);

	/**
	 * 批量删除点评评论的点赞
	 * @param RemarkcommentZiPraiseIdList
	 */
	void deleteRemarkcommentZiPraise(List<Integer> RemarkcommentZiPraiseIdList);


	/**
	 * 批量删除点评评论的举报
	 * @param RemarkcommentZiCommentIdList
	 */
	void deleteRemarkcommentZiComment(List<Integer> RemarkcommentZiCommentIdList);

	/**
	 *批量删除点评评论的的评论
	 * @param TravelsceniccommentZiCommentIdList
	 */
	void deleteTravelsceniccommentZiComment(List<Integer> TravelsceniccommentZiCommentIdList);

	/**
	 * 批量删除点评评论的评论的点赞
	 * @param RemarkcommentZiCommentPraiseIdList
	 */
	void deleteRemarkcommentZiCommentPraise(List<Integer> RemarkcommentZiCommentPraiseIdList);

	/**
	 * 批量删除点评评论的评论的举报
	 * @param RemarkcommentZiCommentReportIdList
	 */
	void deleteRemarkcommentZiCommentReport(List<Integer> RemarkcommentZiCommentReportIdList);
}
