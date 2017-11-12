package com.mereking.meretool.dto;

import com.mereking.meretool.entity.Skill;

/**
 * skill关联关系
 * @author Administrator
 *
 */
public class QuerySkillLinkResultDTO {
	// 父技能
	private Skill parentSkill;
	// 子技能
	private Skill childSkill;
	
	public Skill getParentSkill() {
		return parentSkill;
	}
	public void setParentSkill(Skill parentSkill) {
		this.parentSkill = parentSkill;
	}
	public Skill getChildSkill() {
		return childSkill;
	}
	public void setChildSkill(Skill childSkill) {
		this.childSkill = childSkill;
	}
	
	

}
