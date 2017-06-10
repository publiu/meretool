package com.mereking.meretool.dto;

import java.util.Date;

/**
 * 技能插入参数
 * @author mereking
 *
 */
public class InsertSkillDTO {
	// 需要插入的父节点ID
	private Integer parentSkillID;
	
	private String skillName;
	private String skillDetail;
	
	private Integer userId;
	
	public InsertSkillDTO(){}
	
	public InsertSkillDTO(Integer parentSkillID, String skillName, String skillDetail, Integer userId){
		this.parentSkillID = parentSkillID;
		this.skillName = skillName;
		this.skillDetail = skillDetail;
		this.userId = userId;
	}

	
	public Integer getParentSkillID() {
		return parentSkillID;
	}
	public void setParentSkillID(Integer parentSkillID) {
		this.parentSkillID = parentSkillID;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillDetail() {
		return skillDetail;
	}
	public void setSkillDetail(String skillDetail) {
		this.skillDetail = skillDetail;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
