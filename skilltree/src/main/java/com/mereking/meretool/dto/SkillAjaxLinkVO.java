package com.mereking.meretool.dto;


public class SkillAjaxLinkVO {
	// 技能子节点ID
	private Integer source;
	// 技能父节点ID
	private Integer target;
	// 子技能层次
	private Integer value;
	
	public SkillAjaxLinkVO() {}
	public SkillAjaxLinkVO(QuerySkillLinkResultDTO querySkillLinkResultDTO) {
		this.source = querySkillLinkResultDTO.getChildSkill().getSkillID();
		this.target = querySkillLinkResultDTO.getParentSkill().getSkillID();
		this.value = querySkillLinkResultDTO.getChildSkill().getLayer();
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Integer getTarget() {
		return target;
	}
	public void setTarget(Integer target) {
		this.target = target;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	

	
}
