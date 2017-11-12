package com.mereking.meretool.entity;
/**
 * 用户
 * @author mereKing
 *
 */
public class User {
	private Integer id;
	private String username; // 用户名
	private Integer lastSkillLayer; // 最近搜索的技能层次
	private Integer lastSkillID; // 最近搜索的技能id
	private Integer lastSkillLayerNum; // 最近搜索的技能深度
	private String email;//邮箱
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
