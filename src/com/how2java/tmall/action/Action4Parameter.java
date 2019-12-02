package com.how2java.tmall.action;

public class Action4Parameter extends Action4Service {

	protected String msg; // 错误信息
	protected String sort; // 排序方式
	protected String keyword; // 关键字
	protected int num; // 购买产品数量
	protected int oiid; // 立即购买生成的订单项id
	protected int[] oiids; // 通过购物车选中的多个订单项id
	protected float total; // 结算页面的订单总金额
	
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
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getOiid() {
		return oiid;
	}
	
	public void setOiid(int oiid) {
		this.oiid = oiid;
	}
	
	public int[] getOiids() {
		return oiids;
	}
	
	public void setOiids(int[] oiids) {
		this.oiids = oiids;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	
}