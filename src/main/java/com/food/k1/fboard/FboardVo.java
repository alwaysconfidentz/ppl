package com.food.k1.fboard;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FboardVo {

	private String fsno;
	private String ftitle;
	private String fcontent;
	private String fwriter;
	private int fcnt;
	private Date fregdate;
	private String fimg; // 파일 저장이름
	private  MultipartFile  updateFile; //실제파일이름 
	private int fgood;
	private int ftc;
	private int fcount;
	private String ch1;
	private String ch2;
	
	
	private int startIdx; // 현재레코드
	private int totalPage;
	private int nowPage;
	private int endPage;

	private int pageSize; // 페이지 사이즈
	private int pageListSize;// 페이지 List Size
	private int nowRecord; // 현재레코드
	private int startListPage; // 하단 가로 페이지
	private int endListPage; // 하단 마지막 페이지
	
	
	
	
	
	
	private String fbjoindate;
	
	private int fcustno;
	
	
	
	
	
	
	
	
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
	public int getFcustno() {
		return fcustno;
	}
	public void setFcustno(int fcustno) {
		this.fcustno = fcustno;
	}
	public String getFbjoindate() {
		return fbjoindate;
	}
	public void setFbjoindate(String fbjoindate) {
		this.fbjoindate = fbjoindate;
	}
	public int getFtc() {
		return ftc;
	}
	public void setFtc(int ftc) {
		this.ftc = ftc;
	}
	public int getFcount() {
		return fcount;
	}
	public void setFcount(int fcount) {
		this.fcount = fcount;
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
	public int getFgood() {
		return fgood;
	}
	public void setFgood(int fgood) {
		this.fgood = fgood;
	}
	public String getFimg() {
		return fimg;
	}
	public void setFimg(String fimg) {
		this.fimg = fimg;
	}
	public MultipartFile getUpdateFile() {
		return updateFile;
	}
	public void setUpdateFile(MultipartFile updateFile) {
		this.updateFile = updateFile;
	}
	public String getFsno() {
		return fsno;
	}
	public void setFsno(String fsno) {
		this.fsno = fsno;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getFwriter() {
		return fwriter;
	}
	public void setFwriter(String fwriter) {
		this.fwriter = fwriter;
	}
	public int getFcnt() {
		return fcnt;
	}
	public void setFcnt(int fcnt) {
		this.fcnt = fcnt;
	}
	public Date getFregdate() {
		return fregdate;
	}
	public void setFregdate(Date fregdate) {
		this.fregdate = fregdate;
	}
	
	
	
	
}
