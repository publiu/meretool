package com.mereking.meretool.dto;

import com.mereking.meretool.entity.Skill;


/**
 * 查询当前层次的所有技能
 * @author mereking
 *
 */
public class QuerySkillsByLayerAjaxVO {
	private Integer skillID;
	private String skillName;
	private Integer layer;
	
	public QuerySkillsByLayerAjaxVO() {}
	
	public QuerySkillsByLayerAjaxVO(Skill skill) {
		this.skillID = skill.getSkillID();
		this.skillName = skill.getSkillName();
		this.layer = skill.getLayer();
	}

	public Integer getSkillID() {
		return skillID;
	}

	public void setSkillID(Integer skillID) {
		this.skillID = skillID;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Integer getLayer() {
		return layer;
	}

	public void setLayer(Integer layer) {
		this.layer = layer;
	}
	
	
	

}
