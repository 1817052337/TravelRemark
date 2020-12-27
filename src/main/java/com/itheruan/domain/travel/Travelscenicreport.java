package com.itheruan.domain.travel;
import java.io.Serializable;
import java.sql.*;


public class Travelscenicreport implements Serializable{
	private Integer travelscenicreportId;
	private String travelscenicreportText;
	private Date travelscenicreportTime;
	private String travelscenicreportUserId;
	private String travelscenicreportTsId;
	@Override
	public String toString() {
		return "Travelscenicreport [travelscenicreportId=" + travelscenicreportId + ", travelscenicreportText="
				+ travelscenicreportText + ", travelscenicreportTime=" + travelscenicreportTime
				+ ", travelscenicreportUserId=" + travelscenicreportUserId + ", travelscenicreportTsId="
				+ travelscenicreportTsId + "]";
	}
	
	
	
	
	
}

