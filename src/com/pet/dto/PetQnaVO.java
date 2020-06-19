package com.pet.dto;

import java.sql.Timestamp;

public class PetQnaVO {
	private Integer qseq;
	private Integer qgroup;
	private String qtitle;
	private String qcontent;
	private Timestamp qindate;
	private String qid;
	private String qrep;
	private String qreply;
	private String qreid;
	private Integer qview;
	
	public Integer getQseq() {
		return qseq;
	}
	public void setQseq(Integer qseq) {
		this.qseq = qseq;
	}
	public Integer getQgroup() {
		return qgroup;
	}
	public void setQgroup(Integer qgroup) {
		this.qgroup = qgroup;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public Timestamp getQindate() {
		return qindate;
	}
	public void setQindate(Timestamp qindate) {
		this.qindate = qindate;
	}
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	public String getQrep() {
		return qrep;
	}
	public void setQrep(String qrep) {
		this.qrep = qrep;
	}
	public String getQreply() {
		return qreply;
	}
	public void setQreply(String qreply) {
		this.qreply = qreply;
	}
	public String getQreid() {
		return qreid;
	}
	public void setQreid(String qreid) {
		this.qreid = qreid;
	}
	public Integer getQview() {
		return qview;
	}
	public void setQview(Integer qview) {
		this.qview = qview;
	}
	
}
