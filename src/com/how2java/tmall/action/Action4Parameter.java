package com.how2java.tmall.action;

public class Action4Parameter extends Action4Service {

	protected String msg; // ������Ϣ
	protected String sort; // ����ʽ
	protected String keyword; // �ؼ���
	
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