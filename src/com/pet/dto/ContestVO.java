package com.pet.dto;

import java.sql.Timestamp;

public class ContestVO {
	private Integer conseq;
	private Timestamp conindate;
	private String contitle;
	private String concontent;
	private String conimg;
	private Integer conlike;
	private String conid;
	private Integer conview;
	private Integer conanikind;
	
	public Integer getConanikind() {
		return conanikind;
	}
	public void setConanikind(Integer conanikind) {
		this.conanikind = conanikind;
	}
	public Integer getConseq() {
		return conseq;
	}
	public void setConseq(Integer conseq) {
		this.conseq = conseq;
	}
	public Timestamp getConindate() {
		return conindate;
	}
	public void setConindate(Timestamp conindate) {
		this.conindate = conindate;
	}
	public String getContitle() {
		return contitle;
	}
	public void setContitle(String contitle) {
		this.contitle = contitle;
	}
	public String getConcontent() {
		return concontent;
	}
	public void setConcontent(String concontent) {
		this.concontent = concontent;
	}
	public String getConimg() {
		return conimg;
	}
	public void setConimg(String conimg) {
		this.conimg = conimg;
	}
	public Integer getConlike() {
		return conlike;
	}
	public void setConlike(Integer conlike) {
		this.conlike = conlike;
	}
	public String getConid() {
		return conid;
	}
	public void setConid(String conid) {
		this.conid = conid;
	}
	public Integer getConview() {
		return conview;
	}
	public void setConview(Integer conview) {
		this.conview = conview;
	}
}
