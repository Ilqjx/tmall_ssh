package com.how2java.tmall.util;

public class Page {

	private int start;
	private int count;
	private int total;
	private String param;
	
	private static final int defaultCount = 5;
	
	public Page() {
		count = defaultCount;
	}
	
	public Page(int start, int count) {
		this.start = start;
		this.count = count;
	}
	
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public String getParam() {
		return param;
	}
	
	public void setParam(String param) {
		this.param = param;
	}
	
	public int getLast() {
		int last;
		if (total % count == 0) {
			last = total - count;
		} else {
			last = total - total % count;
		}
		// total = 0
		last = last < 0 ? 0 : last;
		return last;
	}
	
	public int getTotalPage() {
		int totalPage;
		if (total % count == 0) {
			totalPage = total / count;
		} else {
			totalPage = total / count + 1;
		}
		// total = 0
		totalPage = totalPage == 0 ? 1 : totalPage;
		return totalPage;
	}
	
	public boolean isHasPrevious() {
		if (start == 0) {
			return false;
		}
		return true;
	}
	
	public boolean isHasNext() {
		if (start == getLast()) {
			return false;
		}
		return true;
	}
	
}
