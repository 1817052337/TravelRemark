package com.itheruan.dao.msyqldao.Impl;

import java.util.List;

import com.itheruan.dao.msyqldao.ITravelDao;
import com.itheruan.domain.travel.Travelscenic;
import com.itheruan.domain.travel.Travelsceniccollect;
import com.itheruan.domain.travel.Travelsceniccomment;
import com.itheruan.domain.travel.TravelsceniccommentZiComment;
import com.itheruan.domain.travel.TravelsceniccommentZiImage;
import com.itheruan.domain.travel.TravelsceniccommentZiPraise;
import com.itheruan.domain.travel.TravelsceniccommentZiReport;
import com.itheruan.domain.travel.Travelscenicimage;
import com.itheruan.domain.travel.Travelscenicreport;
import com.itheruan.domain.travel.Travelscenicshare;


public class TravelDaoImpl implements ITravelDao{

	@Override
	public List<Travelscenic> findAllTravelScenic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> findAllTravelScenicCollect(List<String> travelScenicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<Travelscenicimage>> findAllTravelScenicImage(List<String> travelScenicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> findAllTravelScenicShare(List<String> travelScenicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<Travelsceniccomment>> findAllTravelsceniccomment(List<String> travelScenicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> findAllTravelScenicCommentZiPraise(List<Integer> TravelsceniccommentIdList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<TravelsceniccommentZiImage>> findAllTravelScenicCommentZiImage(
			List<Integer> TravelsceniccommentIdList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TravelsceniccommentZiComment> findAllTravelScenicCommentZiComment(int TravelsceniccommentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> findAllTravelScenicCommentZiComment(List<Integer> TravelsceniccommentZiCommentIdList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTravelScenic(Travelscenic travelscenic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveTravelScenicCollect(Travelsceniccollect travelsceniccollect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveTravelScenicImage(List<Travelscenicimage> travelscenicimageList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveTravelScenicShare(Travelscenicshare travelscenicshare) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveTravelScenicreport(Travelscenicreport travelscenicreport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveTravelScenicComment(Travelsceniccomment travelsceniccomment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveTravelScenicCommentZiImage(List<TravelsceniccommentZiImage> travelsceniccommentZiImageList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveTravelScenicCommentZiPraise(TravelsceniccommentZiPraise travelsceniccommentZiPraise) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveTravelScenicCommentZiReport(TravelsceniccommentZiReport travelsceniccommentZiReport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelScenic(List<String> TravelScenicListIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelScenicCollect(List<Integer> TravelScenicCollectListIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelscenicimage(List<Integer> TravelscenicimageListIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelscenicreport(List<Integer> TravelscenicreportIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelscenicshare(List<Integer> TravelscenicshareIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelsceniccomment(List<Integer> TravelsceniccommentListIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelsceniccommentZiImage(List<Integer> TravelsceniccommentZiImageListIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelsceniccommentZiPraise(List<Integer> TravelsceniccommentZiPraiseIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelsceniccommentZiReport(List<Integer> TravelsceniccommentZiReportIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelsceniccommentZiComment(List<Integer> TravelsceniccommentZiCommentIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelsceniccommentZiCommentPraise(List<Integer> TravelsceniccommentZiCommentPraiseIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTravelsceniccommentZiCommentReport(List<Integer> TravelsceniccommentZiCommentReportIdList) {
		// TODO Auto-generated method stub
		
	}

}
