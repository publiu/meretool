package com.mereking.meretool.entity;
/**
 * 股票
 */
public class Stock {
	
	
	
	private Integer id;
	private String gid; // 股票代码
	private String gidShort;
	private String name; // 股票名称
	private String nameShort;
	private Integer type; // 股票类型
	
	public enum STOCK_TYPE {
		;
		private Integer code;
		private String value;
		private STOCK_TYPE(Integer code, String value) {
			this.code = code;
			this.value = value;
		}
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getGidShort() {
		return gidShort;
	}
	public void setGidShort(String gidShort) {
		this.gidShort = gidShort;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameShort() {
		return nameShort;
	}
	public void setNameShort(String nameShort) {
		this.nameShort = nameShort;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	

}
