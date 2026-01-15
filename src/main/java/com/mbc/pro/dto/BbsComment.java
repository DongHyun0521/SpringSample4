package com.mbc.pro.dto;

import java.io.Serializable;

public class BbsComment implements Serializable {
	int seq, bbsSeq;
	String id, content, wdate;
	
	public BbsComment() {}
	public BbsComment(int seq, String id, String content) {
		super();
		this.seq = seq;
		this.id = id;
		this.content = content;
	}
	public BbsComment(int seq, int bbsSeq, String id, String content, String wdate) {
		this.seq = seq;
		this.bbsSeq = bbsSeq;
		this.id = id;
		this.content = content;
		this.wdate = wdate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getBbsSeq() {
		return bbsSeq;
	}
	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "BbsComment [seq=" + seq + ", bbsSeq=" + bbsSeq + ", id=" + id + ", content=" + content + ", wdate="
				+ wdate + "]";
	}
}
