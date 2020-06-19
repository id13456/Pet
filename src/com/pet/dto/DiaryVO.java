package com.pet.dto;

import java.sql.Timestamp;

public class DiaryVO {
	private Integer dseq;
	private String did;
	private Timestamp dindate;
	private String dtitle;
	private String dcontent;
	public Integer getDseq() {
		return dseq;
	}
	public void setDseq(Integer dseq) {
		this.dseq = dseq;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public Timestamp getDindate() {
		return dindate;
	}
	public void setDindate(Timestamp dindate) {
		this.dindate = dindate;
	}
	public String getDtitle() {
		return dtitle;
	}
	public void setDtitle(String dtitle) {
		this.dtitle = dtitle;
	}
	public String getDcontent() {
		return dcontent;
	}
	public void setDcontent(String dcontent) {
		this.dcontent = dcontent;
	}
}

