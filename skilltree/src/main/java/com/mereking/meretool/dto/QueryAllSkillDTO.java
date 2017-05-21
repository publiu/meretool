package com.mereking.meretool.dto;

public class QueryAllSkillDTO {
	private Integer layer;
	private String username;
	private Integer skillID;
	private Integer layerNum; // 搜索最深层次数
	

	public Integer getLayer() {
		return layer;
	}
	public void setLayer(Integer layer) {
		this.layer = layer;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getSkillID() {
		return skillID;
	}
	public void setSkillID(Integer skillID) {
		this.skillID = skillID;
	}
	public Integer getLayerNum() {
		return layerNum;
	}
	public void setLayerNum(Integer layerNum) {
		this.layerNum = layerNum;
	}
}
