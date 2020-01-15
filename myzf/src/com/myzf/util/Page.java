package com.myzf.util;

/**
 * 分页类
 * @author hgf
 *
 * 2019年8月9日
 */
public class Page {
	private int rowCount;//总记录数
	private int pageCount;//总共页数
	private int pageSize;//每页记录数
	private int pageNo;//当前页码
	
	
	
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		this.pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0)
			this.pageCount++;
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		if(pageNo>getPageCount()) 
			pageNo=pageCount;
		if(pageNo<1)
			pageNo=1;
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		
	}
	public Page(int rowCount, int pageCount, int pageSize, int pageNo) {
		super();
		this.rowCount = rowCount;
		this.pageCount = pageCount;
		this.pageSize = pageSize;
		this.pageNo = pageNo;
	}
	public Page() {
		super();
		this.pageNo=1;
		this.pageSize=5;
	}
	
	
	
	
}
