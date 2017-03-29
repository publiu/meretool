package com.mereking.meretool.entity;

import java.util.Date;

/**
 * 技能
 * @author Administrator
 *
 */
public class Skill {
	private Integer skillID; // 技能ID
	private String skillName; // 技能名称
	private String skillDetail; // 技能详情
	private Date skillCreate; // 技能创建时间
	private Date skillModified; // 技能修改时间
	
	private Integer leftSkillNo; // 左值
	private Integer rightSkillNo; // 右值
	private Integer skillLevel; // 技能等级
	private Integer layer; // 层次
	
	public Skill() {		
	}
	
	public Skill(String skillName, String skillDetail, Date skillCreate) {
		this.skillName = skillName;
		this.skillDetail = skillDetail;
		this.skillCreate = skillCreate;
	}
	
	public void initSkillRelation(Integer leftSkillNo, Integer rightSkillNo, Integer skillLevel, Integer layer) {
		this.leftSkillNo = leftSkillNo;
		this.rightSkillNo = rightSkillNo;
		this.skillLevel = skillLevel;
		this.layer = layer;
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
	public String getSkillDetail() {
		return skillDetail;
	}
	public void setSkillDetail(String skillDetail) {
		this.skillDetail = skillDetail;
	}
	public Date getSkillCreate() {
		return skillCreate;
	}
	public void setSkillCreate(Date skillCreate) {
		this.skillCreate = skillCreate;
	}
	public Date getSkillModified() {
		return skillModified;
	}
	public void setSkillModified(Date skillModified) {
		this.skillModified = skillModified;
	}
	public Integer getLeftSkillNo() {
		return leftSkillNo;
	}
	public void setLeftSkillNo(Integer leftSkillNo) {
		this.leftSkillNo = leftSkillNo;
	}
	public Integer getRightSkillNo() {
		return rightSkillNo;
	}
	public void setRightSkillNo(Integer rightSkillNo) {
		this.rightSkillNo = rightSkillNo;
	}
	public Integer getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
	}
	public Integer getLayer() {
		return layer;
	}
	public void setLayer(Integer layer) {
		this.layer = layer;
	}
	
	
	

}
