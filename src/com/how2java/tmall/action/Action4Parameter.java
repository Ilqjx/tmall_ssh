package com.how2java.tmall.action;

public class Action4Parameter extends Action4Service {

	protected String msg; // 错误信息
	protected String sort; // 排序方式
	protected String keyword; // 关键字
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getSort() {
		return sort;
	}
	
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}