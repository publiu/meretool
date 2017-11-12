package com.mereking.meretool.dto;


public class SkillAjaxNodeVO {
	// 技能ID
	private Integer id;
	// 技能名称
	private String title;
	// 技能父ID
	private Integer group;
	
	public SkillAjaxNodeVO() {}
	public SkillAjaxNodeVO(Integer id, String title, Integer group) {
		this.id = id;
		this.title = title;
		this.group = group;
	}
	public SkillAjaxNodeVO(QuerySkillLinkResultDTO querySkillLinkResultDTO) {
		this.id = querySkillLinkResultDTO.getChildSkill().getSkillID();
		this.title = querySkillLinkResultDTO.getChildSkill().getSkillName();
		this.group = querySkillLinkResultDTO.getParentSkill().getSkillID();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getGroup() {
		return group;
	}
	public void setGroup(Integer group) {
		this.group = group;
	}
	
	
	
}
