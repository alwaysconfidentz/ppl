package com.food.k1.fmember;

public class FmemberVo {

	private int rownum;
	private int rnum;
	
	private String ch1;
	private String ch2;

	private int fcustno;
	private String fid;
	private String fpwd;
	private String fname;
	private String fjender;

	private int fcnt;

	private String fjoindate;

	private int startIdx; // 현재레코드
	private int totalPage;
	private int nowPage;
	private int endPage;

	private int pageSize; // 페이지 사이즈
	private int pageListSize;// 페이지 List Size
	private int nowRecord; // 현재레코드
	private int startListPage; // 하단 가로 페이지
	private int endListPage; // 하단 마지막 페이지
	


	public int getStartIdx() {
		return startIdx;
	}

	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageListSize() {
		return pageListSize;
	}

	public void setPageListSize(int pageListSize) {
		this.pageListSize = pageListSize;
	}

	public int getNowRecord() {
		return nowRecord;
	}

	public void setNowRecord(int nowRecord) {
		this.nowRecord = nowRecord;
	}

	public int getStartListPage() {
		return startListPage;
	}

	public void setStartListPage(int startListPage) {
		this.startListPage = startListPage;
	}

	public int getEndListPage() {
		return endListPage;
	}

	public void setEndListPage(int endListPage) {
		this.endListPage = endListPage;
	}

	public int getFcnt() {
		return fcnt;
	}

	public void setFcnt(int fcnt) {
		this.fcnt = fcnt;
	}

	public String getFjoindate() {
		return fjoindate;
	}

	public void setFjoindate(String fjoindate) {
		this.fjoindate = fjoindate;
	}

	public int getFcustno() {
		return fcustno;
	}

	public void setFcustno(int fcustno) {
		this.fcustno = fcustno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFjender() {
		return fjender;
	}

	public void setFjender(String fjender) {
		this.fjender = fjender;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFpwd() {
		return fpwd;
	}

	public void setFpwd(String fpwd) {
		this.fpwd = fpwd;
	}
	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getCh1() {
		return ch1;
	}

	public void setCh1(String ch1) {
		this.ch1 = ch1;
	}

	public String getCh2() {
		return ch2;
	}

	public void setCh2(String ch2) {
		this.ch2 = ch2;
	}

	@Override
	public String toString() {
		return "FmemberVo [rownum=" + rownum + ", rnum=" + rnum + ", ch1=" + ch1 + ", ch2=" + ch2 + ", fcustno="
				+ fcustno + ", fid=" + fid + ", fpwd=" + fpwd + ", fname=" + fname + ", fjender=" + fjender + ", fcnt="
				+ fcnt + ", fjoindate=" + fjoindate + ", startIdx=" + startIdx + ", totalPage=" + totalPage
				+ ", nowPage=" + nowPage + ", endPage=" + endPage + ", pageSize=" + pageSize + ", pageListSize="
				+ pageListSize + ", nowRecord=" + nowRecord + ", startListPage=" + startListPage + ", endListPage="
				+ endListPage + "]";
	}
	

}
