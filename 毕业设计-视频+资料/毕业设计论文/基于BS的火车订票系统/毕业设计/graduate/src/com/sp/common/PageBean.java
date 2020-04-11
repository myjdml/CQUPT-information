package com.sp.common;

public class PageBean {
	private int currentPage = 1; //��ǰҳ
	private int pageSize = 8; //ÿҳ��ʾ��Ŀ
	private int totalPage = 0; //��ҳ��
	private int totalCount = 0; //����Ŀ
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalCount%pageSize==0? totalCount/pageSize : totalCount/pageSize+1 ;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
