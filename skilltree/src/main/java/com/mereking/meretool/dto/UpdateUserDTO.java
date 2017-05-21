package com.mereking.meretool.dto;

public class UpdateUserDTO {
	private String username;
	private Integer lastSkillLayer; // 最近搜索的技能层次
	private Integer lastSkillID; // 最近搜索的技能id
	private Integer lastSkillLayerNum; // 最近搜索的技能深度
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getLastSkillLayer() {
		return lastSkillLayer;
	}
	public void setLastSkillLayer(Integer lastSkillLayer) {
		this.lastSkillLayer = lastSkillLayer;
	}
	public Integer getLastSkillID() {
		return lastSkillID;
	}
	public void setLastSkillID(Integer lastSkillID) {
		this.lastSkillID = lastSkillID;
	}
	public Integer getLastSkillLayerNum() {
		return lastSkillLayerNum;
	}
	public void setLastSkillLayerNum(Integer lastSkillLayerNum) {
		this.lastSkillLayerNum = lastSkillLayerNum;
	}
}
