package com.pet.dto;

import java.sql.Timestamp;

public class BorderVO {
	private Integer bseq;
	private Integer bgroup;
	private String 	btitle;
	private String bcontent;
	private Timestamp bindate;
	private String bid;
	private Integer bview;
	
	public Integer getBseq() {
		return bseq;
	}
	public void setBseq(Integer bseq) {
		this.bseq = bseq;
	}
	public Integer getBgroup() {
		return bgroup;
	}
	public void setBgroup(Integer bgroup) {
		this.bgroup = bgroup;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public Timestamp getBindate() {
		return bindate;
	}
	public void setBindate(Timestamp bindate) {
		this.bindate = bindate;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public Integer getBview() {
		return bview;
	}
	public void setBview(Integer bview) {
		this.bview = bview;
	}
}
