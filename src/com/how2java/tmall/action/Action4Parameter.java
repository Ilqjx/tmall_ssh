package com.how2java.tmall.action;

public class Action4Parameter extends Action4Service {

	protected String msg; // ������Ϣ
	protected String sort; // ����ʽ
	protected String keyword; // �ؼ���
	protected int num; // �����Ʒ����
	protected int oiid; // �����������ɵĶ�����id
	protected int[] oiids; // ͨ�����ﳵѡ�еĶ��������id
	protected float total; // ����ҳ��Ķ����ܽ��
	
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