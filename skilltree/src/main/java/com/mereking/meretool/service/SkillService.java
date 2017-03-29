package com.mereking.meretool.service;

import java.util.List;

import com.mereking.meretool.entity.Skill;
/**
 * 技能服务
 * @author mereKing
 *
 */
public interface SkillService {
	
	/**
	 * 查询单个技能
	 * @param skillID
	 * @return
	 */
	public Skill getBySkillID(Integer skillID);
	/**
	 * 查询技能列表
	 * @return
	 */
	public List<Skill> queryALLSkill();

}
