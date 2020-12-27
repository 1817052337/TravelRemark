package com.itheruan.dao.msyqldao;

import com.itheruan.domain.travel.*;

import java.util.List;

public interface ITravelDao {

	/**
	 * 查询所有景点信息
	 * @return
	 */
	List<Travelscenic> findAllTravelScenic();

	/**
	 * 根据景点id查询景点收藏数量
	 * @return
	 */
	List<Long> findAllTravelScenicCollect(List<String> travelScenicId);


	/**
	 * 根据景点id查询景点图片
	 * @return
	 */
	List<List<Travelscenicimage>> findAllTravelScenicImage(List<String> travelScenicId);

	/**
	 * 根据景点id查询分享数量
	 * @return
	 */
	List<Long> findAllTravelScenicShare(List<String> travelScenicId);

	/**
	 * 根据景点id查询景点评论
	 * @return
	 */
	List<List<Travelsceniccomment>> findAllTravelsceniccomment(List<String> travelScenicId);

	/**
	 * 根据评论id查询景点评论的点赞数量
	 * @return
	 */
	List<Long> findAllTravelScenicCommentZiPraise(List<Integer> TravelsceniccommentIdList);


	/**
	 * 根据评论id查询景点评论的图片
	 * @return
	 */
	List<List<TravelsceniccommentZiImage>> findAllTravelScenicCommentZiImage(List<Integer> TravelsceniccommentIdList);


	/**
	 * 根据评论id查询景点评论的评论
	 * @return
	 */
	List<TravelsceniccommentZiComment> findAllTravelScenicCommentZiComment(int TravelsceniccommentId);

	/**
	 * 根据id查询景点评论的评论的点赞数量
	 * @param TravelsceniccommentZiCommentIdList
	 * @return
	 */
	List<Long> findAllTravelScenicCommentZiComment(List<Integer> TravelsceniccommentZiCommentIdList);


	/**
	 * 保存景点
	 * @param travelscenic
	 */
	void saveTravelScenic(Travelscenic travelscenic);

	/**
	 * 保存景点收藏
	 * @param travelsceniccollect
	 */
	void saveTravelScenicCollect(Travelsceniccollect travelsceniccollect);

	/**
	 * 保存景点图片
	 * @param travelscenicimageList
	 */
	void saveTravelScenicImage(List<Travelscenicimage> travelscenicimageList);

	/**
	 * 保存景点分享
	 * @param travelscenicshare
	 */
	void saveTravelScenicShare(Travelscenicshare travelscenicshare);

	/**
	 * 保存景点举报
	 * @param travelscenicreport
	 */
	void saveTravelScenicreport(Travelscenicreport travelscenicreport);


	/**
	 * 保存景点评论
	 * @param travelsceniccomment
	 */
	void saveTravelScenicComment(Travelsceniccomment travelsceniccomment);

	/**
	 * 保存景点评论的图片
	 * @param travelsceniccommentZiImageList
	 */
	void saveTravelScenicCommentZiImage(List<TravelsceniccommentZiImage> travelsceniccommentZiImageList);

	/**
	 * 保存景点评论的点赞
	 * @param travelsceniccommentZiPraise
	 */
	void saveTravelScenicCommentZiPraise(TravelsceniccommentZiPraise travelsceniccommentZiPraise);

	/**
	 * 保存景点评论的举报
	 * @param travelsceniccommentZiReport
	 */
	void saveTravelScenicCommentZiReport(TravelsceniccommentZiReport travelsceniccommentZiReport);
	//void saveTravelScenicComment(Travelsceniccomment travelsceniccomment);


	/**
	 * 批量删除景点
	 * @param TravelScenicListIdList
	 */
	void deleteTravelScenic(List<String> TravelScenicListIdList);

	/**
	 * 批量删除景点收藏
	 * @param TravelScenicCollectListIdList
	 */
	void deleteTravelScenicCollect(List<Integer> TravelScenicCollectListIdList);

	/**
	 * 批量删除景点图片
	 * @param TravelscenicimageListIdList
	 */
	void deleteTravelscenicimage(List<Integer> TravelscenicimageListIdList);

	/**
	 * 批量删除景点举报
	 * @param TravelscenicreportIdList
	 */
	void deleteTravelscenicreport(List<Integer> TravelscenicreportIdList);

	/**
	 * 批量删除景点分享
	 * @param TravelscenicshareIdList
	 */
	void deleteTravelscenicshare(List<Integer> TravelscenicshareIdList);

	/**
	 * 批量删除景点评论
	 * @param TravelsceniccommentListIdList
	 */
	void deleteTravelsceniccomment(List<Integer> TravelsceniccommentListIdList);

	/**
	 * 批量删除景点评论的图片
	 * @param TravelsceniccommentZiImageListIdList
	 */
	void deleteTravelsceniccommentZiImage(List<Integer> TravelsceniccommentZiImageListIdList);

	/**
	 * 批量删除景点评论的点赞
	 * @param TravelsceniccommentZiPraiseIdList
	 */
	void deleteTravelsceniccommentZiPraise(List<Integer> TravelsceniccommentZiPraiseIdList);

	/**
	 * 批量删除景点评论的举报
	 * @param TravelsceniccommentZiReportIdList
	 */
	void deleteTravelsceniccommentZiReport(List<Integer> TravelsceniccommentZiReportIdList);

	/**
	 *批量删除景点评论的的评论
	 * @param TravelsceniccommentZiCommentIdList
	 */
	void deleteTravelsceniccommentZiComment(List<Integer> TravelsceniccommentZiCommentIdList);

	/**
	 * 批量删除景点评论的评论的点赞
	 * @param TravelsceniccommentZiCommentPraiseIdList
	 */
	void deleteTravelsceniccommentZiCommentPraise(List<Integer> TravelsceniccommentZiCommentPraiseIdList);

	/**
	 * 批量删除景点评论的评论的举报
	 * @param TravelsceniccommentZiCommentReportIdList
	 */
	void deleteTravelsceniccommentZiCommentReport(List<Integer> TravelsceniccommentZiCommentReportIdList);

}
